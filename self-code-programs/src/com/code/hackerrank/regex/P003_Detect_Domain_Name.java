package com.code.hackerrank.regex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/detect-the-domain-name/problem
 * @author adijain4
 *
 */
public class P003_Detect_Domain_Name {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        
        List<String> addresses = new ArrayList<>();
        for(int i=0; i<lines; i++) {
            String text = sc.nextLine();
            Pattern pattern = Pattern.compile("https?://?(ww[w2].)?[\\w-.]+(\\.[a-zA-Z0-1]+)");
            Matcher matcher = pattern.matcher(text);
            while(matcher.find()) {
                String group = matcher.group();
                if(group.startsWith("http:") || group.startsWith("https:")) {
                    group = group.substring(group.indexOf("//")+2);
                }
                if(group.startsWith("www.") || group.startsWith("ww2.")) {
                    group = group.substring(4);
                }
                if(!addresses.contains(group)) {
                    addresses.add(group);
                }
            }
        }
        
        addresses.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = o1.compareTo(o2);
                int ret;
                if(res>0) {
                    ret=1;
                }else if(res<0) {
                    ret=-1;
                }else {
                    ret=0;
                }
                
                return ret;
            }
        });
        
        String output = String.join(";", addresses);
        
        System.out.println(output);
    }
}
