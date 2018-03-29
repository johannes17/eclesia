package br.vix.rws.eclesia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vix.rws.eclesia.model.Cidade;
import br.vix.rws.eclesia.model.Estado;
import br.vix.rws.eclesia.repository.helper.cidade.CidadesQueries;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
	
}