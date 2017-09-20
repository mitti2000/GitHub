package ch.mitti.sorting;

public class Quicksort implements Isorter {
	
	@Override
	public void sort(int[] zahlen) {
		quicksort(0, zahlen.length-1, zahlen); 
	}
	
	private void quicksort(int links, int rechts, int[] feld){
		int element;
		int hilf;
		int li = links;
		int re = rechts;
		if(rechts>links){
			element = feld[(links+rechts)/+2];
			do{
				while(feld[li]<element)
					li++;
				while(feld[re]>element)
					re--;
				if(li<=re){//<= wegen Tausch in Quicksort, vgl. dort
					hilf = feld[li];
					feld[li] = feld[re];
					feld[re] = hilf;
					li++;
					re--;
				}
			} while(re>li);
			if(links<re) quicksort(links,re, feld);
			if(li<rechts) quicksort(li,rechts, feld);
		}
	}
}
