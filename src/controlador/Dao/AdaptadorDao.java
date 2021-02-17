/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import com.thoughtworks.xstream.XStream;
import controlador.listas.ListaS;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author javie
 */
public class AdaptadorDao implements InterfazDao {

    private Conexion conexion;
    private Class clazz;

    public AdaptadorDao(Conexion conexion, Class clazz) {
        this.conexion = conexion;
        this.clazz = clazz;
    }

    @Override
    public void guardar(Object o) throws Exception {
        ListaS lista = this.listar();
        lista.insertar(o);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO()
                + File.separatorChar + clazz.getSimpleName() + ".json"));

    }

    @Override
    public ListaS listar() {
        ListaS lista = new ListaS();
        try {
            lista = (ListaS) conexion.getXtrStream().fromXML(new FileReader(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return lista;
    }

    
    @Override
    public void modificar(Object o) throws Exception {
        Field aux = this.obtenerIdF();
        Long id = (Long)aux.getLong(o);
        Object auxobj = obtener(id);
        if (auxobj != null) {
            ListaS lista = listar();
            lista.EliminarXDato(id.intValue() - 1);
            lista.insertar(id.intValue() - 1, (int) o);
            conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO()
                    + File.separatorChar + clazz.getSimpleName() + ".json"));
        }
    }

    @Override
    public Long generarId() {
        Long id = new Long(1);
        if (listar().tamano() > 0) {
            id = new Long(listar().tamano() + 1);

        }
        return id;
    }

    public Field obtenerIdF() {
        Field aux = null;
        Field[] flieds = clazz.getDeclaredFields();
        try {
            for (Field f : flieds) {
                if (f.getType().getSimpleName().equalsIgnoreCase("Long") && f.getName().contains("Id")) {
                    aux = f;
                    break;
                }
            }
            if (aux == null) {
                flieds = clazz.getSuperclass().getDeclaredFields();
                for (Field f : flieds) {
                    if (f.getType().getSimpleName().equalsIgnoreCase("Long") && f.getName().contains("Id")) {
                        aux = f;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return aux;
    }

    @Override
    public Object obtener(Long id) {
        Object obj = null;
        try {
            Field aux = this.obtenerIdF();
            
            for (int i = 0; i < listar().tamano(); i++) {
                Object val = aux.get(obj);
                Long idvalue = (Long) val;
                if (idvalue.intValue()==id.intValue()) {
                    obj = i;
                    break;
                }
            }


        } catch (Exception e) {
        }

        return obj;
    }

}
