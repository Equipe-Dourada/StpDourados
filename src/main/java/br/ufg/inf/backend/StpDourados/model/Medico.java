package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private String nome;
    private String telefone;
    @ManyToOne
    private UnidadeHospitalar unidadeHospitalar;
    private String papel;
    @ManyToOne
    private Especialidade especialidade;

    public Medico() {}

    public Medico(String crm, String nome, String telefone, UnidadeHospitalar unidadeHospitalar, String papel, Especialidade especialidade) {
        this.crm = crm;
        this.nome = nome;
        this.telefone = telefone;
        this.unidadeHospitalar = unidadeHospitalar;
        this.papel = papel;
        this.especialidade = especialidade;
    }

}
