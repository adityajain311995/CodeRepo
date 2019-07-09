package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P005_Goldman_Sach_Traveler_Fund {

	public static int requiredAmountAtStart(List<Integer> netSaving) {
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		for(int saving : netSaving) {
			sum = sum + saving;
			list.add(sum);
		}
		
		int min = Collections.min(list);
		
		if(min>0) {
			return 0;
		}
		
		return (min*-1) + 1;
	}
	
}
