package ch.mitti.sorting;

public class StraightInsertation implements Isorter {
	int hilf;
	int j;
	
	public StraightInsertation() {
		hilf = -1;
	}
	
	@Override
	public void sort(int[] zahlen) {
		
		for(int i=1;i<(zahlen.length);i++){
			//hilf = zahlen[i];
			
			for(j=i; (j>=1) && (hilf < zahlen[j-1]);j--){
				hilf = zahlen[i];
				zahlen[j] = zahlen[j-1];
			}
			zahlen[j] = hilf;
		}
	}
}
