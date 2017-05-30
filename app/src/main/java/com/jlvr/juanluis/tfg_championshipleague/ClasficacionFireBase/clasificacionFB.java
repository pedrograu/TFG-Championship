package com.jlvr.juanluis.tfg_championshipleague.ClasficacionFireBase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jlvr.juanluis.tfg_championshipleague.GoleadoresFireBase.goleadoresFB;
import com.jlvr.juanluis.tfg_championshipleague.R;
import com.jlvr.juanluis.tfg_championshipleague.ResultadosFireBase.resultadosFB;

import java.util.ArrayList;
import java.util.List;

public class clasificacionFB extends AppCompatActivity {

    private static final String TAGLOG = "firebase-db";
    private RecyclerView lstClasificacion;
    FirebaseRecyclerAdapter adaptadorClasificacion;

    private List<String> ID = new ArrayList<>();
    private Button buttonOrdenarC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacionfb);
     //  ID.addAll(buscaID());
       // Log.i(String.valueOf(ID),"holaaaa");
/*
        //////////////////Saber el ID de la tabla y añadirlo a lista:
        DatabaseReference dbResultados2 =
                FirebaseDatabase.getInstance().getReference().child("Liga")
                        .child("Clasificacion");
        dbResultados2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<String> s = new ArrayList<String>();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {
                    Object obj = objSnapshot.getKey();
                    s.add(String.valueOf((obj)));
                    Log.i(String.valueOf(obj),"<----------------------WEEEE");

                }
                Log.i(String.valueOf(s),"<----------------------2222222");
                Log.i(String.valueOf(s.get(1)),"<----------------------33333");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

////////////////////////////////////////////////////////////////////////////////////////
*/

        //Log.i(ID.get(0),">>>>>>>>>3");

        //Referencias a db:


        DatabaseReference dbclasifcacion =
                FirebaseDatabase.getInstance().getReference().child("Liga")
                        .child("Clasificacion");

        final RecyclerView recycler = (RecyclerView) findViewById(R.id.lstClasificacion);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adaptadorClasificacion =
                new FirebaseRecyclerAdapter<ClasificacionObjeto, ClasificacionHolder>(
                        ClasificacionObjeto.class, R.layout.activity_lista__clasificacion, ClasificacionHolder.class, dbclasifcacion) {

                    @Override
                    public void populateViewHolder(ClasificacionHolder resViewHolder, ClasificacionObjeto res, int position) {

                        resViewHolder.setnombre(res.getnombre());
                        resViewHolder.setPuntos(res.getPuntos());
                        resViewHolder.setPartidosJugados(res.getPJ());
                        resViewHolder.setPG(res.getPG());
                        resViewHolder.setPE(res.getPE());
                        resViewHolder.setPP(res.getPP());

                    }
                };
      /*  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recycler.setLayoutManager(layoutManager);
       // recycler2.setAdapter(mAdapter3);*/
        recycler.setAdapter(adaptadorClasificacion);

        //botonOrdenar
        buttonOrdenarC = (Button)findViewById(R.id.buttonOrdenarC);
        //Implementamos el evento click del botón
        final RecyclerView recyclerO = (RecyclerView) findViewById(R.id.lstClasificacion);
        recyclerO.setHasFixedSize(true);
        recyclerO.setLayoutManager(new LinearLayoutManager(this));
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        buttonOrdenarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query consultaOrdenaC =
                        FirebaseDatabase.getInstance().getReference()
                                .child("Liga").child("Clasificacion")
                                .orderByChild("Puntos");
              //  List<Query> lista = new ArrayList();
             //   lista.addAll( consultaOrdenaC.o);

               //Log.i(String.valueOf(lista),"consultaaaa");//<----------------------------------------

                FirebaseRecyclerAdapter mAdapter3;
                mAdapter3 =
                        new FirebaseRecyclerAdapter<ClasificacionObjeto, ClasificacionHolder>(
                                ClasificacionObjeto.class, R.layout.activity_lista__clasificacion, ClasificacionHolder.class, consultaOrdenaC) {

                            @Override
                            public void populateViewHolder(ClasificacionHolder resViewHolder, ClasificacionObjeto res, int position) {
                                resViewHolder.setnombre(res.getnombre());
                                resViewHolder.setPuntos(res.getPuntos());
                                resViewHolder.setPartidosJugados(res.getPJ());
                                resViewHolder.setPG(res.getPG());
                                resViewHolder.setPE(res.getPE());
                                resViewHolder.setPP(res.getPP());

                            }
                        };

                recyclerO.setLayoutManager(layoutManager);
                recyclerO.setAdapter(mAdapter3);
                ///Log.i(mAdapter3.toString(),"<---------------------adapter");
            }


        });



    }


    private List<String> buscaID(){

        final List<String> id = new ArrayList<String>();
        //localizar nombre equipos:
        DatabaseReference dbResultados2 =
                FirebaseDatabase.getInstance().getReference().child("Liga")
                        .child("Clasificacion");
        dbResultados2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()) {                                    Object obj = objSnapshot.getKey();
                    id.add(String.valueOf((obj)));
                   // Log.i(String.valueOf(obj),"<----------------------WEEEE");
                }
                //Log.i(String.valueOf(id),"<----------------------2222222");
                Log.i(String.valueOf(id.get(1)),"<----------------------1");                            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Log.i(String.valueOf(id),"<----------------------2222222");

        return id;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menulateral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {

            case R.id.menu_seccion_1:
                Intent intent =
                        new Intent(clasificacionFB.this, clasificacionFB.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
                break;
            case R.id.menu_seccion_2:
                Intent intent2 =
                        new Intent(clasificacionFB.this, resultadosFB.class);
                //Iniciamos la nueva actividad
                startActivity(intent2);
                break;


            case R.id.menu_seccion_3:
                Intent intent3 =
                        new Intent(clasificacionFB.this, goleadoresFB.class);
                //Iniciamos la nueva actividad
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

