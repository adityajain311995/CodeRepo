package com.interview;

import java.util.List;

public class P007_Groupon_MinimumMoves {

	public static int minimumMoves(List<Integer> a, List<Integer> m) {
		int moveCount = 0;
		int size = a.size();

		for (int i = 0; i < size; i++) {
			int valA = a.get(i);
			int valM = m.get(i);
			moveCount = moveCount + findMoves(valA, valM);
		}

		return moveCount;
	}

	private static int findMoves(int valA, int valM) {
		int moves = 0;
		if (valA == valM) {
			return 0;
		}
		while (valA != 0 && valA != 0) {
			moves = moves + Math.abs(valM % 10 - valA % 10);

			valA = valA / 10;
			valM = valM / 10;
		}
		return moves;
	}

}
