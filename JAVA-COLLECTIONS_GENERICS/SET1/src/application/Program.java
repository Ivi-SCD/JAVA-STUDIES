package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		//Show all colors.
		System.out.println("All colors:");
		Set<String> colorsRainbow = new HashSet<>(Arrays.asList("Violet",
				"Indigo", "Green", "Yellow", "Orange", "Red"));
		colorsRainbow.forEach(e -> System.out.println(e));
		
		//Show the number of colors the rainbow contains
		System.out.println("\nShow All numbers:");
		int counter = 0;
		// Can be used colorsRainbow.size();
		for(@SuppressWarnings("unused") String color: colorsRainbow) counter++;
		
		System.out.println("The number of colors in the rainbow is <"
				+ counter + ">");
		
		//Show the colors in alphabetical order
		System.out.println("\nAlphabetical Order:");
		Set<String> colorsRainbowAlphabetical = new TreeSet<>(colorsRainbow);
		colorsRainbowAlphabetical.forEach(e -> System.out.println(e));
		
		//Show the colors in inverse order of the informed
		System.out.println("\nInverse Order:");
		Set<String> colorsRainbowInOrder = new LinkedHashSet<>(colorsRainbow);
		List<String> colorsRainbowInverseOrder = new ArrayList<>(colorsRainbowInOrder);
		Collections.reverse(colorsRainbowInverseOrder);
		colorsRainbowInverseOrder.forEach(e -> System.out.println(e));
		
		//Show all colors that starts with "V"
		System.out.println("\nWith 'v':");
		for(String color : colorsRainbowInOrder) {
			if(color.contains("v") || color.contains("V")) {
				System.out.println(color);
			} //Can be used color.startsWith("V")
		}
		
		//Clear the set
		System.out.println("\nCleaning the set . . .");
		colorsRainbowInOrder.clear();
		
		//Check if the set is empty
		System.out.println("\nSet is empty? " + colorsRainbowInOrder.isEmpty());
		
	}
}