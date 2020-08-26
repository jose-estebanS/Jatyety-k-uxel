package com.example.estebanlz.proyecto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InicioFragment extends Fragment implements View.OnClickListener {
    Button opcion1, opcion2;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Jatyety k'uxel");
        rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
        opcion1 = (Button) rootView.findViewById(R.id.opcion1);
        opcion2 = (Button) rootView.findViewById(R.id.opcion2);
        controlFragmento.frag = -1;
        opcion1.setOnClickListener(this);
        opcion2.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.opcion1:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, new BuscadorFragment()).commit();
                break;
            case R.id.opcion2:
                FragmentTransaction transactiondos = getFragmentManager().beginTransaction();
                transactiondos.replace(R.id.contenedor, new ModeloFragment()).commit();
                break;
                default:
                    break;
        }
    }
}
