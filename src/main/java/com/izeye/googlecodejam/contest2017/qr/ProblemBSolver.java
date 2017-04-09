package com.izeye.googlecodejam.contest2017.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solver for Google Code Jam 2017 Qualification Round Problem B.
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

	static String solve(String testCaseInput) {
		StringBuilder sb = new StringBuilder(testCaseInput);

		Integer untidyStartIndex = null;
		for (int i = 0; i < sb.length(); i++) {
			if (i > 0 && sb.charAt(i) < sb.charAt(i - 1)) {
				untidyStartIndex = i;
				break;
			}
		}
		if (untidyStartIndex == null) {
			return testCaseInput;
		}
		int tidyEndIndex = untidyStartIndex - 1;
		int index = 0;
		for (int i = tidyEndIndex; i > 0; i--) {
			if (sb.charAt(i) - 1 >= sb.charAt(i - 1)) {
				index = i;
				break;
			}
		}
		if (index == 0 && sb.charAt(0) == '1') {
			sb.deleteCharAt(0);
		}
		else {
			sb.setCharAt(index, (char) (sb.charAt(index) - 1));
			index++;
		}
		for (int i = index; i < sb.length(); i++) {
			sb.setCharAt(i, '9');
		}
		return sb.toString();
	}

}
