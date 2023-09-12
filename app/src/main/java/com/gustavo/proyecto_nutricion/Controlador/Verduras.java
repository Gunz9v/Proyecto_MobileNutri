package com.gustavo.proyecto_nutricion.Controlador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavo.proyecto_nutricion.Detalles;
import com.gustavo.proyecto_nutricion.MainActivity;
import com.gustavo.proyecto_nutricion.R;
import com.gustavo.proyecto_nutricion.RecyclerViewInterface;
import com.gustavo.proyecto_nutricion.models.ProductDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Verduras extends Fragment implements RecyclerViewInterface {

    List<ListElement> elements;
    List<ProductDetail> productDetails;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    private String mParam1;
    private String mParam2;

    public static Verduras newInstance(String param1, String param2) {
        Verduras fragment = new Verduras();
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
        View view = inflater.inflate(R.layout.fragment_verduras, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewVerduras);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        init(view);
        return view;

    }
    public void init(View view){

        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Choclo","341Kcal", "100g"));

        productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail("Choclo", "CON QUESO", "detail2", "detail3", "detail4"));

        elements.add(new ListElement("#775447", "Frijoles Negros","373Kcal", "100g"));
        productDetails.add(new ProductDetail("Frijoles Negros", "detail1", "detail2", "detail3", "detail4"));

        elements.add(new ListElement("#775447", "Pear","22Kcal", "100g"));
        productDetails.add(new ProductDetail("Pear", "detail1", "detail2", "detail3", "detail4"));

        elements.add(new ListElement("#775447", "asd","asd", "asd"));
        productDetails.add(new ProductDetail("asd", "detail1", "detail2", "detail3", "detail4"));

        ListAdapter listAdapter= new ListAdapter(elements,this);
        recyclerView.setAdapter(listAdapter);

    }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(requireActivity(), Detalles.class);
        intent.putExtra("nombre", elements.get(position).getName());
        intent.putExtra("calorias", elements.get(position).getCalorias());

        for(ProductDetail productDetail: productDetails) {
            if (productDetail.getName().equals(elements.get(position).getName())) {
                intent.putExtra("detail1", productDetail.getDetail1());
                intent.putExtra("detail2", productDetail.getDetail2());
                intent.putExtra("detail3", productDetail.getDetail3());
                intent.putExtra("detail4", productDetail.getDetail4());

            }
        }
        startActivity(intent);
    }
}