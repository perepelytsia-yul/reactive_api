package com.reactive.reactiveapi.controller;

import com.reactive.reactiveapi.model.Panda;
import com.reactive.reactiveapi.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/panda")
public class PandaController {

    @Autowired
    private PandaService pandaService;

    @GetMapping("/")
    public List<Panda> panda() {
        return pandaService.getPandas();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Panda> pandaFlux() {
        return pandaService.getPandasFlux();
    }
}
