package com.code.programs;


/**
 * There's a matrix MxN. A Robo sit on one of the coordinates (m,n). Each 1
 * second, Robo moves 1 coordinate in one of the 4 directions.(It doesn't stay
 * at same place) If the Robo moves out of the MxN matrix it dies. Find the
 * probability that the Robo is still alive after t seconds.
 */

public class MxN_Matrix_Robo_Probability {

	int M,N;
	int T;
	int alivePaths=0;
	int totalPaths;
	
	public static void main(String[] args) {
		MxN_Matrix_Robo_Probability prob = new MxN_Matrix_Robo_Probability();
		prob.M = 5;
		prob.N = 5;
		prob.T = 50;
		prob.move(new Coordinate(1, 1), 0);
		prob.totalPaths = (int)Math.pow(4, prob.T);
		System.out.println(prob.alivePaths);
		System.out.println(prob.totalPaths);
		System.out.println("Probability : "+ ((double)prob.alivePaths/(double)prob.totalPaths));
	}
	
	public void move(Coordinate current, int time){
		System.out.println("Time: "+time);
		if(!isAlive(current))return;
		
		if(time==T){
			System.out.println(alivePaths);
			alivePaths++;
			return;
		}
		
		move(current.shiftX(1), time+1);
		move(current.shiftY(1), time+1);
		move(current.shiftX(-1), time+1);
		move(current.shiftY(-1), time+1);
	}
	
	public boolean isAlive(Coordinate pos){
		if(pos.X >= M || pos.X < 0 || pos.Y >= N || pos.Y < 0){
			return false;
		}
		
		return true;
	}
	
}

class Coordinate{
	int X;
	int Y;
	
	public Coordinate(int x, int y) {
		X=x;
		Y=y;
	}
	
	public Coordinate shiftX(int x){
		return new Coordinate(X+x, Y);
	}
	
	public Coordinate shiftY(int y){
		return new Coordinate(X, Y+y);
	}
}