package br.ufg.inf.backend.StpDourados.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DocumentoTransferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicamentoPrescrito> drogasAdministradas;
    @ElementCollection
    private List<String> procedimentosAcondicionamento;
    @ElementCollection
    private List<String> procedimentosRecebimento;

    public DocumentoTransferencia() {}

    public DocumentoTransferencia(List<MedicamentoPrescrito> drogasAdministradas, List<String> procedimentosAcondicionamento, List<String> procedimentosRecebimento) {
        this.drogasAdministradas = drogasAdministradas;
        this.procedimentosAcondicionamento = procedimentosAcondicionamento;
        this.procedimentosRecebimento = procedimentosRecebimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MedicamentoPrescrito> getDrogasAdministradas() {
        return drogasAdministradas;
    }

    public void setDrogasAdministradas(List<MedicamentoPrescrito> drogasAdministradas) {
        this.drogasAdministradas = drogasAdministradas;
    }

    public List<String> getProcedimentosAcondicionamento() {
        return procedimentosAcondicionamento;
    }

    public void setProcedimentosAcondicionamento(List<String> procedimentosAcondicionamento) {
        this.procedimentosAcondicionamento = procedimentosAcondicionamento;
    }

    public List<String> getProcedimentosRecebimento() {
        return procedimentosRecebimento;
    }

    public void setProcedimentosRecebimento(List<String> procedimentosRecebimento) {
        this.procedimentosRecebimento = procedimentosRecebimento;
    }
}
