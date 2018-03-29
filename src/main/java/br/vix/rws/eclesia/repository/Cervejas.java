package br.vix.rws.eclesia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.vix.rws.eclesia.model.Cerveja;
import br.vix.rws.eclesia.repository.helper.cerveja.CervejasQueries;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {

	public Optional<Cerveja> findBySkuLikeIgnoreCase(String sku);

	
}
