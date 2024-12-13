package com.appweb.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class EnergiaProducida {

    @Id
    private Integer codigoProductor;

    @ManyToOne
    @JoinColumn( name = "productorID")
    private Productor productor;
    
    @Column(nullable = false)
    private Float costo;

    @Column(length = 100, nullable = false)
    private String impactoAmbiental;

    @Column(length = 20, nullable = false)
    private String regionAplicable;

    @Column(nullable = false)
    private Integer reporteEnergia;

    @Column(length = 100, nullable = false)
    private String recomendacionEnergia;


    public EnergiaProducida(Integer codigoProductor, Float costo, String impactoAmbiental, String regionAplicable, Integer reporteEnergia, String recomendacionEnergia) {
        this.codigoProductor = codigoProductor;
        this.costo = costo;
        this.impactoAmbiental = impactoAmbiental;
        this.regionAplicable = regionAplicable;
        this.reporteEnergia = reporteEnergia;
        this.recomendacionEnergia = recomendacionEnergia;
    }

    public EnergiaProducida() {
        
    }

    public Integer getCodigoProductor() {
        return codigoProductor;
    }

    public void setCodigoProductor(Integer codigoProductor) {
        this.codigoProductor = codigoProductor;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(String impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }

    public String getRegionAplicable() {
        return regionAplicable;
    }

    public void setRegionAplicable(String regionAplicable) {
        this.regionAplicable = regionAplicable;
    }

    public Integer getReporteEnergia() {
        return reporteEnergia;
    }

    public void setReporteEnergia(Integer reporteEnergia) {
        this.reporteEnergia = reporteEnergia;
    }

    public String getRecomendacionEnergia() {
        return recomendacionEnergia;
    }

    public void setRecomendacionEnergia(String recomendacionEnergia) {
        this.recomendacionEnergia = recomendacionEnergia;
    }


    

}
