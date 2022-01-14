package com.example.SpringEjercicio4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    // 1. Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String modelName;
    private Integer bateryCapacity;
    private String os;

    // 2.Constructores

    public Laptop(){}

    public Laptop(Long id, String manufacturer, String modelName, Integer bateryCapacity, String os) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.bateryCapacity = bateryCapacity;
        this.os = os;
    }

    // 3. Getter y Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getBateryCapacity() {
        return bateryCapacity;
    }

    public void setBateryCapacity(Integer bateryCapacity) {
        this.bateryCapacity = bateryCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
