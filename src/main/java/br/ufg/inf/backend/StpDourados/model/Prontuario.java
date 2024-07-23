package br.ufg.inf.backend.StpDourados.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Classificacao classificacao;

    @OneToMany
    private java.util.List<MedicamentoPrescrito> medicamentosAtuais;

}
