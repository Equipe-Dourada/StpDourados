package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
@Entity
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;
    private String motivo;
    @ManyToOne
    private DocumentoTransferencia documento;
    @ManyToMany
    private List<Especialidade> especialidadesRequisitadas;
    private Date horarioSolicitacao;

    public Solicitacao() {}

    public Solicitacao(Medico medico, Paciente paciente, String motivo, DocumentoTransferencia documento, List<Especialidade> especialidadesRequisitadas, Date horarioSolicitacao) {
        this.medico = medico;
        this.paciente = paciente;
        this.motivo = motivo;
        this.documento = documento;
        this.especialidadesRequisitadas = especialidadesRequisitadas;
        this.horarioSolicitacao = horarioSolicitacao;
    }

}
