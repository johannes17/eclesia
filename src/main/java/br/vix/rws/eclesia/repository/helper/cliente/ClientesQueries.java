package br.vix.rws.eclesia.repository.helper.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.vix.rws.eclesia.model.Cliente;
import br.vix.rws.eclesia.repository.filter.ClienteFilter;

public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
	
}