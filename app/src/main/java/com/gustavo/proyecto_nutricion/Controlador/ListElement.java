package com.gustavo.proyecto_nutricion.Controlador;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

//Esta clase representa un elemento de una lista que contiene información sobre un producto alimenticio, como su color, nombre, calorías y estado
public class ListElement {
    public String color;
    public String name;
    public String calorias;
    public String status;
    public String imageName; // Propiedad para almacenar la referencia de la imagen

    public ListElement(String color, String name, String calorias, String status, String imageName) {
        this.color = color;
        this.name = name;
        this.calorias = calorias;
        this.status = status;
        this.imageName = imageName; // Asigna la referencia de la imagen al elemento
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
