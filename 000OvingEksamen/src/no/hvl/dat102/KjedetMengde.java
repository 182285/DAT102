package no.hvl.dat102;

import java.util.Random;

public class KjedetMengde<T extends Comparable<T>> {
	private Random rand = new Random();
	private LinearNode<T> start;
	private int antall;

	public KjedetMengde() {
		start = null;
		antall = 0;
	}

	public KjedetMengde(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		start = node;
		antall = 1;
	}

	public boolean erTom() {
		int i = this.antall;
		return (i == 0);
	}

	public void leggTil(T element) {
		if (!(finnes(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	public void leggTilOrdnet(T element) {
		if (!(finnes(element))) {
			LinearNode<T> aktuell, forrige;
			LinearNode<T> node = new LinearNode<T>(element);
			aktuell = start;
			forrige = null;
			if (erTom()) {
				node.setNeste(start);
				start = node;
			} else {
				boolean lagttil = false;
				while (aktuell != null && !lagttil) {
					if (element.compareTo(aktuell.getElement()) < 0) {
						if (forrige == null) {
							node.setNeste(aktuell);
							start = node;
						} else {
							node.setNeste(aktuell);
							forrige.setNeste(node);
						}
						lagttil = true;
					} else {
						forrige = aktuell;
						aktuell = aktuell.getNeste();
					}
				}
			}
			antall++;
		}
	}

	public void skrivUt() {
		LinearNode<T> node = start;
		while (node != null) {
			if (node.getNeste() != null) {
				System.out.print(node.getElement() + "-->");
			} else {
				System.out.println(node.getElement());
			}
			node = node.getNeste();
		}
		System.out.println();
	}

	public boolean finnes(T element) {
		LinearNode<T> node = start;
		while (node != null) {
			if (element.equals(node.getElement())) {
				return true;
			} else {
				node = node.getNeste();
			}
		}
		return false;
	}

	public T slett(T element) {
		if (finnes(element)) {
			boolean funnet = false;
			T temp = null;
			LinearNode<T> forrige, aktuell;
			aktuell = start;
			forrige = null;
			while (aktuell != null && !funnet) {
				if (aktuell.getElement().equals(element)) {
					temp = aktuell.getElement();
					funnet = true;
				} else {
					forrige = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
			if (funnet) {
				if (forrige == null) {
					start = start.getNeste();
					antall--;
				} else {
					forrige.setNeste(aktuell.getNeste());
					antall--;
				}
			}
			return temp;
		} else {
			return null;
		}
	}

	public boolean erLik(KjedetMengde m2) {
		boolean like = true;
		if (this.antall == m2.antall) {
			LinearNode<T> aktuell = start;
			while (like && aktuell != null) {
				if (this.finnes(aktuell.getElement())) {
					aktuell = aktuell.getNeste();
				} else {
					like = false;
				}
			}
		} else {
			like = false;
		}
		return like;
	}

	public boolean erDelmengde(KjedetMengde<T> m2) {
		boolean erdelmengde = true;
		if (this.antall >= m2.antall) {
			LinearNode<T> aktuell = m2.start;
			while (erdelmengde && aktuell != null) {
				T temp = aktuell.getElement();
				if (this.finnes(temp)) {
					erdelmengde = true;
					aktuell = aktuell.getNeste();
				} else {
					erdelmengde = false;
				}
			}
		} else {
			erdelmengde = false;
		}
		return erdelmengde;

	}

	public KjedetMengde<T> union(KjedetMengde<T> m2) {
		KjedetMengde<T> union = this;
		LinearNode<T> aktuell = m2.start;
		while (aktuell != null) {
			T temp = aktuell.getElement();
			union.leggTil(temp);
			aktuell = aktuell.getNeste();
		}
		return union;
	}

	public KjedetMengde<T> snitt(KjedetMengde<T> m2) {
		KjedetMengde<T> snitt = new KjedetMengde<T>();
		int minste = m2.antall;
		LinearNode<T> aktuell = m2.start;
		if (this.antall > minste) {
			minste = this.antall;
			aktuell = this.start;
		}
		while (aktuell != null) {
			T temp = aktuell.getElement();
			if (m2.finnes(temp) && this.finnes(temp)) {
				snitt.leggTil(temp);
			}
			aktuell = aktuell.getNeste();
		}

		return snitt;
	}

	public int getAntall() {
		return this.antall;
	}

	public T slettTilfeldig() {
		T temp = null;
		int plass = rand.nextInt(antall + 1);
		if (plass == 0) {
			temp = start.getElement();
			start = start.getNeste();
			antall--;
		} else {
			LinearNode<T> aktuell = start.getNeste();
			LinearNode<T> forrige = start;
			int i = 1;
			while (i < plass) {
				forrige = aktuell;
				aktuell = aktuell.getNeste();
				i++;
			}
			temp = aktuell.getElement();
			forrige.setNeste(aktuell.getNeste());
			antall--;
		}
		return temp;
	}

	public void flette(KjedetMengde<T> m2) {
		LinearNode<T> m2Aktuell = m2.start;
		while (m2Aktuell != null) {
			this.leggTil(m2Aktuell.getElement());
			m2Aktuell = m2Aktuell.getNeste();
		}
		m2.start = null;
		m2.antall = 0;
	}

	public void snu() {
		LinearNode<T> p, ny, aktuell;
		p = start;
		ny = null;
		while (p != null) {
			start = p.getNeste();
			p.setNeste(ny);
			ny = p;
			p = start;
			aktuell = ny;
			while(aktuell !=null) {
				System.out.print(aktuell.getElement() + "-->");
				aktuell = aktuell.getNeste();
			}
			System.out.println();
		}
		start = ny;
	}
}
