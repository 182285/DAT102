package no.hvl.dat102.test;

import java.util.Random;

import no.hvl.dat102.KjedetListe;
import no.hvl.dat102.LinearNode;

public class ListeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KjedetListe<Integer> liste = new KjedetListe<Integer>(3);
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			if(i<4) {
				liste.leggTil(4);
			} else {
				liste.leggTil(rand.nextInt(100));
			}
		}
		liste.skrivUt();
		liste.slettDup();
		liste.skrivUt();

	}

}
