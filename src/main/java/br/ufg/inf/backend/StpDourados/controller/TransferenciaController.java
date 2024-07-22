package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Transferencia;
import br.ufg.inf.backend.StpDourados.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService service;

	@GetMapping
	public ResponseEntity<List<Transferencia>> findAll() {
		List<Transferencia> transferencias = service.findAll();
		return ResponseEntity.ok(transferencias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transferencia> findById(@PathVariable Long id) {
		Optional<Transferencia> transferencia = service.findById(id);
		return transferencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Transferencia> create(@RequestBody Transferencia transferencia) {
		Transferencia savedTransferencia = service.save(transferencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTransferencia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Transferencia> update(@PathVariable Long id, @RequestBody Transferencia transferencia) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		transferencia.setId(id);
		Transferencia updatedTransferencia = service.save(transferencia);
		return ResponseEntity.ok(updatedTransferencia);
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
