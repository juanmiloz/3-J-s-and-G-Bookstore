package structures.hashTable;

public class HashTable<K,V> implements hashTableInterface<K,V>{
	
	private Node<K,V> [] hashTable; // = (Node<K,V>[])(new Node[2]);
	private int lengthHash;
	
	public HashTable(int length) {
		hashTable = (Node<K,V>[])(new Node[length]);
		this.lengthHash = length;
	}
	
	@Override
	public void put(K key, V value) {
		int position = key.hashCode()%lengthHash;
		if(hashTable[position]==null) {
			hashTable[position] = new Node<K,V>(key ,value);
		}else {
			setLatestNode(hashTable[position],key,value);
		}
	}
	
	@Override
	public void setLatestNode(Node<K,V> current, K key, V value) {
		if(current.getNext() == null) {
			current.setNext(new Node<K,V>(key,value));
			current.getNext().setPrev(current);
		}else {
			setLatestNode(current.getNext(), key,value);
		}
	}
	
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
