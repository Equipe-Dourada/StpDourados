package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;
import br.ufg.inf.backend.StpDourados.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService service;

	@GetMapping
	public ResponseEntity<List<Solicitacao>> findAll() {
		List<Solicitacao> solicitacoes = service.findAll();
		return ResponseEntity.ok(solicitacoes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Solicitacao> findById(@PathVariable Long id) {
		Optional<Solicitacao> solicitacao = service.findById(id);
		return solicitacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Solicitacao> create(@RequestBody Solicitacao solicitacao) {
		Solicitacao savedSolicitacao = service.save(solicitacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSolicitacao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Solicitacao> update(@PathVariable Long id, @RequestBody Solicitacao solicitacao) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		solicitacao.setId(id);
		Solicitacao updatedSolicitacao = service.save(solicitacao);
		return ResponseEntity.ok(updatedSolicitacao);
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