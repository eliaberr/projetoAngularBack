package br.com.fatec.primeiroprojeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.primeiroprojeto.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer>{}
