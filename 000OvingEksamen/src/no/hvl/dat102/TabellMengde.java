package no.hvl.dat102;

public class TabellMengde<T extends Comparable<T>> {
	private int antall;
	private T[] mengde;
	final static int STDK = 100;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		mengde = (T[]) (new Object[STDK]);
	}

	public void leggTil(T element) {
		if (finnes(element) < 0) {

			if (antall == STDK) {
				utvid();
			}
			mengde[antall] = element;
			antall++;
		}
	}

	public int finnes(T element) {
		int plass = -1;
		for (int i = 0; i < antall; i++) {
			if (mengde[i].equals(element)) {
				return i;
			}
		}
		return plass;
	}

	private void utvid() {
		int lengde = mengde.length * 2;
		T[] nyTab = (T[]) (new Object[lengde]);
		for (int i = 0; i < antall; i++) {
			nyTab[i] = mengde[i];
			mengde = nyTab;
		}
	}

	public int getAntall() {
		return this.antall;
	}

	public void slett(T element) {
		int plass = finnes(element);
		if (plass >= 0) {
			mengde[plass] = null;
			for (int i = plass; i < antall; i++) {
				mengde[i] = mengde[i + 1];
				mengde[antall] = null;
				antall--;
			}
		}
	}

	public boolean erLik(TabellMengde<T> m2) {
		boolean lik = true;
		if (this.antall != m2.antall) {
			lik = false;
		} else {

			for (int i = 0; i < antall && lik; i++) {
				if (m2.finnes(mengde[i]) < 0) {
					lik = false;
				}
			}
		}
		return lik;
	}

	public TabellMengde<T> union(TabellMengde<T> m2) {
		TabellMengde<T> union = this;
		for (int i = 0; i < m2.antall; i++) {
			union.leggTil(m2.mengde[i]);
		}
		return union;
	}
	
	public TabellMengde<T> snitt(TabellMengde<T> m2) {
		TabellMengde<T> snitt = new TabellMengde<T>();
		boolean erSnitt = true;
		int minsteantall = Math.min(this.antall,m2.antall);
		int i=0;
		while (erSnitt && i<minsteantall) {
			if(finnes(m2.mengde[i])>=0) {
				i++;
			} else {
				erSnitt=false;
			}
		}
		return snitt;
	}

	public boolean erDelmengde (TabellMengde<T> m2) {
		boolean mengde = true;
		int i=0;
		while(mengde && i<m2.antall) {
			if(finnes(m2.mengde[i])<0) {
				mengde = false;
			} i++;
		}
		return mengde;
	}

	public void skrivut() {
		for (int i = 0; i < antall; i++) {
			if (mengde[i + 1] != null) {
				System.out.println(mengde[i] + "-->");
			} else {
				System.out.println(mengde[i]);
			}
		}
	}

}
