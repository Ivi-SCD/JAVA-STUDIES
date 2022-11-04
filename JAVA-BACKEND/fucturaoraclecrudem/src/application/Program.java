package application;

import domain.entities.Book;


public class Program {
	public static void main(String [] args) {
		
		Book b1 = new Book(1, "Dracula", "Bram Stroker", "Terror");
		System.out.println(b1);
	}
}