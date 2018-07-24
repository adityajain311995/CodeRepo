package com.code.hackerrank;
//WRONG
public class Hexagonal_Grid {

	public static void main(String[] args) {
		
	}
	
    static String hexagonalGrid(String a, String b) {
    	char[] aArr = a.toCharArray();
    	char[] bArr = b.toCharArray();
    	int blockCount = 0;
    	for(int i=0; i<aArr.length; i++){
    		if(aArr[i] == '1')blockCount++;
    		if(bArr[i] == '1')blockCount++;
    	}
    	if(blockCount%2 != 0)return "NO";
    	
    	return null;
    }
	
}
