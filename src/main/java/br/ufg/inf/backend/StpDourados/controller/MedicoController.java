package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Medico;
import br.ufg.inf.backend.StpDourados.service.EnderecoService;
import br.ufg.inf.backend.StpDourados.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;

	@GetMapping
	public ResponseEntity<List<Medico>> findAll() {
		List<Medico> medicos = service.findAll();
		return ResponseEntity.ok(medicos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Long id) {
		Optional<Medico> medico = service.findById(id);
		return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Medico> create(@RequestBody Medico medico) {
		Medico savedMedico = service.save(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMedico);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody Medico medico) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		medico.setId(id);
		Medico updatedMedico = service.save(medico);
		return ResponseEntity.ok(updatedMedico);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}