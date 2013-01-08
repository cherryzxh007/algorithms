package yingrong.fundamentals.ex03;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Queue<Item> implements Iterable<Item> {
	public Queue() {
	}

	public void enqueue(Item item) {
	}

	public String dequeue() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}

	public int size() {
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty())
				StdOut.print(q.dequeue() + "");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
