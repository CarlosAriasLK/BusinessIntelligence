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

import com.appweb.business.model.Productor;
import com.appweb.business.service.ProductorService;


@RestController
@RequestMapping("/productor")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductorController {

    final ProductorService servicio;

    public ProductorController(ProductorService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Productor insertar( @RequestBody Productor productor ) {
        return servicio.insertarProductor( productor );
    }

    @GetMapping
    public List<Productor> listar () {
        return servicio.listarProductores();
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarConsumidores() {
        long totalConsumidores = servicio.contarProductores();
        return ResponseEntity.ok(totalConsumidores);
    }

    @GetMapping("/consultar/{codigoProductor}")
    public List<Productor> consultar( @PathVariable Integer codigoProductor ) {
        return servicio.consultarProductoresPorCodigo( codigoProductor );
    }

    @PutMapping("/actualizar/{codigoProductor}")
    public ResponseEntity<Productor> actualizar( @PathVariable Integer codigoProductor, @RequestBody Productor productor ) {
        Productor productorActualizado = servicio.actualizarProductor(codigoProductor, productor);
        return ResponseEntity.ok(productorActualizado);
    }

    @DeleteMapping("/eliminar/{codigoProductor}")
    public ResponseEntity<String> eliminar( @PathVariable Integer codigoProductor ) {
        servicio.eliminarProductor(codigoProductor);
        return ResponseEntity.ok("Productor eliminado correctamente");
    }
 
}
