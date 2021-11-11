package com.example.apirest;

import android.content.Intent;
import android.os.Bundle;

import com.example.apirest.Model.Persona;
import com.example.apirest.Model.Producto;
import com.example.apirest.Utils.Apis;
import com.example.apirest.Utils.PersonaService;
import com.example.apirest.Utils.ProductoService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PersonaService personaService;
    ProductoService productoService;
    List<Persona>listPersona=new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.listView);
        listarProductos();

        //listPersons();

        /*FloatingActionButton fab = findViewById(R.id.fabe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,ProductoActivity.class);
               intent.putExtra("ID","");
                intent.putExtra("PRODUCTO","");
                intent.putExtra("MARCA","");
                intent.putExtra("DESCRIPCION","");
                intent.putExtra("IMAGEN","");
                intent.putExtra("COSTO","");
                intent.putExtra("PRECIO","");
                intent.putExtra("EXISTENCIA","");
                intent.putExtra("INGRESO","");
               startActivity(intent);
            }
        });*/

    }

    public void listPersons(){
        personaService= Apis.getPersonaService();
        Call<List<Persona>>call=personaService.getPersonas();
        call.enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if(response.isSuccessful()) {
                    listPersona = response.body();
                    listView.setAdapter(new PersonaAdapter(MainActivity.this,R.layout.content_main,listPersona));
                }
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }

    public void listarProductos(){
        productoService = Apis.getProductoService();
        Call<List<Producto>>call = productoService.getProductos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()){
                    listaProductos = response.body();
                    listView.setAdapter(new ProductoAdapter(MainActivity.this, R.layout.content_main, listaProductos));
                }
            }
            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
