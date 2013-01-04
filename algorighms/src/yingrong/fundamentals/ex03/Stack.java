package yingrong.fundamentals.ex03;

public abstract class Stack<Item> {
	public Stack() {
	}

	public abstract void push(Item item);

	public abstract Item pop(Item item);

	public abstract boolean isEmpty();

	public abstract int size();
}
