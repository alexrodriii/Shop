package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.LimitLoginException;
import model.Employee;
import utils.Constants;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField password;
	private JButton btnNewButton;
	private int loginCounter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = 	new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(164, 6, 75, 26);
		lblNewLabel_2.setFont(new Font("ITF Devanagari", Font.BOLD, 19));
		lblNewLabel_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Número de empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 74, 155, 16);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(164, 69, 85, 26);
		user.setText("123");
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\n Password");
		lblNewLabel_1.setBounds(80, 107, 72, 16);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(164, 102, 85, 26);
		password.setText("test");
		contentPane.add(password);
		password.setColumns(10);
		
		 btnNewButton = new JButton("Acceder");
		 btnNewButton.setBounds(192, 140, 111, 29);
		
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.BLACK);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setIcon(new ImageIcon("/Users/manana/Downloads/tienda.png"));
		lblNewLabel_3.setBounds(-571, -93, 1336, 529);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton.addActionListener(this);
	}
	
	
	@Override



	public void actionPerformed(ActionEvent e) {

     	if(e.getSource() == btnNewButton) {

			Employee employee = new Employee();



			  int username = Integer.parseInt(user.getText()); 

		      String passwords = password.getText();

		      

		      boolean logged = employee.login(username, passwords);



		      if(logged) {



	            ShopView shopView = new ShopView(); 

		            shopView.setVisible(true);         

		            dispose();

		        } else {

		        	 loginCounter++;

		        	 if(Constants.MAX_LOGIN_TIMES <= loginCounter){

		        		 try {

		        			 throw new LimitLoginException("Superado máximo numero de intentos");

		        		 } catch (LimitLoginException ex){

		        			 JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		                      

		                        dispose();

		        		 }

		        	 } else {

		        		 JOptionPane.showMessageDialog(this, "Error al logearte. Porfavor vuelve a intentarlo"+ JOptionPane.ERROR_MESSAGE);

		        	 }

		           

		           

		        }

       

		    }



		}

	}	

		// else abrir joption pane

		
