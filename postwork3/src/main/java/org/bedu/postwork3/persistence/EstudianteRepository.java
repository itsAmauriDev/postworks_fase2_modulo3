package org.bedu.postwork3.persistence;

import org.bedu.postwork3.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
