package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.ColegioEntity;
import com.example.topEduMonolitico.services.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/colegio")
public class ColegioController {
    @Autowired
	ColegioService colegioService;

    @GetMapping("/listar")
	public String listar(Model model) {
    	ArrayList<ColegioEntity>colegios = colegioService.obtenerColegios();
    	/*model.addAttribute("estudiante",estudiantes);
		return "index";*/
		return "OK";
	}

}