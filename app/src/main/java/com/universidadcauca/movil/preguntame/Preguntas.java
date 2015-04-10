package com.universidadcauca.movil.preguntame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.universidadcauca.movil.preguntame.adapters.PreguntAdapter;
import com.universidadcauca.movil.preguntame.models.Pregunte;
import com.universidadcauca.movil.preguntame.util.PreguntaUtil;

import java.util.ArrayList;
import java.util.List;


public class Preguntas extends ActionBarActivity  implements DialogInterface.OnClickListener{

    ListView list;
    String Preguntas[];
    PreguntAdapter adapter;
    AlertDialog alert;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        list = (ListView) findViewById(R.id.list);
        PreguntaUtil.data = new ArrayList<Pregunte>();

        adapter = new PreguntAdapter(this, PreguntaUtil.data);

        list.setAdapter(adapter);

        Preguntas = getResources().getStringArray(R.array.preguntas);
        loadPreguntas();

        registerForContextMenu(list);

        alert = new AlertDialog.Builder(this).setTitle("Alerta").setMessage("¿Desea Eliminar el juego?")
                .setPositiveButton("Aceptar", this).setNegativeButton("Cancelar" ,this).create();
    }

    public void loadPreguntas(){

        for (int i=0; i<Preguntas.length;i++){
            String info [] = Preguntas[i].split(",");

            Pregunte g = new Pregunte(info[2], info[1], info[0]);
            PreguntaUtil.data.add(g);
        }

        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_preguntas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_add:

                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);

                break;
            case R.id.action_more:
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_info:
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);

    }


    //menu contextual


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v==list)
            getMenuInflater().inflate(R.menu.menu_prengunte_ctx, menu);

        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        pos = info.position;

        switch (item.getItemId()){

            case R.id.action_delete:
                //data.remove(pos);
                //adapter.notifyDataSetChanged();
                alert.show();
                break;
            case R.id.action_edit:
                Intent intent = new Intent(this, AddActivity.class);
                intent.putExtra("pos", pos);
                startActivity(intent);



                break;

        }

        return super.onContextItemSelected(item);
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

        if (which == DialogInterface.BUTTON_POSITIVE){

            PreguntaUtil.data.remove(pos);
            adapter.notifyDataSetChanged();
        }

    }
}
