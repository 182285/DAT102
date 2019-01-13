package no.hvl.dat102.postfix;

import java.util.Scanner;
//import java.util.Stack;

import no.hvl.dat102.stabel.TabellStabel;

public class PostfixEvaluator {
	private final static char ADD = '+';
	private final static char SUB = '-';
	private final static char MUL = '*';
	private final static char DIV = '/';
	private TabellStabel<Integer> stabel;
	//private Stack<Integer> stabel;

	public PostfixEvaluator() {
		stabel = new TabellStabel<Integer>();
		//stabel = new Stack<Integer>();
	}

	public int beregn(String utr) {
		int op1;
		int op2;
		int resultat = 0;
		String token;
		Scanner parser = new Scanner(utr);
		while (parser.hasNext()) {
			token = parser.next();
			if (erOperator(token)) {
				op2 = (stabel.pop()).intValue();
				op1 = (stabel.pop()).intValue();
				resultat = beregnEn(token.charAt(0), op1, op2);
				stabel.push(new Integer(resultat));
			} else {
				stabel.push(new Integer(Integer.parseInt(token)));
			}
		}
		return resultat;
	}

	private boolean erOperator(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
	}

	private int beregnEn(char operasjon, int op1, int op2) {
		int resultat = 0;
		switch (operasjon) {
		case ADD:
			resultat = op1 + op2;
			break;
		case SUB:
			resultat = op1 - op2;
			break;
		case MUL:
			resultat = op1 * op2;
			break;
		case DIV:
			resultat = op1 / op2;
		}
		return resultat;
	}

}// class
