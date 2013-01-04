package yingrong.fundamentals.ex03;

public abstract class Queue<Item> implements Iterable<Item> {
	public Queue() {
	};

	public abstract void enqueue(Item item);

	public abstract void dequeue(Item item);

	public abstract boolean isEmpty();

	public abstract int size();
}
