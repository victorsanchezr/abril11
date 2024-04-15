package com.softtek.persistencia.CRUD;


import com.softtek.modelo.crud.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion{

    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {


        Statement sentencia;

        ResultSet resultado;

        String sql = "Select product_id,product_name,unit_price,units_in_stock,category_id from products";

        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        while (resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("category_id")));


        }

        return productos;
    }



    public String modificar(){ //update

        String sql = "Update products SET product_name = ?,unit_price = ?,units_in_stock = ? WHERE product_id  = 1";

        try {
            PreparedStatement pr = miConexion.prepareStatement(sql);
            pr.setString(1,"TEST");
            pr.setDouble(2,300.0);
            pr.setInt(3,999);
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Fallo al Updatear";
        }


        return "Updateado correctamente";
    }


    public String insertar(){ //update

        String sql = "INSERT INTO products (product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";


        try {
            PreparedStatement pr = miConexion.prepareStatement(sql);
            pr.setInt(1,78);
            pr.setString(2,"Remolacha");
            pr.setInt(3,6);

            pr.setInt(4,5);
            pr.setString(5,"kilo");
            pr.setInt(6,455);

            pr.setInt(7,5);
            pr.setInt(8,42);
            pr.setInt(9,555);

            pr.setInt(10,21);




            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Fallo al insertar";
        }


        return "insertado correctamente";
    }


    public String borrar(){ //delete

        try {
            String sql = "DELETE FROM products WHERE product_id = ?";
            PreparedStatement statement = miConexion.prepareStatement(sql);
            statement.setInt(1, 78);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return "no se ha podido borrar";

        }

        return "borrado correctamente";
    }


}
