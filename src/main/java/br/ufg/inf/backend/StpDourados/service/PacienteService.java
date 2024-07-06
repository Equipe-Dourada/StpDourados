package br.ufg.inf.backend.StpDourados.service;

import java.util.List;

import br.ufg.inf.backend.StpDourados.excecao.ResourceNotFoundException;
import br.ufg.inf.backend.StpDourados.model.Paciente;
import br.ufg.inf.backend.StpDourados.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listar() { return repository.findAll(); }

    public Paciente obter(Long id) { return repository.findById(id).orElse(null); }

    public Paciente salvar(Paciente paciente) { return repository.save(paciente); }

    public Paciente salvar(Long id, Paciente paciente) {
        Paciente pacienteExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado: " + id));

        pacienteExistente.setNome(paciente.getNome());
        pacienteExistente.setCpf(paciente.getCpf());
        pacienteExistente.setDataNascimento(paciente.getDataNascimento());
        pacienteExistente.setEndereco(paciente.getEndereco());
        pacienteExistente.setTelefone(paciente.getTelefone());
        pacienteExistente.setEmail(paciente.getEmail());
        pacienteExistente.setContatoEmergencia(paciente.getContatoEmergencia());

        return salvar(pacienteExistente);
    }

    public void remover(Long id) { repository.deleteById(id); }
}
