package yingrong.fundamentals.ex03;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import sun.misc.Regexp;

/**
 * 补全中序表达式的括号。(极粗糙版本) 输入<<< 1+2)*3-4)*5-6))) 输出>>> ((1+2)*((3-4)*(5-6)))
 * 
 * @author yingrong
 * 
 */
public class Infix {

	public static void main(String[] args) {
		Stack<String> opts = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String temp = StdIn.readString();
			if (temp.equals("+") || temp.equals("-") || temp.equals("*")) {
				opts.push(temp);
			} else if (temp.equals(")")) {
				String val1 = vals.pop();
				String val2 = vals.pop();
				String opt = opts.pop();
				String val = "(" + val2 + opt + val1 + ")";
				vals.push(val);
			} else {
				vals.push(temp);
			}
		}

		StdOut.print(vals);
	}

}
