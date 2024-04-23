package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale {

	Client client;

	private static ArrayList<Product> products = new ArrayList<>();

	double amount;
	LocalDateTime date;

	public Sale(Client client, ArrayList<Product> products, double amount, LocalDateTime date) {

		super();

		this.client = client;

		this.products = products;

		this.amount = amount;
		
		this.date = date;
	}

	public Client getClient() {

		return client;

	}

	public void setClient(Client client) {

		this.client = client;

	}

	public ArrayList<Product> getProducts() {

		return products;

	}

	public void setProducts(ArrayList<Product> products) {

		this.products = products;

	}

	public double getAmount() {

		return amount;

	}

	public void setAmount(double amount) {

		this.amount = amount;

	}
	public String getTime() {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

	@Override

	public String toString() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter times = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mmm:ss");
		String formatteDate = time.format(times);
		
		return "Venta realizada el " + getTime() + " - Cliente: " + client + ", Total: " + formatteDate;

	}

}
