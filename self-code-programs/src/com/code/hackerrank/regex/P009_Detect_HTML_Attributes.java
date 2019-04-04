package com.code.hackerrank.regex;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P009_Detect_HTML_Attributes {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringWriter writer = new StringWriter();
        for (int i = 0; i < N; i++) {
            writer.append(sc.nextLine());
        }
        
        String text = writer.toString();
        String regex = "(<(\\w+)>)|(<(\\w+) .+?>)";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        
        Map<String,Set> map = new HashMap<>();
        while(matcher.find()) {
            String group = matcher.group();
            String tagValue;
            if(!group.contains(" ")) {
                tagValue = matcher.group(2);
            }else {
                tagValue = matcher.group(4);
            }
            Matcher matcher2 = Pattern.compile("(\\w+)=(\"|').*?\\2").matcher(group);
            Set<String> output = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            while(matcher2.find()) {
                output.add(matcher2.group(1));
            }
            
            if(map.containsKey(tagValue)) {
                map.get(tagValue).addAll(output);
            }else {
                map.put(tagValue, output);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(Entry<String, Set> entry : map.entrySet()) {
            list.add(String.join(":", entry.getKey(), String.join(",",entry.getValue())));
        }
        
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        for(String out:list) {
            System.out.println(out);
        }
        
        sc.close();
    }
}
