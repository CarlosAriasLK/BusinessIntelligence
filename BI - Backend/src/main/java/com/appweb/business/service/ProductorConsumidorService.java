package com.appweb.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appweb.business.model.ProductorConsumidor;
import com.appweb.business.repository.ProductorConsumidorRepository;

@Service
public class ProductorConsumidorService {

    final ProductorConsumidorRepository repositorio;

    public ProductorConsumidorService(ProductorConsumidorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public ProductorConsumidor insertarProductorConsumidor( ProductorConsumidor proCon ) {
        try {
            return repositorio.save(proCon);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar " + e);
        }
    }

    public List<ProductorConsumidor> buscarPorId( Integer id ) {
        try {
            return repositorio.findByIdProductorConsumidor( id );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar por id " + e);
        }
    }
 
}
