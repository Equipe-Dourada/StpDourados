package br.ufg.inf.backend.StpDourados.repository;

import br.ufg.inf.backend.StpDourados.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
