package org.bedu.postwork1.tools;

import org.bedu.postwork1.model.Curso;
import org.bedu.postwork1.model.Estudiante;
import org.bedu.postwork1.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ReporteCalificacionesTest {
    private static final Materia MATERIA = new Materia();
    private static final Estudiante ESTUDIANTE_1 = new Estudiante();
    private static final Estudiante ESTUDIANTE_2 = new Estudiante();
    private static final Estudiante ESTUDIANTE_3 = new Estudiante();
    private static final Curso CURSO = new Curso();

    private static ReporteCalificaciones.Reporte reporte1;
    private static ReporteCalificaciones.Reporte reporte2;
    private static ReporteCalificaciones.Reporte reporte3;

    static{
        MATERIA.setNombre("Matemáticas");

        ESTUDIANTE_1.setNombreCompleto("Rosa");
        ESTUDIANTE_2.setNombreCompleto("Ramon");
        ESTUDIANTE_3.setNombreCompleto("Pedro");

        CURSO.setCiclo("2020");
        CURSO.setMateria(MATERIA);

        Map<Estudiante,Integer> calificaciones = new HashMap<>();
        calificaciones.put(ESTUDIANTE_1, 6);
        calificaciones.put(ESTUDIANTE_2, 4);
        calificaciones.put(ESTUDIANTE_3, 9);


        CURSO.setCalificaciones(calificaciones);

        reporte1 = new ReporteCalificaciones.Reporte("Rosa", 6);
        reporte2 = new ReporteCalificaciones.Reporte("Ramon", 4);
        reporte3 = new ReporteCalificaciones.Reporte("Pedro", 9);


    }

    @Test
    @DisplayName("Ordena alfabéticamente")
    void alfabetico(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.alfabetico(CURSO)).containsExactly(reporte3, reporte2, reporte1);
    }


    @Test
    @DisplayName("Ordena por calificaciones")
    void calificaciones(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.calificacion(CURSO)).containsExactly(reporte3, reporte1, reporte2);
    }
}
