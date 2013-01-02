package yingrong.fundamentals.ex01;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class BinarySearch {
	public static int rank(int key, int[] a) {
		int lo = 0, hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// int[] whitelist =
		// In.readInts("http://algs4.cs.princeton.edu/11model/largeW.txt");
		int[] whitelist = In
				.readInts("http://algs4.cs.princeton.edu/11model/tinyW.txt");
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1) {
				StdOut.println(key);
			}
		}
	}
}
