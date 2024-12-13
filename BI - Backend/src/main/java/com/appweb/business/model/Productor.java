package com.appweb.business.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity

public class Productor {

    @Id
    private Integer codigoProductor;


    @Column( nullable = false, unique = true )
    private Integer documento;
    
    @Column( length = 30, nullable = false )
    private String nombre;

    @Column( length = 30, nullable = false )
    private String apellido;
    
    @Column( length = 30, nullable = false, unique = true )
    private String correo;
    
    @Column( length = 30, nullable = false )
    private String contrasenia;



    @Column( length = 50, nullable = false )
    private String tipoEnergia;
    
    @Column( length = 50, nullable = false )
    private String tipoEntidad;

    @Column( length = 50, nullable = false )
    private String ubicacion;

    @Column( nullable = false )
    private Integer cantidad;

    @Column( nullable = false )
    private Integer mesConsumido;
    
    @Column( nullable = false )
    private Integer reporteProduccion;



    public Productor(Integer codigoProductor, Integer documento, String nombre, String apellido, String correo, String contrasenia, String tipoEnergia, String tipoEntidad, String ubicacion, Integer cantidad, Integer mesConsumido, Integer reporteProduccion) {
        this.codigoProductor = codigoProductor;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipoEnergia = tipoEnergia;
        this.tipoEntidad = tipoEntidad;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
        this.mesConsumido = mesConsumido;
        this.reporteProduccion = reporteProduccion;
    }

    public Productor() {

    }

    public Integer getCodigoProductor() {
        return codigoProductor;
    }

    public void setCodigoProductor(Integer codigoProductor) {
        this.codigoProductor = codigoProductor;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getMesConsumido() {
        return mesConsumido;
    }

    public void setMesConsumido(Integer mesConsumido) {
        this.mesConsumido = mesConsumido;
    }

    public Integer getReporteProduccion() {
        return reporteProduccion;
    }

    public void setReporteProduccion(Integer reporteProduccion) {
        this.reporteProduccion = reporteProduccion;
    }


    

}
