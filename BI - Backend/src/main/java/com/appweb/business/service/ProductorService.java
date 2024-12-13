package com.appweb.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appweb.business.model.Productor;
import com.appweb.business.repository.ProductorRepository;


@Service
public class ProductorService {

    final ProductorRepository productorRepositorio;

    public ProductorService(ProductorRepository productorRepositorio) {
        this.productorRepositorio = productorRepositorio;
    }


    public Long contarProductores() {
        try {
            return productorRepositorio.count();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al contar los consumidores: " + e);
        }
    }

    public Productor insertarProductor( Productor productor ) {

        try {
            return productorRepositorio.save( productor );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar el productor " + e);
        }
    }

    public List<Productor> listarProductores() {
        try {
            return productorRepositorio.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al listar los productores " + e);
        }
    }

    public List<Productor> consultarProductoresPorCodigo( Integer codigoConsumidor ) {

        try {
            return productorRepositorio.findByCodigoProductor( codigoConsumidor );           
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al consultar el productor " + e);
        }
    }

    public Productor actualizarProductor( Integer codigoProductor, Productor productor) {

        Productor productorActualizado = productorRepositorio.findById(codigoProductor).orElseThrow( () -> new RuntimeException("Error al encontrar el productor") );

        productorActualizado.setNombre(productor.getNombre());
        productorActualizado.setApellido(productor.getApellido());
        productorActualizado.setCorreo(productor.getCorreo());
        productorActualizado.setUbicacion(productor.getUbicacion());
        productorActualizado.setTipoEnergia(productor.getTipoEnergia());
        productorActualizado.setMesConsumido(productor.getMesConsumido());
        productorActualizado.setContrasenia(productor.getContrasenia());

        try {
            return productorRepositorio.save(productorActualizado);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar el productor " + e);
        }
    }

    public void eliminarProductor( Integer codigoProductor ) {
        try {
            if (codigoProductor == null) {
                throw new RuntimeException("La ID del productor no puede ser nula");
            }
            productorRepositorio.deleteById(codigoProductor);
        } catch (Exception e) {
            throw new RuntimeException("Error al Eliminar el productor " + e);
        }
    }
    
}