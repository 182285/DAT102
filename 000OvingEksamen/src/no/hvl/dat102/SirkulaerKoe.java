package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;

public class SirkulaerKoe <T> implements KoeADT<T> {

	private T[] koe;
	private int antall;
	private int foran;
	private int bak;
	final static int STDK = 100;
	
	public SirkulaerKoe () {
		koe = (T[]) new Object[STDK];
		antall = 0;
		foran = 0;
		bak = 0;
	}
	
	public SirkulaerKoe(int lengde) {
		koe = (T[]) new Object[lengde];
		antall = 0;
		foran = 0;
		bak = 0;
	}
	@Override
	public void innKoe(T element) {
		if(foran==bak && antall>0) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak+1)%koe.length;
		antall ++;
	}

	@Override
	public T utKoe() {
		T ut = koe[foran];
		koe[foran] = null;
		foran = (foran+1)%koe.length;
		antall --;
		return ut;
	}

	@Override
	public T foerste() {
		return koe[0];
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private void utvid() {
		int nyL = koe.length*2;
		T [] hjelpetabell = (T[]) new Object[nyL];
		/*
		 * Legger inn verdiene på samme sted: foran og bak endres ikke.  
		 */
		for(int i=0; i<koe.length; i++) {
			hjelpetabell[i] = koe[i];
			koe = hjelpetabell;
		}
	}
	
	public void skriv() {
		for(int i=0; i<koe.length; i++) {
			System.out.print(koe[i] + " - ");
			
		}
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public int getForan() {
		return foran;
	}

	public void setForan(int foran) {
		this.foran = foran;
	}

	public int getBak() {
		return bak;
	}

	public void setBak(int bak) {
		this.bak = bak;
	}
	
	

}
