package com.code.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 *
 */
public class Migratory_Birds {

	public static void main(String[] args) {

	}

    static int migratoryBirds(List<Integer> arr) {
    	Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    	for(int ar : arr){
    		if(map.containsKey(ar)){
    			map.put(ar, map.get(ar)+1);
    			continue;
    		}
    		map.put(ar, 1);
    	}
    	int max=-1;
    	for(Entry<Integer, Integer> en : map.entrySet()){
    		if(max==-1){
    			max = en.getKey();
    			continue;
    		}
    		if(en.getValue() > map.get(max)){
    			max = en.getKey();
    		}else if((en.getValue() > map.get(max)) && (max>en.getKey())){
    			max = en.getKey();
    		}
    	}
    	return max;
    }
	
}
