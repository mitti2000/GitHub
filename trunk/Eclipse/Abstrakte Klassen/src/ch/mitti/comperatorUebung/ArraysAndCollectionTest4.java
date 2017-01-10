package ch.mitti.comperatorUebung;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysAndCollectionTest4 {

	public static void main(String[] args) {
		Comparator<Bier> comp = new BierNameComparator();
		
		Bier[] biere = {new Bier("w�rzburger Hofbr�u", "W�rzburg", 0.5F),
				new Bier("Becks", "Bremen", 0.33F),
				new Bier("Paulaner", "M�nchen", 0.5F),
				new Bier("Distelh�user", "Distelhausen", 0.33F) };
		
		System.out.println("Unsortiert");
		System.out.println("----------");
		for (Bier bier : biere){
			System.out.println(bier);
		}
		
		Arrays.sort(biere, comp);
		
		System.out.println("Sortiert:");
		System.out.println("---------");
		for(Bier bier : biere){
			System.out.println(bier);
		}

	}

}
