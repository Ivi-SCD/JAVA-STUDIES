package application;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import entities.Contact;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("-- Name contact order-- ");
		Map <String, Contact> agenda = new HashMap<>();
		
		agenda.clear();
		agenda.put("Ivisson", new Contact(null, 99999999));
		agenda.put("Leticia", new Contact(null, 88888888));
		agenda.put("Lucas", new Contact(null, 77777777));
		agenda.put("Stelzer", new Contact(null, 22222222));
		agenda.put("Sabrina", new Contact(null, 21111111));
			
		/*
		 
		 Using Anonymous Class
		 
		Set<Map.Entry<String, Contact>> set2 = new TreeSet<>(new Comparator <Map.Entry<String, Contact>>() {

			@Override
			public Integer compare(Entry<String, Contact> o1, Entry<String, Contact> o2) {
				return Integer.compare(o1.getValue().getPhonenumber(), o2.getValue().getPhonenumber());
			}
			
		});
		
		*/
		
		/* 
 			Using Functional Interface
 				
		   Comparator.comparing(new Function<Map.Entry<String, Contact>, Integer>() {
			
			@Override
			public Integer apply(Entry<String, Contact> contEntry) {
				return contEntry.getValue().getPhonenumber();
			}
		}); 
		
		*/
		
		
		// Lambda Expression
		Set<Map.Entry<String, Contact>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getPhonenumber()));
		set.addAll(agenda.entrySet());
		
		set.forEach(people -> System.out.println(people.getKey() + " - " + people.getValue().getPhonenumber()));
	}
}