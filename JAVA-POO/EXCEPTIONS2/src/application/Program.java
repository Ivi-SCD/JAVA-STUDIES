package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BankException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account data.");
		
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Initial Balance: ");
		double balance = sc.nextDouble();
		
		System.out.print("Withdraw limit: ");
		double withDrawLimit = sc.nextDouble();
		
		Account conta = new Account(number, name, balance, withDrawLimit);
		
		try {
			System.out.print("Enter amount for withdraw: ");
			conta.withdraw(sc.nextDouble());
		}
		catch (BankException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unknow error :(");
		}
		
		
		sc.close();
	}
}