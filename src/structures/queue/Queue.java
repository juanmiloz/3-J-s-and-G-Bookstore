package structures.queue;

public class Queue<T> implements QueueInterface<T>{

	private Node<T> front;
	private Node<T> latest;
	/**
	 * Name: Queue
	 * Method constructor queue  <br>
	 */
	public Queue() {
		front = null;
		latest = null;
	}
	/**
	 * Name: Queue
	 * Method constructor queue  <br>
	 * @param newitem - new item = T, newItem != null
	 */
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
	/**
	 * Name: inEmpty
	 * Method to confirm if is empty  <br>
	 * @return a boolean if is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean isEmpty =(front==null)?true:false;
		return isEmpty;
	}
	/**
	 * Name: front
	 * Method used to get font element  <br>
	 * @return a T whit the next element
	 */
	@Override
	public T front() {
		return front.getElement();
	}
	/**
	 * Name: getLatest
	 * Method used to get latest element  <br>
	 * @return a T whit the latest element
	 */
	@Override
	public T getLatest() {
		return latest.getElement();
	}
	/**
	 * Name: dequeue
	 * Method used to get queue element  <br>
	 * @return a T whit the queue element
	 */
	@Override
	public T dequeue() {
		T elementOut = front.getElement();
		front = front.getBack();
		return elementOut;
	}
	/**
	 * Name: size
	 * Method used to get size of the queue  <br>
	 * @return a int representing queue size
	 */
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
