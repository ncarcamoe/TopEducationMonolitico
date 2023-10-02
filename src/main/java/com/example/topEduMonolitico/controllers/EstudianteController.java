package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.ColegioEntity;
import com.example.topEduMonolitico.entities.EstudianteEntity;
import com.example.topEduMonolitico.services.ColegioService;
import com.example.topEduMonolitico.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
	EstudianteService estudianteService;

	@Autowired
	ColegioService colegioService;

	@GetMapping("/listar")
	public String listar(Model model) {
		ArrayList<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
		model.addAttribute("titulo","Listado de estudiante");
		model.addAttribute("estudiantes",estudiantes);
		return "estudiante";
	}

	@GetMapping("/editarPorId/{id}")
	public String editarPorId(Model model, @PathVariable Long id) {
		EstudianteEntity estudiante = estudianteService.obtenerPorId(id);
		ArrayList<ColegioEntity> colegios = colegioService.obtenerColegios();
		model.addAttribute("titulo","Modifica Estudiante");
		model.addAttribute("colegios",colegios);
		model.addAttribute("estudiante",estudiante);
		return "estudianteEditar";
	}

	@GetMapping("/eliminarPorId/{id}")
	public String eliminarPorId(Model model, @PathVariable Long id) {
		estudianteService.eliminarEstudiante(id);
		return "redirect:/estudiante/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		EstudianteEntity estudiante = new EstudianteEntity();
		ArrayList<ColegioEntity> colegios = colegioService.obtenerColegios();
		model.addAttribute("titulo","Nuevo Estudiante");
		model.addAttribute("colegios",colegios);
		model.addAttribute("estudiante",estudiante);
		return "estudianteEditar";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute EstudianteEntity estudianteEntity){
		estudianteService.guardarEstudiante(estudianteEntity);
		return "redirect:/estudiante/listar";
	}

}