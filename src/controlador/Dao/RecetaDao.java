/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Receta;

/**
 *
 * @author javie
 */
public class RecetaDao extends AdaptadorDao{
    private Receta receta;
    
    public RecetaDao() {
        super(new Conexion(),Receta.class);
    }
    
    public Receta getReceta() {
        if (receta == null) {
            receta = new Receta();
        }
        return receta;

    }
    
     public Boolean guardar() {
        try {
            this.getReceta().setIdReceta(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getReceta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Receta " + e);
            return false;
        }
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
}
