package com.izeye.googlecodejam.contest2016.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solver for Google Code Jam 2016 Qualification Round Problem D.
 *
 * @author Johnny Lim
 */
public class ProblemDSolver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCaseCount; i++) {
			String testCaseInput = br.readLine();
			String answer = String.format("Case #%d: %s", i, solve(testCaseInput));
			System.out.println(answer);
		}
	}

	static String solve(String testCaseInput) {
		String[] split = testCaseInput.split(" ");
		int originalTileCount = Integer.parseInt(split[0]);
		int complexity = Integer.parseInt(split[1]);
		int studentCount = Integer.parseInt(split[1]);
		return solve(originalTileCount, complexity, studentCount);
	}

	// This works only with the small dataset constraint :)
	private static String solve(int originalTileCount, int complexity, int studentCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= originalTileCount; i++) {
			sb.append(i);
			sb.append(' ');
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

}
