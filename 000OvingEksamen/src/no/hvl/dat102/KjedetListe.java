package no.hvl.dat102;

public class KjedetListe<T extends Comparable<T>> {
	private LinearNode<T> start;
	private int antall;
	T element;

	public KjedetListe() {
		start = null;
		element = null;
		antall = 0;
	}

	public KjedetListe(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		start = node;
		antall = 1;
	}

	public void leggTil(T element) {
		LinearNode<T> node, aktuell, forrige;
		node = new LinearNode<T>(element);
		forrige = null;
		aktuell = start;
		while (aktuell != null && aktuell.getElement().compareTo(element) < 0) {
			forrige = aktuell;
			aktuell = aktuell.getNeste();
		}
		if (forrige == null) {
			node.setNeste(start);
			start = node;
		} else {
			node.setNeste(aktuell);
			forrige.setNeste(node);
		}
	}

	public void slett(T element) {
		LinearNode<T> forrige, aktuell;
		forrige = null;
		aktuell = start;
		while (aktuell != null && !(aktuell.getElement().equals(element))) {
			forrige = aktuell;
			aktuell = aktuell.getNeste();
		}
		if (forrige == null) {
			start = aktuell.getNeste();
		}
		forrige.setNeste(aktuell.getNeste());
	}

	public void skrivUt() {
		LinearNode<T> node = start;
		while (node != null) {
			System.out.print(node.getElement() + "-->");
			node = node.getNeste();
		}
		System.out.println();
	}

	public void slettDuplikat() {
		if (antall <= 1) {
			// Returnerer hvis det er en eller ingen elementer i lista.
			return;
		}
		LinearNode<T> node, videre;
		node = start;
		videre = node.getNeste();
		while (videre != null) {
			if (node.getElement().equals(videre.getElement())) {
				// Kutter forbindelsen til den like, setter neste til videre sin nesteelement
				node.setNeste(videre.getNeste());
				videre = node.getNeste();
			}
			node = videre;
			videre = videre.getNeste();
		} // while
		start = node;

	}

	public LinearNode<T> getStart() {
		return start;
	}

	public void setStart(LinearNode<T> start) {
		this.start = start;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
