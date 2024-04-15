package com.softtek.presentacion.ejercicios;

import com.softtek.modelo.crud.Empleado;
import com.softtek.modelo.crud.Producto;
import com.softtek.persistencia.CRUD.AccesoEmpleado;
import com.softtek.persistencia.CRUD.AccesoProducto;
import com.softtek.persistencia.CRUD.Conexion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccesoProducto ac = new AccesoProducto();
        AccesoEmpleado ae = new AccesoEmpleado();
       // apartado1(ac);
       //apartado2(ac);
        //apartado3(ac);
       // apartado4(ac);
       // apartado5(ac);
        apartado6(ae);
        apartado7(ac);
        apartado8(ae);

    }

    public static void apartado1(AccesoProducto ac) throws SQLException, ClassNotFoundException {
        Predicate<Producto> categoria = x->x.getCategoria() == 2;

        ac.obtenerTodos().stream().filter(categoria).forEach(System.out::println);

    }
    public static void apartado2(AccesoProducto ac) throws SQLException, ClassNotFoundException {
        Predicate<Producto> categoria = x->x.getNombreProducto().startsWith("N");

        ac.obtenerTodos().stream().filter(categoria).forEach(System.out::println);

    }

    public static void apartado3(AccesoProducto ac) throws SQLException, ClassNotFoundException {


        List<Producto> orden =  ac.obtenerTodos().stream().sorted(Comparator.comparing(Producto::getNombreProducto)).collect(Collectors.toList());
        orden.forEach(System.out::println);

    }

    public static void apartado4(AccesoProducto ac) throws SQLException, ClassNotFoundException {


       double test =  ac.obtenerTodos().stream().mapToDouble(Producto::getPrecioUnitario).max().orElse(0);
        System.out.println(test);

    }

    public static void apartado5(AccesoProducto ac) throws SQLException, ClassNotFoundException {


        double test =  ac.obtenerTodos().stream().mapToDouble(Producto::getPrecioUnitario).average().orElse(0);
        System.out.println(test);

    }

    public static void apartado6(AccesoEmpleado ac) throws SQLException, ClassNotFoundException {

        Predicate<Empleado> edad = empleado -> {
            int edadCalculada = 124 - empleado.getBirth_date().getYear();
          if (edadCalculada < 68){
              return false;
          }else return true;
        };

        ac.obtenerTodos().stream()
                .filter(edad)
                .forEach(System.out::println);
    }


    public static void apartado7(AccesoProducto ac) throws SQLException, ClassNotFoundException {

        List<Producto> productos = ac.obtenerTodos();

        Map<Integer, Long> cantidadPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));

        cantidadPorCategoria.forEach((categoria, cantidad) -> {
            System.out.println("Categoría: " + categoria + ", Cantidad de productos: " + cantidad);
        });


    }


    public static void apartado8(AccesoEmpleado ac) throws SQLException, ClassNotFoundException {

        List<Empleado> empleados = ac.obtenerTodos();

        Set<String> ciudadesDistintas = empleados.stream()
                .map(Empleado::getCity)
                .collect(Collectors.toSet());

        // Imprimir las ciudades distintas
        ciudadesDistintas.forEach(System.out::println);
    }



}