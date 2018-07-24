package com.code.hackerrank;

public class Time_Conversion {

	public static void main(String[] args) {
		System.out.println(timeConversion("12:00:00AM"));
	}

    static String timeConversion(String time) {
    	int size = time.length();
    	String meridiem = time.substring(size-2, size); 
    	System.out.println(meridiem);
    	
    	String[] arr = time.split(":");
    	if(meridiem.equals("PM") && !arr[0].equals("12")){
    		arr[0] = String.valueOf((12 + Integer.valueOf(arr[0])));
    	}else if(meridiem.equals("AM") && arr[0].equals("12")){
    		arr[0] = "00";
    	}
    	return arr[0]+":"+arr[1]+":"+arr[2].substring(0, 2);
    }
	
}
