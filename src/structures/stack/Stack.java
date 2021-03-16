package structures.stack;

public class Stack<T> implements StackInterface<T>{

	private Node<T> top; 
	
	public Stack() {
		top = null;
	}

	@Override
	public void push(T newItem) {
		top = new Node<T>(newItem, top);
	}

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

	@Override
	public T top() {
		return top.getElement();
	}

	@Override
	public void pop() {
		top = top.getPrevItem();
	}

}
