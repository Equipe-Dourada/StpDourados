package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
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

}
