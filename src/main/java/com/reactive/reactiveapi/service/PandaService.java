package com.reactive.reactiveapi.service;

import com.reactive.reactiveapi.model.Panda;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class PandaService {
    public List<Panda> getPandas() {
        Long start = System.currentTimeMillis();

        List<Panda> pandaList = new ArrayList<Panda>();
        for(int i=1; i<=20; i++) {
            pandaList.add(new Panda(i, "panda "+i));
            System.out.println("Panda record: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Long end = System.currentTimeMillis();
        System.out.println("Total time taken by my API: " + (end - start));
        return pandaList;
    }

    public Flux<Panda> getPandasFlux() {
        Long start = System.currentTimeMillis();

        Flux pandaFlux = Flux.range(1,20)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Panda record by stream: " + i))
                .map(i -> new Panda(i, "student" + i));

        Long end = System.currentTimeMillis();
        System.out.println("Total time taken by my API: " + (end - start));

        return pandaFlux;
    }
}
