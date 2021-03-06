package ch.mitti.tierwelt;

import java.util.ArrayList;
import java.util.Iterator;

public class Zoo {

	public static void main(String[] args) {
		ArrayList<Lebewesen> zoo = new ArrayList<Lebewesen>();
		int anzahlKatzen = 0;
		int anzahlHunde = 0;
		int anzahlWellensittich = 0;
		
		zoo.add(new Katze());
		zoo.add(new Katze());
		zoo.add(new Katze());
		
		zoo.add(new Hund());
		zoo.add(new Hund());

		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		zoo.add(new Wellensittich());
		
		Iterator<Lebewesen> it = zoo.iterator();
		while(it.hasNext()){
			Lebewesen lebewesen = it.next();
			if(lebewesen.gibLebt())System.out.println(lebewesen.gibLaut());
			if(lebewesen instanceof Hund) anzahlHunde++;
			else if(lebewesen instanceof Katze) anzahlKatzen++;
			else if(lebewesen instanceof Wellensittich) anzahlWellensittich++;
		}
		System.out.println("Anzahl Hunde: "+anzahlHunde);
		System.out.println("Anzahl Katzen: "+anzahlKatzen);
		System.out.println("Anzahl Wellensittiche: "+anzahlWellensittich);

	}

}
