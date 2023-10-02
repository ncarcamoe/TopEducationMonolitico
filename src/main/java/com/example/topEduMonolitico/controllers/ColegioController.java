package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.ColegioEntity;
import com.example.topEduMonolitico.entities.TipoColegioEntity;
import com.example.topEduMonolitico.services.ColegioService;
import com.example.topEduMonolitico.services.TipoColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/colegio")
public class ColegioController {
    @Autowired
	ColegioService colegioService;

	@Autowired
	TipoColegioService tipoColegioService;

	@GetMapping("/listar")
	public String listar(Model model) {
		ArrayList<ColegioEntity> colegios = colegioService.obtenerColegios();
		model.addAttribute("titulo","Listado de colegios");
		model.addAttribute("colegios",colegios);
		return "colegio";
	}

	@GetMapping("/editarPorId/{id}")
	public String editarPorId(Model model, @PathVariable Long id) {
		ColegioEntity colegio = colegioService.obtenerPorId(id);
		ArrayList<TipoColegioEntity> tipoColegios = tipoColegioService.obtenerTipoColegios();
		model.addAttribute("titulo","Modifica Colegio");
		model.addAttribute("tipoColegios",tipoColegios);
		model.addAttribute("colegio",colegio);
		return "colegioEditar";
	}

	@GetMapping("/eliminarPorId/{id}")
	public String eliminarPorId(Model model, @PathVariable Long id) {
		colegioService.eliminarColegio(id);
		return "redirect:/colegio/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		ColegioEntity colegio = new ColegioEntity();
		ArrayList<TipoColegioEntity> tipoColegios = tipoColegioService.obtenerTipoColegios();
		model.addAttribute("titulo","Nuevo Colegio");
		model.addAttribute("tipoColegios",tipoColegios);
		model.addAttribute("colegio",colegio);
		return "colegioEditar";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute ColegioEntity colegioEntity){
		colegioService.guardarColegio(colegioEntity);
		return "redirect:/colegio/listar";
	}

}