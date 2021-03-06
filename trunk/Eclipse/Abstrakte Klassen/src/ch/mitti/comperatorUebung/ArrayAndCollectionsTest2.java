package ch.mitti.comperatorUebung;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayAndCollectionsTest2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(8);
		list.add("Sebastian W�rkner");
		list.add("Stefan Kiesel");
		list.add("Andreas Pries");
		list.add("Byte-Welt.de");
		list.add("Erich Gamma");
		list.add("Richard Helm");
		list.add("Ralph Johnson");
		list.add("John Vlissides");
		
		System.out.println("Unsortiert:");
		System.out.println("-----------");
		for(String str : list){
			System.out.println(str);
		}
		
		Collections.sort(list);
		
		System.out.println("Sortiert:");
		System.out.println("---------");
		for(String str : list){
			System.out.println(str);
		}
		
	}

}
