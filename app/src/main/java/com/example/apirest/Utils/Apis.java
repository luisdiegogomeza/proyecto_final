package com.example.apirest.Utils;

public class Apis {

    public static final String URL_001="http://192.168.0.106:8080/personas/";
    public static final String URL_002="http://192.168.0.27:8001/productos/";

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }

    public static ProductoService getProductoService(){
        return Producto.getProducto(URL_002).create(ProductoService.class);
    }

}
