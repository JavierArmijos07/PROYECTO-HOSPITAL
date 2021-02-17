/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Medico;

/**
 *
 * @author javie
 */
public class MedicoDao extends AdaptadorDao{
    private Medico medico;
    
    public MedicoDao() {
        super(new Conexion(),Medico.class);
    }
    
    public Medico getMedico() {
        if (medico == null) {
            medico = new Medico();
        }
        return medico;

    }
    
     public Boolean guardar() {
        try {
            this.getMedico().setIdMedico(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getMedico());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Medico " + e);
            return false;
        }
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
