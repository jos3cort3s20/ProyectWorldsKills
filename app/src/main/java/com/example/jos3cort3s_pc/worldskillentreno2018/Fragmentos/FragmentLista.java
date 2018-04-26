package com.example.jos3cort3s_pc.worldskillentreno2018.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jos3cort3s_pc.worldskillentreno2018.Activitys.ActivityDetalle;
import com.example.jos3cort3s_pc.worldskillentreno2018.Adaptadores.AdaptadorRecycler;
import com.example.jos3cort3s_pc.worldskillentreno2018.Interface.OnItemClickListener;
import com.example.jos3cort3s_pc.worldskillentreno2018.R;





/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentLista.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentLista extends Fragment {

    private OnFragmentInteractionListener mListener;

    public FragmentLista() {
        // Required empty public constructor
    }


    public static FragmentLista newInstance(int positionBtn){
            FragmentLista lista = new FragmentLista();
            Bundle infoShow = new Bundle();
            infoShow.putInt("dataShow", positionBtn);
            lista.setArguments(infoShow);
            return  lista;
    }



    RecyclerView myRecycler;

    String [] data =  {"Pintor  1", "Pintor  2", "Pintor  3", "Pintor  4", "Pintor  5", "Pintor  6",
                        "Pintor  7", "Pintor  8", "Pintor 9"};

    String [] data1 =  {"Escritor 1", "Escritor 2", "Escritor 3", "Escritor 4", "Escritor 5", "Escritor 6",
            "Escritor 7", "Escritor 8", "Escritor 9"};

    String [] data2 =  {"Escultor 1", "Escultor 2", "Escultor 3", "Escultor 4", "Escultor 5", "Escultor 6",
            "Escultor 7", "Escultor 8", "Escultor 9"};





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =   inflater.inflate(R.layout.layout_fragment_lista, container, false);
        agregaId(vista);
        myRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorRecycler myAdapter ;
        Intent goDetalle = new Intent(getContext(), ActivityDetalle.class);





        switch (getArguments().getInt("dataShow")){

            case 1:
                myAdapter= new AdaptadorRecycler(getContext(), data, goDetalle);
                myRecycler.setAdapter(myAdapter);
                break;
            case 2:
                myAdapter = new AdaptadorRecycler(getContext(), data1, goDetalle);
                myRecycler.setAdapter(myAdapter);
                break;
            case 3:
                myAdapter =  new AdaptadorRecycler(getContext(), data2, goDetalle);
                myRecycler.setAdapter(myAdapter);
                break;

             default:
                 return  null;


        }

        return vista;
    }


    public void agregaId(View vista ){

        myRecycler = (RecyclerView)vista.findViewById(R.id.recyViewLista);

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
