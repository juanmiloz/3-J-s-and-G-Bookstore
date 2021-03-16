package model;

public class Queue<T> implements QueueInterface<T>{

	private Node<T> front;
	private Node<T> latest;
	
	public Queue() {
		front = null;
		latest = null;
	}

	@Override
	public void enqueue(T newItem) {
		if(front==null) {
			front = new Node<T>(newItem);
			latest = front;
		}else {
			Node<T> current = front;
			while(current.getBack()!=null) {
				current = current.getBack();
			}
			current.setBack(new Node<T>(newItem));
			latest = current.getBack();
		}
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty =(front==null)?true:false;
		return isEmpty;
	}

	@Override
	public T front() {
		return front.getElement();
	}
	
	@Override
	public T getLatest() {
		return latest.getElement();
	}

	@Override
	public T dequeue() {
		T elementOut = front.getElement();
		front = front.getBack();
		return elementOut;
	}
	
	@Override
	public int size() {
		int cont = 0;
		Node<T> current = front;
		if(current != null) {
			while(current!=null) {
				cont += 1;
				current = current.getBack();
			}
		}
		return cont;
	}

}
