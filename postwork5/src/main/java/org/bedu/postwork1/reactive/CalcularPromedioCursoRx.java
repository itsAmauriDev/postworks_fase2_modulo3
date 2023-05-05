package org.bedu.postwork1.reactive;

import java.util.stream.Collectors;

import org.bedu.postwork1.model.Curso;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class CalcularPromedioCursoRx {

    public Mono<Double> calcularPromedio(Curso curso){

        return Flux.fromStream(curso.getCalificaciones().values().parallelStream())
                .collect(Collectors.averagingDouble(i -> (double) i));

    }

}
