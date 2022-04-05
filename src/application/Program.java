package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name :");
		String name = in.nextLine();
		System.out.print("Email :");
		String email = in.nextLine();
		System.out.print("Birth date(dd/mm/yyyy): ");
		Date birthDate = sdf.parse(in.next());
		
		Client client = new Client(name, email, birthDate);
		
		//Aqui instanciamos um objeto client da classe Client.
//<<<----------------------------------------------------------->>		
		
		System.out.println();
		System.out.println("Enter order data: ");
		System.out.print("Status :");
		OrderStatus status = OrderStatus.valueOf(in.next());
		
		//Usaremos o tipo enum para receber dados do usário.
		
//<<<------------------------------------------------------------------------>>
		
		//Instancia do objeto order do tipo Order associado ao objeto client.
		//Associação do tipo tem um.
		Order order = new Order(new Date(), status, client);
//<<------------------------------------------------------------------------->>		

		System.out.println("How many items to this order? ");
		int n = in.nextInt();
		
        //For para verificar quantas vezes seram instanciados os objetos.		
		for(int i = 1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			in.nextLine();
			String productName = in.nextLine();
			System.out.print("Product price: ");
			double productPrice = in.nextDouble();
			
			
			Product product = new Product(productName, productPrice);
            // Aqui instanciamos um objeto product do tipo Product.	
			
			System.out.println("Quantity: ");
			int quantity = in.nextInt();
//---------------------------------------------------------------------------->>			
			//Aqui instaciamos um objeto ordit do tipo Orderitem associado ao objeto product.
			OrderItem ordit = new OrderItem(quantity, productPrice, product);
			
//---------------------------------------------------------------------------->>			
			
			//Inlcuimos o objeto ordit dentro da lista items através da chamada do obejto . função addItem.
			order.addItem(ordit);
			
		}
			System.out.println();
			System.out.println("ORDER SUMMARY: ");
			System.out.println(order);
		
		in.close();

	}

}
