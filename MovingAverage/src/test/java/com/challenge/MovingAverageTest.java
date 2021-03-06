package com.challenge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MovingAverageTest {

	@Test
	public void initSuccess() {
		new MovingAverageImpl();
	}
	
	@Test
	public void testAddAndGet() {
		MovingAverage avg = new MovingAverageImpl();
		avg.add(2);
		avg.add(1);
		avg.add(-3);
		
		Integer[] elements = avg.getElements();
		assertArrayEquals(new Integer[]{-3,  1, 2}, elements);
	}
	
	@Test
	public void getEmtpyListTest() {
		MovingAverage avg = new MovingAverageImpl();
		
		assertArrayEquals(new Integer[]{}, avg.getElements());
	}
	
	@Test
	public void getAverageSuccess() {
		MovingAverage avg = new MovingAverageImpl();
		avg.add(2);
		avg.add(1);
		avg.add(-3);
		
		assertTrue(0.0 == avg.getAverage(3));
		assertTrue(-1.0 == avg.getAverage(2));
		assertTrue(-3.0 == avg.getAverage(1));
		
		avg.add(6);
		assertTrue(4.0/3 == avg.getAverage(3));
		assertTrue(6.0/4 == avg.getAverage(4));
		assertTrue(0.0 == avg.getAverage(0));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getAverageWithInvalidArgumentThrows() {
		MovingAverage avg = new MovingAverageImpl();
		avg.add(2);
		avg.add(3);
		
		avg.getAverage(3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getAverageWithNegativeArgumentThrows() {
		MovingAverage avg = new MovingAverageImpl();
		avg.add(2);
		
		avg.getAverage(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getAverageWithEmptyListThrows() {
		MovingAverage avg = new MovingAverageImpl();
		
		avg.getAverage(1);
	}
}
