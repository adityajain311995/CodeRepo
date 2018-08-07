package com.code.dailycoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * <pre>
This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. 
Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
Given this matrix, a start coordinate, and an end coordinate, return the minimum number 
of steps required to reach the end coordinate from the start. 
If there is no possible path, then return null. 
You can move up, left, down, and right. You cannot move through walls. 
You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left),
the minimum number of steps required to reach the end is 7, 
since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 * </pre>
 *
 */
public class MxN_matrix_wall_problem {

	int M,N;
	List<Coordinate> walls = new ArrayList<Coordinate>();
	Coordinate start;
	Coordinate end;
	Map<Integer, List<Coordinate>> paths = new HashMap<Integer, List<Coordinate>>();
	int count = 0;
	public static void main(String[] args) {
/*		MxN_matrix_wall_problem problem = new MxN_matrix_wall_problem();
		problem.M = problem.N = 3;
		problem.walls.add(new Coordinate(2, 1));
		problem.walls.add(new Coordinate(1, 1));
		problem.start = new Coordinate(0, 0);
		problem.end = new Coordinate(1, 2);
		
		problem.move(null, problem.start);
		System.out.println(problem.paths);*/
		
		Coordinate c1 = new Coordinate(1, 2);
		Coordinate c2 = new Coordinate(1, 2);
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1 == c2);
	}
	
	public void add(int id, Coordinate coordinate){
		if(!paths.containsKey(id)){
			paths.put(id, new ArrayList<Coordinate>());
		}
		paths.get(id).add(coordinate);
	}
	
	public MyBoolean move(Coordinate prev, Coordinate current){
		System.out.println("Count "+count);
		if(count >20){return new MyBoolean(false);}
		count++;
		
		if(current.getX()<0 || current.getX()>M-1 || current.getY()<0 || current.getY()>N-1)return new MyBoolean(false);
		if(walls.contains(current))return new MyBoolean(false);
		if(current.equals(end))return new MyBoolean(true);
		
		MyBoolean result;
		Coordinate next;
		
		next = current.moveX(1);
		if(!next.equals(prev)){
			result = move(current, next);
			if(result.isValue()){
				add(result.hashCode(), current);
				return result;
			}
		}
		
		next = current.moveY(1);
		if(!next.equals(prev)){
			result = move(current, next);
			if(result.isValue()){
				add(result.hashCode(), current);
				return result;
			}
		}
		
		next = current.moveX(-1);
		if(!next.equals(prev)){
			result = move(current, next);
			if(result.isValue()){
				add(result.hashCode(), current);
				return result;
			}
		}
		
		next = current.moveY(-1);
		if(!next.equals(prev)){
			result = move(current, next);
			if(result.isValue()){
				add(result.hashCode(), current);
				return result;
			}
		}
		
		
		return new MyBoolean(false);
	}
	
}

class MyBoolean{
	boolean value;
	public MyBoolean(boolean value) {
		this.value = value;
	}
	
	public boolean isValue() {
		return value;
	}
}

class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate moveX(int moveBy){
		return new Coordinate(this.x+moveBy, this.y);
	}
	
	public Coordinate moveY(int moveBy){
		return new Coordinate(this.x, this.y+moveBy);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return x*157+y*131;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coordinate){
			return ((Coordinate)obj).getX() == this.x && ((Coordinate)obj).getY() == this.y;
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "("+String.valueOf(this.x)+","+String.valueOf(this.y)+")";
	}
}