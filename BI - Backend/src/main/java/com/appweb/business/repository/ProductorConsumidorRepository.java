package com.appweb.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.business.model.ProductorConsumidor;

public interface ProductorConsumidorRepository extends JpaRepository< ProductorConsumidor, Integer > {

    List<ProductorConsumidor> findByIdProductorConsumidor( Integer codigoProductor );

}
