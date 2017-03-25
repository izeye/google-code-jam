package com.izeye.googlecodejam.contest2016.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Solver for Google Code Jam 2016 Qualification Round Problem A.
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

	static String solve(String testCaseInput) {
		int number = Integer.parseInt(testCaseInput);
		return solve(number);
	}

	private static String solve(int number) {
		if (number == 0) {
			return "INSOMNIA";
		}
		Set<Character> digits = new HashSet<>();
		Integer answer = null;
		for (int i = 1; digits.size() != 10; i++) {
			answer = number * i;
			for (char c : String.valueOf(answer).toCharArray()) {
				digits.add(c);
			}
		}

		// 'answer' is impossible to be 'null'
		// but it's not possible to make the compile aware of it.
		return answer.toString();
	}

}
