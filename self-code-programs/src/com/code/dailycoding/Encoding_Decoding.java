package com.code.dailycoding;
/**
 * 
 <pre>
 This problem was asked by Amazon.

 Run-length encoding is a fast and simple method of encoding strings.
 The basic idea is to represent repeated successive characters as a 
 single count and character. For example, the string "AAAABBBCCDAA"
 would be encoded as "4A3B2C1D2A".

 Implement run-length encoding and decoding. You can assume the
 string to be encoded have no digits and consists solely of
 alphabetic characters. You can assume the string to be decoded is valid.
 </pre>
 *
 */
public class Encoding_Decoding {

	String word;
	int index;
	
	public static void main(String[] args) {
		Encoding_Decoding en = new Encoding_Decoding();
		en.word = "AAAABBBCCDAA";
		en.index = 0;
		System.out.println(en.encode());
	}
	
	public String decode(){
		String decoded = "";
		while(index<word.length()){
			decoded = decoded + getExpandedChars();
		}
		return decoded;
	}
	
	private String getExpandedChars() {
		String countStr = "";
		int val = getIntValue(word.charAt(index));
		
		while(val!=-1){
			countStr = countStr + word.charAt(index);
			index++;
			val = getIntValue(word.charAt(index));
		}
		String result = "";
		for(int i=0; i<getIntValue(countStr); i++){
			result=result+word.charAt(index);
		}
		index++;
		return result;
	}
	
	private int getIntValue(Object ch){
		int val;
		try {
			val = Integer.parseUnsignedInt(String.valueOf(ch));
		} catch (NumberFormatException e) {
			val = -1;
		}
		return val;
	}

	public String encode(){
		String encoded = "";
		while(index < word.length()){
			encoded = encoded + getCharWithCount(word.charAt(index));
		}
		return encoded;
	}

	private String getCharWithCount(char current){
		int count = 0;
		while(index<word.length() && current==word.charAt(index)){
			count++;
			index++;
		}
		
		return String.valueOf(count) + current;
		
	}

}
