package br.vix.rws.eclesia.repository.helper.cerveja;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.vix.rws.eclesia.dto.CervejaDTO;
import br.vix.rws.eclesia.dto.ValorItensEstoque;
import br.vix.rws.eclesia.model.Cerveja;
import br.vix.rws.eclesia.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
	
	public List<CervejaDTO> porSkuOuNome(String skuOuNome);

	public ValorItensEstoque valorItensEstoque();
}
