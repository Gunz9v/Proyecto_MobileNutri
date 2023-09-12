package com.gustavo.proyecto_nutricion.Controlador;

public class ListElement {
    public String color;
    public String name;
    public String calorias;
    public String status;


    public ListElement(String color, String name, String calorias, String status) {
        this.color = color;
        this.name = name;
        this.calorias = calorias;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
