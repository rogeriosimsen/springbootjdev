package curso.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.PessoaModel;
import curso.springboot.repository.PessoaRepository;

@Controller
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/cadastropessoa")
	public ModelAndView inicio() {
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pessoaobj", new PessoaModel());
		
		return mv;
	}
	
	@PostMapping("*/salvarpessoa")
	public ModelAndView salvar(PessoaModel pessoaModel) {
		
		pessoaRepository.save(pessoaModel);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		
		Iterable<PessoaModel> pessoasIt = pessoaRepository.findAll();
		
		modelAndView.addObject("pessoas", pessoasIt);
		modelAndView.addObject("pessoaobj", new PessoaModel());
		
		return modelAndView;
	}
	
	@GetMapping("/listapessoas")
	public ModelAndView listaPessoas() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		
		Iterable<PessoaModel> pessoasIt = pessoaRepository.findAll();
		
		modelAndView.addObject("pessoas", pessoasIt);
		modelAndView.addObject("pessoaobj", new PessoaModel());
		
		return modelAndView;
	}
	
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
		
		Optional<PessoaModel> pessoaModel = pessoaRepository.findById(idpessoa);
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pessoaobj", pessoaModel.get());
		
		return mv;
	}
	
	@GetMapping("/excluirpessoa/{idpessoa}")
	public ModelAndView exluir(@PathVariable("idpessoa") Long idpessoa) {
		
		pessoaRepository.deleteById(idpessoa);
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		mv.addObject("pessoas", pessoaRepository.findAll());
		mv.addObject("pessoaobj", new PessoaModel());
		
		return mv;
	}
	
	@PostMapping("*/pesquisapornome")
	public ModelAndView pesquisaPorNome(@RequestParam("nomepesquisa") String nomepesquisa) {
		
		ModelAndView mv = new ModelAndView("cadastro/cadastropessoa");
		
		mv.addObject("pessoas", pessoaRepository.findByName(nomepesquisa));
		mv.addObject("pessoaobj", new PessoaModel());
		
		return mv;
	}
}
