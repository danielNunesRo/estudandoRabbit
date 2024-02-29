package com.danielnunesro.ensino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.ensino.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
