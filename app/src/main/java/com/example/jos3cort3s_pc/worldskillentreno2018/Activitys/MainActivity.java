package com.example.jos3cort3s_pc.worldskillentreno2018.Activitys;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import com.example.jos3cort3s_pc.worldskillentreno2018.Fragmentos.FragmentLista;
import com.example.jos3cort3s_pc.worldskillentreno2018.Fragmentos.Fragment_Registro;
import com.example.jos3cort3s_pc.worldskillentreno2018.R;

public class MainActivity extends AppCompatActivity {

    Fragment_Registro frRegistro = new Fragment_Registro();
    FragmentLista frLista = new FragmentLista();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void cargoFrag (Fragment fragment){
        FragmentTransaction fragmentManager  = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.frameInter, fragment).commit();

       //this.getSupportFragmentManager().beginTransaction().replace(R.id.frameInter, fragment).commit();

    }

    public void funcionButton(View view) {

        switch (view.getId()){

            case R.id.btnImEscritor:
                cargoFrag(FragmentLista.newInstance(1));
                break;
            case R.id.btnImPintor:
                cargoFrag(FragmentLista.newInstance(2));
                break;
            case R.id.btnImEscultor:
                cargoFrag(FragmentLista.newInstance(3));
                break;
            case R.id.btnImRegistro:
                cargoFrag(frRegistro);
                break;
            case R.id.btnImSalir:
                finish();
                break;
             default:
                 break;
        }
    }
}
