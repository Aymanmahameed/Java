package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Customer;
import model.Hotel;
import utils.Service;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RemoveCustomer {

	private JFrame frame;
	private JButton SubmitBtn_1;
	private JComboBox<Customer> CustomerscomboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveCustomer window = new RemoveCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemoveCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		SubmitBtn_1 = new JButton("Remove!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Hotel.getInstance().removeCustomer((Customer) CustomerscomboBox.getSelectedItem())) {
					JOptionPane.showMessageDialog(frame, "The Customer has been removed successfully");
					CustomerscomboBox.removeItem(CustomerscomboBox.getSelectedItem());
				}else {
					JOptionPane.showMessageDialog(frame, "Oops, something wrong!!!!");
				}
			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(346, 185, 150, 40);
		frame.getContentPane().add(SubmitBtn_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 117, 766, 40);
		frame.getContentPane().add(scrollPane);
		
		CustomerscomboBox = new JComboBox<model.Customer>();
		scrollPane.setViewportView(CustomerscomboBox);
		Service.fillcombo(CustomerscomboBox,Hotel.getInstance().getAllCustomers());
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/sa.jpg"));
			JPanel panel = new JPanel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panel.setBounds(0, 0, 950, 500);
			panel.setLayout(null);
			
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}