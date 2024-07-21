package br.ufg.inf.backend.StpDourados.model;


import jakarta.persistence.Entity;

@lombok.Getter
@lombok.Setter
@Entity
public class Paciente {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private java.util.Date dataNascimento;
    @jakarta.persistence.OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Endereco endereco;
    private String telefone;
    private String email;
    private String contatoEmergencia;
}
