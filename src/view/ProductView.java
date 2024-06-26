package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Shop;
import model.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dialog;

public class ProductView extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductView dialog = new ProductView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre producto:");
		lblNewLabel.setBounds(39, 52, 115, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stock producto:");
		lblNewLabel_1.setBounds(39, 96, 115, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio producto:");
		lblNewLabel_2.setBounds(39, 138, 115, 16);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/manana/Downloads/tienda.png"));
		lblNewLabel_3.setBounds(-326, 328, 612, 0);
		contentPanel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setSelectionColor(new Color(0, 0, 0));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(171, 47, 130, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 91, 130, 26);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 133, 130, 26);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent e) {   
				        	if(e.getSource() == okButton) {
				        		
				        		String nombre = textField.getText();
				        		int stock = Integer.parseInt(textField_1.getText());
				        		Double precio = Double.parseDouble(textField_2.getText());
				        		
				        		Shop shop = new Shop();
				        		
				        		 Product existe= shop.findProduct(nombre);
				        		 
				        		if(existe == null) {
		     
				        			  Product producto = new Product(nombre, precio / 2, true, stock, precio);
				        	            shop.addProduct(producto);
				        	            
				        	          JOptionPane.showMessageDialog(ProductView.this, "Producto añadido!",  nombre, JOptionPane.INFORMATION_MESSAGE);

				        		}
				        		else {
				        		      JOptionPane.showMessageDialog(ProductView.this, "El producto ya existe!", "Error", JOptionPane.ERROR_MESSAGE);
				        		
				        		}
				        		}
				        		
				   
				           }
				        
				        });
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					 cancelButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {   
					        	if(e.getSource() == cancelButton) {
					            dispose();
				            
				         
				            
				        }
				        }
				    });
			
				buttonPane.add(cancelButton);
			}
		}
	}
	  public void addStock() {
	        
	        JDialog addStockDialog = new JDialog();
	        addStockDialog.setTitle("Añadir Stock");
	        addStockDialog.setBounds(100, 100, 450, 300);
	        addStockDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	        JPanel contentPanel = new JPanel();
	        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        addStockDialog.getContentPane().add(contentPanel, BorderLayout.CENTER);
	        contentPanel.setLayout(null);
	
			JLabel lblNewLabel = new JLabel("Nombre producto:");
			lblNewLabel.setBounds(39, 52, 115, 16);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Stock producto:");
			lblNewLabel_1.setBounds(39, 96, 115, 16);
			contentPanel.add(lblNewLabel_1);
		
			textField = new JTextField();
			textField.setSelectionColor(new Color(0, 0, 0));
	
			textField.setForeground(new Color(0, 0, 0));
			textField.setBackground(new Color(255, 255, 255));
			textField.setBounds(171, 47, 130, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(171, 91, 130, 26);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
			
		
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				addStockDialog.getContentPane().add(buttonPane, BorderLayout.SOUTH);
				
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					 okButton.addActionListener(new ActionListener() {
					     public void actionPerformed(ActionEvent e) {   
					      	if(e.getSource() == okButton) {
					          String nombre = textField.getText();
					          int stock = Integer.parseInt(textField_1.getText());
					         	  
					          Shop shop = new Shop();	
					          Product product = shop.findProduct(textField.getText());
					           if(product == null) {
					        	  JOptionPane.showMessageDialog(null,"El producto no existe","Error", JOptionPane.ERROR_MESSAGE);
					             } else {
				             product.setStock(product.getStock() + Integer.parseInt(textField_1.getText()));					            			  
					       		 JOptionPane.showMessageDialog(null, "Stock actualizado",nombre, JOptionPane.INFORMATION_MESSAGE );
					              }
					              addStockDialog.dispose();
					             
					           		      
					        }
					        }
					    });
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					
				
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					 cancelButton.addActionListener(new ActionListener() {
					        public void actionPerformed(ActionEvent e) {   
					        	if(e.getSource() == cancelButton) {
					              addStockDialog.dispose();
					           		      
					        }
					        }
					    });
					    buttonPane.add(cancelButton);
					
				

		        addStockDialog.setVisible(true);
	  }
	  


        public void deleteProduct() {
	    JDialog deleteProduct = new JDialog();
	    deleteProduct.setTitle("Eliminar Producto");
	    deleteProduct.setBounds(100, 100, 450, 300);
	    deleteProduct.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
	    JPanel contentPanel = new JPanel();
	    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	    deleteProduct.getContentPane().add(contentPanel, BorderLayout.CENTER);
	    contentPanel.setLayout(null);
	
	    JLabel lblNewLabel = new JLabel("Nombre producto:");
	    lblNewLabel.setBounds(39, 52, 115, 16);
	    contentPanel.add(lblNewLabel);
	
	    textField = new JTextField();
	    textField.setBounds(171, 47, 130, 26);
	    contentPanel.add(textField);
	    textField.setColumns(10);      
	
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    deleteProduct.getContentPane().add(buttonPane, BorderLayout.SOUTH);
	
	    JButton okButton = new JButton("OK");
	    okButton.setActionCommand("OK");
		 okButton.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {   
		      if(e.getSource() == okButton) {
		         String nombre = textField.getText();	
		         ArrayList<Product> inventory = new ArrayList<>();
		         Shop shop = new Shop();	
		         boolean productoEliminado = shop.deleteProduct(nombre);
		        
		           if(productoEliminado) {
		        	   JOptionPane.showMessageDialog(null, "El producto ha sido eliminado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		             } else {
		            	 JOptionPane.showMessageDialog(null, "El producto no existe", "Error", JOptionPane.ERROR_MESSAGE);
		              }
		              deleteProduct.dispose();
		             
		      	}
		     }
		 });
	    
	    buttonPane.add(okButton);
	    getRootPane().setDefaultButton(okButton);
	
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.setActionCommand("Cancel");
	    buttonPane.add(cancelButton);

		 cancelButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {   
		        	if(e.getSource() == cancelButton) {
		        		 deleteProduct.dispose(); 
		           		      
		        }
		        }
		    });
		    buttonPane.add(cancelButton);
		
	

	
	    deleteProduct.setVisible(true);
	}
			
	
		
		
	


		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
