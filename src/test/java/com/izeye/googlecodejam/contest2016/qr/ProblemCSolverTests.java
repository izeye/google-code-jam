package com.izeye.googlecodejam.contest2016.qr;

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
		assertThat(ProblemCSolver.solve("6 3")).isEqualTo(
				"100001 3 2 5 2 7 2 3 2 11\n" +
						"100011 5 13 3 31 43 3 73 7 3\n" +
						"100111 3 2 5 2 7 2 3 2 11");
	}

}
