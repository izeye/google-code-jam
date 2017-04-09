package com.izeye.googlecodejam.contest2017.qr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ProblemDSolver}.
 *
 * @author Johnny Lim
 */
public class ProblemDSolverTests {

	@Test
	public void testSolve() {
		assertThat(
				ProblemDSolver.solve("2 0"))
				.isEqualTo(
						"4 3\n" +
								"o 2 2\n" +
								"+ 2 1\n" +
								"x 1 1");
		assertThat(
				ProblemDSolver.solve(
						"1 1\n" +
								"o 1 1"))
				.isEqualTo("2 0");
		assertThat(
				ProblemDSolver.solve(
						"3 4\n" +
								"+ 2 3\n" +
								"+ 2 1\n" +
								"x 3 1\n" +
								"+ 2 2"))
				.isEqualTo(
						"6 2\n" +
								"o 2 3\n" +
								"x 1 2");
	}

}
