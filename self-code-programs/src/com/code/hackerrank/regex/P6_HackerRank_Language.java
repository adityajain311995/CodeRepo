package com.code.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P6_HackerRank_Language {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		String regex = "^\\d+ (C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$";
		for (int i = 0; i < lines; i++) {
			String text = sc.nextLine();
			if (Pattern.matches(regex, text)) {
				System.out.println("VALID");
			} else {
				System.out.println("INVALID");
			}
		}
	}

}
