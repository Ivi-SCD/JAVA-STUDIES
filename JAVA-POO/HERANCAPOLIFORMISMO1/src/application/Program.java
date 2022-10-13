
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> client = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			System.out.println("Employee #" + (i + 1) + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char carac = sc.next().charAt(0);
			if (carac == 'n') {
				System.out.print("Name: ");
				String nome = sc.next();

				System.out.print("Hours: ");
				int hours = sc.nextInt();

				System.out.print("Value per hour: ");
				double valperhour = sc.nextDouble();

				Employee cliente = new Employee(nome, hours, valperhour);
				client.add(cliente);
			}
			
			if (carac == 'y') {
				System.out.print("Name: ");
				String nome = sc.next();

				System.out.print("Hours: ");
				int hours = sc.nextInt();

				System.out.print("Value per hour: ");
				double valperhour = sc.nextDouble();

				System.out.print("Additional Charge: ");
				double additionalcharge = sc.nextDouble();

				Employee cliente = new OutSourcedEmployee(nome, hours, valperhour, additionalcharge);
				client.add(cliente);
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee c : client) {
			System.out.println(c);
		}

		sc.close();
	}
}