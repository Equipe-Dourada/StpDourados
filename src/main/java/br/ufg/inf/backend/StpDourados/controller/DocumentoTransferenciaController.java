package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.DocumentoTransferencia;
import br.ufg.inf.backend.StpDourados.service.DocumentoTransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/documentoTransferencia")
public class DocumentoTransferenciaController {

	@Autowired
	private DocumentoTransferenciaService service;

	@GetMapping
	public ResponseEntity<List<DocumentoTransferencia>> findAll() {
		List<DocumentoTransferencia> documentos = service.findAll();
		return ResponseEntity.ok(documentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DocumentoTransferencia> findById(@PathVariable Long id) {
		Optional<DocumentoTransferencia> documento = service.findById(id);
		return documento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<DocumentoTransferencia> create(@RequestBody DocumentoTransferencia documentoTransferencia) {
		DocumentoTransferencia savedDocumento = service.save(documentoTransferencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDocumento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DocumentoTransferencia> update(@PathVariable Long id, @RequestBody DocumentoTransferencia documentoTransferencia) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		documentoTransferencia.setId(id);
		DocumentoTransferencia updatedDocumento = service.save(documentoTransferencia);
		return ResponseEntity.ok(updatedDocumento);
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
