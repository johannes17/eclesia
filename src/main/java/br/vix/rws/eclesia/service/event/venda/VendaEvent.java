package br.vix.rws.eclesia.service.event.venda;

import br.vix.rws.eclesia.model.Venda;

public class VendaEvent {

	private Venda venda;

	public VendaEvent(Venda venda) {
		this.venda = venda;
	}

	public Venda getVenda() {
		return venda;
	}

}
