package com.danielnunesro.ensino.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.danielnunesro.ensino.dtos.ClienteDTO;
import com.danielnunesro.ensino.entities.Cliente;

@Mapper
public interface ClienteMapper {
	
	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	@Mapping(target = "id", ignore = true)
	Cliente convertDtoToCliente(ClienteDTO clienteDTO);
	
	ClienteDTO converteEntityToDto(Cliente cliente);
	
}
