package com.googlecode.jmxtrans.model.output;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.googlecode.jmxtrans.model.Query;
import com.googlecode.jmxtrans.model.Result;
import com.googlecode.jmxtrans.model.Server;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.MDC;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;

@RunWith(MockitoJUnitRunner.class)
public class Slf4JOutputWriterTest {

	private Slf4JOutputWriter outputWriter;
	private Server server;
	private Query query;
	private ImmutableList<Result> results;
	private Result result;

	@Mock private Logger logger;

	@Before
	public void initOutputWriter() {
		outputWriter = new Slf4JOutputWriter(logger);
	}

	@Before
	public void initMetrics() {
		server = Server.builder().setHost("localhost").setPort("9876").build();
		query = Query.builder().build();
		result = new Result(1, "attributeName", "className", "objDomain", null, "typeName", ImmutableMap.of("key", (Object) 1));
		results = ImmutableList.of(result);
	}

	@Test
	public void metricsAreSentToLoggerViaMDC() throws Exception {
		doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				assertThat(MDC.get("server")).isEqualTo("localhost_9876");
				assertThat(MDC.get("metric")).isEqualTo("localhost_9876.className.attributeName_key");
				assertThat(MDC.get("value")).isEqualTo("1");
				assertThat(MDC.get("attributeName")).isEqualTo("attributeName");
				assertThat(MDC.get("key")).isEqualTo("key");
				assertThat(MDC.get("epoch")).isEqualTo("1");
				return null;
			}
		}).when(logger).info("");

		outputWriter.doWrite(server, query, results);
	}

	@Test
	public void mdcIsCleanedAfterCall() throws Exception {
		outputWriter.doWrite(server, query, results);

		assertThat(MDC.get("server")).isNull();
		assertThat(MDC.get("metric")).isNull();
		assertThat(MDC.get("value")).isNull();
		assertThat(MDC.get("attributeName")).isNull();
		assertThat(MDC.get("key")).isNull();
		assertThat(MDC.get("epoch")).isNull();
	}

}
