package com.challenge;

public interface MovingAverage {

	/**
	 * Inserts the specified element at the beginning of this list
	 * @param the element to add
	 */
	void add(Integer element);
	
	/**
	 * Returns an array containing all of the elements in this list
	 * @return an array containing all of the elements in this list
	 */
	Integer[] getElements();
	
	/**
	 * Get average of the last N elements added
	 * @param N last N elements to take average of
	 * @return average of the last N elements added
	 * @throws IllegalArgumentException if N is less then 0 or bigger then current size of list
	 */
	Double getAverage(int N);
	 
}
