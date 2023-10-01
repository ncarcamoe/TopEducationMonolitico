package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.TipoColegioEntity;
import com.example.topEduMonolitico.services.TipoColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/tipoColegio")
public class TipoColegioController {
    @Autowired
	TipoColegioService tipoColegioService;

    @GetMapping("/listar")
	public String listar(Model model) {
    	ArrayList<TipoColegioEntity>tipoColegios = tipoColegioService.obtenerTipoColegios();
    	model.addAttribute("tipoColegios",tipoColegios);
		return "tipocolegio";
		//return "OK";
	}

}