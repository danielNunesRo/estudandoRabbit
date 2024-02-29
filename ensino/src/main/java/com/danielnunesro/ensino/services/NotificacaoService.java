package com.danielnunesro.ensino.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.danielnunesro.ensino.entities.Cliente;

@Service
public class NotificacaoService {
	
	private RabbitTemplate rabbitTemplate;

	public NotificacaoService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void notificar(Cliente cliente, String exchange) {
		rabbitTemplate.convertAndSend(exchange, "", cliente);
	}
	
	
	
}
