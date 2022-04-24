package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.ArrayList;
import java.util.List;

public class TestSendToKafka {
	private static final List<String> CARDS = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		for (int i = 1000; i < 2000; i++) {
			CARDS.add(String.format("card%s", i));
		}

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
				.process(exchange -> {
					final int amount = (int) (Math.random() * 1000 + 1);
					final String card = CARDS.get((int) (Math.random() * 1000));
					exchange
						.getMessage()
						.setBody(String.format("{\"card\":\"%s\",\"amount\":%s}", card, amount));
				})
				.to("kafka:camel-topic?brokers=localhost:29092")
				.to("log:" + TestSendToKafka.SendKafkaRoute.class.getName());
		}
	}

}
