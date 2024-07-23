package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Prontuario;
import br.ufg.inf.backend.StpDourados.service.ProntuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    @GetMapping
    public java.util.List<Prontuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Prontuario obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    public Prontuario adicionar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return service.salvar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
