package yingrong.fundamentals.ex03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Queue<Item> implements Iterable<Item> {
	private int N;
	private Node first;
	private Node last;

	private class Node {
		private Item item;
		private Node next;
	}

	public Queue() {
		first = null;
		last = null;
		N = 0;
		assert check();
	}

	private boolean check() {
		if (N == 0) {
			if (first != null || last != null) {
				return false;
			}
		} else if (N == 1) {
			if (first == null || last == null) {
				return false;
			}
			if (first != last) {
				return false;
			}
			if (first.next != null) {
				return false;
			}
		} else {
			if (first == last)
				return false;
			if (first.next == null)
				return false;
			if (last.next != null)
				return false;
			// check internal consistency of instance variable N
			int numberOfNodes = 0;
			for (Node x = first; x != null; x = x.next) {
				numberOfNodes++;
			}
			if (numberOfNodes != N)
				return false;
			// check internal consistency of instance variable last
			Node lastNode = first;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			if (last != lastNode)
				return false;
		}
		return true;
	};

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
		assert check();
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last = null;
		}
		assert check();
		return item;
	}

	public boolean isEmpty() {
		// return N==0;
		// return last == null;
		return first == null;
	}

	public int size() {
		return N;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (Item item : this) {
			s.append(item + "");
		}
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

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
