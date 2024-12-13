package com.appweb.business.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.business.model.Consumidor;
import com.appweb.business.service.ConsumidorService;

@RestController
@RequestMapping("/consumidor")
@CrossOrigin(origins = "http://localhost:5173")
public class ConsumidorController {

    private final ConsumidorService servicio;

    public ConsumidorController(ConsumidorService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Consumidor insertar(@RequestBody Consumidor consumidor) {
        return servicio.insertarConsumidor(consumidor);
    }

    @GetMapping
    public List<Consumidor> listarConsumidor() {
        return servicio.listarConsumidores();
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarConsumidores() {
        long totalConsumidores = servicio.contarConsumidores();
        return ResponseEntity.ok(totalConsumidores);
    }

    @GetMapping("/consultar/{codigoConsumidor}")
    public List<Consumidor> consultar(@PathVariable Integer codigoConsumidor) {
        return servicio.consultarConsumidores(codigoConsumidor);
    }

    @PutMapping("/actualizar/{codigoConsumidor}")
    public ResponseEntity<Consumidor> actualizar(@PathVariable Integer codigoConsumidor, @RequestBody Consumidor consumidor) {
        Consumidor consumidorActualizado = servicio.actualizarConsumidor(codigoConsumidor, consumidor);
        return ResponseEntity.ok(consumidorActualizado);
    }

    @DeleteMapping("/eliminar/{codigoConsumidor}")
    public ResponseEntity<String> eliminar(@PathVariable Integer codigoConsumidor) {
        servicio.eliminarConsumidor(codigoConsumidor);
        return ResponseEntity.ok("Consumidor eliminado con exito!");
    }

}
