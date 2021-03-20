package structures.hashTable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;

class hashTableTest {

	public HashTable<String, Book> setupScenary1() {
		HashTable<String, Book> hash = new HashTable<>(7);
		return hash;
	}
	
	@Test
	public void testPutAndGetValue() {
		HashTable<String, Book> hash = setupScenary1();
		
		Book book1 = new Book("HarryPotter1",40000,"margarita",20,"4243",0,1,0);
		Book book2 = new Book("HarryPotter2",50000,"margarita",14,"5321",0,1,1);
		Book book3 = new Book("HarryPotter3",60000,"margarita",15,"5433",0,1,2);
		Book book4 = new Book("HarryPotter4",70000,"margarita",11,"6213",0,1,3);
		Book book5 = new Book("HarryPotter5",80000,"margarita",11,"8723",0,1,4);
		Book book6 = new Book("HarryPotter6",65000,"margarita",11,"7832",0,1,5);
		Book book7 = new Book("HarryPotter7",55000,"margarita",11,"3847",0,1,6);
		Book book8 = new Book("HarryPotter8",44000,"margarita",11,"2903",0,1,7);
		Book book9 = new Book("HarryPotter9",66000,"margarita",11,"8923",0,1,8);
		
		hash.put(book1.getISBN(), book1);
		hash.put(book2.getISBN(), book2);
		hash.put(book3.getISBN(), book3);
		hash.put(book4.getISBN(), book4);
		hash.put(book5.getISBN(), book5);
		hash.put(book6.getISBN(), book6);
		hash.put(book7.getISBN(), book7);
		hash.put(book8.getISBN(), book8);
		hash.put(book9.getISBN(), book9);
		
		assertEquals(book1, hash.getValue(book1.getISBN()));
		assertEquals(book2, hash.getValue(book2.getISBN()));
		assertEquals(book3, hash.getValue(book3.getISBN()));
		assertEquals(book4, hash.getValue(book4.getISBN()));
		assertEquals(book5, hash.getValue(book5.getISBN()));
		assertEquals(book6, hash.getValue(book6.getISBN()));
		assertEquals(book7, hash.getValue(book7.getISBN()));
		assertEquals(book8, hash.getValue(book8.getISBN()));
		assertEquals(book9, hash.getValue(book9.getISBN()));
	}

}
