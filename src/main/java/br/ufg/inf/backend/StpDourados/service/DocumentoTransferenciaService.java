package br.ufg.inf.backend.StpDourados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.DocumentoTransferencia;
import br.ufg.inf.backend.StpDourados.repository.DocumentoTransferenciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoTransferenciaService {

    @Autowired
    private DocumentoTransferenciaRepository documentoTransferenciaRepository;

    public List<DocumentoTransferencia> findAll() {
        return documentoTransferenciaRepository.findAll();
    }

    public Optional<DocumentoTransferencia> findById(Long id) {
        return documentoTransferenciaRepository.findById(id);
    }

    public DocumentoTransferencia save(DocumentoTransferencia documentoTransferencia) {
        return documentoTransferenciaRepository.save(documentoTransferencia);
    }

    public void deleteById(Long id) {
        documentoTransferenciaRepository.deleteById(id);
    }
}
