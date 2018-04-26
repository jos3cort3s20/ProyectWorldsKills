package com.example.jos3cort3s_pc.worldskillentreno2018.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jos3cort3s_pc.worldskillentreno2018.Interface.OnItemClickListener;
import com.example.jos3cort3s_pc.worldskillentreno2018.R;


public class AdaptadorRecycler extends RecyclerView.Adapter<VistaHolderRecycler> {

    Context context, contextTwo;
    String [] arrayData;
    Intent myIntent;

    public AdaptadorRecycler(Context context, String[] arrayData, Intent myIntent)  {
        this.context = context;
        this.arrayData = arrayData;
        this.myIntent = myIntent;

    }


    public AdaptadorRecycler(Context contextTwo, String[] arrayData) {
        this.contextTwo = contextTwo;
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public VistaHolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vista_cardview,parent, false);


        return new VistaHolderRecycler(v);
    }



    @Override
    public void onBindViewHolder(@NonNull final VistaHolderRecycler holder, final int position) {

        holder.tvCardNombre.setText(arrayData[position]);

        

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent goDetalle =  new Intent(context, contextTwo.getClass());
                myIntent.putExtra("data", arrayData[position]);
                context.startActivity(myIntent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayData.length;
    }




}






