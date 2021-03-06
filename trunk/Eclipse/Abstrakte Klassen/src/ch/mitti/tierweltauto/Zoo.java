package ch.mitti.tierweltauto;

import java.util.ArrayList;
import java.util.Iterator;

public class Zoo {

	public static void main(String[] args) {
		ArrayList<Hoerbar> zoo = new ArrayList<Hoerbar>();
		int anzahlKatzen = 0;
		int anzahlHunde = 0;
		int anzahlWellensittich = 0;
		int anzahlAutos = 0;
		
		zoo.add(new Katze());
		zoo.add(new Katze());
		zoo.add(new Katze());
		
		zoo.add(new Hund());
		zoo.add(new Hund());

		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		
		zoo.add(new Auto());
		
		Iterator<Hoerbar> it = zoo.iterator();
		while(it.hasNext()){
			Hoerbar imZoo = it.next();
			if(imZoo instanceof Lebewesen){
				if(((Lebewesen) imZoo).gibLebt()) System.out.println(imZoo.gibLaut());
			}
			else System.out.println(imZoo.gibLaut());
			
			if(imZoo instanceof Hund) anzahlHunde++;
			else if(imZoo instanceof Katze) anzahlKatzen++;
			else if(imZoo instanceof Wellensittich) anzahlWellensittich++;
			else if(imZoo instanceof Auto) anzahlAutos++;
		}
		System.out.println("Anzahl Hunde: "+anzahlHunde);
		System.out.println("Anzahl Katzen: "+anzahlKatzen);
		System.out.println("Anzahl Wellensittiche: "+anzahlWellensittich);
		System.out.println("Anzahl Autos: "+anzahlAutos);

	}

}
