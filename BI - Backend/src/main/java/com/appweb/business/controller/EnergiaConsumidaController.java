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

import com.appweb.business.model.EnergiaConsumida;
import com.appweb.business.service.EnergiaConsumidaService;

@RestController
@RequestMapping("/energiaconsumida")
@CrossOrigin(origins = "http://localhost:5173")
public class EnergiaConsumidaController {

    final EnergiaConsumidaService servicio;

    public EnergiaConsumidaController(EnergiaConsumidaService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public EnergiaConsumida insertar(@RequestBody EnergiaConsumida energia) {
        return servicio.insertarEnergiaConsumida(energia);
    }

    @GetMapping("/energia-especifica/{codigoConsumidor}")
    public ResponseEntity<Integer> obtenerEnergiaEspecifica(@PathVariable Integer codigoConsumidor) {
        int energiaEspecifica = servicio.obtenerEnergiaEspecifica(codigoConsumidor);
        return ResponseEntity.ok(energiaEspecifica);
    }

    @GetMapping("/suma-energia")
    public ResponseEntity<Integer> obtenerSumaEnergiaConsumida() {
        int sumaEnergia = servicio.obtenerSumaEnergiaConsumida();
        return ResponseEntity.ok(sumaEnergia);
    }

    @GetMapping("/consultar/{codigoConsumidor}")
    public List<EnergiaConsumida> consultar(@PathVariable Integer codigoConsumidor) {
        return servicio.buscarEnergiaPorCodigo(codigoConsumidor);
    }

    @PutMapping("/actualizar/{codigoConsumidor}")
    public ResponseEntity<EnergiaConsumida> actualizar(@PathVariable Integer codigoConsumidor,
            @RequestBody EnergiaConsumida energia) {
        EnergiaConsumida energiaActualizada = servicio.actualizarEnergiaConsumida(codigoConsumidor, energia);
        return ResponseEntity.ok(energiaActualizada);
    }

    @DeleteMapping("/eliminar/{codigoConsumidor}")
    public ResponseEntity<String> eliminar(Integer codigoConsumidor) {
        servicio.eliminarEnergiaConsumida(codigoConsumidor);
        return ResponseEntity.ok("Energia consumida eliminada con exito!");
    }

}
