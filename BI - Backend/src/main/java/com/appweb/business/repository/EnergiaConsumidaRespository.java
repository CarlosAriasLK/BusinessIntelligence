package com.appweb.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.business.model.EnergiaConsumida;

public interface EnergiaConsumidaRespository extends JpaRepository< EnergiaConsumida, Integer > {

    List<EnergiaConsumida> findByCodigoConsumidor( Integer codigoConsumidor );

}
