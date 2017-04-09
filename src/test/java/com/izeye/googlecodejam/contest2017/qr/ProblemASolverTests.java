package com.izeye.googlecodejam.contest2017.qr;

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
		assertThat(ProblemASolver.solve("---+-++- 3")).isEqualTo("3");
		assertThat(ProblemASolver.solve("+++++ 4")).isEqualTo("0");
		assertThat(ProblemASolver.solve("-+-+- 4")).isEqualTo("IMPOSSIBLE");
	}

}
