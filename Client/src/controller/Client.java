package controller;

import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Button_cell;
import model.Player;
import view.GameRoom;
import view.InRoom;
import view.ViewOnline;
import view.Waiting;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Waiting wait;
	private GameRoom gameroom;
	private ViewOnline viewonline;
	private InRoom inroom;

	private Socket client;
	private DataOutputStream os;
	private DataInputStream is;
	private int id;
	private Thread thread;
	private Player player;
	private String name;

 
	public Client() {
		
		name = JOptionPane.showInputDialog("Nhập tên của bạn");

		upSocket();
	}

	public void upSocket() {
		try {
			thread = new Thread() {
				@Override
				public void run() {

					try {
						client = new Socket("localhost", 1234);
						System.out.println("Kết nối thành công!");
						// Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
						os = new DataOutputStream(client.getOutputStream());
						// Luồng đầu vào tại Client (Nhận dữ liệu từ server).
						is = new DataInputStream(client.getInputStream());
						write("set-name,"+name);
						String message;

						while (true) {
							message = is.readUTF();
							if (message == null) {
								break;
							}
							String[] messageSplit = message.split(",");
							if (messageSplit[0].equals("set-player")) {
								int ID = Integer.parseInt(messageSplit[1]);
								player = new Player(name, "No", ID);
								viewonline = new ViewOnline(client, player);
							}
							if (messageSplit[0].equals("create-success")) {
								viewonline.setVisible(false);
								inroom = new InRoom(client,player);
								inroom.SetIDRoom(messageSplit[1]);
							}
							if (messageSplit[0].equals("doi-thu-join-room")) {
								inroom.setplayer1(messageSplit[1]);
								System.out.println("Doi thu vao room");
							}
							if (messageSplit[0].equals("me-join-room")) {
								System.out.println("toi vao room");

								viewonline.setVisible(false);
								inroom = new InRoom(client,player);
								inroom.SetIDRoom(messageSplit[1]);
								inroom.setplayer2(messageSplit[2]);
							}
							 
							if (messageSplit[0].equals("start")) {
								player.setValue(messageSplit[1]);
								inroom.setVisible(false);
								gameroom = new GameRoom(client, player);
								gameroom.setplayer(messageSplit[2], messageSplit[3]);
							}
							if (messageSplit[0].equals("attack")) {
								gameroom.setAttack(Integer.parseInt(messageSplit[1]),Integer.parseInt(messageSplit[2]));

							}
							if (messageSplit[0].equals("win")) {
								gameroom.lose();

							}
						}

					} catch (UnknownHostException e) {
						return;
					} catch (IOException e) {
						return;
					}
				}
			};

			thread.start();
		} catch (Exception e) {
		}

	}

	public void write(String message) throws IOException {
		os.writeUTF(message);
		os.flush();
	}

}
