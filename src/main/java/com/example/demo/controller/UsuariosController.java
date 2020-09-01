package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.entity.Usuario;

@Controller
public class UsuariosController {
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/form")
	public String userForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "userForm";
	}
	
	@PostMapping("save")
	public String saveUser(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "userForm";
		}
		
		try {
			usuarioDao.save(usuario);
		}catch (DataAccessException e) {
			e.getMessage();
			model.addAttribute("unique", "El usuario ya existe!");
			return "userForm";
			
		}
		
			
	
		return "redirect:/home";
	}

}
