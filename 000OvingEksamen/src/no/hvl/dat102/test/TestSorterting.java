package no.hvl.dat102.test;

import java.util.Random;

import no.hvl.dat102.Sort;

public class TestSorterting {

	public static void main(String[] args) {
		Random ran = new Random();
		Integer[] tab =  new Integer[10];
		for(int i=0; i<10; i++) {
			tab[i] = (Integer)ran.nextInt(100);
		}
		Sort.insertionSort(tab);
//		Sort.selectionSort(tab);
//		Sort.bubbleSort(tab);
//		Sort.quickSort(tab);
//		Sort.mergeSort(tab);

		for(int i=0; i<tab.length; i++) {
			System.out.print(tab[i] + "  ");
	}
	}
}

