package yingrong.fundamentals.ex03;

import java.util.Iterator;

/**
 * 栈的一种数组实现 
 * 几乎（但还没有）达到了任意集合类数据类型的实现的最佳性能。
 * 优点：
 * 1、每项操作的用时都与集合大小无关；
 * 2、空间需求总不超过集合大小乘以一个常数……
 * 缺点：
 * 某些push和pop操作会调整数组的大小，而这项操作的耗时和栈大小成正比。
 * 
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1]; //栈元素
	private int N = 0;//元素的数量

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length) {
			resize(a.length * 2);
		}
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null; // 避免对象游离。使可以被回收。
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		// 后进先出的迭代方式
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {
		}

	}

}
