package com.izeye.googlecodejam.contest2016.qr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ProblemBSolver}.
 *
 * @author Johnny Lim
 */
public class ProblemBSolverTests {

	@Test
	public void testSolve() {
		assertThat(ProblemBSolver.solve("-")).isEqualTo("1");
		assertThat(ProblemBSolver.solve("-+")).isEqualTo("1");
		assertThat(ProblemBSolver.solve("+-")).isEqualTo("2");
		assertThat(ProblemBSolver.solve("+++")).isEqualTo("0");
		assertThat(ProblemBSolver.solve("--+-")).isEqualTo("3");
		assertThat(ProblemBSolver.solve("++-++++---")).isEqualTo("4");
	}

}
