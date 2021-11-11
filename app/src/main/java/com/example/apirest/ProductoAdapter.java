package com.example.apirest;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apirest.Model.Producto;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    private Context context;
    private List<Producto> productos;
    public ProductoAdapter(@NonNull Context context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.context = context;
        this.productos = objects;
    }


    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView textidProducto= (TextView) rowView.findViewById(R.id.idProducto);
        TextView textProducto= (TextView) rowView.findViewById(R.id.producto);
        ImageView imagen = (ImageView)  rowView.findViewById(R.id.viewImagen);
        Picasso.with(this.context)
                .load(productos.get(position).getImagen())
                .error(R.drawable.ic_launcher_foreground)
                .fit()
                .centerInside()
                .into(imagen);

        textidProducto.setText(String.format("ID: %s", productos.get(position).getIdProducto()));
        textProducto.setText(String.format("Producto: %s", productos.get(position).getProducto()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PersonaActivity.class);
                intent.putExtra("ID",String.valueOf(productos.get(position).getIdProducto()));
                intent.putExtra("PRODUCTO",productos.get(position).getProducto());
                intent.putExtra("MARCA",String.valueOf(productos.get(position).getIdMarca()));
                intent.putExtra("DESCRIPCION",productos.get(position).getDescripcion());
                //intent.putExtra("IMAGEN",productos.get(position).getImagen());
                //intent.putExtra("IMAGEN",viewImagen);
                intent.putExtra("COSTO",String.valueOf(productos.get(position).getPrecio_costo()));
                intent.putExtra("PRECIO",String.valueOf(productos.get(position).getPrecio_venta()));
                intent.putExtra("EXISTENCIA",String.valueOf(productos.get(position).getExistencia()));
                intent.putExtra("INGRESO",String.valueOf(productos.get(position).getFecha_ingreso()));
                context.startActivity(intent);
            }
        });

        return rowView;
        //return null;
    }
}
