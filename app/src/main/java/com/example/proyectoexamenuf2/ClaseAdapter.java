package com.example.proyectoexamenuf2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClaseAdapter extends RecyclerView.Adapter<ClaseAdapter.ClaseViewHolder> implements View.OnClickListener {

    List<Incidencias> incidenciasList = new ArrayList<>();
    Context context;

    private View.OnClickListener listener;



    public ClaseAdapter(List<Incidencias> incidencias) {

        this.incidenciasList = incidencias;

    }




    @Override

    public ClaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_items, viewGroup, false);

        view.setOnClickListener(this);


        return new ClaseViewHolder(view);



    }



    @Override

    public void onBindViewHolder(@NonNull final ClaseViewHolder claseViewHolder, int i) {



        Incidencias m = incidenciasList.get(i);

        claseViewHolder.descripcion.setText(m.getDescripcion());

        claseViewHolder.estado.setText(m.getEstado());

        claseViewHolder.cruz.animate().alpha(0).translationX(-60).setDuration((long) 0.1);

        MiHilo miHilo = new MiHilo(claseViewHolder.foto_incidencia, context);
        miHilo.execute(m.getUrlImagen());

        claseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                claseViewHolder.cruz.animate().alpha(1).translationX(60).setDuration(2000);
            }
        });

    }



    @Override
    public int getItemCount() {

        return incidenciasList.size();

    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }


    class ClaseViewHolder extends RecyclerView.ViewHolder{



        TextView descripcion, estado;
        ImageView foto_incidencia, cruz;



        public ClaseViewHolder(@NonNull View itemView) {

            super(itemView);


            cruz = itemView.findViewById(R.id.cruz);
            descripcion = itemView.findViewById(R.id.descripcion_recycler);

            estado = itemView.findViewById(R.id.estado);

            foto_incidencia = itemView.findViewById(R.id.imagen_incidencia);


        }

    }
}
