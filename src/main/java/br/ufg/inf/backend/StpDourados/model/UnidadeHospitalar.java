package br.ufg.inf.backend.StpDourados.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UnidadeHospitalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private String dadosPessoal;
    private Double latitude;
    private Double longitude;
    private Integer disponibilidadeLeitos;
    private boolean temUTI;
    @ManyToMany
    private List<Especialidade> especialidades;

    public UnidadeHospitalar() {}

    public UnidadeHospitalar(String telefone, String email, Endereco endereco, String dadosPessoal, Double latitude, Double longitude, Integer disponibilidadeLeitos, boolean temUTI, List<Especialidade> especialidades) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dadosPessoal = dadosPessoal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.disponibilidadeLeitos = disponibilidadeLeitos;
        this.temUTI = temUTI;
        this.especialidades = especialidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDadosPessoal() {
        return dadosPessoal;
    }

    public void setDadosPessoal(String dadosPessoal) {
        this.dadosPessoal = dadosPessoal;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getDisponibilidadeLeitos() {
        return disponibilidadeLeitos;
    }

    public void setDisponibilidadeLeitos(Integer disponibilidadeLeitos) {
        this.disponibilidadeLeitos = disponibilidadeLeitos;
    }

    public boolean isTemUTI() {
        return temUTI;
    }

    public void setTemUTI(boolean temUTI) {
        this.temUTI = temUTI;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}
