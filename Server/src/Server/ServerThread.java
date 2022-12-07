package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ServerThread implements Runnable {
	private Socket socketOfServer;
	private int clientNumber;
	private DataInputStream is;
	private DataOutputStream os;
	private boolean isClosed;
	private String name;
	private boolean isRoom;
	private int ID_ROOM;

	public boolean isRoom() {
		return isRoom;
	}

	public void setRoom(boolean isRoom) {
		this.isRoom = isRoom;
	}

	public int getID_ROOM() {
		return ID_ROOM;
	}

	public void setID_ROOM(int iD_ROOM) {
		ID_ROOM = iD_ROOM;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public ServerThread(Socket socketOfServer, int clientNumber) {
		this.socketOfServer = socketOfServer;
		this.clientNumber = clientNumber;
		isClosed = false;
		this.isRoom = false;
	}

	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// Mở luồng vào ra trên Socket tại Server.
			is = new DataInputStream(socketOfServer.getInputStream());
			os = new DataOutputStream((socketOfServer.getOutputStream()));

			System.out.println("Khời động luông mới thành công, ID là: " + clientNumber);
			Server.serverview.setnotify("Một người chơi vừa đăng nhập , ID là: " + clientNumber);
			Server.serverThreadBus.SetOnlineList();
			write("set-player" + "," + this.clientNumber);

			String message;

			while (!isClosed) {
				message = is.readUTF();
				System.out.println(message);
				if (message == null) {
					break;
				}
				
				String[] messageSplit = message.split(",");
				if(messageSplit[0].equals("set-name")) {
					this.setName(messageSplit[1]);
				}
				if (messageSplit[0].equals("start")) {
					

					for (ServerThread serverThread : Server.serverThreadBus.getListServerThreads()) {
						if (this != serverThread && serverThread.isRoom == true
								&& serverThread.getID_ROOM() == this.getID_ROOM()) {
							this.write("start,X,"+this.getName()+","+serverThread.getName());
							serverThread.write("start,O,"+serverThread.getName()+","+this.getName());
						}
					}

				}
				if (messageSplit[0].equals("attack")) {
					for (ServerThread serverThread : Server.serverThreadBus.getListServerThreads()) {
						if (this != serverThread && serverThread.isRoom == true
								&& serverThread.getID_ROOM() == this.getID_ROOM()) {
							serverThread.write("attack," + messageSplit[1] + "," + messageSplit[2]);
						}
					}

				}
				if (messageSplit[0].equals("win")) {
					Server.serverThreadBus.attack(clientNumber, "win");
				}
				if (messageSplit[0].equals("create-room")) {
					System.out.println(2);
					Server.serverview.setnotify("Đã tạo phòng mới!");
					Server.serverThreadBus.createRoom(this);
					Server.serverThreadBus.RoomList();
					write("create-success," + getID_ROOM());
				}

				if (messageSplit[0].equals("join-room")) {
					for (ServerThread serverThread : Server.serverThreadBus.getListServerThreads()) {
						if (this != serverThread && serverThread.isRoom == true
								&& serverThread.getID_ROOM() == Integer.parseInt(messageSplit[1])) {
							this.setID_ROOM(serverThread.getID_ROOM());
							this.setRoom(true);
							Server.serverThreadBus.sendto(serverThread, "doi-thu-join-room,"+this.getName());
							this.write("me-join-room," + getID_ROOM() + ","+serverThread.getName());

						}
					}
					 
				}
			}

		} catch (IOException e) {

			setRoom(false);
			Server.serverThreadBus.RoomList();
			Server.serverThreadBus.remove(clientNumber);
			isClosed = true;

			Server.serverview.setnotify("Người chơi có ID " + this.clientNumber + " đã thoát");

			Server.serverThreadBus.SetOnlineList();
			System.out.println(this.clientNumber + " đã thoát");
		}
	}

}
