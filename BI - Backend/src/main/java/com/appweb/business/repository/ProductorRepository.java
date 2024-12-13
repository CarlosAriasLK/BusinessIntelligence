package com.appweb.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appweb.business.model.Productor;

public interface ProductorRepository extends JpaRepository< Productor, Integer > {

    List<Productor> findByCodigoProductor( Integer codigoProductor );
}
