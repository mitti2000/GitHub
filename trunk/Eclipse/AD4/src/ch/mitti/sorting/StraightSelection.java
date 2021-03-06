package ch.mitti.sorting;

public class StraightSelection implements Isorter {
	int hpos;
	int temp;
	
	public StraightSelection() {
		hpos = -1;
		
	}

	@Override
	public void sort(int[] zahlen) {
		for(int i=0; i < (zahlen.length-1); i++){
			hpos = i;
			for(int j=i+1;j<zahlen.length;j++){
				if(zahlen[j]<zahlen[hpos]){
					hpos = j;
				}
			}
			temp = zahlen[i];
			zahlen[i]=zahlen[hpos];
			zahlen[hpos] = temp;
			hpos=-1;
			temp=-1;
		}
	}

}
