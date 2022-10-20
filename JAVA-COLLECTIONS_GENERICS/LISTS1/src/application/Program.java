package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;

public class Program {
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Pessoa> pessoas = new ArrayList<>();
		
		System.out.print("Quantas pessoas serao armazenadas: ");
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.printf("#### Pessoa numero (%d)", (i+1));
			
			System.out.print("\nDigite o nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Digite a idade: ");
			Integer idade = sc.nextInt();
			
			System.out.print("Digite a altura: ");
			Double altura = sc.nextDouble();
			
			System.out.print("Digite o peso: ");
			Double peso = sc.nextDouble();
			
			System.out.print("Digite o sexo (H/M): ");
			char sexo = sc.next().charAt(0);
			
			pessoas.add(new Pessoa(nome, idade, altura, peso, sexo));
		}
		
		System.out.println();
		pessoas.forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome() 
		+ "| Peso: " + pessoa.getPeso() 
		+ "| Verificacao de peso ideal: " + pessoa.mostrarResultadoPeso()));
		
		sc.close();
	}
}