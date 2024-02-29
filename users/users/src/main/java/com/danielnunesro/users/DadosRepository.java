package com.danielnunesro.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.users.domain.Dados;

public interface DadosRepository extends JpaRepository<Dados, Long> {

}
