package no.hvl.dat102;

public class TabellHaug<T extends Comparable<T>> {
	private T[] tabell;
	private int antall;
	final static int STDK = 100;

	public TabellHaug() {
		tabell = (T[]) new Comparable[STDK];
		antall = 0;
	}

	public void leggTil(T element) {
		if (antall == tabell.length) {
			utvid();
		}
		tabell[antall] = element;
		antall++;
		if (antall > 1) {
			reparerOpp();
		}
	}

	private void utvid() {
		int lengde = tabell.length;
		T[] ny = (T[]) new Comparable[lengde * 2];
		for (int i = 0; i < antall; i++) {
			ny[i] = tabell[i];
			tabell = ny;
		}

	}

	public void slettSiste() {
		tabell[antall] = null;
		antall--;
	}

	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = tabell[0];
			tabell[0] = tabell[antall - 1];
			reparerNed();
			antall--;
		}
		return svar;
	}

	public T finnMinste() {
		if (erTom()) {
			return null;
		} else
			return tabell[0];
	}

	public void reparerOpp() {
		int rettPlass = antall - 1;
		T tmp = tabell[rettPlass];
		int forelder = (rettPlass - 1) / 2;
		while (rettPlass > 0 && tmp.compareTo(tabell[forelder]) < 0) {
			tabell[rettPlass] = tabell[forelder];
			rettPlass = forelder;
			forelder = (rettPlass - 1) / 2;
		}
		tabell[rettPlass] = tmp;
	}

	public void reparerNed() {
		T temp = tabell[0];
		int minsteBarn;
		int start = 0;
		int vBarn = (start * 2) + 1;
		int hBarn = vBarn + 1;
		boolean ferdig = false;
		do {
			vBarn = start * 2 + 1;
			hBarn = vBarn + 1;
			if (vBarn < antall) {
				minsteBarn = vBarn;
				if (hBarn < antall) {
					if (tabell[hBarn].compareTo(tabell[vBarn]) < 0) {
						minsteBarn = hBarn;
					}
				}
				if (tabell[minsteBarn].compareTo(temp) < 0) {
					tabell[start] = tabell[minsteBarn];
					start = minsteBarn;
				} else {
					ferdig = true;
				}
			} else {
				ferdig = true;
			}
		} while (!ferdig);
		tabell[start] = temp;

	}
	

	private boolean erTom() {
		return (antall == 0);
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public T[] reparerNedRek(T[] tab, int start, int slutt) {
		// Base
		T temp;
		int vBarn = start * 2 + 1;
		int hBarn = vBarn + 1;
		int minsteBarn = vBarn;
		if (tab[vBarn].compareTo(tab[hBarn]) > 0) {
			minsteBarn = hBarn;
		}
		if (tab[start].compareTo(tab[minsteBarn]) < 0 && start < slutt) {
			return tab;
		} else {
			temp = tab[minsteBarn];
			tab[minsteBarn] = tab[start];
			tab[start] = temp;
			start = minsteBarn;
			return reparerNedRek(tab, start, slutt);

		}
	}

	public void reparerNedmRek() {
		tabell = reparerNedRek(tabell, 0, antall);
	}

	public void skrivTab() {
		// Hjelpemetode til test
		for (int i = 0; i < antall; i++)
			System.out.print(tabell[i] + " ");
		System.out.println();
	}
	
	public void fjern(T element) {
		String s = "Elementet finnes ikke i haugen";
		boolean funnet = false;
		int i=0; 
		while(i<antall && !funnet) {
			if (tabell[i].equals(element)) {
				funnet = true;
				antall--;
				tabell[i] = tabell[antall];
				tabell[antall] = null;
				reparerNed();
			}
			i++;
		}
		if(!funnet) {
			System.out.println(s);
		}
	}
	

} //class body
