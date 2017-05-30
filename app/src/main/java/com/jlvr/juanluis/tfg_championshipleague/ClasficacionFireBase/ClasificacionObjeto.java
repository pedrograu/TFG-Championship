package com.jlvr.juanluis.tfg_championshipleague.ClasficacionFireBase;

/**
 * Created by juanluis on 12/05/2017.
 */

public class ClasificacionObjeto {

    private Long Puntos,PJ,PG,PE,PP;
    private String nombre;
    public ClasificacionObjeto(){}

    public ClasificacionObjeto(String Equipo,Long Puntos,Long jugados,Long ganados,Long empate, Long perdido){
        this.nombre=Equipo;
        this.Puntos=Puntos;
        this.PJ=jugados;
        this.PG=ganados;
        this.PE=empate;
        this.PP=perdido;
    }

    public Long getPJ() {
        return PJ;
    }

    public void setPJ(Long jugados) {
        this.PJ = jugados;
    }

    public Long getPG() {
        return PG;
    }

    public void setPG(Long ganados) {
        this.PG = ganados;
    }

    public Long getPE() {
        return PE;
    }

    public void setPE(Long empatados) {
        this.PE = empatados;
    }

    public Long getPP() {
        return PP;
    }
    public void setPP(Long perdidos) {
        this.PP = perdidos;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String equipo) {
        this.nombre = equipo;
    }

    public Long getPuntos() {
        return Puntos;
    }

    public void setPuntos(Long puntos) {
        this.Puntos = puntos;
    }




    @Override
    public String toString() {
        return "Clasificacion{" +
                "puntos=" + Puntos +
                ", jugados=" + PJ +
                ", ganados=" + PG +
                ", empatados=" + PE +
                ", perdidos=" + PP +
                ", equipo='" + nombre + '\'' +
                '}';
    }
}
