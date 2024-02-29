package com.danielnunesro.ensino.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.danielnunesro.ensino.dtos.ClienteDTO;
import com.danielnunesro.ensino.mapper.ClienteMapper;
import com.danielnunesro.ensino.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	private NotificacaoService notificacaoService;
	
	private String exchange;
	
	public ClienteService(ClienteRepository clienteRepository, NotificacaoService notificacaoService, @Value("${rabbitmq.cliente.exchange}")String exchange) {
		this.clienteRepository = clienteRepository;
		this.notificacaoService = notificacaoService;
		this.exchange = exchange;
	}

	public Optional<ClienteDTO> findById(Long id) {
		var entity = clienteRepository.findById(id);
		if(entity.isEmpty()) {
			throw new NoSuchElementException("Cliente não encontrado para o ID: " + id);
		}
		
		var cliente = entity.get();
		ClienteDTO clienteDTO = ClienteMapper.INSTANCE.converteEntityToDto(cliente);
		
		return Optional.of(clienteDTO);
	}
	
	public ClienteDTO create(ClienteDTO clienteDTO) {
		var entityCliente = ClienteMapper.INSTANCE.convertDtoToCliente(clienteDTO);
		if(entityCliente == null) {
			throw new IllegalArgumentException("NULO!!!!!!!!!!");
		}
		
		clienteRepository.save(entityCliente);
		notificacaoService.notificar(entityCliente, exchange);
		ClienteDTO clienteSalvo = ClienteMapper.INSTANCE.converteEntityToDto(entityCliente);
		
		
		return clienteSalvo;
		
	}
	
	
}
