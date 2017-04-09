package com.izeye.googlecodejam.contest2017.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solver for Google Code Jam 2017 Qualification Round Problem A.
 *
 * @author Johnny Lim
 */
public class ProblemASolver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCaseCount; i++) {
			String testCaseInput = br.readLine();
			String answer = String.format("Case #%d: %s", i, solve(testCaseInput));
			System.out.println(answer);
		}
	}

	private static final char HAPPY_SIDE = '+';
	private static final char BLANK_SIDE = '-';

	static String solve(String testCaseInput) {
		String[] split = testCaseInput.split(" ");
		String rowOfPancakes = split[0];
		int flipperSize = Integer.parseInt(split[1]);

		StringBuilder sb = new StringBuilder(rowOfPancakes);
		int flipCount = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == HAPPY_SIDE) {
				continue;
			}
			if (i + flipperSize > sb.length()) {
				return "IMPOSSIBLE";
			}
			for (int j = 0; j < flipperSize; j++) {
				int index = i + j;
				sb.setCharAt(index, flip(sb.charAt(index)));
			}
			flipCount++;
		}
		return String.valueOf(flipCount);
	}

	private static char flip(char side) {
		return side == HAPPY_SIDE ? BLANK_SIDE : HAPPY_SIDE;
	}

}
