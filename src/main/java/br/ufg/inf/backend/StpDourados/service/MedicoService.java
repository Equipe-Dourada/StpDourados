package br.ufg.inf.backend.StpDourados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Medico;
import br.ufg.inf.backend.StpDourados.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }
}