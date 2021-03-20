package model;
import org.junit.Test;

import junit.framework.TestCase;
import model.*;

public class ClientTest extends TestCase{
	private Client client;
	
	@Test
	public void setUpEscenary1() {
		String name = "giovanni";
		String id = "45432467";
		int time = 0;
		client = new Client(name, id, time);
	}
	public void test1() {
		setUpEscenary1();
		assertEquals("giovanni", client.getName());
	}
	public void test2() {
		setUpEscenary1();
		boolean x = false;
		if (client != null) {
			x = true;
		}
		assertTrue(x);
		
	}
}
