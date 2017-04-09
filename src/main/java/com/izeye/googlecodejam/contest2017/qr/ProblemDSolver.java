package com.izeye.googlecodejam.contest2017.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solver for Google Code Jam 2017 Qualification Round Problem D.
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
		// TODO: Solve me.
		return null;
	}

}
