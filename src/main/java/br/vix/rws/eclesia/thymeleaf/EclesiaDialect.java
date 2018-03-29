package br.vix.rws.eclesia.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.vix.rws.eclesia.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.vix.rws.eclesia.thymeleaf.processor.MenuAttributeTagProcessor;
import br.vix.rws.eclesia.thymeleaf.processor.MessageElementTagProcessor;
import br.vix.rws.eclesia.thymeleaf.processor.OrderElementTagProcessor;
import br.vix.rws.eclesia.thymeleaf.processor.PaginationElementTagProcessor;

@Component
public class EclesiaDialect extends AbstractProcessorDialect {

	public EclesiaDialect() {
		super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginationElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}