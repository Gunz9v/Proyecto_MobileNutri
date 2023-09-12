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
        void bindData(final ListElement item){
            //iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            calorias.setText(item.getCalorias());
            status.setText(item.getStatus());
        }


    }
    private List<ListElement> mData;
    public ListAdapter(List<ListElement> itemList, RecyclerViewInterface recyclerViewInterface){
        this.recyclerViewInterface = recyclerViewInterface;
        this.mData=itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,recyclerViewInterface);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }



}
