package com.appweb.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.business.model.Consumidor;

public interface ConsumidorRepository extends JpaRepository< Consumidor, Integer > {

    List<Consumidor> findByCodigoConsumidor( Integer codigoConsumidor );

}
