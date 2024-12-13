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

import com.appweb.business.model.EnergiaProducida;
import com.appweb.business.service.EnergiaProducidaService;

@RestController
@RequestMapping("/energiaproducida")
@CrossOrigin(origins = "http://localhost:5173")
public class EnergiaProducidaController {


    final EnergiaProducidaService servicio;

    public EnergiaProducidaController(EnergiaProducidaService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public EnergiaProducida insertar( @RequestBody EnergiaProducida energia ) {
        return servicio.insertarEnergiaProducida( energia );
    }

    @GetMapping("/energia-especifica/{codigoProductor}")
    public ResponseEntity<Integer> obtenerEnergiaEspecifica(@PathVariable Integer codigoProductor) {
        int energiaEspecifica = servicio.obtenerEnergiaEspecifica(codigoProductor);
        return ResponseEntity.ok(energiaEspecifica);
    }

    @GetMapping("/suma-energia")
    public ResponseEntity<Integer> obtenerSumaEnergiaConsumida() {
        int sumaEnergia = servicio.obtenerSumaEnergiaConsumida();
        return ResponseEntity.ok(sumaEnergia);
    }

    @GetMapping("/consultar/{codigoProductor}")
    public List<EnergiaProducida> consultar( @PathVariable Integer codigoProductor ) {
        return servicio.buscarEnergiaPorCodigo( codigoProductor );
    } 


    @PutMapping("/actualizar/{codigoProductor}")
    public ResponseEntity<EnergiaProducida> actualizar( @PathVariable Integer codigoProductor, @RequestBody EnergiaProducida energia) {
        EnergiaProducida energiaActualizada = servicio.actualizarEnergiaProducida(codigoProductor, energia);
        return ResponseEntity.ok(energiaActualizada);
    }

    @DeleteMapping("/eliminar/{codigoProductor}")
    public ResponseEntity<String> eliminar( Integer codigoProductor ) {
        servicio.eliminarEnergiaProducida(codigoProductor);
        return ResponseEntity.ok("Energia producida eliminada con exito!");
    }


}
