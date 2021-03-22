package structures.stack;

public class Stack<T> implements StackInterface<T>, Cloneable {

	private Node<T> top; 
	
	public Stack() {
		top = null;
	}
/**
	 * Name: push
	 * Method to create a new node. <br>
	 * @param newItem - newItem = T
 */
	@Override
	public void push(T newItem) {
		top = new Node<T>(newItem, top);
	}
	/**
	 * Name: inEmpty
	 * Method to confirm if is empty  <br>
	 * @return a boolean if is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean isEmpty;
		if(top == null) {
			isEmpty = true;
		}else {
			isEmpty = false;
		}
		
		return isEmpty;
	}
	/**
	 * Name: top
	 * Method to get node element  <br>
	 * @return a T representing the element
	 */
	@Override
	public T top() {
		return top.getElement();
	}
	/**
	 * Name: pop
	 * Method to update node <br>
	 * @return A node of Type T
	 */
	@Override
	public T pop() {
		T r = top.getElement();
		top = top.getPrevItem();
		return r;
	}


	/*	
	public String toStringStack(Node<T> top){
		String output = "";
		Node<T> toPrint = top;

		while(toPrint!=null){
			output += top.getElement() + "\n";
			
		}

		return output;
	}
	*/

}
