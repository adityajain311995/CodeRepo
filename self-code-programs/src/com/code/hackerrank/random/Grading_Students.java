package com.code.hackerrank.random;

public class Grading_Students {

	public static void main(String[] args) {
		int[] results = gradingStudents(new int[] {73,67,38,33});
		for (int i : results) {
			System.out.println(i);
		}
	}

	
    static int[] gradingStudents(int[] grades) {
        for (int i=0; i<grades.length; i++) {
            if(grades[i] >= 38 && (grades[i]+1)%5==0) {
                grades[i] += 1;  
            }else if(grades[i] >= 38 &&  (grades[i]+2)%5==0){
                grades[i] += 2;
            }
        }
        return grades;
    }
	
}
