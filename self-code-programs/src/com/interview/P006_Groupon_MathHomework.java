package com.interview;

import java.util.List;

public class P006_Groupon_MathHomework {

	public static int minNum(int threshold, List<Integer> happy) {
		int minVal = happy.get(0);
		int valReq = threshold + minVal;

		int index = -1;

		for (int i = 0; i < happy.size(); i++) {
			if (happy.get(i) >= valReq) {
				index = i;
				break;
			}
		}
		int result = ((index+1) / 2) + 1;
		if (index == -1) {
			result = happy.size();
		}else {
			result = ((index+1) / 2) + 1;
		}

		return result;
	}

}
