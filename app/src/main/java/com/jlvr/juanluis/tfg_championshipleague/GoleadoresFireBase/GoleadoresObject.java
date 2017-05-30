package com.jlvr.juanluis.tfg_championshipleague.GoleadoresFireBase;

/**
 * Created by juanluis on 13/05/2017.
 */

public class GoleadoresObject {

    private String nombre;
    private Long goles;

    public GoleadoresObject(){}

    public GoleadoresObject(String nombre, Long goles){
        this.nombre =nombre;
        this.goles=goles;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getgoles() {
        return goles;
    }

    public void setgoles(Long goles) {
        this.goles = goles;
    }


}
