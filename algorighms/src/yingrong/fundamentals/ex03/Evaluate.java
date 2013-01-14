package yingrong.fundamentals.ex03;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Evaluate {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("+") || s.equals("-") || s.equals("*")) {
				ops.push(s);
				StdOut.print("aaa"+vals.toString());
			} else if (s.equals(")")) {
				String lastO = ops.pop();
				if (lastO.equals("+") || lastO.equals("-")) {
					String lastV = vals.pop();
					String firstV = vals.pop();
					vals.push("(" + firstV + lastO + lastV + s+")");
				}
				StdOut.print("ccc"+vals.toString());
			}else{
				vals.push(s);
				StdOut.print("ddd"+vals.toString());
			}
		}
		StdOut.print("eee"+vals.toString());
//		java.util.ArrayList<String> a = new java.util.Stack<>();
	}
}
