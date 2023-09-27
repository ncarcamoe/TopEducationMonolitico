package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.EstudianteEntity;
import com.example.topEduMonolitico.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EstudianteController {
    @Autowired
	EstudianteService estudianteService;

    @GetMapping("/listar")
	public String listar(Model model) {
    	ArrayList<EstudianteEntity>estudiantes = estudianteService.obtenerEstudiantes();
    	/*model.addAttribute("estudiante",estudiantes);
		return "index";*/
		return "OK";
	}

}