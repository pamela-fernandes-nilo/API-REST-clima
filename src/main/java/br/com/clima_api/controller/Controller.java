package br.com.clima_api.controller;
import br.com.clima_api.service.ClimaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

    private final ClimaService service;

    public Controller(ClimaService service) {
        this.service = service;
    }

    @GetMapping("/clima")
    public String getClimaBH() {
        return service.getClimaBH();
    }
}