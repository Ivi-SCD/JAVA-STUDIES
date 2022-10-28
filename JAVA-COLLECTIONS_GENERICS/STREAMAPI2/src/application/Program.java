package application;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Program {

	public static void main(String[] args) {
		List <Integer> list = Arrays.asList(1, 2, 3, 4, 5, 20, 1001);
		
		/*
		list.stream().filter(new Predicate<Object>() {

			@Override
			public boolean test(Object t) {
				return (Integer) t%2 != 0 ;
			}
		}).toList();
		*/
		
		System.out.println(list.stream()
				.filter(t -> t%2 != 0).toList());
		
		List <String> list2 = Arrays.asList("Ivisson", "Fernanda", "Lucas", "leticia");
		
		list2.stream().map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				String [] array = t.split("");
				
				return array[0];
			}
		}).filter(x -> x.charAt(0) >= 65 && x.charAt(0) <= 90 ).forEach(System.out::println);
		
	}
}