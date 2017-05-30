package com.jlvr.juanluis.tfg_championshipleague.GoleadoresFireBase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jlvr.juanluis.tfg_championshipleague.R;

/**
 * Created by juanluis on 13/05/2017.
 */

public class GoleadoresHolder extends RecyclerView.ViewHolder {
    private View mView;

    public GoleadoresHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setnombre(String nombre) {
        TextView field = (TextView) mView.findViewById(R.id.NombreJugador);
        field.setText(nombre);
    }



    public void setgoles(Long goles) {
        TextView field = (TextView) mView.findViewById(R.id.golesMArcados);
        field.setText(String.valueOf(goles));
    }
}
