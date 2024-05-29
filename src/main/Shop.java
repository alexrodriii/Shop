package main;
import java.util.ArrayList;

import model.Client;
import model.Employee;
import model.Product;
import model.Sale;
import view.CashView;
import view.LoginView;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

 public class Shop {

 private double cash = 100.00;

// private Product[] inventory;

 private int numberProducts;

 private static ArrayList<Sale> sales = new ArrayList<>();

 private static ArrayList<Product> inventory = new ArrayList<>();

 final static double TAX_RATE = 1.04;
	
	public Shop() {
	
	}
	
	public static void main(String[] args)  throws IOException{
	
	
	Shop shop = new Shop();	
	Scanner scanner = new Scanner(System.in);
	
	shop.initSession();
	
	int opcion = 0;
	
	boolean exit = false;
	
		
	do {
	
	System.out.println("\n");	
	System.out.println("===========================");	
	System.out.println("Menú principal miTienda.com");	
	System.out.println("===========================");	
	System.out.println("1) Contar caja");	
	System.out.println("2) Añadir producto");	
	System.out.println("3) Añadir stock");	
	System.out.println("4) Marcar producto proxima caducidad");	
	System.out.println("5) Ver inventario");	
	System.out.println("6) Venta");	
	System.out.println("7) Ver ventas");	
	System.out.println("8) Eliminar Producto");	
	System.out.println("10) Salir programa");	
	System.out.print("Seleccione una opción: ");
	
	opcion = scanner.nextInt();
	
	switch (opcion) {
	
	case 1:
	
	shop.showCash();
	
	break;
	
	case 2:
	
	shop.addProduct();
	
	break;
	
	case 3:
	
	shop.addStock();
	
	break;
	
	case 4:
	
	shop.setExpired();
	
	break;
	
	case 5:
	
	shop.showInventory();
	
	break;
	
	case 6:
	
	shop.sale();
	
	break;
	
	case 7:
	
	shop.showSales();
	
	break;
	
	case 8:
	
	shop.deleteProduct(scanner, inventory);
	
	break;
	
	case 9:
	  shop.exportarDatos();
	  break;
	
	case 10:
	
	System.out.println("Saliendo del programa!");
	
	exit = true;
	
	break;
	
	}
	
	} while (!exit);
	
	}
	
	/**
	*
	* load initial inventory to shop
	*
	*/
	
	public void loadInventory() throws IOException{
	
	File fichero = new File("files/inputinventory.txt");
	
	FileReader ficheror = new FileReader (fichero);
	BufferedReader br = new BufferedReader (ficheror);
	
	String miLinea = br.readLine();
	
	while (miLinea != null) {
	String [] partes = miLinea.split (";");
	String name = " ";
	Double wholesalerPrice = 0.0;
	int stock= 0;
	
	for (int i = 0; i < partes.length; i++) {
	
	String [] partess = partes[i].split(":");
	
	switch (i) {
	case 0:
	name = partess[1];
	break;
	
	case 1:
	wholesalerPrice = Double.parseDouble(partess[1]);
	break;
	
	case 2:
	stock = Integer.parseInt (partess[1]);
	break;
	
	}
	}
	addProduct(new Product(name, wholesalerPrice, true, stock, (wholesalerPrice*2)));
	miLinea = br.readLine();
	
	}
	
	
	     }
	
	 
	
	
	public void exportarDatos()throws IOException {
	  Scanner sc = new Scanner(System.in);
	  System.out.print("Quieres exportar las ventas a un archivo? (si/no): ");
	  String opcion = sc.nextLine();
	  if (opcion.equalsIgnoreCase("si ")) {
	  String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"));
	  File file = new File("outputInventory" + date + ".txt");
	  file.createNewFile();
	  FileWriter fileW = new FileWriter(file);
	          for (Sale sale : sales) {
	         
	          fileW.write("Cliente= " + sale.getClient() + ";");
	              fileW.write("Date= " + date + ";\n");
	              fileW.write("Products= ");
	                 for (Product product : sale.getProducts()) {
	               fileW.write(product.getName() + "," + product.getPublicPrice() + "€");
	              }
	              fileW.write("\n");
	              fileW.write("Amount= " + sale.getAmount() + "€;\n\n");
	          }
	          System.out.println("Las ventas exportadas a " + file);
	         
	  } else {
	  System.out.println("Error");
	  }
	  }
	
	 
	
	
	/**
	*
	* show current total cash
	*
	*/
	
	private void showCash() {
	
	boolean exist = false;
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Nombre: ");
	
	if (!exist)
	
	System.out.println("Dinero actual: " + cash);
	
	}
	
	/**
	*
	* add a new product to inventory getting data from console
	*
	*/
	
	public void addProduct() {
	
	if (isInventoryFull()) {
	
	System.out.println("No se pueden añadir más productos");
	
	return;
	
	}
	
	Scanner scanner = new Scanner(System.in);
		System.out.print("Nombre: ");
	
	String name = scanner.nextLine();
		System.out.print("Precio mayorista: ");
	
	double wholesalerPrice = scanner.nextDouble();
		System.out.print("Stock: ");
	
	int stock = scanner.nextInt();
	
	double publicPrice = wholesalerPrice * 2;
	
	addProduct(new Product(name, wholesalerPrice, true, stock, publicPrice));
	  System.out.println("Precio Público: " + publicPrice);
	
	}
	
	/**
	*
	* add stock for a specific product
	*
	*/
	
	public void addStock() {
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("Seleccione un nombre de producto: ");
	
	String name = scanner.next();	
	Product product = findProduct(name);
	
	if (product != null) {
	
	// ask for stock
		System.out.print("Seleccione la cantidad a añadir: ");
	
	int stockNew = scanner.nextInt();
	int stock = product.getStock();
	
	stock += stockNew;
	
	// update stock product
	
	product.setStock(stock);
		System.out.println("El stock del producto " + name + " ha sido actualizado a " + product.getStock());
	
	} else {
		System.out.println("No se ha encontrado el producto con nombre " + name);
	
	}
	
	}
	
	/**
	*
	* set a product as expired
	*
	*/
	
	private void deleteProduct(Scanner sc, ArrayList<Product> Inventory) {
	System.out.print("Seleccione un nombre de producto a eliminar:");
	  String name = sc.next();
	
	Product product = findProduct(name);
	
	if (product != null) {
	
	Inventory.remove(product);
	
	System.out.println("El producto " + name + " a sido eliminado!");
		} else {
	
	System.err.println("Produco no encontrado");
	
	}
	
	}
	
	private void setExpired() {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Seleccione un nombre de producto: ");
		String name = scanner.next();
	
	Product product = findProduct(name);
	
	if (product != null) {
	
	double precioFinal = product.getPublicPrice() - product.expire();
	
	product.setPublicPrice(precioFinal);
	System.out.println("El stock del producto " + name + " ha sido actualizado a " + precioFinal);
	
	}
	
	}
	
	/**
	*
	* show all inventory
	*
	*/
	
	public void showInventory() {
	System.out.println("Contenido actual de la tienda:");
	
	for (Product product : inventory) {
	if (product != null)

	{
	System.out.println(product.toString());
	
	}
	
	}
	
	}
	
	/**
	*
	* make a sale of products to a client
	*
	*/
	
	public void sale() {
	
	// ask for client name
		Scanner sc = new Scanner(System.in);
	LocalDateTime time = LocalDateTime.now();
	System.out.println("Realizar venta, escribir nombre cliente");
	
	String clientName = sc.nextLine();
	Client client = new Client(clientName,23);
	ArrayList<Product> products = new ArrayList<>();
	
	
	
		double totalAmount = 0.0;
	
	String name = "";
		while (! name.equals("0")) {
	
	System.out.println("Introduce el nombre del producto, escribir 0 para terminar:");
		name = sc.nextLine();	
	if (name.equals("0")) {
	
	break;
	
	}
		Product product = findProduct(name);
	
	boolean productAvailable = false;
		if (product != null && product.isAvailable()) {
	
	productAvailable = true;
	
	totalAmount += product.getPublicPrice();
	
	product.setStock(product.getStock() - 1);
	

	
	if (product.getStock() == 0) {
	
	product.setAvailable(false);
	
	}
	    System.out.println("Producto añadido con éxito");
	
	}
	
	if (!productAvailable) {
System.out.println("Producto no encontrado o sin stock");
	
	}
	
	}
	
	// show cost total
	
	totalAmount = totalAmount * TAX_RATE;
	if (client.pay(totalAmount)) {
	           cash += totalAmount;
	           System.out.println("Venta realizada con éxito, total: " + client.getBalance() + " " + time);
	           sales.add(new Sale(client, products, client.getBalance(), time));
	       } else {
	           System.err.println("El cliente debe : " + (totalAmount - client.getBalance())+ "€");
	       }
	
	   }
	
	/**
	*
	* show all sales
	*
	*/
	
	private void showSales() throws IOException  {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Desea poner todas las ventas en un Fichero? ");
	String respuesta = sc.next();
	
	
	System.out.println("Lista de ventas: ");
	
	for (Sale sale : sales) {
	
	if (sale != null) {
	exportarDatos();
	System.out.println(sale);
	Client client = sale.getClient();
	   String clientName = client.getName();
	
	  System.out.println("Cliente: ".toUpperCase());
	      System.out.println("Fecha y hora de la venta: " + sale.getTime());
	
	      System.out.println("Total: " + sale.getAmount());
	      System.out.println("-------------------------------------");
	 
	}
	
	System.out.println(sale.toString());
	
	{
	
	}
	
	System.out.println("Nombre cliente: ");
	
	String client = sc.nextLine();
	
	}
	
	}
	
	
	
	/**
	*
	* add a product to inventory
	*
	*
	*
	* @param product
	*
	*/
	
	public void addProduct(Product product) {
	
	if (isInventoryFull()) {
	
	System.out.println("No se pueden añadir más productos, se ha alcanzado el máximo de " + inventory.size());
		return;
	
	}
	  inventory.add(product);
	
	
	
	}
	
	/**
	*
	* check if inventory is full or not
	*
	*/
	public boolean deleteProduct(String productName) {
	    ArrayList<Product> inventory = new ArrayList<>();
	 
	    for (Product product : inventory) {
	        if (product.getName().equalsIgnoreCase(productName)) {
	            inventory.remove(product);
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean isInventoryFull() {
		if (numberProducts == 10) {
	return true;
	
	} else {
	return false;
	
	}
	
	}
	
	/**
    	*
	* find product by name
	*
	*
	*
	* @param product name
	*
	*/
	
	public Product findProduct(String name) {
	 	for (Product product : inventory) {	
	if (product.getName().equalsIgnoreCase(name)) {
	   return product;
	
	}
	
	}
	
	return null;
	
	}
	public void initSession() {
	Scanner sc = new Scanner (System.in);
	LoginView loginV = new LoginView();
	Employee e = new Employee ();
	
       int user = 0;
       boolean login;
       String password = null;
       e.login(user, password);
	
	do {
	System.out.println("Introduce tu numero de usuario: ");
	 user = sc.nextInt();
	
	System.out.println("Introduce tu contraseña: ");
	 password = sc.next();
	 login = e.login(user, password);
	
	if (!login) {
	 System.err.println("Error, contraseña o password incorrectos.");
	  }
	
	} while (!login);
	
	
	if (login) {
	System.out.println("\nBienvenido a nuestra tienda!");
}
	
}
	 public double getCash() {
		 return cash;
	 }
}