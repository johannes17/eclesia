package br.vix.rws.eclesia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vix.rws.eclesia.model.Cliente;
import br.vix.rws.eclesia.repository.helper.cliente.ClientesQueries;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {

	public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

	public List<Cliente> findByNomeStartingWithIgnoreCase(String nome);

}
