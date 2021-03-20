package structures.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;
import structures.stack.Stack;

class QueueTest {
	public Queue<Book> setupScenary1() {
		Queue<Book> queue = new Queue<Book>();
		return queue;
	}
	@Test
	void test() {
		Queue<Book> queue  = setupScenary1();
		Book book1 = new Book("HarryPotter1",40000,"margarita",20,"4243",0,1,0);
		Book book2 = new Book("HarryPotter2",50000,"margarita",14,"5321",0,1,1);
		Book book3 = new Book("HarryPotter3",60000,"margarita",15,"5433",0,1,2);
		Book book4 = new Book("HarryPotter4",70000,"margarita",11,"6213",0,1,3);
		Book book5 = new Book("HarryPotter5",80000,"margarita",11,"8723",0,1,4);
		Book book6 = new Book("HarryPotter6",65000,"margarita",11,"7832",0,1,5);
		Book book7 = new Book("HarryPotter7",55000,"margarita",11,"3847",0,1,6);
		Book book8 = new Book("HarryPotter8",44000,"margarita",11,"2903",0,1,7);
		Book book9 = new Book("HarryPotter9",66000,"margarita",11,"8923",0,1,8);
		queue.enqueue(book1);
		queue.enqueue(book2);
		queue.enqueue(book3);
		queue.enqueue(book4);
		queue.enqueue(book5);
		queue.enqueue(book6);
		queue.enqueue(book7);
		queue.enqueue(book8);
		queue.enqueue(book9);
		assertEquals(book1, queue.dequeue());
		assertEquals(book2, queue.dequeue());
		assertEquals(book3, queue.dequeue());
		assertEquals(book4, queue.dequeue());
		assertEquals(book5, queue.dequeue());
		assertEquals(book6, queue.dequeue());
		assertEquals(book7, queue.dequeue());
		assertEquals(book8, queue.dequeue());
		assertEquals(book9, queue.dequeue());
		
	}

}
