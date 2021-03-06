package com.challenge;

import java.util.LinkedList;

public class MovingAverageImpl implements MovingAverage {

	private LinkedList<Integer> list = new LinkedList<>();
	
	@Override
	public void add(Integer element) {
		list.push(element);
	}

	@Override
	public Integer[] getElements() {
		return list.toArray(new Integer[list.size()]);
	}

	@Override
	public Double getAverage(int N) {
		if (N < 0 || N > list.size()) {
			throw new IllegalArgumentException("Invalid parameter value: " + N);
		}
		
		if (N == 0) return 0.0;
		
		double total = 0;
		int count = 0;
		for (Integer ele : list) {
			if (count >= N) {
				break;
			}
			total += ele;
			count++;
		}
		return total/N;
	}

}
