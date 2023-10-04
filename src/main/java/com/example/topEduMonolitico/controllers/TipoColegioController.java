package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.TipoColegioEntity;
import com.example.topEduMonolitico.services.TipoColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/tipoColegio")
public class TipoColegioController {
    @Autowired
	TipoColegioService tipoColegioService;

    @GetMapping("/listar")
	public String listar(Model model) {
		ArrayList<TipoColegioEntity>tipoColegios = tipoColegioService.obtenerTipoColegios();
		model.addAttribute("titulo","Listado de tipos de colegios");
		model.addAttribute("tipoColegios",tipoColegios);
		return "tipoColegio";
	}

	@GetMapping("/editarPorId/{id}")
	public String editarPorId(Model model, @PathVariable Long id) {
		TipoColegioEntity tipoColegio = tipoColegioService.obtenerPorId(id);
		model.addAttribute("titulo","Modifica Tipo Colegio");
		model.addAttribute("tipoColegio",tipoColegio);
		return "tipoColegioEditar";
	}

	@GetMapping("/eliminarPorId/{id}")
	public String eliminarPorId(Model model, @PathVariable Long id) {
		tipoColegioService.eliminarTipoColegio(id);
		return "redirect:/tipoColegio/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		TipoColegioEntity tipoColegio = new TipoColegioEntity();
		model.addAttribute("titulo","Nuevo Tipo Colegio");
		model.addAttribute("tipoColegio",tipoColegio);
		return "tipoColegioEditar";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute TipoColegioEntity tipoColegioEntity){
		tipoColegioService.guardarTipoColegio(tipoColegioEntity);
		return "redirect:/tipoColegio/listar";
	}
}