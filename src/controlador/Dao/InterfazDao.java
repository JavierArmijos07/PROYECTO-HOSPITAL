/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import controlador.listas.ListaS;
import modelo.Persona;
/**
 *
 * @author javie
 */
public interface InterfazDao {
    public void guardar(Object o) throws Exception;
    public void modificar(Object o)throws Exception;
    public ListaS listar();  
    public Object obtener(Long id);
    public Long generarId();
    
}
