package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.MedicamentoPrescrito;
import br.ufg.inf.backend.StpDourados.service.EnderecoService;
import br.ufg.inf.backend.StpDourados.service.MedicamentoPrescritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentosPrescritos")
public class MedicamentoPrescritoController {

	@Autowired
	private MedicamentoPrescritoService service;

	@GetMapping
	public ResponseEntity<List<MedicamentoPrescrito>> findAll() {
		List<MedicamentoPrescrito> medicamentosPrescritos = service.findAll();
		return ResponseEntity.ok(medicamentosPrescritos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicamentoPrescrito> findById(@PathVariable Long id) {
		Optional<MedicamentoPrescrito> medicamentoPrescrito = service.findById(id);
		return medicamentoPrescrito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<MedicamentoPrescrito> create(@RequestBody MedicamentoPrescrito medicamentoPrescrito) {
		MedicamentoPrescrito savedMedicamentoPrescrito = service.save(medicamentoPrescrito);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicamentoPrescrito);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MedicamentoPrescrito> update(@PathVariable Long id, @RequestBody MedicamentoPrescrito medicamentoPrescrito) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		medicamentoPrescrito.setId(id);
		MedicamentoPrescrito updatedMedicamentoPrescrito = service.save(medicamentoPrescrito);
		return ResponseEntity.ok(updatedMedicamentoPrescrito);
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
