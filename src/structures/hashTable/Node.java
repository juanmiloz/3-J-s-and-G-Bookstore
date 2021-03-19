package structures.hashTable;;

public class Node<K,V>{

	private K key;
	private V value;
	private Node<K,V> next;
	private Node<K,V> prev;
	/**
	 * Name: Node
	 * Method constructor node  <br>
	 * @param key - node key - key = K, key != null
	 * @param value - node value - value = V, value != null
	 */
	public Node(K key ,V value){
		this.value = value;
		this.key = key;
		next = null;
		prev = null;
	}
	/**
	 * Name: getKey
	 * Method used to get node key  <br>
	 * @return A K representing node key.
	*/
	public K getKey() {
		return key;
	}
	/**
	 * Name: setKey
	 * Method used to update node key.  <br>
	 * @param key - node key - key = K, key != null
	*/
	public void setKey(K key) {
		this.key = key;
	}
	/**
	 * Name: getValue
	 * Method used to get node value <br>
	 * @return A V representing node value.
	*/
	public V getValue() {
		return value;
	}
	/**
	 * Name: setValue
	 * Method used to update node value.  <br>
	 * @param element - node value - element = V, element != null
	*/
	public void setValue(V element) {
		this.value = element;
	}
	/**
	 * Name: getNext
	 * Method used to get next node <br>
	 * @return A Node<K,V> representing next node.
	*/
	public Node<K,V> getNext() {
		return next;
	}
	/**
	 * Name: setNext
	 * Method used to update next node.  <br>
	 * @param next - next node - next = Node<K,V>, next != null
	*/
	public void setNext(Node<K,V> next) {
		this.next = next;
	}
	/**
	 * Name: getPrev
	 * Method used to get previous node <br>
	 * @return A Node<K,V> representing previous node.
	*/
	public Node<K,V> getPrev() {
		return prev;
	}
	/**
	 * Name: setPrev
	 * Method used to update previous node.  <br>
	 * @param prev - previous node - prev = Node<K,V>, prev != null
	*/
	public void setPrev(Node<K,V> prev) {
		this.prev = prev;
	}
}