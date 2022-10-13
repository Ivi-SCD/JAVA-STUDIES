package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPayer> pi = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char carac = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Anual income: ");
			double anualincome = sc.nextDouble();
			
			if(carac == 'i') {
				System.out.print("Health expenditures: ");
				double healthexpenditures = sc.nextDouble();
				pi.add(new Individual(name, anualincome, healthexpenditures));
			}
			if(carac == 'c') {
				System.out.print("Number of employees: ");
				int numemployees = sc.nextInt();
				pi.add(new Company(name, anualincome, numemployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		for(TaxPayer t : pi) {
			System.out.println(t);
		}
		double total = 0;
		for(TaxPayer t : pi) {
			total += t.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $" + total);
		
		sc.close();
	}
}