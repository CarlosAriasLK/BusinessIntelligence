package com.appweb.business.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.business.model.ProductorConsumidor;
import com.appweb.business.service.ProductorConsumidorService;

@RestController
@RequestMapping("/productorconsumidor")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductorConsumidorController {

    final ProductorConsumidorService servicio;

    public ProductorConsumidorController(ProductorConsumidorService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ProductorConsumidor insertar( @RequestBody ProductorConsumidor proCon ) {
        return servicio.insertarProductorConsumidor(proCon);
    }

    @GetMapping("consultar/{id}")
    public List<ProductorConsumidor> consultar( @PathVariable Integer id ) {
        return servicio.buscarPorId(id);
    }

}
