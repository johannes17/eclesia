package br.vix.rws.eclesia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.vix.rws.eclesia.controller.page.PageWrapper;
import br.vix.rws.eclesia.model.Estilo;
import br.vix.rws.eclesia.repository.Estilos;
import br.vix.rws.eclesia.repository.filter.EstiloFilter;
import br.vix.rws.eclesia.service.CadastroEstiloService;
import br.vix.rws.eclesia.service.exception.ImpossivelExcluirEntidadeException;
import br.vix.rws.eclesia.service.exception.NomeEstiloJaCadastradoException;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

	@Autowired
	private CadastroEstiloService cadastroEstiloService;
	
	@Autowired
	private Estilos estilos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		//System.out.println("passou por aqui (2) com o nome: " + estilo.getNome());
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		estilo = cadastroEstiloService.salvar(estilo);
		return ResponseEntity.ok(estilo);
	}
	
	@GetMapping
	public ModelAndView pesquisar(EstiloFilter estiloFilter, BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("estilo/PesquisaEstilos");
		
		PageWrapper<Estilo> paginaWrapper = new PageWrapper<>(estilos.filtrar(estiloFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		return mv;
	}

	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		Estilo estilo = estilos.getOne(codigo);
		//System.out.println("passou por aqui com o nome: " + estilo.getNome());
		ModelAndView mv = novo(estilo);
		mv.addObject(estilo);
		return mv;
	}


	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Estilo estilo) {
		try {
			cadastroEstiloService.excluir(estilo);
		} catch (ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}

}