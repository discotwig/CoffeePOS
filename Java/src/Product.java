import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
	
	// attributes
	private int product_id;
	private String name;
	private double price;	
	private int quantity;
	private double total;
		
	// constructor womb
	public Product(int id, String n, double p) {
		product_id = id;
		name = n;
		price = p;
	}	
	
	// get
	public int getProduct_id() {return product_id;}
	public String getName() {return name;}
	public double getPrice() {return price;}
	public int getQuantity() {return quantity;}
	public double getTotal() {
		total = quantity * price;
		return total;
	}
	
	// set
	public void setProduct_id(int product_id) {this.product_id = product_id;}
	public void setName(String name) {this.name = name;}	
	public void setPrice(double price) {this.price = price;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	
	public void addItems() {
		// how many items sold
		String prompt = String.format("Please enter the quantity sold for item %d", product_id);
		System.out.println(prompt);
		
		Scanner input = new Scanner(System.in);	
		
		try {
			quantity = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid amount. Enter integers only");
			quantity = 0;
		}
	}
	
}
