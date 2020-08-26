package com.example.estebanlz.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DesarrolladoresFragment extends Fragment {
    RecyclerView desarrolladores;
    private AdaptadorDesarrolladores adapter;
    View rootView;
    private Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Desarrolladores");
        rootView = inflater.inflate(R.layout.recycler_desarrolladores, container, false);
        activity = getActivity();
        desarrolladores = (RecyclerView) rootView.findViewById(R.id.recyclerDesarrolladores);
        desarrolladores.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new AdaptadorDesarrolladores(activity);
        desarrolladores.setAdapter(adapter);
        return rootView;
    }
}
