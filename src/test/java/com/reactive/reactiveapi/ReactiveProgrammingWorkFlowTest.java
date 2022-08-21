package com.reactive.reactiveapi;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveProgrammingWorkFlowTest {

    @Test
    public void monoTest() {
        Mono<?> justInt = Mono.just(1);
        justInt.then(Mono.error(new RuntimeException("Exception happened. Nonono")))
                .log()
                .subscribe(System.out::println);
    }

    @Test
    public void fluxTest() {
        Flux<?> flux = Flux.just(1,2,3,4);
        flux.concatWith(Flux.error(new RuntimeException("Exception happened. Nonono")))
                .log()
                .subscribe(System.out::println);
    }
}
