package com.appweb.business.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.appweb.business.model.Consumidor;
import com.appweb.business.repository.ConsumidorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service 
public class ConsumidorService {

    private final ConsumidorRepository repositorio;

    public ConsumidorService(ConsumidorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public long contarConsumidores() {
        try {
            return repositorio.count();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al contar los consumidores: " + e);
        }
    }

    public Consumidor insertarConsumidor( Consumidor consumidor ) {

        try {
            return repositorio.save(consumidor);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar el consumidor", e );
        }
    }

    public List<Consumidor> listarConsumidores() {
        try {
            return repositorio.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al listar los consumidores " + e);
        }
    }

    public List<Consumidor> consultarConsumidores( Integer codigoConsumidor ) {

        try {
            return repositorio.findByCodigoConsumidor( codigoConsumidor );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar el consumidor " + e);
        }
    }

    public Consumidor actualizarConsumidor( Integer codigoConsumidor, Consumidor consumidor ) {

        Consumidor consumidorExistente = repositorio.findById(codigoConsumidor).orElseThrow( () -> new RuntimeException("Consumidor no encontrado")  );
        consumidorExistente.setNombre(consumidor.getNombre());
        consumidorExistente.setApellido(consumidor.getApellido());
        consumidorExistente.setCorreo(consumidor.getCorreo());
        consumidorExistente.setUbicacion(consumidor.getUbicacion());
        consumidorExistente.setTipoEnergia(consumidor.getTipoEnergia());
        consumidorExistente.setMesConsumido(consumidor.getMesConsumido());
        consumidorExistente.setContrasenia(consumidor.getContrasenia());
        
        try {
            return repositorio.save(consumidorExistente);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error " + e);
        }

    }

    public void eliminarConsumidor(Integer codigoConsumidor) {
        if (!repositorio.existsById(codigoConsumidor)) {
            throw new EntityNotFoundException("No se encontró consumidor con código: " + codigoConsumidor);
        }

        try {
            repositorio.deleteById(codigoConsumidor);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No se puede eliminar el consumidor debido a dependencias existentes", e);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el consumidor", e);
        }
    }


}
