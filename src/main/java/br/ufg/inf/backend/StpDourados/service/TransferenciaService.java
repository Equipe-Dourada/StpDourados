package br.ufg.inf.backend.StpDourados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Transferencia;
import br.ufg.inf.backend.StpDourados.repository.TransferenciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }

    public Optional<Transferencia> findById(Long id) {
        return transferenciaRepository.findById(id);
    }

    public Transferencia save(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    public void deleteById(Long id) {
        transferenciaRepository.deleteById(id);
    }
}
