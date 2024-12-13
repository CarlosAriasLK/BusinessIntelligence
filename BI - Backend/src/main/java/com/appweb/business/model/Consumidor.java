package com.appweb.business.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Consumidor {

    @Id
    private Integer codigoConsumidor;


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
    
    
    @Column( length = 30, nullable = false )
    private String ubicacion;

    @Column( length = 30, nullable = false )
    private String tipoEnergia;
    
    @Column( nullable = false )
    private Integer mesConsumido;

    @Column( length = 100, nullable = false )
    private String recomendacionConsumo;

    @Column( nullable = false )
    private Integer reporteConsumo;



    public Consumidor(Integer codigoConsumidor, Integer documento, String nombre, String apellido, String correo, String contrasenia, String ubicacion, String tipoEnergia, Integer mesConsumido, String recomendacionConsumo, Integer reporteConsumo) {
        this.codigoConsumidor = codigoConsumidor;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.ubicacion = ubicacion;
        this.tipoEnergia = tipoEnergia;
        this.mesConsumido = mesConsumido;
        this.recomendacionConsumo = recomendacionConsumo;
        this.reporteConsumo = reporteConsumo;
    }

    public Consumidor() {

    }

    public Integer getCodigoConsumidor() {
        return codigoConsumidor;
    }

    public void setCodigoConsumidor(Integer codigoConsumidor) {
        this.codigoConsumidor = codigoConsumidor;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoEnergia() {
        return tipoEnergia;
    }

    public void setTipoEnergia(String tipoEnergia) {
        this.tipoEnergia = tipoEnergia;
    }

    public Integer getMesConsumido() {
        return mesConsumido;
    }

    public void setMesConsumido(Integer mesConsumido) {
        this.mesConsumido = mesConsumido;
    }

    public String getRecomendacionConsumo() {
        return recomendacionConsumo;
    }

    public void setRecomendacionConsumo(String recomendacionConsumo) {
        this.recomendacionConsumo = recomendacionConsumo;
    }

    public Integer getReporteConsumo() {
        return reporteConsumo;
    }

    public void setReporteConsumo(Integer reporteConsumo) {
        this.reporteConsumo = reporteConsumo;
    }

}
