package br.com.cryptoProject.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cryptoProject.commons.Price;
import br.com.cryptoProject.dao.CriptoMoedaRepository;
import br.com.cryptoProject.model.CriptoMoeda;
import br.com.cryptoProject.model.CriptoMoedaCoingecko;
import br.com.cryptoProject.service.CriptoMoedaCoingeckoService;
import br.com.cryptoProject.service.CriptoPriceService;

@Controller
@RequestMapping("/criptoMoedas")
public class CriptoMoedaController {
	@Autowired
	CriptoMoedaRepository daoc;
	
	@Autowired
	CriptoMoedaCoingeckoService criptoService;
	
	@Autowired
	CriptoPriceService priceService;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		CriptoMoeda u = new CriptoMoeda();
		model.addAttribute("criptoMoeda", u);	
		return "criptoMoeda/manterCriptoMoeda.html";
	}
	
	@GetMapping("/coingecko/{id}")
	public String coingecko(@PathVariable("id") Long id,Model model) {
		CriptoMoeda c = daoc.findById(id).get();
		model.addAttribute("criptoMoeda", c);
		

		CriptoMoedaCoingecko cripto = criptoService.getCriptoById(c.getCodigo());
		c.setCoingecko(cripto);
		
		ResponseEntity<Map<String, Price>> price = priceService.getCriptoPriceById(c.getCodigo());
		
			//c.setPriceString(price.getBody().get(c.getCodigo()).getUsd());
			c.setPrice(price.getBody().get(c.getCodigo()));

		
		return "criptoMoeda/manterCriptoMoeda.html";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		CriptoMoeda c = daoc.findById(id).get();
		model.addAttribute("criptoMoeda", c);
		
		return "criptoMoeda/manterCriptoMoeda.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid CriptoMoeda c, BindingResult result, Model model) {
		CriptoMoedaCoingecko cripto = criptoService.getCriptoById(c.getCodigo());
		
		if(cripto == null) {
			result.addError(new FieldError("criptoMoeda", "codigo", "Código da cripto não foi encontrada na API coingecko"));
			return "criptoMoeda/mantercriptoMoeda.html";
		}
		
		if(result.hasErrors()) {
			return "criptoMoeda/mantercriptoMoeda.html";		
		}
			daoc.save(c);
			return "redirect:/criptoMoedas/list";
		
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<CriptoMoeda> criptoMoedas = daoc.findAll();
		model.addAttribute("criptoMoedaList", criptoMoedas);
		return "criptoMoeda/list.html";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		daoc.removerCriptoMoeda(id);
		return "redirect:/criptoMoedas/list";
	}
}
