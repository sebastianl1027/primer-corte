package com.universidadcauca.movil.preguntame.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universidadcauca.movil.preguntame.Preguntas;
import com.universidadcauca.movil.preguntame.R;
import com.universidadcauca.movil.preguntame.models.Pregunte;

import java.util.List;

/**
 * Created by Sebastian on 09/04/2015.
 */
public class PreguntAdapter extends BaseAdapter {

    Context context;
    List<Pregunte> data;

    public PreguntAdapter(Context context, List<Pregunte> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if (convertView == null)
            v = View.inflate(context, R.layout.template_pregunte, null);
        else
            v = convertView;

        Pregunte p = (Pregunte) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.pregunta);
        txt.setText(p.getPregunta());

        txt = (TextView) v.findViewById(R.id.categoria);
        txt.setText(p.getCategoria());

        txt = (TextView) v.findViewById(R.id.nivel_educativo);
        txt.setText(p.getNivel_educativo());

        return v;
    }
}
