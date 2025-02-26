package com.example.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api") // Ruta base
@Slf4j
public class controller {

    private final service service;

    public controller(service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        log.info("estoy saludando");
        log.info("estoy saludando");
        log.info("estoy saludando");
        return "Espero que esta si sea la maldita prueba casi finalllllll";
    }

    @PostMapping("/save")
    public Map<String, String> postMethodName(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        try {
            String name = request.get("name");
            service.saveName(name);
            response.put("message", "Nombre guardado " + name);
            log.info("GUARDADOOO"+name);
        } catch (Exception e) {
            response.put("error", "Error al guardar el nombre: " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/getNames")
    public List<String> getNames() {
        log.info("obtener nombres"+service.getAllNames());
        log.info("obtener nombres"+service.getAllNames());
        return service.getAllNames();
    }

}