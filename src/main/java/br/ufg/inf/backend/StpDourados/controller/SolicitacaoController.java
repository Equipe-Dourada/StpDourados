package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;
import br.ufg.inf.backend.StpDourados.service.SolicitacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

	private final SolicitacaoService service;

	@GetMapping
	public java.util.List<Solicitacao> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Solicitacao obter(@PathVariable Long id) {
		return service.obter(id);
	}

	@PostMapping
	public Solicitacao adicionar(@RequestBody Solicitacao solicitacao) {
		return service.salvar(solicitacao);
	}

	@PutMapping("/{id}")
	public Solicitacao atualizar(@PathVariable Long id, @RequestBody Solicitacao solicitacao) {
		return service.salvar(id, solicitacao);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		service.remover(id);
	}
}
