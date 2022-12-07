package view;
import java.util.TimerTask;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class Waiting extends JFrame {

	private JPanel contentPane;
	private Timer timer = new Timer();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public Waiting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		 lblNewLabel = new JLabel("Đang chờ đối thủ vào phòng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 70, 267, 73);
		contentPane.add(lblNewLabel);
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				// TODO Auto-generated method stub
				lblNewLabel.setText("Loading");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblNewLabel.setText("Loading..");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblNewLabel.setText("Loading....");

			}
		}, 1000, 1000);
		setVisible(true);
	}
	public void cancel() {
		
		timer.cancel();
		lblNewLabel.setText("Loading...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
