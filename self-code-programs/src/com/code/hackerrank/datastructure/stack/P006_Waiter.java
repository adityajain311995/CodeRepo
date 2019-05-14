package com.code.hackerrank.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P006_Waiter {
	
	public static void main(String[] args) {
		int[] val = {3,4,7,6,5};
		waiter(val, 1);
	}

    static int[] waiter(int[] number, int q) {
    	List<Integer> primes = getPrimeNoList(q);
    	List<Stack<Integer>> A = new ArrayList<>();
    	List<Stack<Integer>> B = new ArrayList<>();
    	
    	Stack<Integer> A1 = new Stack<>();
    	for (int i = 0; i < number.length; i++) {
			A1.push(number[i]);
		}
    	A.add(A1);
    	
    	for(int i=0; i<q; i++) {
    		Stack<Integer> aStack = getStack(A, i);
    		while(!aStack.isEmpty()) {
    			int val = aStack.pop();
    			if(val%primes.get(i)==0) {
    				getStack(B, i).add(val);
    			}else {
    				getStack(A, i+1).add(val);
    			}
    		}
    	}
    	
    	int[] result = new int[number.length];
    	
    	int i = 0;
    	for(Stack<Integer> stack : B) {
    		while(!stack.isEmpty()) {
    			result[i] = stack.pop();
    			i++;
    		}
    	}
    	
    	for(Stack<Integer> stack : A) {
    		while(!stack.isEmpty()) {
    			result[i] = stack.pop();
    			i++;
    		}
    	}
    	
    	return result;
    }
    
    static Stack<Integer> getStack(List<Stack<Integer>> list, int index) {
    	if(index+1>list.size()) {
    		list.add(new Stack<Integer>());
    		return list.get(list.size()-1);
    	}
    	return list.get(index);
    }
    
    
	private static List<Integer> getPrimeNoList(int N) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		int i = 3;
		boolean isprime = true;
		while(list.size()<N) {
			isprime = true;
			for(int j=0; j<list.size() && list.get(j)<i; j++) {
				if(i%list.get(j)==0) {
					isprime = false;
					break;
				}
			}
			if(isprime) {
				list.add(i);
			}
			i++;
		}
		return list;
	}
}
