package com.appweb.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.business.model.EnergiaProducida;

public interface EnergiaProducidaRepository extends JpaRepository< EnergiaProducida, Integer > {

    List<EnergiaProducida> findByCodigoProductor( Integer codigoProductor );

}
