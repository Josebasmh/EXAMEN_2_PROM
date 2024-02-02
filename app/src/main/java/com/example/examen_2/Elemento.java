package com.example.examen_2;

public class Elemento {

    private Integer id,numAtomico;
    private String nombre,simbolo,estado;

    public Elemento(Integer i, String n, String s, Integer na, String e){
        id=i;
        nombre=n;
        simbolo=s;
        numAtomico=na;
        estado=e;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumAtomico() {
        return numAtomico;
    }

    public void setNumAtomico(Integer numAtomico) {
        this.numAtomico = numAtomico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
