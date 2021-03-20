package structures.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;
import structures.hashTable.HashTable;

class StackTest {
	public Stack<Book> setupScenary1() {
		Stack<Book> stack = new Stack<Book>();
		return stack;
	}
	@Test
	void test() {
		Stack<Book> stack  = setupScenary1();
		Book book1 = new Book("HarryPotter1",40000,"margarita",20,"4243",0,1,0);
		Book book2 = new Book("HarryPotter2",50000,"margarita",14,"5321",0,1,1);
		Book book3 = new Book("HarryPotter3",60000,"margarita",15,"5433",0,1,2);
		Book book4 = new Book("HarryPotter4",70000,"margarita",11,"6213",0,1,3);
		Book book5 = new Book("HarryPotter5",80000,"margarita",11,"8723",0,1,4);
		Book book6 = new Book("HarryPotter6",65000,"margarita",11,"7832",0,1,5);
		Book book7 = new Book("HarryPotter7",55000,"margarita",11,"3847",0,1,6);
		Book book8 = new Book("HarryPotter8",44000,"margarita",11,"2903",0,1,7);
		Book book9 = new Book("HarryPotter9",66000,"margarita",11,"8923",0,1,8);
		stack.push(book1);
		stack.push(book2);
		stack.push(book3);
		stack.push(book4);
		stack.push(book5);
		stack.push(book6);
		stack.push(book7);
		stack.push(book8);
		stack.push(book9);
		boolean x = false;
		if(!stack.isEmpty()) {
			x = true;
		}
		assertTrue(x);
		
		assertEquals(book9, stack.pop());
		assertEquals(book8, stack.pop());
		assertEquals(book7, stack.pop());
		assertEquals(book6, stack.pop());
		assertEquals(book5, stack.pop());
		assertEquals(book4, stack.pop());
		assertEquals(book3, stack.pop());
		assertEquals(book2, stack.pop());
		assertEquals(book1, stack.pop());
		
		
		
		
		/**
		assertEquals(book1, stack.top().getValue(book1.getISBN()));
		assertEquals(book2, hash.getValue(book2.getISBN()));
		assertEquals(book3, hash.getValue(book3.getISBN()));
		assertEquals(book4, hash.getValue(book4.getISBN()));
		assertEquals(book5, hash.getValue(book5.getISBN()));
		assertEquals(book6, hash.getValue(book6.getISBN()));
		assertEquals(book7, hash.getValue(book7.getISBN()));
		assertEquals(book8, hash.getValue(book8.getISBN()));
		assertEquals(book9, hash.getValue(book9.getISBN()));
		*/
	}

}
