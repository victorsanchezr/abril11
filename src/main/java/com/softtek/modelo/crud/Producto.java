package com.softtek.modelo.crud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {


    private int idProducto;

    private String nombreProducto;

    private double precioUnitario;

    private int unidadesStock;

    private int categoria;
//borrar modificar insertar CRUD
    @Override
    public String toString() {
        return "\nProducto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", unidadesStock=" + unidadesStock +
                '}';
    }
}
