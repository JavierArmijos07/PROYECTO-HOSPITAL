/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import controlador.listas.ListaS;
import java.util.UUID;
import modelo.Rol;

/**
 *
 * @author javie
 */
public class RolDao extends AdaptadorDao {

    private Rol rol;

    public RolDao() {
        super(new Conexion(), Rol.class);
    }

    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }

    public Boolean guardar() {
        try {
            this.getRol().setId(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol " + e);
            return false;
        }
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
/**
    *Metodo que permite Listar
    *@param tipo_ordenacion  el identificador de cuenta
    *@param atributo  el identificador de cuenta
    *@return Pacientes
    */
    public ListaS ordenar(ListaS Pacientes, int tipo_ordenacion, String atributo) {
        Pacientes.ordenar(tipo_ordenacion, atributo);
        return Pacientes;
    }

    public void crearRoles() {
        PersonaDao pdao = new PersonaDao();
        if (listar().tamano() == 0) {
            Rol admin = new Rol();
            admin.setNombre("Administrador");
            setRol(admin);
            guardar();
            setRol(null);
            Rol part = new Rol();
            part.setNombre("Particular");
            setRol(part);
            guardar();
            setRol(null);

            if (pdao.listar().tamano() == 0) {
                ListaS listado = listar().ordenar(ListaS.ORDENAR_ASCENDENTE, "nombre");
                Object objeto = listado.busquedaBinaria("Particular", "nombre");
                long id_rol = (objeto != null) ? ((Rol) objeto).getId() : -1;
                System.out.println("Se encontro " + objeto);

                pdao.getPersona().setApellido("Particular");
                pdao.getPersona().setNombre("Particular");
                pdao.getPersona().setCedula("1104141781");
                pdao.getPersona().setDireccion("Casa");
                pdao.getPersona().setExternal_id(UUID.randomUUID().toString());
                //pdao.getPersona().setId(pdao.listar().tamano() + 1);
                pdao.getPersona().setId_rol(id_rol);
                pdao.guardar();
                
                CuentaDao cdao = new CuentaDao();
                cdao.getCuenta().setClave("1234");
                cdao.getCuenta().setEstado(Boolean.TRUE);
                cdao.getCuenta().setExternal_id(UUID.randomUUID().toString());
                cdao.getCuenta().setId_persona(pdao.getPersona().getId_rol());
                cdao.getCuenta().setUsuario("2222222222");
                cdao.guardar();
                pdao.setPersona(null);
                cdao.setCuenta(null);
            }
        }

    } 
}
