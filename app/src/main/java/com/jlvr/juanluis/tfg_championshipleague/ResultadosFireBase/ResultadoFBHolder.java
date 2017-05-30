package com.jlvr.juanluis.tfg_championshipleague.ResultadosFireBase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jlvr.juanluis.tfg_championshipleague.R;

/**
 * Created by juanluis on 11/05/2017.
 */

public class ResultadoFBHolder extends RecyclerView.ViewHolder {
    private View mView;

    public ResultadoFBHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setFecha(String fecha) {
        TextView field = (TextView) mView.findViewById(R.id.lblPartido);
        field.setText(fecha);
    }

    public void setEquipoL(String equipoL) {
        TextView field = (TextView) mView.findViewById(R.id.lblEquipoLocal);
        field.setText(equipoL);
    }

    public void setGolesLocal(String golesL) {
        TextView field = (TextView) mView.findViewById(R.id.lblGolesLocal);
        field.setText(golesL);
    }

    public void setEquipoVisitante(String equipoV) {
        TextView field = (TextView) mView.findViewById(R.id.lblEquipoVisitante);
        field.setText(equipoV);
    }

    public void setGolesVisitante(String golesV) {
        TextView field = (TextView) mView.findViewById(R.id.lblGolesVisitante);
        field.setText(golesV);
    }
}
