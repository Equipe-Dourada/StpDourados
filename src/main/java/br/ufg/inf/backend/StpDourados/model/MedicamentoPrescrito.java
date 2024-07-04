package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicamentoPrescrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medicamento medicamento;
    private String posologia;
    private Double dosagem;
    private String unidadeDosagem;
    private String viaAdministracao;

    public MedicamentoPrescrito() {}

    public MedicamentoPrescrito(Medicamento medicamento, String posologia, Double dosagem, String unidadeDosagem, String viaAdministracao) {
        this.medicamento = medicamento;
        this.posologia = posologia;
        this.dosagem = dosagem;
        this.unidadeDosagem = unidadeDosagem;
        this.viaAdministracao = viaAdministracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Double getDosagem() {
        return dosagem;
    }

    public void setDosagem(Double dosagem) {
        this.dosagem = dosagem;
    }

    public String getUnidadeDosagem() {
        return unidadeDosagem;
    }

    public void setUnidadeDosagem(String unidadeDosagem) {
        this.unidadeDosagem = unidadeDosagem;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }
}
