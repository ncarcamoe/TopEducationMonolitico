package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.ArancelEntity;
import com.example.topEduMonolitico.services.ArancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/arancel")
public class ArancelController {
    @Autowired
	ArancelService arancelService;

    @GetMapping("/listar")
	public String listar(Model model) {
		ArrayList<ArancelEntity>aranceles = arancelService.obtenerAranceles();
		model.addAttribute("titulo","Listado de aranceles");
		model.addAttribute("aranceles",aranceles);
		return "arancel";
	}

	@GetMapping("/editarPorId/{id}")
	public String editarPorId(Model model, @PathVariable Long id) {
		ArancelEntity arancel = arancelService.obtenerPorId(id);
		model.addAttribute("titulo","Modifica Arancel");
		model.addAttribute("arancel",arancel);
		return "arancelEditar";
	}

	@GetMapping("/eliminarPorId/{id}")
	public String eliminarPorId(Model model, @PathVariable Long id) {
		arancelService.eliminarArancel(id);
		return "redirect:/arancel/listar";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		ArancelEntity arancel = new ArancelEntity();
		model.addAttribute("titulo","Nuevo Arancel");
		model.addAttribute("arancel",arancel);
		return "arancelEditar";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute ArancelEntity arancelEntity){
		arancelService.guardarArancel(arancelEntity);
		return "redirect:/arancel/listar";
	}
}