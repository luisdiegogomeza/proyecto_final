package com.example.apirest.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Producto {

    @SerializedName("idProducto")
    @Expose
    private int idProducto;

    @SerializedName("Producto")
    @Expose
    private String producto;

    @SerializedName("idMarca")
    @Expose
    private int idMarca;

    @SerializedName("Descripcion")
    @Expose
    private String descripcion;

    @SerializedName("Imagen")
    @Expose
    private String imagen;

    @SerializedName("Precio_costo")
    @Expose
    private int precio_costo;

    @SerializedName("Precio_venta")
    @Expose
    private int precio_venta;

    @SerializedName("Existencia")
    @Expose
    private int existencia;

    @SerializedName("Fecha_ingreso")
    @Expose
    private String fecha_ingreso;

    public Producto() {
    }

    public Producto(int idProducto, String producto, int idMarca, String descripcion, String imagen, int precio_costo, int precio_venta, int existencia, String fecha_ingreso) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.idMarca = idMarca;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio_costo = precio_costo;
        this.precio_venta = precio_venta;
        this.existencia = existencia;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(int precio_costo) {
        this.precio_costo = precio_costo;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}