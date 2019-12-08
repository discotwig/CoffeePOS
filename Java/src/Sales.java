import java.util.InputMismatchException;
import java.util.Scanner;

public class Sales {
	
	public static void main(String[] args) {	
		
		// Create list of products
		Product[] all_prods = new Product[4];
	
		// Create each product object
		all_prods[0] = new Product(1, "Coffee", 3.65);
		all_prods[1] = new Product(2, "Tea", 2.45);
		all_prods[2] = new Product(3, "Bagel", 1.50);
		all_prods[3] = new Product(4, "Muffin", 1.85);
		
		// print menu
		menu(all_prods);
		
		// enter product number
		
		saleloop: while(true) {
			
			int product = get_pro();
			
			switch (product) {
			
				case 0:
					reciept(all_prods);
					break saleloop;
				case 1:
					all_prods[0].addItems();	
					break;
				case 2:
					all_prods[1].addItems();
					break;
				case 3:
					all_prods[2].addItems();
					break;
				case 4:
					all_prods[3].addItems();
					break;
				default:
					System.out.println("Product number must be 1 to 4 or 0 to get the receipt, please try again");
					break;
				
			}
		}		
	}


	public static void menu(Product[] all_prods) {
		// print menu
		System.out.println("********** Our Menu **********");
		for ( Product x : all_prods ) {
			String price = String.format("$%.2f", x.getPrice());
			System.out.println(x.getProduct_id() + "\t" + x.getName() + "\t\t" + price);
		}
		System.out.println("********** ******** **********");
	}
	
	
	public static int get_pro() {
		// get product number
		System.out.println("Please enter the product ID from menu (0 to quit and get the reciept)");
		Scanner input = new Scanner(System.in);	
		int id;
		try {
			id = input.nextInt();
		} catch (InputMismatchException e) {
			id = 5;
		}
		return id;
	}				

	
	public static void reciept(Product[] all_prods) {

		System.out.println("********** ******** **********");
		System.out.println(" Here Is Your Order Reciept:");
		System.out.println("Item\tQuantity\tTotal");
		
		double total = 0.00;
		
		for ( Product x : all_prods ) {
			if (x.getTotal() > 0.00) {
				String item_total = String.format("$%.2f", x.getTotal());
				System.out.println(x.getName() + "\t    " + x.getQuantity() + "\t\t" + item_total);
				total += x.getTotal();
			}
		}
		
		double tax = total * 0.06;
		String tax_string =  String.format("$%.2f", tax);
		String total_string =  String.format("$%.2f", total);
		
		System.out.println("\nTax\t\t\t" + tax_string);
		System.out.println("\t\t\t" + total_string);
		System.exit(0);
	}
	
}
