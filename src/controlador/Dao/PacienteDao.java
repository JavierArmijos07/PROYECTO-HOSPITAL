/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Paciente;

/**
 *
 * @author javie
 */
public class PacienteDao extends AdaptadorDao {

    private Paciente paciente;

    public PacienteDao() {
        super(new Conexion(), Paciente.class);
    }

    public Paciente getPaciente() {
        if (paciente == null) {
            paciente = new Paciente();
        }
        return paciente;

    }

    public Boolean guardar() {
        try {

            this.getPaciente().setIdPaciente(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getPaciente());
            return true;

        } catch (Exception e) {
            System.out.println("Error en guardar Paciente " + e.getMessage());
            return false;
        }
    }

    public Boolean modificar() {
        try {

            this.getPaciente().setIdPaciente(Long.parseLong(String.valueOf(listar().tamano() +1)));
            this.modificar(this.getPaciente());
            return true;

        } catch (Exception e) {
            System.out.println("Error en modificar Paciente " + e.getMessage());
            return false;
        }
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    /**
    *Metodo que permite eliminar  
    *@param posicion el identificador de cuenta
    *@return true
    */
    public boolean eliminarI(int posicion) {
        try {
            
            this.getPaciente().setIdPaciente(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.eliminarI(posicion);
            return true;
        } catch (Exception e) {
            System.out.println("Error en eliminar " + e);
            return false;
        }
    }

}
