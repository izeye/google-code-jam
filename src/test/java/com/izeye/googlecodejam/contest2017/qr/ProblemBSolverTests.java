package com.izeye.googlecodejam.contest2017.qr;

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
		assertThat(ProblemBSolver.solve("132")).isEqualTo("129");
		assertThat(ProblemBSolver.solve("1000")).isEqualTo("999");
		assertThat(ProblemBSolver.solve("7")).isEqualTo("7");
		assertThat(ProblemBSolver.solve("111111111111111110")).isEqualTo("99999999999999999");
		assertThat(ProblemBSolver.solve("943")).isEqualTo("899");
	}

}
