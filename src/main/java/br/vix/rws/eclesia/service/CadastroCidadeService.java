package br.vix.rws.eclesia.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.vix.rws.eclesia.model.Cidade;
import br.vix.rws.eclesia.repository.Cidades;
import br.vix.rws.eclesia.service.exception.ImpossivelExcluirEntidadeException;
import br.vix.rws.eclesia.service.exception.NomeCidadeJaCadastradaException;

@Service
public class CadastroCidadeService {

	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cidade cidade) {
		Optional<Cidade> cidadeExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		if (cidadeExistente.isPresent()) {
			throw new NomeCidadeJaCadastradaException("Nome de cidade já cadastrado");
		}
		
		cidades.save(cidade);
	}

	@Transactional
	public void excluir(Cidade cidade) {
		try {
			cidades.delete(cidade);
			cidades.flush();//lanca excessao
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cidade. Já foi usada em alguma cadastro.");
		}
	}

	
}
