package structures.queue;

public interface QueueInterface<T>{
	public void enqueue(T newItem);
	public boolean isEmpty();
	public T front();
	public T getLatest();
	public T dequeue();
	public int size();
}
