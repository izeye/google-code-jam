package com.izeye.googlecodejam.contest2016.qr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ProblemASolver}.
 *
 * @author Johnny Lim
 */
public class ProblemASolverTests {

	@Test
	public void testSolve() {
		assertThat(ProblemASolver.solve(0)).isEqualTo("INSOMNIA");
		assertThat(ProblemASolver.solve(1)).isEqualTo("10");
		assertThat(ProblemASolver.solve(2)).isEqualTo("90");
		assertThat(ProblemASolver.solve(11)).isEqualTo("110");
		assertThat(ProblemASolver.solve(1692)).isEqualTo("5076");
	}

}
