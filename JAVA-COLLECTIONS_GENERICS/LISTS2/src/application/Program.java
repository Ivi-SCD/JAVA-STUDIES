package application;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		List<Double> tempMeses = new LinkedList<>();

		for (int i = 0; i < 6; i++) {
			System.out.println("Digite a temperatura do mes <" + (i + 1) + "> em Celsius :");
			Double valorTemp = sc.nextDouble();
			tempMeses.add(valorTemp);
		}

		Double media = 0d;
		Iterator<Double> iterador = tempMeses.iterator();
		while (iterador.hasNext()) {
			Double proxTemp = iterador.next();
			
			media += ((proxTemp) / tempMeses.size());
		}
		
		System.out.println("\nMeses abaixo da media:");
		for (Double e : tempMeses) {
			if (e > media) {
				int i = tempMeses.indexOf(e);
				switch (i) {
					case 0:
						System.out.println("Janeiro");
						break;
					case 1:
						System.out.println("Feveiro");
						break;
					case 2:
						System.out.println("Marco");
						break;
					case 3:
						System.out.println("Abril");
						break;
					case 4:
						System.out.println("Maio");
						break;
					case 5:
						System.out.println("Junho");
						break;
				}
			}
		}
		sc.close();
	}
}