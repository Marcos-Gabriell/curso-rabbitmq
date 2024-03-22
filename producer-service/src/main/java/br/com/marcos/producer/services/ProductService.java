package br.com.marcos.producer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.marcos.producer.configs.RabbitMQConfig;
import br.com.marcos.producer.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProductService {
	
	private final RabbitTemplate rabbitTemplate;
	
	public void createProduct(ProductDTO dto) {
		log.info("Sending a message to echange " + dto.toString());
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE, dto);
		rabbitTemplate.convertAndSend(RabbitMQConfig.RK_PRODUCT_LOG, dto);
	}
}
