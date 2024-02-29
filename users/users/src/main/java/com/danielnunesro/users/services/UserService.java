package com.danielnunesro.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunesro.users.DadosRepository;
import com.danielnunesro.users.domain.Dados;

@Service
public class UserService {
	
	@Autowired
	private DadosRepository dadosRepository;
	
	public void saveDados(Dados dados) {
		dadosRepository.save(dados);
	}
	
}
