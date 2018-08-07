package com.code.dailycoding;

import java.util.ArrayList;
import java.util.List;

/**<pre>This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a period and an extension.
The name of a directory or sub-directory will not contain a period.</pre>
*/
public class Longest_File_Directory {
	static final String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
	static char[] chars;
	static int i = -1;
	static Node node;
	
	public static void main(String[] args) {
		createNode();
	}
	
	private static Node createNode() {
		chars = path.toCharArray();
		String str = "";
		if(current()>96 && current()<123){
			str = extract();
			if(node == null){
				node = new Node();
			}
			node.name = str;
		}
		if(current() == '\n' && next() == '\t' && next() != '\t'){
			node.getSub().add(new Node(extract()));
		}
		if(current() == '\n' && next() == '\t' && next() != '\t'){
			
		}
		return null;
	}
	
	private static String extract(){
		String str = "";
		while(current()!='\n' || current()!='\t'){
			str += current();
			next();
		}
		return str;
	}
	
	private static char next(){
		return chars[++i];
	}
	
	private static char current(){
		return chars[i];
	}
	
}

class Node{
	String name;
	List<Node> sub;
	public Node() {}
	
	public Node(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Node> getSub() {
		if(sub==null){
			return new ArrayList<Node>();
		}
		return sub;
	}
}
