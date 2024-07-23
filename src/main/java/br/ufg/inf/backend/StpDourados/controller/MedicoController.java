package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Medico;
import br.ufg.inf.backend.StpDourados.service.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

	private final MedicoService service;

	@GetMapping
	public java.util.List<Medico> listar() {
		return service.listar();
	}

	@GetMapping("/{crm}")
	public Medico obter(@PathVariable String crm) {
		return service.obter(crm);
	}

	@PostMapping
	public Medico adicionar(@RequestBody Medico medico) {
		return service.salvar(medico);
	}

	@PutMapping("/{crm}")
	public Medico atualizar(@PathVariable String crm, @RequestBody Medico medico) {
		return service.salvar(crm, medico);
	}

	@DeleteMapping("/{crm}")
	public void remover(@PathVariable String crm) {
		service.remover(crm);
	}
}