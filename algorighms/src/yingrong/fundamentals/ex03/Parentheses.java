package yingrong.fundamentals.ex03;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Parentheses {
	public static final char L_PAREN = '(';
	public static final char R_PAREN = ')';
	public static final char L_BRACE = '{';
	public static final char R_BRACE = '}';
	public static final char L_BRACKET = '[';
	public static final char R_BRACKET = ']';
	public static void main(String[] args) {
		String s = StdIn.readAll().trim();
		StdOut.print(isBalance(s));
	}

	private static boolean isBalance(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
		}
		return true;
	}
}
