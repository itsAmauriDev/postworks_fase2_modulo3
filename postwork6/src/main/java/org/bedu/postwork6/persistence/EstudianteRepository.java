package org.bedu.postwork6.persistence;

import org.bedu.postwork6.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
