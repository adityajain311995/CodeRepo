package com.code.hackerrank.regex;

import java.io.StringWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P7_Building_a_Smart_IDE {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringWriter writer = new StringWriter();
        while(sc.hasNextLine()) {
            writer.append(sc.nextLine());
        }
        
        Matcher patC = Pattern.compile(".*#include<\\w+.\\w+>.*").matcher(writer.toString());
        Matcher patJava = Pattern.compile(".*import \\w+(\\.(\\w|\\*)+)*;.*(public )?class [A-Z_]\\w* *\\{.*").matcher(writer.toString());
        if(patC.find()) {
            System.out.println("C");
        }else if(patJava.find()) {
            System.out.println("Java");
        }else {
            System.out.println("Python");
        }
        
    }
	
}
