package com.appweb.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appweb.business.model.EnergiaProducida;
import com.appweb.business.repository.EnergiaProducidaRepository;

@Service
public class EnergiaProducidaService {

    final EnergiaProducidaRepository repositorio;

    public EnergiaProducidaService(EnergiaProducidaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public EnergiaProducida insertarEnergiaProducida(EnergiaProducida energia) {
        try {
            return repositorio.save(energia);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al insertar la energia producida " + e);
        }
    }

    public int obtenerEnergiaEspecifica(Integer codigoProductor) {
        try {
            return repositorio.findById(codigoProductor)
                    .map(EnergiaProducida::getReporteEnergia)
                    .orElseThrow(() -> new RuntimeException(
                            "No se encontró la energía para el consumidor con código: " + codigoProductor));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener la energía específica: " + e);
        }
    }

    public int obtenerSumaEnergiaConsumida() {
        try {
            return repositorio.findAll().stream()
                    .mapToInt(EnergiaProducida::getReporteEnergia)
                    .sum();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al calcular la suma de la energía consumida: " + e);
        }
    }

    public List<EnergiaProducida> buscarEnergiaPorCodigo(Integer codigo) {
        try {
            return repositorio.findByCodigoProductor(codigo);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar la energia producida " + e);
        }
    }

    public EnergiaProducida actualizarEnergiaProducida(Integer codigo, EnergiaProducida energiaProducida) {

        EnergiaProducida energiaActualizada = repositorio.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Error al encontrar la energia producida"));
        energiaActualizada.setCosto(energiaProducida.getCosto());
        energiaActualizada.setImpactoAmbiental(energiaProducida.getImpactoAmbiental());
        energiaActualizada.setRecomendacionEnergia(energiaProducida.getRecomendacionEnergia());
        energiaActualizada.setRegionAplicable(energiaProducida.getRegionAplicable());
        energiaActualizada.setReporteEnergia(energiaProducida.getReporteEnergia());

        try {
            return repositorio.save(energiaActualizada);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar la energia producida " + e);
        }
    }

    public void eliminarEnergiaProducida(Integer codigoProductor) {

        try {
            repositorio.deleteById(codigoProductor);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al eliminar la energia producida " + e);
        }
    }

}
