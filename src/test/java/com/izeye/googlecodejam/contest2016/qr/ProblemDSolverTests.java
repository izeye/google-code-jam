package com.izeye.googlecodejam.contest2016.qr;

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
		assertThat(ProblemDSolver.solve("2 3 2")).isEqualTo("2");
		assertThat(ProblemDSolver.solve("1 1 1")).isEqualTo("1");
		assertThat(ProblemDSolver.solve("2 1 1")).isEqualTo("IMPOSSIBLE");
		assertThat(ProblemDSolver.solve("2 1 2")).isEqualTo("1 2");
		assertThat(ProblemDSolver.solve("3 2 3")).isEqualTo("2 6");
	}

}
