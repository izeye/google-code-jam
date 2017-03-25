package com.izeye.googlecodejam.contest2016.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Solver for Google Code Jam 2016 Qualification Round Problem C.
 *
 * @author Johnny Lim
 */
public class ProblemCSolver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCaseCount; i++) {
			String testCaseInput = br.readLine();
			String answer = String.format("Case #%d:%n%s", i, solve(testCaseInput));
			System.out.println(answer);
		}
	}

	static String solve(String testCaseInput) {
		String[] split = testCaseInput.split(" ");
		int jamcoinLength = Integer.parseInt(split[0]);
		int jamcoinCount = Integer.parseInt(split[1]);
		return solve(jamcoinLength, jamcoinCount);
	}

	private static String solve(int jamcoinLength, int jamcoinCount) {
		List<Jamcoin> jamcoins = new ArrayList<>();
		long minBinaryJamcoin =
				BigInteger.valueOf(2).pow(jamcoinLength - 1).add(BigInteger.ONE).longValue();
		long maxBinaryJamcoin =
				BigInteger.valueOf(2).pow(jamcoinLength).subtract(BigInteger.ONE).longValue();
		for (long binaryJamcoin = minBinaryJamcoin; binaryJamcoin < maxBinaryJamcoin; binaryJamcoin++) {
			String binary = Long.toString(binaryJamcoin, 2);
			if (binary.charAt(binary.length() - 1) == '0') {
				continue;
			}

			List<Integer> nonTrivialDivisors = new ArrayList<>();
			for (int base = 2; base <= 10; base++) {
				BigInteger jamcoin = BigInteger.ZERO;
				for (int i = 0; i < binary.length(); i++) {
					BigInteger digit = BigInteger.valueOf(binary.charAt(binary.length() - 1 - i) - '0');
					jamcoin = jamcoin.add(BigInteger.valueOf(base).pow(i).multiply(digit));
				}
				// NOTE: Try to find a non-trivial divisor having two digit for performance.
				// If it's not sufficient, I can raise the number of digits for non-trivial divisors :)
				boolean nonTrivialDivisorFound = false;
				for (int nonTrivialDivisor = 2; nonTrivialDivisor < 100; nonTrivialDivisor++) {
					if (jamcoin.remainder(BigInteger.valueOf(nonTrivialDivisor)).equals(BigInteger.ZERO)) {
						nonTrivialDivisors.add(nonTrivialDivisor);
						nonTrivialDivisorFound = true;
						break;
					}
				}
				if (!nonTrivialDivisorFound) {
					break;
				}
			}
			if (nonTrivialDivisors.size() != 9) {
				continue;
			}
			jamcoins.add(new Jamcoin(binary, nonTrivialDivisors));

			if (jamcoins.size() == jamcoinCount) {
				break;
			}
		}

		if (jamcoins.size() != jamcoinCount) {
			throw new RuntimeException(
					"Maybe the number of digits for non-trivial divisors is too small?");
		}

		StringBuilder sb = new StringBuilder();
		for (Jamcoin jamcoin : jamcoins) {
			sb.append(jamcoin);
			sb.append("\n");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	private static class Jamcoin {

		private final String value;
		private final List<Integer> nonTrivialDivisors;

		public Jamcoin(String value, List<Integer> nonTrivialDivisors) {
			this.value = value;
			this.nonTrivialDivisors = nonTrivialDivisors;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.value);
			for (Integer nonTrivialDivisor : this.nonTrivialDivisors) {
				sb.append(' ');
				sb.append(nonTrivialDivisor);
			}
			return sb.toString();
		}

	}

}
