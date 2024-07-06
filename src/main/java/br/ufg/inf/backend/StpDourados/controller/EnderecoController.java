package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentoTransferencia")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	/*

	@GetMapping
	public List<Endereco> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Endereco obter(@PathParam(value = "id") Long documentoTransferenciaId) {
		return service.obter(documentoTransferenciaId);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathParam(value = "id") Long documentoTransferenciaId) {
		service.remover(documentoTransferenciaId);
	}

	@PostMapping
	public Endereco adicionar(@RequestBody Endereco documentoTransferencia) {
		return service.salvar(documentoTransferencia);
	}

	@PutMapping("/{id}")
	public Endereco atualizar(@PathParam(value = "id") Long documentoTransferenciaId, @RequestBody Endereco documentoTransferencia) {
		return service.salvar(documentoTransferenciaId, documentoTransferencia);
	}
	 */
}