package com.code.dailycoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This problem was asked by Amazon.
 * Given an integer k and a string s,
 * find the length of the longest substring 
 * that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2,
 * the longest substring with k distinct characters is "bcb".
 */
public class Longest_Substring_with_K_dist_char {

	static final int k=20;
	static String maxSub="";
	static List<String> list_maxSub = new ArrayList<String>();
	static List<Index> memo;
	
	public static void main(String[] args) {
		String str = "abcbaasditahtaffaijiabcbaasdrafsrjakiastdggfsrdasijasataffbajasataffattsfsttsabcbabcsuagstdfascscbagtjijasabaasdattsfsraftahsuagstdabcijasdijijasatabcbaasdijijasataffattsfsraftahsuagstdfascscbagtsrjakiastdggfsrdasaffattsfsraftahsuagstdfascscbagtsrjakiastdggfsrdasabcbaasdijijasataffattsfsraftahsuagstdfascscbagtsrjakiastdggfsrdasfascscbagtsrjakiastdggfsrdasaasdabcbaasdijijasataffattsfsraftahsuagstdfascscbagtsrjakiastdggfsrdasijijasataffattsfsraftahsuagstdfascscbagtsrjakiastdggfsrdasfsraftahsuagstdfascscbagtsrjakiastdggfsrdas";
		System.out.println(str.length());
		find_max_Sub(str, 0, str.length());
		System.out.println(list_maxSub);
	}

	private static void find_max_Sub(String str, int i, int j) {
		if(memo==null) {
			memo = new ArrayList<Index>();
		}
		if(memo.contains(new Index(i, j))) {
			return;
		}
		
		if(j-i<k) {
			return;
		}
		
		String sub = str.substring(i, j);
		int chars = distinct_char(sub);
		if(chars==k) {
			if(sub.length()>maxSub.length()) {
				maxSub = sub;
				list_maxSub.removeAll(list_maxSub);
				list_maxSub.add(sub);
			}else if(sub.length()==maxSub.length()) {
				list_maxSub.add(sub);
			}
		}
		memo.add(new Index(i, j));
		find_max_Sub(str, i+1, j);
		find_max_Sub(str, i, j-1);
	}
	
	private static int distinct_char(String word) {
		Set<Character> set = new HashSet<Character>();
		
		for (char letter : word.toCharArray()) {
			set.add(letter);
		}
		return set.size();
	}
	
	private static class Index{
		int i,j;

		public Index(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Index)
			return this.i==((Index)obj).i && this.j==((Index)obj).j;
			return super.equals(obj);
		}
	}
}
