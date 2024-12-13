package com.appweb.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appweb.business.model.EnergiaConsumida;
import com.appweb.business.repository.EnergiaConsumidaRespository;

@Service
public class EnergiaConsumidaService {

    final EnergiaConsumidaRespository repositorio;

    public EnergiaConsumidaService(EnergiaConsumidaRespository repositorio) {
        this.repositorio = repositorio;
    }


    public int obtenerEnergiaEspecifica(Integer codigoConsumidor) {
        try {
            return repositorio.findById(codigoConsumidor)
                    .map(EnergiaConsumida::getReporteEnergia)
                    .orElseThrow(() -> new RuntimeException("No se encontró la energía para el consumidor con código: " + codigoConsumidor));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener la energía específica: " + e);
        }
    }
    
    public int obtenerSumaEnergiaConsumida() {
        try {
            return repositorio.findAll().stream()
                    .mapToInt(EnergiaConsumida::getReporteEnergia)
                    .sum();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al calcular la suma de la energía consumida: " + e);
        }
    } 

    public EnergiaConsumida insertarEnergiaConsumida( EnergiaConsumida energia ) {
        
        try {
            return repositorio.save( energia );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar la energia " + e);
        }
    }
    
    public List<EnergiaConsumida> buscarEnergiaPorCodigo( Integer codigoConsumidor ) {
        try {
            return repositorio.findByCodigoConsumidor( codigoConsumidor );
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la energia " + e);
        }
    }


    public EnergiaConsumida actualizarEnergiaConsumida( Integer codigoConsumidor, EnergiaConsumida energia ) {
    
        EnergiaConsumida energiaActualizada = repositorio.findById(codigoConsumidor).orElseThrow( () -> new RuntimeException("Error al encontrar el consumidor") );

        energiaActualizada.setCosto(energia.getCosto());
        energiaActualizada.setImpactoAmbiental(energia.getImpactoAmbiental());
        energiaActualizada.setRecomendacionEnergia(energia.getRecomendacionEnergia());
        energiaActualizada.setRegionAplicable(energia.getRegionAplicable());
        energiaActualizada.setReporteEnergia(energia.getReporteEnergia());

        try {
            return repositorio.save(energiaActualizada);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar los datos " + e);
        }
    }

    public void eliminarEnergiaConsumida( Integer codigoConsumidor ) {
        try {
            repositorio.deleteById(codigoConsumidor);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al eliminar la energia consumida " + e);
        }
    }


}
