package br.ufg.inf.backend.StpDourados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.Solicitacao;
import br.ufg.inf.backend.StpDourados.repository.SolicitacaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public List<Solicitacao> findAll() {
        return solicitacaoRepository.findAll();
    }

    public Optional<Solicitacao> findById(Long id) {
        return solicitacaoRepository.findById(id);
    }

    public Solicitacao save(Solicitacao solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    public void deleteById(Long id) {
        solicitacaoRepository.deleteById(id);
    }
}
