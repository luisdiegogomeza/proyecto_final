package com.example.apirest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apirest.Model.Persona;
import com.example.apirest.Utils.Apis;
import com.example.apirest.Utils.PersonaService;
import com.example.apirest.Utils.ProductoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonaActivity extends AppCompatActivity {
    PersonaService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persona_layout);


        TextView idProducto=(TextView)findViewById(R.id.idProducto);
        EditText txtIdProducto=(EditText)findViewById(R.id.txtIdProducto);

        TextView producto =(TextView)findViewById(R.id.producto);
        EditText txtProducto=(EditText)findViewById(R.id.txtProducto);

        TextView marca=(TextView)findViewById(R.id.marca);
        EditText txtMarca=(EditText)findViewById(R.id.txtMarca);

        TextView descripcion=(TextView)findViewById(R.id.descripcion);
        EditText txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);

        //TextView imagen=(TextView)findViewById(R.id.imagen);
        ImageView viewmagen=(ImageView)findViewById(R.id.viewImagen);

        TextView precioCosto = (TextView)findViewById(R.id.precioCosto);
        EditText txtPrecioCosto = (EditText)findViewById(R.id.txtPrecioCosto);

        TextView precioVenta = (TextView)findViewById(R.id.precioVenta);
        EditText txtPrecioVenta = (EditText)findViewById(R.id.txtPrecioVenta);

        TextView existencia = (TextView)findViewById(R.id.existencia);
        EditText txtExistencia = (EditText)findViewById(R.id.txtExistencia);

        TextView fechaIngreso = (TextView)findViewById(R.id.fechaIngreso);
        EditText txtFechaIngreso = (EditText)findViewById(R.id.txtFechaIngreso);

        Button btnVolver=(Button)findViewById(R.id.btnVolver);

        Bundle bundle=getIntent().getExtras();
        final String id = bundle.getString("ID");
        final String pro = bundle.getString("PRODUCTO");
        final String marc = bundle.getString("MARCA");
        final String desc = bundle.getString("DESCRIPCION");
        final String imag = bundle.getString("IMAGEN");
        final String costo = bundle.getString("COSTO");
        final String precio = bundle.getString("PRECIO");
        final String exist = bundle.getString("EXISTENCIA");
        final String fecha = bundle.getString("INGRESO");

        txtIdProducto.setText(id);
        txtProducto.setText(pro);
        txtMarca.setText(marc);
        txtDescripcion.setText(desc);

        txtPrecioCosto.setText(costo);
        txtPrecioVenta.setText(precio);
        txtExistencia.setText(exist);
        txtFechaIngreso.setText(fecha);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        /*TextView idper=(TextView)findViewById(R.id.Id);
        EditText txtId=(EditText)findViewById(R.id.txtId);
        TextView nombres=(TextView)findViewById(R.id.nombres);
        final EditText txtNombres=(EditText)findViewById(R.id.txtNombres);
        TextView apellidos=(TextView)findViewById(R.id.apellidos);
        final EditText txtApellidos=(EditText)findViewById(R.id.txtApellidos);

        Button btnSave=(Button)findViewById(R.id.btnSave);
        Button btnVolver=(Button)findViewById(R.id.btnVolver);
        Button btnEliminar=(Button)findViewById(R.id.btnEliminar);


        Bundle bundle=getIntent().getExtras();
        final String id = bundle.getString("ID");
        String nom=bundle.getString("NOMBRE");
        String ape=bundle.getString("APELLIDOS");

        txtId.setText(id);
        txtNombres.setText(nom);
        txtApellidos.setText(ape);
        if(id.trim().length()==0||id.equals("")){
            idper.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p=new Persona();
                p.setNombres(txtNombres.getText().toString());
                p.setApellidos(txtApellidos.getText().toString());
                if(id.trim().length()==0||id.equals("")){
                    addPersona(p);
                    Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    updatePersona(p,Integer.valueOf(id));
                    Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePersona(Integer.valueOf(id));
                Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });*/

    }
    public void addPersona(Persona p){
        service= Apis.getPersonaService();
        Call<Persona>call=service.addPersona(p);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PersonaActivity.this,"Se agrego con éxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void updatePersona(Persona p,int id){
        service= Apis.getPersonaService();
        Call<Persona>call=service.updatePersona(p,id);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PersonaActivity.this,"Se Actualizó conéxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void deletePersona(int id){
        service=Apis.getPersonaService();
        Call<Persona>call=service.deletePersona(id);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PersonaActivity.this,"Se Elimino el registro",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PersonaActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
