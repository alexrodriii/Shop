package model;

public class Product {

	private int id;

	private String name;

	private double publicPrice;

	private double wholesalerPrice;

	private boolean available;

	private int stock;

	private static int totalProducts;

	final static double EXPIRATION_RATE = 0.60;

	public Product(String name, double wholesalerPrice, boolean available, int stock, double publicPrice) {

		super();

		this.id = totalProducts + 1;

		this.name = name;

		this.wholesalerPrice = wholesalerPrice;

		this.available = available;

		this.stock = stock;

		this.publicPrice = publicPrice;

		totalProducts++;

	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public double getPublicPrice() {

		return publicPrice;

	}

	public void setPublicPrice(double publicPrice) {

		this.publicPrice = publicPrice;

	}

	public double getWholesalerPrice() {

		return wholesalerPrice;

	}

	public void setWholesalerPrice(double wholesalerPrice) {

		this.wholesalerPrice = wholesalerPrice;

	}

	public boolean isAvailable() {

		return available;

	}

	public void setAvailable(boolean available) {

		this.available = available;

	}

	public int getStock() {

		return stock;

	}

	public void setStock(int stock) {

		this.stock = stock;

	}

	public static int getTotalProducts() {

		return totalProducts;

	}

	public static void setTotalProducts(int totalProducts) {

		Product.totalProducts = totalProducts;

	}

	public double expire() {

		return this.publicPrice = this.getPublicPrice() * EXPIRATION_RATE;

	}

	@Override

	public String toString() {

		return "Product [id=" + id + ", name=" + name + ", publicPrice=" + publicPrice + ", wholesalerPrice="

				+ wholesalerPrice + ", available=" + available + ", stock=" + stock + "]";

	}

}