package br.vix.rws.eclesia.repository.helper.venda;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.vix.rws.eclesia.dto.VendaMes;
import br.vix.rws.eclesia.dto.VendaOrigem;
import br.vix.rws.eclesia.model.Venda;
import br.vix.rws.eclesia.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	public BigDecimal valorTotalNoMes();
	public BigDecimal valorTicketMedioNoAno();
	
	public List<VendaMes> totalPorMes();
	public List<VendaOrigem> totalPorOrigem();
	
}