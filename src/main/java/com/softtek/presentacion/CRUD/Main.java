package com.softtek.presentacion.CRUD;



import com.softtek.persistencia.CRUD.AccesoProducto;
import com.softtek.persistencia.CRUD.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexion con = new Conexion();
        con.abrirConexion();

        AccesoProducto ac = new AccesoProducto();
        System.out.println(ac.obtenerTodos());


        System.out.println(ac.modificar());
        System.out.println(ac.obtenerTodos());

        System.out.println(ac.insertar());
        System.out.println(ac.obtenerTodos());


        System.out.println(ac.borrar());
        System.out.println(ac.obtenerTodos());
    }
}
