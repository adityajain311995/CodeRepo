package com.code;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
    	String group = "http://sdsd.ewesf";
    	group = group.substring(group.indexOf("//")+2);
    	System.out.println(group);
	}

}
