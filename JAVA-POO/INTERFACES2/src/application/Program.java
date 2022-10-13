package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Airplane;

public class Program {
	public static void main (String[] args) {
		List <Airplane> airplanes = new ArrayList<>();
		airplanes.add(new Airplane(1, 500.00, "TP202 [TAM]", 200));
		airplanes.add(new Airplane(2, 500.00, "TP301 [GOL]", 100));
		airplanes.add(new Airplane(3, 200.00, "TP504 [BLUE]", 40));
		
		Collections.sort(airplanes);
		
		System.out.println("-=-= Priority List =-=-");
		airplanes.forEach(airplane -> System.out.println(airplane));
	}
}