package no.hvl.dat102.test;

import java.util.Random;

import no.hvl.dat102.KjedetMengde;

public class KjedetMengdeTest {

	public static void main(String[] args) {
	KjedetMengde<Integer> mengde = new KjedetMengde<Integer>();
		Random rand = new Random ();
		for(int i=6; i<10; i++) {
			mengde.leggTil(i);
		}
		mengde.skrivUt();
		mengde.snu();
		mengde.skrivUt();
//		mengde.snu();
//		System.out.println();
//		mengde.skrivUt();
//		
////		KjedetMengde<Integer> m2 = new KjedetMengde<Integer>();
////		for(int i=10; i<15; i++) {
////			m2.leggTil(i/2);
////		}
////		m2.skrivUt();
////		
////		mengde.flette(m2);
////		mengde.skrivUt();
////		m2.skrivUt();
		
	} 

}
