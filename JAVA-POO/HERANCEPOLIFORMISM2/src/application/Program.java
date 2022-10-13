package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List <Product> produto = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char carac = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (carac == 'c') {
				produto.add(new Product(name, price));
			}
			if (carac == 'i') {
				System.out.print("Customs fee: ");
				double customfee = sc.nextDouble();
				produto.add(new ImportedProduct(name, price, customfee));
			}
			if (carac == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date data = formato.parse(sc.next());
				produto.add(new UsedProduct(name, price, data));
			}
		}
		
		System.out.println();
		System.out.println("Price TAGS: ");
		for (Product p : produto) {
			System.out.println(p);
		}
		
		sc.close();
	}
}