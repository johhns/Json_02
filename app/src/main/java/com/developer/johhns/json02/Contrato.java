package com.developer.johhns.json02;

public class Contrato {

    private int     numero ;
    private String  nombre ;
    private int     area   ;
    private int     tonelasdas ;

    public Contrato() {
    }

    public Contrato(int numero, String nombre, int area, int tonelasdas) {
        this.numero     = numero;
        this.nombre     = nombre;
        this.area       = area;
        this.tonelasdas = tonelasdas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getTonelasdas() {
        return tonelasdas;
    }

    public void setTonelasdas(int tonelasdas) {
        this.tonelasdas = tonelasdas;
    }
}
