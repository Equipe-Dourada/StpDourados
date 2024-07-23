package br.ufg.inf.backend.StpDourados.controller;

import br.ufg.inf.backend.StpDourados.model.Paciente;
import br.ufg.inf.backend.StpDourados.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    @GetMapping
    public java.util.List<Paciente> listar() {
        return service.listar();
    }

    @GetMapping("/{cpf}")
    public Paciente obter(@PathVariable String cpf) {
        return service.obter(cpf);
    }

    @PostMapping
    public Paciente adicionar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }

    @PutMapping("/{cpf}")
    public Paciente atualizar(@PathVariable String cpf, @RequestBody Paciente paciente) {
        return service.salvar(cpf, paciente);
    }

    @DeleteMapping("/{cpf}")
    public void remover(@PathVariable String cpf) {
        service.remover(cpf);
    }
}
