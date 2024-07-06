package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Paciente;
import br.ufg.inf.backend.StpDourados.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping
	public List<Paciente> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Paciente obter(@PathVariable(value = "id") Long pacienteId) { return service.obter(pacienteId);	}

	@PostMapping
	public Paciente adicionar(@RequestBody Paciente paciente) { return service.salvar(paciente); }

	@PutMapping("/{id}")
	public Paciente atualizar(@PathVariable(value = "id") Long pacienteId, @RequestBody Paciente paciente) {
		return service.salvar(pacienteId, paciente);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable(value = "id") Long pacienteId) { service.remover(pacienteId); }
}
