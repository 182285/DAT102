package no.hib.dat102;

public class SoekingOgSortering {

	/*************************************************************************************************/
	// S�kealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gj�r et line�rt s�k i en tabell av usorterte data
	 * 
	 * @param data
	 *            er data som skal s�kes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            er verdien vi s�ker etter
	 * @return sann om elementet ble funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekU(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0)
				funnet = true;
			indeks++;
		} // while
		return funnet;
	}// metode

	/**
	 * Metoden gj�r et line�rt s�k i en sortert tabell av data
	 * 
	 * @param data
	 *            er data som skal s�kes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            verdien vi s�ker etter
	 * @return sann hvis funnet ellers usann
	 */
	public static <T extends Comparable<T>> boolean linearSoekS(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;

		while (indeks < maks && data[indeks].compareTo(el) < 0) {
			indeks++;
		} // while

		if (data[indeks].compareTo(el) == 0) {
			funnet = true;
		}

		return funnet;

	}// metode

	/**
	 * Metoden gj�r et bin�rt s�k i en *sortert* tabell av data
	 * 
	 * @param data
	 *            er data som skal s�kes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            er elementet vi s�ker etter
	 * @return sann om elementet ble funnet ellers usann.
	 */

	public static <T extends Comparable<T>> boolean binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) { // basistilfelle, ingen element
			return false;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0) { // basistilfelle, finner elementet
			return true;
		}
		if (resultat < 0) {// (her vil ogs� fungere med else if)
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}//

	/* Rekursiv bin�rs�k som returnerer indeks */

	public static <T extends Comparable<T>> int binaerSoek2(T[] data, int min, int maks, T el) {
		// Returnerer indeksen til m�lelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) { // basistilfelle, finner elementet
			return midtpunkt;
		}
		if (resultat < 0) {// ( vil her ogs� fungere med else if)
			return binaerSoek2(data, min, midtpunkt - 1, el);
		} else { // resultat > 0
			return binaerSoek2(data, midtpunkt + 1, maks, el);
		}
	}// metode

	/* Ikke rekursiv bin�rs�k som returnerer indeks */
	public static <T extends Comparable<T>> int binaerSoek3(T[] data, int min, int maks, T el) {
		return maks;
		// Returnerer indeksen til m�lelementet hvis det fins ellers -1
		//Fyll ut og kj�r metoden
	}//

	/*************************************************************************************************/
	// Sorteringsalgoritmer
	/*************************************************************************************************/

	/**
	 * Utvalgsortering
	 * 
	 * @param data
	 *            er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgSortering(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}
			} // indre for-l�kke

			/** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre for-l�kke
	}// metode

	/**
	 * Sortering ved innsetting
	 * 
	 * @param data
	 *            er data som skal sorteres
	 */
	// ...
}
