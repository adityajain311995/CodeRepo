package com.code.randomprograms;

public class PassByValue_or_Reference {

	public static void main(String[] args) {
		Point pnt1 = new Point(0, 0);
		Point pnt2 = new Point(0, 0);
		System.out.println("X1: " + pnt1.x + " Y1: " + pnt1.y);
		System.out.println("X2: " + pnt2.x + " Y2: " + pnt2.y);
		System.out.println(" ");
		tricky(pnt1, pnt2);
		System.out.println("X1: " + pnt1.x + " Y1:" + pnt1.y);
		System.out.println("X2: " + pnt2.x + " Y2:" + pnt2.y);
	}

	public static void tricky(Point arg1, Point arg2) {
		arg1.x = 100;
		arg1.y = 100;
		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
		
		System.out.println("In method");
		System.out.println("X1: " + arg1.x + " Y1:" + arg1.y);
		System.out.println("X2: " + arg2.x + " Y2:" + arg2.y);
		System.out.println("\n");
	}
}

class Point {
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
