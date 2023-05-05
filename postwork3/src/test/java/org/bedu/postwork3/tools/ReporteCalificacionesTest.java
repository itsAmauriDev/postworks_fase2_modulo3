package org.bedu.postwork3.tools;

import org.assertj.core.api.Assertions;

import org.bedu.postwork3.model.Curso;
import org.bedu.postwork3.model.Estudiante;
import org.bedu.postwork3.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ReporteCalificacionesTest {

    private static final Materia MATERIA = new Materia();
    private static final Estudiante ESTUDIANTE_UNO = new Estudiante();
    private static final Estudiante ESTUDIANTE_DOS = new Estudiante();
    private static final Estudiante ESTUDIANTE_TRES = new Estudiante();
    private static final Curso CURSO = new Curso();

    private static ReporteCalificaciones.Reporte reporte1;
    private static ReporteCalificaciones.Reporte reporte2;
    private static ReporteCalificaciones.Reporte reporte3;

    static{
        MATERIA.setNombre("POO");

        ESTUDIANTE_UNO.setNombreCompleto("ccc");
        ESTUDIANTE_DOS.setNombreCompleto("bbb");
        ESTUDIANTE_TRES.setNombreCompleto("aaa");

        CURSO.setCiclo("2030");
        CURSO.setMateria(MATERIA);

        Map<Estudiante,Integer> calificaciones = new HashMap<>();
        calificaciones.put(ESTUDIANTE_UNO, 8);
        calificaciones.put(ESTUDIANTE_DOS, 5);
        calificaciones.put(ESTUDIANTE_TRES, 10);

        CURSO.setCalificaciones(calificaciones);

        reporte1 = new ReporteCalificaciones.Reporte("ccc", 8);
        reporte2 = new ReporteCalificaciones.Reporte("bbb", 5);
        reporte3 = new ReporteCalificaciones.Reporte("aaa", 10);


    }

    @Test
    @DisplayName("Ordenado alfabéticamente")
    void alfabetico(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.alfabetico(CURSO)).containsExactly(reporte3, reporte2, reporte1);
    }


    @Test
    @DisplayName("Ordenado por calificaciones")
    void calificaciones(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.calificacion(CURSO)).containsExactly(reporte3, reporte1, reporte2);
    }

}