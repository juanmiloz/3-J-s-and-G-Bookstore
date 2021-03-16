package Estructures;

public class Node<T> {

	private T element;
	private Node<T> prevItem;
	
	public Node(T element, Node<T> prevItem) {
		this.element = element;
		this.prevItem = prevItem;
	}
	
	public Node<T> getPrevItem() {
		return prevItem;
	}
	
	public T getElement() {
		return element;
	}
}
