package com.izeye.googlecodejam.contest2017.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solver for Google Code Jam 2017 Qualification Round Problem C.
 *
 * @author Johnny Lim
 */
public class ProblemCSolver {

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
		long stallCount = Long.parseLong(split[0]);
		long personCount = Long.parseLong(split[1]);

		Answer answer = getAnswer(stallCount);
		String binary = Long.toBinaryString(personCount);
		StringBuilder sb = new StringBuilder(binary);
		for (int i = 1; i < binary.length(); i++) {
			sb.setCharAt(i, '0');
		}
		String startBinary = sb.toString();
		for (int i = 1; i < binary.length(); i++) {
			sb.setCharAt(i, '1');
		}
		String endBinary = sb.toString();
		long start = Long.parseLong(startBinary, 2);
		long end = Long.parseLong(endBinary, 2);
		List<Answer> answers = new ArrayList<>();
		System.out.println(end - start);
		for (long i = start; i <= end; i++) {
			answers.add(getAnswer(answer, Long.toBinaryString(i)));
		}
		Collections.sort(answers);

		long offset = personCount - start;
		return answers.get((int) (answers.size() - 1 - offset)).toString();
	}

	private static Answer getAnswer(Answer answer, String binary) {
		for (int i = 1; i < binary.length(); i++) {
			char digit = binary.charAt(i);
			if (digit == '0') {
				answer = getAnswer(answer.getLarge());
			}
			else {
				answer = getAnswer(answer.getSmall());
			}
		}
		return answer;
	}

	private static final Map<Long, Answer> answerCache = new HashMap<>();

	private static Answer getAnswer(long stallCount) {
		Answer cached = answerCache.get(stallCount);
		if (cached != null) {
			return cached;
		}

		long quotient = stallCount / 2;
		long remainder = stallCount % 2;
		long large = quotient;
		long small = Math.max(quotient - (1 - remainder), 0);

		Answer answer = new Answer(large, small);

		answerCache.put(stallCount, answer);
		return answer;
	}

	private static class Answer implements Comparable<Answer> {

		private final long large;
		private final long small;

		public Answer(long large, long small) {
			this.large = large;
			this.small = small;
		}

		public long getLarge() {
			return this.large;
		}

		public long getSmall() {
			return this.small;
		}

		@Override
		public String toString() {
			return this.large + " " + this.small;
		}

		@Override
		public int compareTo(Answer o) {
			int result = Long.compare(this.large, o.large);
			if (result != 0) {
				return result;
			}
			return Long.compare(this.small, o.small);
		}

	}

}
