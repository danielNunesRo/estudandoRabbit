package com.danielnunesro.users.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielnunesro.users.domain.Cliente;
import com.danielnunesro.users.domain.Dados;
import com.danielnunesro.users.services.UserService;

@Component
public class UserListener {
	
	@Autowired
	private UserService userService;
	
	@RabbitListener(queues = "${rabbitmq.queue.cliente.users}")
	public void clienteCadastrado(Cliente cliente) {
		Dados dados = new Dados(cliente.getAge());
		userService.saveDados(dados);
	}
	
}
