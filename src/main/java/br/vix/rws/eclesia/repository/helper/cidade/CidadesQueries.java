package br.vix.rws.eclesia.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.vix.rws.eclesia.model.Cidade;
import br.vix.rws.eclesia.repository.filter.CidadeFilter;

public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
	
	public Cidade buscarComEstado(Long codigo);
	
}