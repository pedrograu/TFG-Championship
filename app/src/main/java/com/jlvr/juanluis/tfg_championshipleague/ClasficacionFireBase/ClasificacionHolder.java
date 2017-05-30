package com.jlvr.juanluis.tfg_championshipleague.ClasficacionFireBase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jlvr.juanluis.tfg_championshipleague.R;

/**
 * Created by juanluis on 12/05/2017.
 */

public class ClasificacionHolder extends RecyclerView.ViewHolder {

    private static View mView;

    public ClasificacionHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public  void setnombre(String equipo) {
        TextView field = (TextView) mView.findViewById(R.id.equipoC);
        field.setText(equipo);
    }

    public void setPuntos(Long puntos) {
        TextView field = (TextView) mView.findViewById(R.id.puntosT);
        field.setText(String.valueOf(puntos));
    }

    public void setPartidosJugados(Long partidos) {
        TextView field = (TextView) mView.findViewById(R.id.partidosJ);
        field.setText(String.valueOf(partidos));
    }

    public void setPG(Long ganados) {
        TextView field = (TextView) mView.findViewById(R.id.partidosG);
        field.setText(String.valueOf(ganados));
    }

    public void setPE(Long empatados) {
        TextView field = (TextView) mView.findViewById(R.id.partidosE);
        field.setText(String.valueOf(empatados));
    }

    public void setPP(Long perdidos) {
        TextView field = (TextView) mView.findViewById(R.id.partidosP);
        field.setText(String.valueOf(perdidos));
    }


}
