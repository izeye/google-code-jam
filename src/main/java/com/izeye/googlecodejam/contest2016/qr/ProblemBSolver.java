package com.izeye.googlecodejam.contest2016.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solver for Google Code Jam 2016 Qualification Round Problem B.
 *
 * @author Johnny Lim
 */
public class ProblemBSolver {

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
		int maneuverCount = 0;
		char[] pancakes = testCaseInput.toCharArray();

		Integer bottomBlankSideIndex = pancakes.length - 1;
		while (
				(bottomBlankSideIndex = getBottomBlankSideIndex(pancakes, bottomBlankSideIndex)) != null) {
			if (pancakes[0] == HAPPY_SIDE) {
				for (int i = 0; i < bottomBlankSideIndex; i++) {
					if (pancakes[i] != HAPPY_SIDE) {
						break;
					}
					pancakes[i] = BLANK_SIDE;
				}
			}
			else {
				for (int i = 0; i <= bottomBlankSideIndex / 2; i++) {
					char temp = pancakes[i];
					pancakes[i] = inverse(pancakes[bottomBlankSideIndex - i]);
					pancakes[bottomBlankSideIndex - i] = inverse(temp);
				}
			}
			maneuverCount++;
		}
		return String.valueOf(maneuverCount);
	}

	private static Integer getBottomBlankSideIndex(
			char[] pancakes, int previousBottomBlankSideIndex) {
		for (int i = previousBottomBlankSideIndex; i >= 0; i--) {
			if (pancakes[i] == BLANK_SIDE) {
				return i;
			}
		}
		return null;
	}

	private static char inverse(char side) {
		return side == HAPPY_SIDE ? BLANK_SIDE : HAPPY_SIDE;
	}

}
