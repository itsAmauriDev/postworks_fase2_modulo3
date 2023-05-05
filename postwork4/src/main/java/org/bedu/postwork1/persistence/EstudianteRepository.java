package org.bedu.postwork1.persistence;

import org.bedu.postwork1.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
