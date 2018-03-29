package br.vix.rws.eclesia.model.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.vix.rws.eclesia.model.Cliente;
import br.vix.rws.eclesia.model.EntidadeReligiosa;

public class EntidadeReligiosaGroupSequenceProvider implements DefaultGroupSequenceProvider<EntidadeReligiosa> {

	@Override
	public List<Class<?>> getValidationGroups(EntidadeReligiosa entidade) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(Cliente.class);
		
		if (isPessoaSelecionada(entidade)) {
			grupos.add(entidade.getTipoPessoa().getGrupo());
		}
		
		return grupos;
	}

	private boolean isPessoaSelecionada(EntidadeReligiosa entidade) {
		return entidade != null && entidade.getTipoPessoa() != null;
	}

}