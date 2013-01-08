package yingrong.fundamentals.ex03;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Stack<Item> implements Iterable<Item> {

	private int N;
	private Node first;

	private class Node {
		private Item item;
		private Node next;
	}

	/**
	 * 创建一个空栈 长度为0，并且first指向null。
	 */
	public Stack() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	};

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
		assert check();
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		assert check();
		return item;
	};

	private boolean check() {
		if (N == 0) {
			if (first != null) {
				return false;
			}
		} else if (N == 1) {
			if (first == null) {
				return false;
			}
			if (first.next == null) {
				return false;
			}
		} else {
			if (first.next == null) {
				return false;
			}
		}

		int numberOfNodes = 0;
		for (Node x = first; x != null; x = x.next) {
			numberOfNodes++;
		}
		if (numberOfNodes != N) {
			return false;
		}

		return true;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return first.item;
	}

	@Override
	public String toString() {
		return toString(" ");
	}

	public String toString(String split) {
		StringBuffer buffer = new StringBuffer();
		for (Item item : this) {
			buffer.append(item + split);
		}
		return buffer.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	};

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current.next != null;
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
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
			}
		}
		StdOut.println("(" + stack.size() + " left on stack)");
	}

}
