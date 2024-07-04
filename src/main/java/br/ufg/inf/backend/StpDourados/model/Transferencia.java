package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meioTransporte;
    @ManyToOne
    private UnidadeHospitalar destino;
    @ManyToOne
    private Medico medicoDestino;
    @ManyToOne
    private UnidadeHospitalar origem;
    @ManyToOne
    private Medico medicoOrigem;
    @ManyToOne
    private Medico medicoRegulador;
    private Date horarioSaida;
    private Date horarioPrevistoChegada;
    private Double distancia;
    @ManyToOne
    private DocumentoTransferencia documento;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Solicitacao solicitacao;

    public Transferencia() {}

    public Transferencia(String meioTransporte, UnidadeHospitalar destino, Medico medicoDestino, UnidadeHospitalar origem, Medico medicoOrigem, Medico medicoRegulador, Date horarioSaida, Date horarioPrevistoChegada, Double distancia, DocumentoTransferencia documento, Paciente paciente, Solicitacao solicitacao) {
        this.meioTransporte = meioTransporte;
        this.destino = destino;
        this.medicoDestino = medicoDestino;
        this.origem = origem;
        this.medicoOrigem = medicoOrigem;
        this.medicoRegulador = medicoRegulador;
        this.horarioSaida = horarioSaida;
        this.horarioPrevistoChegada = horarioPrevistoChegada;
        this.distancia = distancia;
        this.documento = documento;
        this.paciente = paciente;
        this.solicitacao = solicitacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public UnidadeHospitalar getDestino() {
        return destino;
    }

    public void setDestino(UnidadeHospitalar destino) {
        this.destino = destino;
    }

    public Medico getMedicoDestino() {
        return medicoDestino;
    }

    public void setMedicoDestino(Medico medicoDestino) {
        this.medicoDestino = medicoDestino;
    }

    public UnidadeHospitalar getOrigem() {
        return origem;
    }

    public void setOrigem(UnidadeHospitalar origem) {
        this.origem = origem;
    }

    public Medico getMedicoOrigem() {
        return medicoOrigem;
    }

    public void setMedicoOrigem(Medico medicoOrigem) {
        this.medicoOrigem = medicoOrigem;
    }

    public Medico getMedicoRegulador() {
        return medicoRegulador;
    }

    public void setMedicoRegulador(Medico medicoRegulador) {
        this.medicoRegulador = medicoRegulador;
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Date getHorarioPrevistoChegada() {
        return horarioPrevistoChegada;
    }

    public void setHorarioPrevistoChegada(Date horarioPrevistoChegada) {
        this.horarioPrevistoChegada = horarioPrevistoChegada;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public DocumentoTransferencia getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoTransferencia documento) {
        this.documento = documento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
}
