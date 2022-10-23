package application;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Map <String, Integer> valores = new LinkedHashMap<>();
		for(int i = 0; i < 100; i++) {
			Integer num = (int) (Math.random()*100);
			valores.put(String.format("%d", i+1), 0);
			
			Set <Map.Entry<String, Integer>> val = valores.entrySet();
			
			for(Entry<String, Integer> v : val) {
				int count = 1;
				if(num.toString().equals(v.getKey())) {
					v.setValue(v.getValue()+count);
				}
			}
		}
		
		valores.forEach((t, u) -> System.out.println(t + "=" + u));
	}
}