package com.gustavo.proyecto_nutricion.Controlador;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavo.proyecto_nutricion.Detalles;
import com.gustavo.proyecto_nutricion.MainActivity;
import com.gustavo.proyecto_nutricion.R;
import com.gustavo.proyecto_nutricion.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;


public class Frutas extends Fragment implements RecyclerViewInterface {
    List<ListElement> elements;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    private String mParam1;
    private String mParam2;
    public static Frutas newInstance(String param1, String param2) {
        Frutas fragment = new Frutas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frutas, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewFrutas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        init(view);
        return view;

    }
    public void init(View view){

        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Banana","Calorias", "Activo"));
        elements.add(new ListElement("#775447", "Apple","Calorias", "Cancelado"));
        elements.add(new ListElement("#775447", "Pear","Calorias", "Activo"));

        ListAdapter listAdapter= new ListAdapter(elements, this);
        recyclerView.setAdapter(listAdapter);


    }

    @Override
    public void onItemClick(int position) {


    }
}