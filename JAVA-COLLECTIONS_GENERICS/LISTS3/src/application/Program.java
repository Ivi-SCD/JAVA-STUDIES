package application;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List <String> list = new LinkedList<>();
		
		String [] pergunta = new String[] {"Telefonou para a vitima? ",
				"Esteve no local do crime? ",
				"Mora perto da vitima? ",
				"Devia para a vitima? ",
				"Ja trabalhou com a vitima? "};
		
		System.out.println("O interrogatorio ira comecar favor usar (S/N)");
		for(int i = 0; i < 5; i++) {
			System.out.println(pergunta[i]);
			list.add(sc.next());
		}
		
		int numSim = 0;
		
		for(String classification : list) {
			if(classification.equals("S")) {
				numSim++;
			} else {
				System.out.print("");
			}
		}
		
		System.out.println("Classificacao: ");
		if(numSim == 2) {
			System.out.print("Suspeito");
		} else if (numSim == 3 || numSim == 4) {
			System.out.print("Cumplice");
		} else if (numSim == 5) {
			System.out.print("Assassino");
		} else {
			System.out.print("Inocente");
		}
		
		sc.close();
	}
}