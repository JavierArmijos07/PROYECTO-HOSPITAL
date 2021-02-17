/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;


/**
 *
 * @author javie
 */
public class Paciente extends Persona{

    public Long IdPaciente;
    public String nombrePaciente;
    public String apellidoPaciente;
    public String cedulaPaciente;
    public Date Fecha_entrada;
    public String Sexo;
    public String Ciudad;
    public String Patologia;
    
    public Long getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Long IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    

    public Date getFecha_entrada() {
        return Fecha_entrada;
    }

    public void setFecha_entrada(Date Fecha_entrada) {
        this.Fecha_entrada = Fecha_entrada;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getPatologia() {
        return Patologia;
    }

    public void setPatologia(String Patologia) {
        this.Patologia = Patologia;
    }

       public int get(int fila) {
        return fila;
        
    }
     
    
}
