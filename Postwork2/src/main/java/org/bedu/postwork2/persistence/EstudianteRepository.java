package org.bedu.postwork2.persistence;

import org.bedu.postwork2.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
