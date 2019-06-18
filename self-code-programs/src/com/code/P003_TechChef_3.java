package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class P003_TechChef_3 {

    public static List<String> compareFriends(List<String> frndsList) {
    	Collections.sort(frndsList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
    	
    	frndsList = frndsList.stream().distinct().collect(Collectors.toList());
    	
    	List<String> duplicates = new ArrayList<>();
    	
    	for(String frnd : frndsList) {
    		String[] individual = frnd.split(",");
    		String dupMatch = individual[1]+","+individual[0];
			if(!duplicates.contains(frnd) && frndsList.contains(dupMatch)) {
    			duplicates.add(dupMatch);
    		}
    	}
    	frndsList.removeAll(duplicates);
    	return frndsList;
    }
	
}
