package yingrong.fundamentals.ex03;

public abstract class Bag<Item> implements Iterable<Item> {
	public Bag() {
	};

	public abstract void add(Item item);

	public abstract boolean isEmpty();

	public abstract int size();
}
