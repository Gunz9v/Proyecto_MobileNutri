package com.gustavo.proyecto_nutricion.Controlador;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavo.proyecto_nutricion.R;
import com.gustavo.proyecto_nutricion.RecyclerViewInterface;
import com.gustavo.proyecto_nutricion.detalles_gyms;
import com.gustavo.proyecto_nutricion.detalles_tienda;

import java.util.ArrayList;
import java.util.List;


public class Carnes extends Fragment implements RecyclerViewInterface {
    //Instanciar las variables
    List<ListElement> elements;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    private String mParam1;
    private String mParam2;
    //Este método estático se utiliza para crear una nueva instancia del fragmento Carnes y configurar argumentos si es necesario. Esto se hace para pasar datos al fragmento cuando se crea.
    public static Carnes newInstance(String param1, String param2) {
        Carnes fragment = new Carnes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //En este método, se obtienen los argumentos pasados al fragmento, si los hay. Estos argumentos pueden ser utilizados para configurar el fragmento
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    //En este método, se obtienen los argumentos pasados al fragmento, si los hay. Estos argumentos pueden ser utilizados para configurar el fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño de este fragmento
        View view = inflater.inflate(R.layout.fragment_carnes, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewCarnes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        init(view);
        return view;
    }
    // Este método se utiliza para inicializar los elementos y los detalles de los productos. Se crean instancias de objetos ListElement y ProductDetail y se agregan a las listas elements y productDetails. Estos datos se utilizarán más tarde para llenar el RecyclerView y para pasar detalles a la actividad Detalles.

    //Iniciador
    public void init(View view){

        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Shaker Kevin Levron","35 soles", "Stock", "Shaker Kevin Levron"));
        elements.add(new ListElement("#775447", "Maletin Kevin Levron","150 soles", "Stock", "Maletin Kevin Levron"));
        elements.add(new ListElement("#775447", "Crea Kevin Levron","180 soles", "Agotado", "Creatina Kevin Levron"));

        ListAdapter listAdapter= new ListAdapter(elements, this, requireContext());
        recyclerView.setAdapter(listAdapter);


    }
    //Se crea el metodo al usar IMPLEMENTS RecyclerViewInterface
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(requireActivity(), detalles_tienda.class);
        startActivity(intent);
    }
}