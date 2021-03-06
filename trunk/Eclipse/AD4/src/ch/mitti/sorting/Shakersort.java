package ch.mitti.sorting;

public class Shakersort implements Isorter {
	boolean direction;
	int posBottom;
	int posTop;
	boolean sorted;
	
	public Shakersort() {
		direction = true;
		sorted = false;
	}

	@Override
	public void sort(int[] zahlen) {
		posTop = zahlen.length -1;
		posBottom = 0;
		while(!sorted){
			sorted = true;
			if(direction){
				for(int j=posBottom; j<posTop ; j++){
					if(zahlen[j] > zahlen[j+1]){
						int temp = zahlen[j];
						zahlen[j] = zahlen[j+1];
						zahlen[j+1]=temp;
						sorted = false;
					}
				}
				posTop--;
				direction=false;
			}
			
			else{
				for(int j=posTop; j>posBottom;j--){
					if(zahlen[j-1] > zahlen[j]){
						int temp = zahlen[j];
						zahlen[j] = zahlen[j-1];
						zahlen[j-1]=temp;
						sorted = false;
					}
				}
				posBottom++;
				direction=true;
			}
			
			if(posTop-1 <= posBottom){
				sorted = true;			
				}
		}

	}

}
