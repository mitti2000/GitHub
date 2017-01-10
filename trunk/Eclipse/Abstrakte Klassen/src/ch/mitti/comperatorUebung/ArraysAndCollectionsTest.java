package ch.mitti.comperatorUebung;

import java.util.Arrays;

public class ArraysAndCollectionsTest {

	public static void main(String[] args) {
		int[] unsorted = {5,6,1,123,543,32,53,75,89};
		System.out.println("Unsortiert:");
		System.out.println("-----------");
		for(int i : unsorted){
			System.out.println(i);
		}
		
		Arrays.sort(unsorted);
		
		System.out.println("Sortiert:");
		System.out.println("---------");
		for(int i : unsorted){
			System.out.println(i);
		}

	}

}
