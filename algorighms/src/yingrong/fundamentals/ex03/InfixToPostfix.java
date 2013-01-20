package yingrong.fundamentals.ex03;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * http://zh.wikipedia.org/wiki/%E8%B0%83%E5%BA%A6%E5%9C%BA%E7%AE%97%E6%B3%95
 * 详细的算法

 当还有记号可以读取时：
 读取一个记号。
 如果这个记号表示一个数字，那么将其添加到输出队列中。
 如果这个记号表示一个函数，那么将其压入栈当中。
 如果这个记号表示一个函数参数的分隔符（例如，一个半角逗号,）：
 从栈当中不断地弹出操作符并且放入输出队列中去，直到栈顶部的元素为一个左括号为止。如果一直没有遇到左括号，那么要么是分隔符放错了位置，要么是括号不匹配。
 如果这个记号表示一个操作符，记做o1，那么：
 当有另一个记为o2的操作符位于栈的顶端，并且
 如果o1是左结合性的并且它的运算符优先级要小于或者等于o2的优先级，或者
 如果o1是右结合性的并且它的运算符优先级比o2的要低，那么
 将o2从栈的顶端弹出并且放入输出队列中；
 将o1压入栈的顶端。
 如果这个记号是一个左括号，那么就将其压入栈当中。
 如果这个记号是一个右括号，那么：
 从栈当中弹出不断地操作符并且放入输出队列中，直到栈顶部的元素为左括号为止。
 将左括号从栈的顶端弹出，但并不放入输出队列中去。
 如果此时位于栈顶端的记号表示一个函数，那么将其弹出并放入输出队列中去。
 如果在找到一个左括号之前栈就已经弹出了所有元素，那么就表示在表达式中存在不匹配的括号。
 当再没有记号可以读取时：
 如果此时在栈当中还有操作符：
 如果此时位于栈顶端的操作符是一个括号，那么就表示在表达式中存在不匹配的括号。
 将操作符逐个弹出并放入输出队列中。
 退出算法。
 */

/**
 * Shunting yard算法(调度场算法)简版
 * 
 * 将算数表达式由中序改为后序表达式 % java InfixToPostfix ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * <Ctrl-d> 2 3 4 + 5 6 * * +
 * 
 * % java InfixToPostfix | java EvaluatePostfix ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) )
 * ) <Ctrl-d> 212
 * 
 * @author yingrong
 * 
 */
public class InfixToPostfix {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("+")) {
				stack.push(s);
			} else if (s.equals("*")) {
				stack.push(s);
			} else if (s.equals("(")) {
				StdOut.print(" ");
			} else if (s.equals(")")) {
				StdOut.print(stack.pop() + " ");
			} else {
				StdOut.print(stack.pop() + " ");
			}
		}
	}
}
