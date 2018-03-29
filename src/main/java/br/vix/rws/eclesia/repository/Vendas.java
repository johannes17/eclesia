package br.vix.rws.eclesia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vix.rws.eclesia.model.Venda;
import br.vix.rws.eclesia.repository.helper.venda.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}