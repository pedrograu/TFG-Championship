package com.jlvr.juanluis.tfg_championshipleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.jlvr.juanluis.tfg_championshipleague.ClasficacionFireBase.ClasificacionObjeto;
import com.jlvr.juanluis.tfg_championshipleague.ResultadosFireBase.ResultadoFB;

import java.util.ArrayList;
import java.util.List;

public class NuevoPartido extends AppCompatActivity {
private Button buttonNP, buttonGuardar;
    private EditText fecha,equipoLocal,equipoVisitante,golesL,golesV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_partido);

        //botonOAnyadi
        buttonGuardar = (Button)findViewById(R.id.button2);
        //Implementamos el evento click del botón
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fecha = (EditText) findViewById(R.id.nuevaFecha);
                equipoLocal = (EditText) findViewById(R.id.nuevoEquipoLocal);
                equipoVisitante = (EditText) findViewById(R.id.nuevoEquipoVisitante);
                golesL = (EditText) findViewById(R.id.resLocal);
                golesV = (EditText) findViewById(R.id.resVisit);


                String fechaN = String.valueOf(fecha.getText());
                String equiL = String.valueOf(equipoLocal.getText());
                String equiV = String.valueOf(equipoVisitante.getText());
                //        Long gL = Long.parseLong(String.valueOf(golesL.getText()));
                //              Long gV = Long.parseLong(String.valueOf(golesV));

                List<String> s = new ArrayList<String>();

                int i = Math.max(10,1000);

                Query consulta =
                        FirebaseDatabase.getInstance().getReference()
                                .child("Liga").child("Resultados");
                String partido = new String() + "i";



                Log.i(String.valueOf(i),"--------------------------------------------------------------");
                    partido= consulta.toString();
                Log.i(String.valueOf(partido),"--------------------------------------------------------------");
                //Añadir partido nuevo


                DatabaseReference resNuevo =
                        FirebaseDatabase.getInstance().getReference().child("Liga")
                                .child("Resultados");
                ResultadoFB res =
                        new ResultadoFB(equiL,3L, equiV, 2L, fechaN);


                resNuevo.child(partido).setValue(res);
                ////

                ///Añadir en clasificacion
                DatabaseReference resNuevo2 =
                        FirebaseDatabase.getInstance().getReference().child("Liga")
                                .child("Clasificacion");


                ClasificacionObjeto equipo1= new ClasificacionObjeto(res.getEquipoLocal(),5L,5L,5L,5L,5L);
                ClasificacionObjeto equipo2= new ClasificacionObjeto(res.getEquipoVisitante(),1L,0L,0L,0L,0L);
                resNuevo2.child(res.getEquipoLocal()).setValue(equipo1);
              //  resNuevo2.child(res.getEquipoVisitante()).setValue(equipo1);
                resNuevo2.child(res.getEquipoVisitante()).setValue(equipo2);

            }
        });
        buttonNP = (Button)findViewById(R.id.button3);
        //Implementamos el evento click del botón
        buttonNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent


                Intent intent =
                        new Intent(NuevoPartido.this, NuevoGoleador.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
