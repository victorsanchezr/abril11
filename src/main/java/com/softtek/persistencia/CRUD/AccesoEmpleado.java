package com.softtek.persistencia.CRUD;

import com.softtek.modelo.crud.Empleado;
import com.softtek.modelo.crud.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoEmpleado extends Conexion{



    public List<Empleado> obtenerTodos() throws ClassNotFoundException, SQLException {


        Statement sentencia;

        ResultSet resultado;

        String sql = "Select employee_id,first_name,last_name,birth_date,city from employees";

        List<Empleado> empleados = new ArrayList<>();

        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        while (resultado.next()){
            empleados.add(new Empleado(resultado.getInt("employee_id"),
                    resultado.getString("first_name"),
                    resultado.getString("last_name"),
                    resultado.getDate("birth_date"),
                    resultado.getString("city")));


        }

        return empleados;
    }


}
