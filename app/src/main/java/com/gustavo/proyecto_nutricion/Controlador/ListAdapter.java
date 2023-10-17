package com.gustavo.proyecto_nutricion.Controlador;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.gustavo.proyecto_nutricion.R;
import com.gustavo.proyecto_nutricion.RecyclerViewInterface;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>   {
    private final RecyclerViewInterface recyclerViewInterface;

    public class ViewHolder extends RecyclerView.ViewHolder   {
        ImageView iconImage;
        TextView name,calorias, status;
//Esta clase interna se utiliza para mantener las referencias a las vistas individuales de un elemento de la lista. Se hereda de RecyclerView.ViewHolder. En el constructor de ViewHolder, se inicializan las vistas (como iconImage, name, calorias y status) mediante findViewById, y se configura un OnClickListener para manejar los clics en los elementos.
////En el constructor de ViewHolder, se configura un OnClickListener en itemView (la vista raíz del elemento de la lista). Cuando un elemento de la lista se hace clic, se verifica si recyclerViewInterface no es nulo y si la posición (pos) es válida. Si es así, se llama al método onItemClick de recyclerViewInterface pasando la posición del elemento que se ha hecho clic.
        ViewHolder(View iteView, RecyclerViewInterface recyclerViewInterface){
            super(iteView);
            iconImage=itemView.findViewById(R.id.iconImageView);
            name=itemView.findViewById(R.id.nombreTextView);
            calorias=itemView.findViewById(R.id.caloriasTextView);
            status=itemView.findViewById(R.id.statusTextView);
            iteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface!= null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });


        }
        //Este método se utiliza para enlazar los datos de un elemento de la lista (ListElement) con las vistas dentro del ViewHolder. Se establecen los valores de texto en name, calorias, y status a partir de los datos proporcionados por el objeto ListElement.
        void bindData(final ListElement item){
            //iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);

            name.setText(item.getName());
            calorias.setText(item.getCalorias());
            status.setText(item.getStatus());
        }


    }
    private List<ListElement> mData;
    //Constructor, El adaptador se inicializa con una lista de elementos (itemList) y una instancia de RecyclerViewInterface. Esta interfaz se utiliza para manejar eventos de clic en los elementos de la lista.

    public ListAdapter(List<ListElement> itemList, RecyclerViewInterface recyclerViewInterface){
        this.recyclerViewInterface = recyclerViewInterface;
        this.mData=itemList;
    }

    //Este método devuelve el número total de elementos en la lista, que es igual al tamaño de la lista de datos (mData).
    @Override
    public int getItemCount(){return mData.size();}



    //Este método se llama cuando se crea una nueva instancia de ViewHolder. Aquí se infla el diseño de un elemento de la lista (list_element.xml) utilizando un LayoutInflater, y luego se crea una instancia de ViewHolder con la vista inflada y la instancia de RecyclerViewInterface.
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(view,recyclerViewInterface);
        return viewHolder;
    }
    //Este método se llama cuando se actualiza un elemento en el RecyclerView. Aquí se llama al método bindData del ViewHolder para enlazar los datos del elemento en la posición actual con las vistas en el ViewHolder.
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }



}
