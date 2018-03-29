package br.vix.rws.eclesia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.vix.rws.eclesia.model.Estilo;
import br.vix.rws.eclesia.repository.helper.estilo.EstilosQueries;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {

	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}