package org.bedu.postwork1.reactive;

import org.bedu.postwork1.model.Curso;
import org.bedu.postwork1.model.Estudiante;
import org.bedu.postwork1.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class CalcularPromedioCursoRxTest {

    private static final Curso CURSO = new Curso();

    static {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombreCompleto("Rosa");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombreCompleto("Ramon");

        Estudiante estudiante3 = new Estudiante();
        estudiante3.setNombreCompleto("Pedro");

        Materia materia = new Materia();
        materia.setNombre("Materia");

        CURSO.setCiclo("2023");
        CURSO.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante1, 6);
        calificaciones.put(estudiante2, 4);
        calificaciones.put(estudiante3, 9);

        CURSO.setCalificaciones(calificaciones);
    }

    @Test
    @DisplayName("Postwork 5")
    void calculaPromedio(){
        CalcularPromedioCursoRx sut = new CalcularPromedioCursoRx();

        sut.calcularPromedio(CURSO)
                .subscribe(v -> assertThat(v).isEqualTo(6.33, within(0.1)));

    }
}
