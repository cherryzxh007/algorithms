package yingrong.fundamentals.ex01;

import edu.princeton.cs.introcs.StdIn;

//import edu.princeton.cs.introcs.StdOut;

public class ChangeToBinaryString {

	public static String toBinaryString(int N) {
		String s = "";
		// StdOut.printf("%4s\n", "N>>" + N);
		if (N == 0) {
			s = "0";
		}
		for (int n = N; n > 0; n /= 2) {
			// StdOut.printf("%5s", "n%2>>");
			// StdOut.printf("%8d", n % 2);
			s = (n % 2) + s;
			// StdOut.printf("%5s", "s>>");
			// StdOut.printf("%8s\n", s);
		}
		return s;
	}

	public static void main(String[] args) {
		while (!StdIn.isEmpty()) {
			int N = StdIn.readInt();
			System.out.println("change to binaryString is >> \n"
					+ toBinaryString(N));
		}
	}
}
