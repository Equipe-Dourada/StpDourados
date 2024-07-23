package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.DocumentoTransferencia;
import br.ufg.inf.backend.StpDourados.service.DocumentoTransferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/documentoTransferencia")
public class DocumentoTransferenciaController {

    private final DocumentoTransferenciaService service;

    @GetMapping
    public java.util.List<DocumentoTransferencia> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DocumentoTransferencia obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    public DocumentoTransferencia adicionar(@RequestBody DocumentoTransferencia documentoTransferencia) {
        return service.salvar(documentoTransferencia);
    }

    @PutMapping("/{id}")
    public DocumentoTransferencia atualizar(
            @PathVariable Long id, @RequestBody DocumentoTransferencia documentoTransferencia) {

        return service.salvar(id, documentoTransferencia);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
