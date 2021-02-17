/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;
import controlador.listas.ListaS;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author javie
 */

public class PersonaDao extends AdaptadorDao {
    
    private Persona persona;
    
    public PersonaDao() {
        super(new Conexion(), Persona.class);
    }

    public Persona getPersona() {
        if(persona == null)
            persona = new Persona();
        return persona;
    }
    
    public Boolean guardar() {
        try {
            this.getPersona().setIdMedico(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getPersona());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Persona "+ e);
            return false;
        }
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public void nuevaPersona(){
        this.persona = null;
    }
    
    public ListaS ordenar(ListaS Estudiantes, int tipo_ordenacion, String atributo) {
        Estudiantes.ordenar(tipo_ordenacion, atributo);
        return Estudiantes;
    }
    
    
    
    
}
