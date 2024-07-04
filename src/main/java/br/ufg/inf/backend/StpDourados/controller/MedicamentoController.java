package br.ufg.inf.backend.StpDourados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufg.inf.backend.StpDourados.model.Medicamento;
import br.ufg.inf.backend.StpDourados.repository.MedicamentoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        return medicamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoDetails) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);

        if (optionalMedicamento.isPresent()) {
            Medicamento medicamento = optionalMedicamento.get();
            medicamento.setNome(medicamentoDetails.getNome());
            medicamento.setPrincipioAtivo(medicamentoDetails.getPrincipioAtivo());
            medicamento.setDescricao(medicamentoDetails.getDescricao());

            Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);
            return ResponseEntity.ok(updatedMedicamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);

        if (optionalMedicamento.isPresent()) {
            medicamentoRepository.delete(optionalMedicamento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
