package com.code.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class P005_Simple_Text_Editor {

	private static String S = "";
	private static Stack<String> stack = new Stack<>();
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int Q = Integer.parseInt(sc.nextLine());
    	for(int i=0; i<Q; i++) {
    		String input = sc.nextLine();
    		processOperation(input, false);
    	}
    	sc.close();
    }
    
    static void processOperation(String input, boolean isUndo) {
    	int op = Integer.parseInt(String.valueOf(input.charAt(0)));
    	if(op==1) {
    		append(input.substring(2),isUndo);
    	}else if(op==2) {
    		delete(Integer.valueOf(input.substring(2)),isUndo);
    	}else if(op==3) {
    		print(Integer.valueOf(input.substring(2)));
    	}else {
    		processOperation(stack.pop(), true);
    	}
    	
    }
    
    static void append(String W, boolean isUndo) {
    	if(!isUndo) {
    		stack.push("2 "+W.length());
    	}
    	S = S + W;
    }
    
    static void delete(int k, boolean isUndo) {
    	int size = S.length();
    	if(!isUndo) {
    		stack.push("1 "+S.substring(size - k));
    	}
		S = S.substring(0, size - k);
    }
    
    static void print(int k) {
    	System.out.println(S.charAt(k-1));
    }
}
