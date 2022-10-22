package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.FavoriteLanguage;

public class Program {
	public static void main(String [] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Set<FavoriteLanguage> languages = new LinkedHashSet<>();
		
		languages.add(new FavoriteLanguage("Python", sdf.parse("10/10/1989"), "PyCharm"));
		languages.add(new FavoriteLanguage("Java", sdf.parse("10/10/1991"), "Eclipse"));
		languages.add(new FavoriteLanguage("C", sdf.parse("10/10/1972"), "DevC"));
		
		System.out.println("Insection Order:");
		languages.forEach(e -> System.out.println(e));
		
		System.out.println("\nNatural Order:");
		
		Set <FavoriteLanguage> languagesTreeSet = new TreeSet<>(languages);
//		languagesTreeSet.add(new FavoriteLanguage("Python", sdf.parse("10/10/1989"), "PyCharm"));
//		languagesTreeSet.add(new FavoriteLanguage("Java", sdf.parse("10/10/1991"), "Eclipse"));
//		languagesTreeSet.add(new FavoriteLanguage("C", sdf.parse("10/10/1972"), "DevC"));
		
		languagesTreeSet.forEach(e -> System.out.println(e));
		
		System.out.println("\nOrderIDE: ");
		Set <FavoriteLanguage> languagesTreeSetIde = new TreeSet<>(new ComparatorIde());
		languagesTreeSetIde.addAll(languages);
		
		languagesTreeSetIde.forEach(e -> System.out.println(e));
		
	}
}


class ComparatorIde implements Comparator<FavoriteLanguage> {

	@Override
	public int compare(FavoriteLanguage fl1, FavoriteLanguage fl2) {
		return fl1.getIde().compareToIgnoreCase(fl2.getIde());
	}
}