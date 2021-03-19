package structures.stack;

public class Node<T> {

	private T element;
	private Node<T> prevItem;
	/**
	/**
	 * Name: Node
	 * Method constructor node  <br>
	 * @param element -  node element - element = T, element != null
	 * @param prevItem - previous element - prevItem = Node<T>, prevItem != null
	 */
	public Node(T element, Node<T> prevItem) {
		this.element = element;
		this.prevItem = prevItem;
	}
	/**
	 * Name: getPrevItem
	 * Method used to get previous element  <br>
	 * @return A Node<T> representing previous element.
	*/
	public Node<T> getPrevItem() {
		return prevItem;
	}
	/**
	 * Name: getElement
	 * Method used to get element  <br>
	 * @return A T representing node element.
	*/
	public T getElement() {
		return element;
	}
}
