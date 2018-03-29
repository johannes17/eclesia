package br.vix.rws.eclesia.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.vix.rws.eclesia.model.Estilo;
import br.vix.rws.eclesia.repository.Estilos;
import br.vix.rws.eclesia.service.exception.ImpossivelExcluirEntidadeException;
import br.vix.rws.eclesia.service.exception.NomeEstiloJaCadastradoException;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		
		return estilos.saveAndFlush(estilo);
	}
	
	@Transactional
	public void excluir(Estilo estilo) {
		try {
			estilos.delete(estilo);
			estilos.flush();//lanca excessao
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar estilo. Já foi usada em alguma cadastro.");
		}
	}

}
