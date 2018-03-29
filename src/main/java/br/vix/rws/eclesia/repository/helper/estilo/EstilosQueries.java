package br.vix.rws.eclesia.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.vix.rws.eclesia.model.Estilo;
import br.vix.rws.eclesia.repository.filter.EstiloFilter;

public interface EstilosQueries {
	
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}