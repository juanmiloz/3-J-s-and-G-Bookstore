package structures.queue;

public class Node<T> {

	private T element;
	private Node<T> back;
	/**
	 * Name: Node
	 * Method constructor node  <br>
	 * @param element -  node element - element = T, element != null
	 */
	public Node(T element) {
		this.element = element;
		this.back = null;
	}
	/**
	 * Name: getElement
	 * Method used to get element  <br>
	 * @return A T representing node element.
	*/
	public T getElement() {
		return element;
	}
	/**
	 * Name: getBack
	 * Method used to get back node.  <br>
	 * @return A Node<T> representing back node.
	*/
	public Node<T> getBack(){
		return back;
	}
	/**
	 * Name: setBack
	 * Method used to update back node.  <br>
	 * @param back - back node - back = Node<T>, back != null
	*/
	public void setBack(Node<T> back) {
		this.back = back;
	}
}
