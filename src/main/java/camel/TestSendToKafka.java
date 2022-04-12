package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TestSendToKafka {
	public static void main(String[] args) throws Exception {

		final CamelContext context = new DefaultCamelContext();
		context.start();

		context.addRoutes(new SendKafkaRoute());

		Thread.sleep(60000);

		context.shutdown();
	}

	public static class SendKafkaRoute extends RouteBuilder {
		@Override
		public void configure() {
			from("timer:example?period=5000")
				.process(exchange -> exchange
					.getMessage()
					.setBody(String.format("{\"amount\": %s}", (int) (Math.random() * 1000 + 1))))
				.to("kafka:camel-topic?brokers=localhost:29092")
				.to("log:" + TestCamel.HelloWorldRoute.class.getName());
		}
	}

}
