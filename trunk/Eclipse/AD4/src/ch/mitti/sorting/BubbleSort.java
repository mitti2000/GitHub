package ch.mitti.sorting;

public class BubbleSort implements Isorter {

	boolean sorted;
	
	public BubbleSort() {
		sorted = false;
	}

	@Override
	public void sort(int[] zahlen) {
		for(int i=zahlen.length-1; i>=1; i--){
			if(sorted) return;
			sorted = true;
			for(int j=1; j<=i ; j++){
				if(zahlen[j] < zahlen[j-1]){
					int temp = zahlen[j];
					zahlen[j] = zahlen[j-1];
					zahlen[j-1]=temp;
					sorted = false;
				}
			}
		}
	}
}
