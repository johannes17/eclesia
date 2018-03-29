package br.vix.rws.eclesia.service.event.cerveja;

import org.springframework.util.StringUtils;

import br.vix.rws.eclesia.model.Cerveja;

public class CervejaSalvaEvent {

	private Cerveja cerveja;

	public CervejaSalvaEvent(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}
	
	public boolean temFoto() {
		return !StringUtils.isEmpty(cerveja.getFoto());
	}

	public boolean isNovaFoto() {
		return cerveja.isNovaFoto();
	}
}
