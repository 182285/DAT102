package no.hvl.dat102.test;

import java.util.Random;

import no.hvl.dat102.TabellHaug;

public class MainTestHaug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	TabellHaug<Integer> haug = new TabellHaug<Integer>();
	Random rand = new Random();
	for(int i=0; i<5; i++) {
		haug.leggTil(rand.nextInt(7));
	}
	haug.skrivTab();
//	System.out.println(haug.finnMinste());
//	haug.fjernMinste();
//	System.out.println(haug.finnMinste());
//	haug.slettSiste();
	haug.fjern(19);
	haug.fjern(1);
	haug.skrivTab();
	
	

}
}
