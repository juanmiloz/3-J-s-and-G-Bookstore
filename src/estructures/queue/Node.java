package model;

public class Node<T> {

	private T element;
	private Node<T> back;
	
	public Node(T element) {
		this.element = element;
		this.back = null;
	}

	public T getElement() {
		return element;
	}
	
	public Node<T> getBack(){
		return back;
	}
	
	public void setBack(Node<T> back) {
		this.back = back;
	}
}
