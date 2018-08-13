package com.code.hackerrank;
/**
 * 
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 *
 */
public class Breaking_the_Records {

	public static void main(String[] args) {
		int[] scores = new int[]{10,5,20,20,4,5,2,25,1};
		int[] result = breakingRecords(scores);
		for(int el : result){
			System.out.println(el);
		}
	}

    static int[] breakingRecords(int[] scores) {
    	int max = 0;
    	int min = 0;
    	
    	int result[] = new int[]{0,0};
    	for (int i = 0; i < scores.length; i++) {
			if(i==0){
				max=min=scores[i];
				continue;
			}
			if(scores[i] > max){
				max = scores[i];
				result[0]++;
			}
			if(scores[i] < min){
				min = scores[i];
				result[1]++;
			}
			
		}
    	return result;
    }
}
