package test;
import org.junit.Test;

import junit.framework.TestCase;
import model.*;



public class BookTest  extends TestCase{
	private Book book;
	
	@Test
	public void setUpEscenary1() {
		String title = "Harry Potter";
		double price = 70000;
		String author = "J. K. Rowling";
		int quantity = 4;
		String ISBN= "343234";
		int shelve = 3;
		int posInShelve = 2;
		int bookCount=1;
		book = new Book( title,  price,  author,  quantity,  ISBN,  shelve,
			 posInShelve,bookCount);
	}

	public void test1() {
		setUpEscenary1();
		assertEquals("J. K. Rowling", book.getAuthor());

	}
	public void test2() {
		setUpEscenary1();
		boolean x = false;
		if (book != null) {
			x = true;
		}
		assertTrue(x);
		
	}
	

}
