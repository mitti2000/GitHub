package ch.mitti.comperatorUebung;

import java.util.Comparator;

public class BierNameComparator implements Comparator<Bier> {
	
	@Override
	public int compare(Bier b1, Bier b2){
		if(b1.getName() == null && b2.getName() == null){
			return 0;
		}
		
		if(b1.getName() == null){
			return 1;
		}
		
		if(b2.getName() == null){
			return -1;
		}
		
		return b1.getName().compareTo(b2.getName());
	}
}
