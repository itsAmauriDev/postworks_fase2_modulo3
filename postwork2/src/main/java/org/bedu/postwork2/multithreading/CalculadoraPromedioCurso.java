package org.bedu.postwork2.multithreading;

import org.bedu.postwork2.model.Curso;

public class CalculadoraPromedioCurso implements Runnable {

    private Curso curso;
    private double promedio;

    public CalculadoraPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        int numAlumnos = 0;
        for(Integer i : curso.getCalificaciones().values()){
            promedio += i;
            numAlumnos++;
        }
        promedio /= numAlumnos;

        System.out.println("Promedio del curso: " + curso.getId() + " " + curso.getMateria().getNombre() + " = " + promedio);
    }
}
