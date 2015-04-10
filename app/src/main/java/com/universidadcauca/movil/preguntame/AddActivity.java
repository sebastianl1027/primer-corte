package com.universidadcauca.movil.preguntame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.universidadcauca.movil.preguntame.models.Pregunte;
import com.universidadcauca.movil.preguntame.util.PreguntaUtil;


public class AddActivity extends ActionBarActivity implements View.OnClickListener {

    static final int ADD = 0;
    static final int EDIT = 1;

    EditText pregunta, categoria, nivel_educativo;
    Button btn;

    int type, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setTitle("Agregar Pregunta");

        pregunta = (EditText) findViewById(R.id.pregunta);
        categoria = (EditText) findViewById(R.id.categoria);
        nivel_educativo = (EditText) findViewById(R.id.nivel_educativo);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras == null){
            type=ADD;
        }else {
            type=EDIT;
            getSupportActionBar().setTitle("Editar Juego");

            pos = extras.getInt("pos");

            Pregunte pregunte = PreguntaUtil.data.get(pos);

            pregunta.setText(pregunte.getPregunta());
            categoria.setText(pregunte.getCategoria());
            nivel_educativo.setText(pregunte.getNivel_educativo());
        }
    }


    @Override
    public void onClick(View v) {

        String r = pregunta.getText().toString();
        String c = categoria.getText().toString();
        String n = nivel_educativo.getText().toString();

        if (r.equals("") || c.equals("") || n.equals("")){
            Toast.makeText(this, "Llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else {

            if (type==ADD) {

                Pregunte pregunte = new Pregunte(r, c, n);
                PreguntaUtil.data.add(pregunte);
            }else {
                Pregunte pregunte = PreguntaUtil.data.get(pos);
                pregunte.setPregunta(r);
                pregunte.setCategoria(c);
                pregunte.setNivel_educativo(n);
            }

            finish();
        }

    }
}
