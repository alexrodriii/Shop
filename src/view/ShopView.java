 package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Shop;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;



public class ShopView extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	protected int option;
	protected int opcion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopView frame = new ShopView();
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
	public ShopView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione o pulse una opción:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 19, 227, 16);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("1. Contar caja");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton) {
					Shop shop = new Shop();
					double cash = shop.getCash();
					CashView cashview = new CashView(cash);
					cashview.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(118, 40, 141, 43);
		contentPane.add(btnNewButton);
		
	    btnNewButton_1 = new JButton("2. Añadir producto");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnNewButton_1) {
					ProductView productview = new ProductView();
					 productview.setVisible(true);
					}
				
					}
			});
			
		btnNewButton_1.setBounds(118, 83, 141, 43);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("3. Añadir stock");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_2) {
					 ProductView productView = new ProductView();
				        productView.addStock();
				      
					 
				
			}
				}
			
	
		});
		btnNewButton_2.setBounds(118, 124, 141, 43);
		contentPane.add(btnNewButton_2);
		
	    btnNewButton_3 = new JButton("9. Eliminar producto");
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_3) {
					ProductView eliminarView = new ProductView();
					eliminarView.deleteProduct();
				}
			}
		});
		
		btnNewButton_3.setBounds(118, 169, 141, 43);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/manana/Downloads/tienda.png"));
		lblNewLabel_1.setBounds(-312, -39, 1040, 317);
		contentPane.add(lblNewLabel_1);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			abrirCashView();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void abrirCashView() {
		
	}
}
