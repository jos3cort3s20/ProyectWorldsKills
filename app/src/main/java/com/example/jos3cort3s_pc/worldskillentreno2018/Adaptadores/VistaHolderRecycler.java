package com.example.jos3cort3s_pc.worldskillentreno2018.Adaptadores;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jos3cort3s_pc.worldskillentreno2018.Interface.OnItemClickListener;
import com.example.jos3cort3s_pc.worldskillentreno2018.R;

public class VistaHolderRecycler extends RecyclerView.ViewHolder {

        TextView tvCardNombre, tvCardRaza;
        ImageView ivImagenMascota;

        public VistaHolderRecycler(View itemView) {
            super(itemView);
            tvCardNombre = (TextView)itemView.findViewById(R.id.tvTextoCardNombre);
            tvCardRaza = (TextView)itemView.findViewById(R.id.tvTextoCardRaza);
            ivImagenMascota = (ImageView) itemView.findViewById(R.id.imageView);

        }


}





