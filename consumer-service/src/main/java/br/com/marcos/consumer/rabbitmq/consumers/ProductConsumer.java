package br.com.marcos.consumer.rabbitmq.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.marcos.consumer.configs.RabbitMQConfig;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Component
public class ProductConsumer {

	@RabbitListener(queues = {RabbitMQConfig.RK_PRODUCT_LOG})
	public void consumer(String message) {
		log.info("Received message "  + message.toString());
	}
}
