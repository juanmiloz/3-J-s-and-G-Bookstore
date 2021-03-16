package structures.stack;

public interface StackInterface<T> { 
	public void push(T newItem);
	public boolean isEmpty();
	public T top();
	public void pop(); 
}
