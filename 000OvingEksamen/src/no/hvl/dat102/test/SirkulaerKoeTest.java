package no.hvl.dat102.test;

import no.hvl.dat102.SirkulaerKoe;

public class SirkulaerKoeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SirkulaerKoe<Integer> koe = new SirkulaerKoe<Integer>(11);
		for(int i=0; i<11; i++) {
			koe.innKoe(i);
		}
		
		koe.skriv();
		System.out.println("Bak: " + koe.getBak() +"Foran: "+ koe.getForan());
		koe.utKoe(); koe.utKoe();
		koe.skriv();
		System.out.println("Bak: " + koe.getBak() +"Foran: "+ koe.getForan());
	}

}
