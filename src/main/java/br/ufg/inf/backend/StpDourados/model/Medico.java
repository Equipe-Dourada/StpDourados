package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UnidadeHospitalar getUnidadeHospitalar() {
        return unidadeHospitalar;
    }

    public void setUnidadeHospitalar(UnidadeHospitalar unidadeHospitalar) {
        this.unidadeHospitalar = unidadeHospitalar;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
