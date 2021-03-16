package structures.hashTable;

public interface hashTableInterface<K,V> {
	public void put(K key,V value);
	public void setLatestNode(Node<K,V> current, K key, V value);
	public V getValue(K key);
	public boolean existKey(K key);
}
