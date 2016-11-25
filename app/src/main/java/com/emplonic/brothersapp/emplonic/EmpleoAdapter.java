package com.emplonic.brothersapp.emplonic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by usuario on 22/11/2016.
 */

public class EmpleoAdapter extends RecyclerView.Adapter<EmpleoAdapter.EmpleoViewHolder> {
    private List<Empleo> items;
    public static class EmpleoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView Requisitos;

        public EmpleoViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            Requisitos = (TextView) v.findViewById(R.id.Requisitos1);
        }
    }

    public EmpleoAdapter(List<Empleo> items) {
        this.items = items;
    }

    @Override
    public EmpleoAdapter.EmpleoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.emplocard, viewGroup, false);
        return new EmpleoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EmpleoViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.Requisitos.setText (items.get(i).getRequisitos());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
