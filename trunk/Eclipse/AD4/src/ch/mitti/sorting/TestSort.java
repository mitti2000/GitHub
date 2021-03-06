package ch.mitti.sorting;

import java.util.*;

public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int MAX=100;
		int[] zahlen = new int[MAX];
		Random r = new Random();
		long s,e;
		
//		StraightSelection sorter = new StraightSelection();
//		ShellSort sorter = new ShellSort();
//		BubbleSort sorter = new BubbleSort();
//		Shakersort sorter = new Shakersort();
		Quicksort sorter = new Quicksort();
//		Quicksortopt sorter = new Quicksortopt();
//		StraightInsertation sorter = new StraightInsertation();
//		StudAufgabe sorter = new StudAufgabe();
	
		
		// Zahlenwerte einf�gen
		for(int i=0; i<MAX;i++)
		{
			zahlen[i] = r.nextInt(10 * MAX);
//			zahlen[i] = i;
		}
		
		s = System.currentTimeMillis();
		sorter.sort(zahlen);
		e = System.currentTimeMillis();
		System.out.println("Das Sortieren dauerte "+ (e-s) + " Millisekunden");
		// Ausgabe
		if (MAX <= 1000)
		{
			for(int i=0; i < MAX; i++)
			{
				System.out.print(" " + zahlen[i]);
				if (i%20 == 0 && i > 0)
				{
					System.out.println("");
				}
			}
		}
	}
}
