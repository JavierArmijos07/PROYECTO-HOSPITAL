/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;
import controlador.listas.ListaS;
import modelo.Cuenta;
/**
 *
 * @author javie
 */
public class CuentaDao extends AdaptadorDao {
    private Cuenta cuenta;
    
    public CuentaDao() {
        super(new Conexion(), Cuenta.class);
    }

    public Cuenta getCuenta() {
        if(cuenta == null)
            cuenta = new Cuenta();
        return cuenta;
    }
    
    public Boolean guardar() {
        try {
            this.getCuenta().setId(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Cuenta "+ e);
            return false;
        }
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
   
    public ListaS ordenar(ListaS Estudiantes, int tipo_ordenacion, String parametro) {
        Estudiantes.ordenar(tipo_ordenacion, parametro);
        return Estudiantes;
    }
    /**
    *Metodo que permite iniciar seccion atravez de un usuario y clave
    *@param usuario el identificador de cuenta
    *@param clave el identificador de cuenta
    *@return cuenta
    */
    public Cuenta inicioSesion(String usuario, String clave) {
        ListaS cuentas = listar();
        cuentas = ordenar(cuentas, ListaS.ORDENAR_ASCENDENTE, "usuario");
        Cuenta cuenta = (Cuenta) cuentas.busquedaBinaria(usuario, "usuario");//select * from cuenta where usuario = "xxxxx" //inyeccion sql select usuario form cueta where 1 = 1;
        if(cuenta != null) {
            if(!cuenta.getClave().equals(clave)) 
                cuenta = null;            
        }
        return cuenta;
    }   
}
