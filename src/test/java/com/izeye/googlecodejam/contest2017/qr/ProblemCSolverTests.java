package com.izeye.googlecodejam.contest2017.qr;

import java.math.BigInteger;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ProblemCSolver}.
 *
 * @author Johnny Lim
 */
public class ProblemCSolverTests {

	@Test
	public void testSolve() {
		assertThat(ProblemCSolver.solve("4 2")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("5 2")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("6 2")).isEqualTo("1 1");
		assertThat(ProblemCSolver.solve("1000 1000")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("1000 1")).isEqualTo("500 499");

		assertThat(ProblemCSolver.solve("12 1")).isEqualTo("6 5");
		assertThat(ProblemCSolver.solve("12 2")).isEqualTo("3 2");
		assertThat(ProblemCSolver.solve("12 3")).isEqualTo("2 2");
		assertThat(ProblemCSolver.solve("12 4")).isEqualTo("1 1");
		assertThat(ProblemCSolver.solve("12 5")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("12 6")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("12 7")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("12 8")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("12 9")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("12 10")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("12 11")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("12 12")).isEqualTo("0 0");

		assertThat(ProblemCSolver.solve("11 1")).isEqualTo("5 5");
		assertThat(ProblemCSolver.solve("11 2")).isEqualTo("2 2");
		assertThat(ProblemCSolver.solve("11 3")).isEqualTo("2 2");
		assertThat(ProblemCSolver.solve("11 4")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("11 5")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("11 6")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("11 7")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("11 8")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("11 9")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("11 10")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("11 11")).isEqualTo("0 0");

		assertThat(ProblemCSolver.solve("10 1")).isEqualTo("5 4");
		assertThat(ProblemCSolver.solve("10 2")).isEqualTo("2 2");
		assertThat(ProblemCSolver.solve("10 3")).isEqualTo("2 1");
		assertThat(ProblemCSolver.solve("10 4")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("10 5")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("10 6")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("10 7")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("10 8")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("10 9")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("10 10")).isEqualTo("0 0");

		assertThat(ProblemCSolver.solve("9 1")).isEqualTo("4 4");
		assertThat(ProblemCSolver.solve("9 2")).isEqualTo("2 1");
		assertThat(ProblemCSolver.solve("9 3")).isEqualTo("2 1");
		assertThat(ProblemCSolver.solve("9 4")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("9 5")).isEqualTo("1 0");
		assertThat(ProblemCSolver.solve("9 6")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("9 7")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("9 8")).isEqualTo("0 0");
		assertThat(ProblemCSolver.solve("9 9")).isEqualTo("0 0");

		assertThat(ProblemCSolver.solve("1 1")).isEqualTo("0 0");
	}

	@Test
	public void testSolvePerformanceWithSmallDataset2() {
		long stallCount = BigInteger.valueOf(10).pow(6).longValueExact();
		String testCaseInput = stallCount + " " + stallCount;
		assertThat(ProblemCSolver.solve(testCaseInput)).isEqualTo("0 0");
	}

	// FIXME:
	// It doesn't work within the time constraint.
	// Furthermore, it blows up with "java.lang.OutOfMemoryError: Java heap space"
	// although an enough time is given.
	@Test
	public void testSolvePerformanceWithLargeDataset() {
		long stallCount = BigInteger.valueOf(10).pow(18).longValueExact();
		String testCaseInput = stallCount + " " + stallCount;
		assertThat(ProblemCSolver.solve(testCaseInput)).isEqualTo("0 0");
	}

}
