package br.ufg.inf.backend.StpDourados.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public DocumentoTransferencia getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoTransferencia documento) {
        this.documento = documento;
    }

    public List<Especialidade> getEspecialidadesRequisitadas() {
        return especialidadesRequisitadas;
    }

    public void setEspecialidadesRequisitadas(List<Especialidade> especialidadesRequisitadas) {
        this.especialidadesRequisitadas = especialidadesRequisitadas;
    }

    public Date getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    public void setHorarioSolicitacao(Date horarioSolicitacao) {
        this.horarioSolicitacao = horarioSolicitacao;
    }
}
