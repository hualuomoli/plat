package com.github.hualuomoli.junit4;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringTestRunnerTest extends SpringTestRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringTestRunnerTest.class);

	@Test
	public void test() {
		logger.debug("instance spring ok....");
	}

}
