package no.hvl.dat102;

import java.util.List;

public class Sort<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void selectionSort(T[] tab) {
		/**
		 * Temp lagrer objektet Minste lagrer plassen der det minste objektet ligger.
		 */
		T temp;
		int minste;
		/**
		 * Ytre for: gjennoml�per tabellen til nest siste plass, setter akutell plass
		 * som minste Indre: sammenligner resten av tabellen med sortert del(0) i f�rste
		 * omgang
		 */
		for (int i = 0; i < tab.length - 1; i++) {
			minste = i;
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[j].compareTo(tab[minste]) < 0) {
					minste = j;
				}
			}
			/**
			 * Ytre: etter riktig plass for i er hentet og hvilket tall som er det minste,
			 * bytter disse plass, bruker temp som hjelpevariabel.
			 */
			temp = tab[minste];
			tab[minste] = tab[i];
			tab[i] = temp;
		}
	}

	public static <T extends Comparable<T>> void insertionSort(T[] tab) {
		/**
		 * Temp lagrer Metoden har en sortert og en usortert del Sammenligner neste i
		 * usortert med sist ei sortert, hvis mindre s� bytter de plass
		 */
		T temp;
		/**
		 * Ytre looper gjennom tabellen fra og med andre posisjon(i=1) setter
		 * tellevariablen like enden p� sortert del for hver gang Temp gir oss
		 * sammenlignningsgrunnlaget og holder p� variablen vi skal bytte etter hvert
		 * gjennoml�p i den indre l�kka
		 */
		for (int i = 1; i < tab.length; i++) {
			temp = tab[i];
			int j = i;

			/**
			 * Jibber oss gjennom den sorterte delen for � plassere tallet p� riktig plass
			 * s� lenge indeksen bak er mindre enn temp (tab[i]) s� fortsetter l�kka
			 */
			while (j > 0 && tab[j - 1].compareTo(temp) > 0) {
				tab[j] = tab[j - 1];
				j--;
			}
			tab[j] = temp;

		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] tab) {
		/**
		 * Temp holder p� aktuelt objekt
		 */
		T temp;
		int bytter;
		/**
		 * Ytre l�kke jobber seg fra enden stil starten, holder kontroll p� sortert del
		 */
		for (int sortert = tab.length - 1; sortert >= 0; sortert--) {
			bytter = 0;
			/**
			 * Indre l�kke sammenligner to og to elementer og bytter plass p� disse hvis det
			 * til venstre er st�rre en det til h�yre gj�r dette til sortert del er n�dd, da
			 * det st�rste tallet i usortert del alltid blir det neste i sortert
			 * del(bakenifra)
			 */
			for (int usortert = 0; usortert < sortert; usortert++) {
				if (tab[usortert].compareTo(tab[usortert + 1]) > 0) {
					temp = tab[usortert];
					tab[usortert] = tab[usortert + 1];
					tab[usortert + 1] = temp;
					bytter++;
				}

			}
			/**
			 * Hvis det ikke er noen bytter vil tabellen v�re sortert Skriver ut i hvilket
			 * gjennoml�p tabllen er ferdig sortert Dette gj�r at i beste tilfelle kan vi f�
			 * O(n)
			 */
			if (bytter == 0) {
				System.out.println("Null bytter i gjennoml�p nr: " 
			+ (tab.length - sortert) + ", dermed sortert");
				return;
			}

		}
	}

	public static <T extends Comparable<T>> void quickSort(T[] tab) {
		/** Sorterer en hel tabell */
		quickSort(tab, 0, tab.length - 1);
	}
	


	private static <T extends Comparable<T>> void quickSort(T[] tab, int min, int maks) {
		int posPartisjon;
		if (min < maks) {
			/** Lag partisjon */
			posPartisjon = finnPartisjon(tab, min, maks);

			/** Sorterer venstre side */
			quickSort(tab, min, posPartisjon - 1);
			/** H�yre side */
			quickSort(tab, posPartisjon + 1, maks);
		}
	}

	private static <T extends Comparable<T>> int finnPartisjon(T[] tab, int min, int maks) {
		/**
		 * Setter pivot som det f�rste elementet i tabellen tildeler h�yre og
		 * venstrepeker
		 */
		int venstre, hoyre;
		T temp, pivot;
		pivot = tab[min];
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {

			/**
			 * Looper s� lenge tab vensre er mindre eller lik (<=) pivot.
			 * Stopper l�kka og lagrer indeks n�r den finner f�rste som er st�rre enn pivot
			 * eller n�r venstre har blitt st�rre enn h�yre
			 */
			while (venstre < hoyre && tab[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/**
			 * Looper s� lenge elementet er st�rre enn pivot. N�r h�yre blir mindre enn venstre
			 * eller man finner et element som er mindre enn pivot avsluttes l�kka, indeks lagres
			 * 
			 */
			while (tab[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			/**
			 * Bytter elementene
			 */
			if (venstre < hoyre) {
				temp = tab[venstre];
				tab[venstre] = tab[hoyre];
				tab[hoyre] = temp;
			}
		} // ytr while

		/**
		 * FLytter pivot til sin riktige plass
		 */
		temp = tab[min];
		tab[min] = tab[hoyre];
		tab[hoyre] = temp;

		return hoyre;
	}

	public static <T extends Comparable<T>> void mergeSort(T[] tab) {
		mergeSort(tab, 0, tab.length - 1);
	}
	
	private static <T extends Comparable<T>> void merge(T[] tab, int min, int midten, int maks) {
		int lengde = maks - min + 1;
		T[] hjelpetab = (T[]) (new Comparable[lengde]);
		int forsteV = min;
		int sisteV = midten;
		int forsteH = midten + 1;
		int sisteH = maks;

		int i = 0;
		while ((forsteV <= sisteV) && (forsteH <= sisteH)) {
			if (tab[forsteV].compareTo(tab[forsteH]) <= 0) {
				hjelpetab[i] = tab[forsteV];
				forsteV++;
			} else {
				hjelpetab[i] = tab[forsteH];
				forsteH++;
			}
			i++;
		}

		// kopiere resten av venstre del (kan v�re tom)
		while (forsteV <= sisteV) {
			hjelpetab[i] = tab[forsteV];
			forsteV++;
			i++;
		} // while
			// kopiere resten av h�yre del (kan v�re tom)
		while (forsteH <= sisteH) {
			hjelpetab[i] = tab[forsteH];
			forsteH++;
			i++;
		} // while

		int teller = 0;
		for (i = min; i <= maks; i++) {
			tab[i] = hjelpetab[teller];
			teller++;
		}

	}

	private static <T extends Comparable<T>> void mergeSort(T[] tab, int min, int maks) {
		if (min < maks) {
			int midten = (min + maks) / 2;
			mergeSort(tab, min, midten);
			mergeSort(tab, midten + 1, maks);
			merge(tab, min, midten, maks);

		}
	}

	

//	public static <T extends Comparable<T>> void radixSort (T[] tab) {
//		String temp;
//		Integer tallObj;
//		int siffer, tall;
//		List<T> [] listetab = new List[10];
//		for(int j=0; j<3; j++) {
//		for(int i=0; i<tab.length; i++) {
//			temp = String.valueOf(tab[i]);
//			siffer = Character.digit(temp.charAt(4-i), 10);
//			listetab[siffer].add(tab[i]);
//		}
//		tall = 0;
//		for (int sifferVerdi = 0; sifferVerdi<10; sifferVerdi++) {
//			
//		}
//		}
//		
//		
//	}

}
