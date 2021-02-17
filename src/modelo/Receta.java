/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author javie
 */

public class Receta {
    public Long IdReceta;
    public String nombre;
    public int cantidad;

    public Long getIdReceta() {
        return IdReceta;
    }

    public void setIdReceta(Long IdReceta) {
        this.IdReceta = IdReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
