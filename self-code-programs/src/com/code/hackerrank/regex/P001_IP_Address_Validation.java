package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P001_IP_Address_Validation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] array = new String[n];
        sc.nextLine();
        for(int i=0; i<array.length; i++){
            array[i] = sc.nextLine();
        }
	}

	public static void validateIP(String[] list){
		Pattern ipV4 = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");
		Pattern ipV6 = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]{1,4})");
		boolean flag=false;
		for (String current : list) {
			if(ipV4.matcher(current).matches()){
				for(String val : current.split("\\.")){
					flag = Integer.valueOf(val) > 255;
					if(flag)break;
				}
				if(!flag){
					System.out.println("IPV4");
					continue;
				}
			}
			
			if(ipV6.matcher(current).matches()){
				System.out.println("IPV6");
				continue;
			}
			
			System.out.println("Niether");
		}
	}
	
}
