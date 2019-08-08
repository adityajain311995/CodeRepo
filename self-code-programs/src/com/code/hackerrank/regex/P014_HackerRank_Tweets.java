package com.code.hackerrank.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class P014_HackerRank_Tweets {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Integer N = Integer.parseInt(bf.readLine());
		
		MyInt count = new MyInt(0);
		Pattern pattern = Pattern.compile("[hH][aA][cC][kK][eE][rR]{2}[aA][nN][kK]");
		
		IntStream.range(0, N).forEach(i->{
			String input;
			try {
				input = bf.readLine();
				if(pattern.matcher(input).find()) {
					count.increment();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(count);
		bf.close();
	}
}

class MyInt{
	private int value;
	MyInt(int value){
		this.value = value;
	}
	
	public void increment() {
		value = value + 1;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
