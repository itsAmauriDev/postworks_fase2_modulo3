package org.bedu.postwork3.multithreading;

import org.bedu.postwork3.model.Curso;
import org.bedu.postwork3.model.Estudiante;
import org.bedu.postwork3.model.Materia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Postwork2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        Curso[] cursos = new Curso[]{
                crearCurso(rnd, "Programación orientada a objetos", 1),
                crearCurso(rnd, "Estructura de datos", 2),
                crearCurso(rnd, "Programación funcional", 3),
                crearCurso(rnd, "programacion reactiva", 4),
                crearCurso(rnd, "Bases de datos", 5)
        };
        for(Curso curso : cursos){
            pool.execute(new CalculadoraPromedioCurso(curso));
        }
        pool.shutdown();
    }

    private static Curso crearCurso(Random rnd, String nombre_materia, long idCurso) {
        Curso curso1 = new Curso();
        curso1.setId(idCurso);
        Materia materia1 = new Materia();
        materia1.setNombre(nombre_materia);
        curso1.setMateria(materia1);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long)i);
            estudiante.setNombreCompleto("Estudiante " + i);
            calificaciones.put(estudiante, rnd.nextInt(10));
        }

        curso1.setCalificaciones(calificaciones);
        return curso1;
    }
}

