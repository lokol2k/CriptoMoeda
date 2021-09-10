package br.com.cryptoProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cryptoProject.dao.UserRepository;
import br.com.cryptoProject.model.User;


@Controller
@RequestMapping("/users")
public class UserController{
	BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	@Autowired
	UserRepository dao;
	
	@GetMapping("/new")
	public String newForm(Model model) {
		User u = new User();
		model.addAttribute("user", u);	
		return "user/manterUser.html";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		User u = dao.findById(id).get();
		model.addAttribute("user", u);
		return "user/manterUser.html";
	}
	
	@PostMapping("/save")
	public String save(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors())
			return "user/manterUser.html";		
		
		user.setPassword(passEncoder.encode(user.getPassword()));
		if(passEncoder.matches(user.getConfirmPassword(), user.getPassword()))
			{
			dao.save(user);
			return "redirect:/users/list";
			
			}
		else
			result.addError(new FieldError("user", "confirmPassword", "As senhas tem que ser iguais"));
		
		return "user/manterUser.html";
		
		
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<User> users = dao.findAll();
		model.addAttribute("userList", users);
		return "user/list.html";
	}
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.removerUser(id);
		return "redirect:/users/list";
	}
}

