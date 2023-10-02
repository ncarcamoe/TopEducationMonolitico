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
@RequestMapping("/home")
public class HomeController {
    @Autowired
	ColegioService colegioService;

	@GetMapping("/index")
    public String index(){
		return "home";
	}

}