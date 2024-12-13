package com.appweb.business.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class ProductorConsumidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductorConsumidor;

    @ManyToOne
    @JoinColumn(name = "codigo_productor")
    private Productor productor; 
    
    @ManyToOne
    @JoinColumn(name = "codigo_consumidor")
    private Consumidor consumidor;

    public ProductorConsumidor(Integer idProductorConsumidor, Productor productor, Consumidor consumidor) {
        this.idProductorConsumidor = idProductorConsumidor;
        this.productor = productor;
        this.consumidor = consumidor;
    }

    public ProductorConsumidor() {
        
    }


    public Integer getId() {
        return idProductorConsumidor;
    }

    public void setId(Integer idProductorConsumidor) {
        this.idProductorConsumidor = idProductorConsumidor;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }    

    

}
