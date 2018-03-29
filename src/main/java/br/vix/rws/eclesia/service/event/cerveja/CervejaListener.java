package br.vix.rws.eclesia.service.event.cerveja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.vix.rws.eclesia.storage.FotoStorage;

@Component
public class CervejaListener {

	@Autowired
	private FotoStorage fotoStorage;
	
//	@EventListener(condition = "#evento.temFoto() and #evento.novaFoto")
//	public void cervejaSalva(CervejaSalvaEvent evento) {
//		fotoStorage.salvar(evento.getCerveja().getFoto());
//	}
	
}
