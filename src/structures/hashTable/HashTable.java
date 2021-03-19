package structures.hashTable;

public class HashTable<K,V> implements hashTableInterface<K,V>{
	
	private Node<K,V> [] hashTable; // = (Node<K,V>[])(new Node[2]);
	private int lengthHash;
	
	/**
	 * Name: getHashTable
	 * Method used to get hash table <br>
	 * @return a Node<K,V>[] whit hash table
	 */
	public Node<K,V>[] getHashTable() {
		return hashTable;
	}
	/**
	 * Name: HashTable
	 * Method constructor of hash table  <br>
	 * @param length - length = int 
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int length) {
		hashTable = (Node<K,V>[])(new Node[length]);
		this.lengthHash = length;
	}
	/**
	 * Name: put
	 * Method to put a node in the hash table. <br>
	 * @param key - key = K 
	 * @param value - value = V 
	 */
	@Override
	public void put(K key, V value) {
		int position = key.hashCode()%lengthHash;
		if(hashTable[position]==null) {
			hashTable[position] = new Node<K,V>(key ,value);
		}else {
			setLatestNode(hashTable[position],key,value);
		}
	}
	/**
	 * Name: setLatestNode
	 * Method used to update latest node. <br>
	 * @param current - current = Node<K,V> 
	 * @param key - key = K 
	 * @param value - value = V 
	 */
	@Override
	public void setLatestNode(Node<K,V> current, K key, V value) {
		if(current.getNext() == null) {
			current.setNext(new Node<K,V>(key,value));
			current.getNext().setPrev(current);
		}else {
			setLatestNode(current.getNext(), key,value);
		}
	}
	/**
	 * Name: getValue
	 * Method used to get node value. <br>
	 * @param key - key = K 
	 * @return a V representing node value
	 */
	@Override
	public V getValue(K key) {
		int position = key.hashCode()%lengthHash;
		if(hashTable[position].getKey().equals(key)) {
			return hashTable[position].getValue();
		}else {
			Node<K,V> current = hashTable[position];
			V search = null;
			boolean exist = false;
			while(current.getNext()!=null && !exist) {
				if(current.getKey().equals(key)) {
					search = current.getValue();
					exist = true;
				}else {
					current = current.getNext();
				}
			}
			return search;
		}
	}
	/**
	 * Name: existKey
	 * Method uset to confirm node key. <br>
	 * @param key - key = K 
	 * @return a boolean representing if exist a node key
	 */
	@Override
	public boolean existKey(K key) {
		boolean exist = false;
		
		int position = key.hashCode()%lengthHash;
		if(hashTable[position]== null) {
			exist = false;
		}else {
			Node<K,V> current = hashTable[position];
			while(!exist && current!=null) {
				if(current.getKey().equals(key)) {
					exist = true;
				}else {
					current = current.getNext();
				}
			}
		}
		return exist;
	}
	
	
	
}
