package com.example.apirest.Utils;

import com.example.apirest.Model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProductoService {

    @GET("listar")
    Call<List<Producto>> getProductos();

    @POST("agregar")
    Call<Producto>addProducto(@Body Producto producto);

    @POST("actualizar/{id}")
    Call<Producto>updateProducto(@Body Producto producto, @Path("id") int id);

    @POST("eliminar/{id}")
    Call<Producto>deleteProducto(@Path("id")int id);
}
