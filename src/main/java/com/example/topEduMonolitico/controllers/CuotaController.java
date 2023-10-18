package com.example.topEduMonolitico.controllers;

import com.example.topEduMonolitico.entities.ArancelEntity;
import com.example.topEduMonolitico.entities.CuotaEntity;
import com.example.topEduMonolitico.entities.EstudianteEntity;
import com.example.topEduMonolitico.services.ArancelService;
import com.example.topEduMonolitico.services.CuotaService;
import com.example.topEduMonolitico.services.EstudianteService;
import com.example.topEduMonolitico.services.TipoColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cuota")
public class CuotaController {
    @Autowired
	CuotaService cuotaService;

	@Autowired
	EstudianteService estudianteService;

	@Autowired
	ArancelService arancelService;

	@Autowired
	TipoColegioService tipoColegioService;

	@GetMapping("/buscarPorIdEstudiante/{idEstudiante}")
	public String listar(Model model, @PathVariable Long idEstudiante) {
		ArrayList<CuotaEntity> cuotas = cuotaService.obtenerCuotasPorIdEstudiante(idEstudiante);
		EstudianteEntity estudiante = estudianteService.obtenerPorId(idEstudiante);
		model.addAttribute("titulo","Acreditacion de arancel");
		model.addAttribute("estudiante",estudiante);
		model.addAttribute("cuotas",cuotas);
		return "cuota";
	}

	@GetMapping("/editarPorId/{id}")
	public String editarPorId(Model model, @PathVariable Long id) {
		CuotaEntity cuota = cuotaService.obtenerPorId(id);
		ArrayList<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
		model.addAttribute("titulo","Modifica Cuota");
		model.addAttribute("estudiantes",estudiantes);
		model.addAttribute("cuota",cuota);
		return "cuotaEditar";
	}

	@GetMapping("/eliminarPorIdEstudiante/{idEstudiante}/anio/{anio}")
	public String eliminarPorId(Model model, @PathVariable Long idEstudiante, @PathVariable Short anio) {
		cuotaService.eliminarCuota(idEstudiante,anio);
		return "redirect:/cuota/buscarPorIdEstudiante/" + idEstudiante;
	}

	@GetMapping("/crearPorIdEstudiante/{idEstudiante}")
	public String crear(Model model, @PathVariable Long idEstudiante) {
		CuotaEntity cuota = new CuotaEntity();
		EstudianteEntity estudiante = estudianteService.obtenerPorId(idEstudiante);
		ArrayList<Integer> cuotasMaximas = new ArrayList<>();
		for (int i = 1; i <= estudiante.getColegio().getTipoColegio().getMaximoCuotas(); i++) {
			cuotasMaximas.add(i);
		}
		cuota.setEstudiante(estudiante);
		ArrayList<ArancelEntity> aranceles = arancelService.obtenerAranceles();
		model.addAttribute("titulo","Acreditacion de arancel");
		model.addAttribute("cuotasMaximas",cuotasMaximas);
		model.addAttribute("aranceles",aranceles);
		model.addAttribute("cuota",cuota);
		return "cuotaCrear";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute CuotaEntity cuotaEntity){
		cuotaEntity.setArancel(arancelService.obtenerPorId(cuotaEntity.getArancel().getIdArancel()));
		cuotaService.generarCuotas(cuotaEntity,tipoColegioService.obtenerPorIdEstudiante(cuotaEntity.getEstudiante().getIdEstudiante()));
		return "redirect:/cuota/buscarPorIdEstudiante/" + cuotaEntity.getEstudiante().getIdEstudiante();
	}

}