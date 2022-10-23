package application;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Program {
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("Create a dictionary with state and population");
		Map <String, Double> population = new HashMap<>();
		population.put("PE", 9616621d);
		population.put("AL", 3351543d);
		population.put("CE", 9187103d);
		population.put("RN", 3534265d);
		System.out.println(population);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nUpdate data of 'RN'");
		population.put("RN", 3534165d);
		System.out.println(population);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShowing if PB is on dictionary");
		population.put("PB", 403977d);
		System.out.println(population);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShowing the population 'PE'");
		System.out.println(population.get("PE"));
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShowing in insection order");
		Map <String, Double> populationInOrder = new LinkedHashMap<>();
		populationInOrder.put("PE", 9616621d);
		populationInOrder.put("AL", 3351543d);
		populationInOrder.put("CE", 9187103d);
		populationInOrder.put("RN", 3534265d);
		System.out.println(populationInOrder);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShowing in alphabetical order");
		Map<String, Double> populationInAlphaOrder = new TreeMap<>(populationInOrder);
		System.out.println(populationInAlphaOrder);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShow the state with lowest population");
		Double valueMin = Collections.min(populationInAlphaOrder.values());
		String keyMin = "";
		for(Entry<String, Double> pop : populationInAlphaOrder.entrySet()) {
			if(pop.getValue() == valueMin) {
				keyMin = pop.getKey();
			}
		}
		System.out.println(valueMin + " - " + keyMin);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShow the state with higher population");
		Double valueMax = Collections.max(populationInAlphaOrder.values());
		String keyMax = "";
		for(Entry <String, Double> pop : populationInAlphaOrder.entrySet()) {
			if(pop.getValue() == valueMax) {
				keyMax = pop.getKey();
			}
		}
		System.out.println(valueMax + " - " + keyMax);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShow the sum of population of those states");
		Double sum = 0d;
		for(Entry <String, Double> pop : populationInAlphaOrder.entrySet()) {
			sum += pop.getValue();
		}
		System.out.println(sum);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nShow the average");
		System.out.println(sum/populationInAlphaOrder.size());
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nRemove all states with population less than 4.10E6");
		Map <String, Double> popRemove = new HashMap<>(populationInAlphaOrder);
		Set<Map.Entry<String, Double>> pop = popRemove.entrySet();
		pop.removeIf(t -> t.getValue() < 4000000d );
		
		System.out.println(popRemove);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nDelete all states");
		populationInAlphaOrder.clear();
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("\nCheck if the map is empty");
		populationInAlphaOrder.isEmpty();
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}
}