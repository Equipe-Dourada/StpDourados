package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Especialidade;
import br.ufg.inf.backend.StpDourados.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeService service;

	@GetMapping
	public ResponseEntity<List<Especialidade>> findAll() {
		List<Especialidade> especialidades = service.findAll();
		return ResponseEntity.ok(especialidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Especialidade> findById(@PathVariable Long id) {
		Optional<Especialidade> especialidade = service.findById(id);
		return especialidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Especialidade> create(@RequestBody Especialidade especialidade) {
		Especialidade savedEspecialidade = service.save(especialidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEspecialidade);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Especialidade> update(@PathVariable Long id, @RequestBody Especialidade especialidade) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		especialidade.setId(id);
		Especialidade updatedEspecialidade = service.save(especialidade);
		return ResponseEntity.ok(updatedEspecialidade);
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
