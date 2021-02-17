/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.listas;

import controlador.Utilidades.Utiles;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 *
 * @author javie
 */
public class ListaS {

    protected Nodo cabecera;
    public static final int ORDENAR_ASCENDENTE = -1;
    public static final int ORDENAR_DESCENDENTE = 1;

    public ListaS() {
        this.cabecera = null;
    }

    public int tamano() {
        int tamano = 0;
        if (!estaVacio()) {
            Nodo tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSiguiente();
            }
        }
        return tamano;
    }

    public void insertar(Object dato) {
        if (dato == null) {
            new NullPointerException("Se debe agregar un objeto cliente");
        }
        //Se crea el nodo con el elemento e inicio
        Nodo tem = new Nodo(dato, null);
        tem.setSiguiente(cabecera);
        cabecera = tem;
        
    }

    public boolean estaVacio() {
        return (this.cabecera == null);//(this.cabecera != null) ? false : true;
    }
    public void EliminarXDato(int dato) {
        
        Nodo tmp = cabecera;
        do {
            if (tmp.getDato().equals(dato)) {
                if (tmp == cabecera) {
                    cabecera = cabecera.getSiguiente();
                    System.out.println("se elimino el dato " + dato);
                }
            }
            tmp = tmp.getSiguiente();
        } while (tmp != cabecera);

    }
    public void eliminarTodaLista() {
        cabecera = null;
    }

    public Object extraer() {
        Object dato = null;

        if (!estaVacio()) {
            dato = cabecera.getDato();
            cabecera = cabecera.getSiguiente();
        }
        return dato;
    }
/**
    *Metodo que permite ordenar datos por posicion 
    *@param pos  el identificador de odrdebarporPosicion de ListaS
    *@return dato
    */
    public Object obtenerPorPosicion(int pos) {
        Object dato = null;
        if (!estaVacio()&& pos >= 0) {
            Nodo tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSiguiente();
                if (tmp == null) {
                    break;
                }

                //System.out.println(tmp.getDato());
            }
            dato = (tmp != null) ? tmp.getDato() : null;

        }
        return dato;
    }

    public void verDatos() {
       if (!estaVacio()) {
            Nodo recorrer = cabecera;
            while (recorrer != null) {
                System.out.print("--" + recorrer.getDato() + "--");
                recorrer = recorrer.getSiguiente();
            }
            System.out.println();
        }
    }

    public void insertar(Object dato, int pos) {
        if (estaVacio() || pos <= 0) {
            insertar(dato);
        } else {
            Nodo iterador = cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSiguiente() == null) {
                    break;
                }
                iterador = iterador.getSiguiente();
            }
            Nodo tmp = new Nodo(dato, iterador.getSiguiente());
            iterador.setSiguiente(tmp);
        }
    }

    public void insertarFinal(Object dato) {
        insertar(dato, tamano() - 1);
    }

    public void editar(int posicion, Object dato) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamano()) {
            // Consulta si el nodo a eliminar es el primero.
            if (posicion == 0) {
                // Alctualiza el valor delprimer nodo.
                cabecera.setDato(dato);
            } else {
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                Nodo aux = cabecera;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Alctualiza el valor del nodo.
                aux.setDato(dato);
            }
        }
    }
       /**
    *Metodo que permite ordenar datos
    *@param tipo_ordenacion   el identificador de ordenar
    *@param atributo   el identificador de ordenar
    *@return this
    */
    public ListaS ordenar(int tipo_ordenacion, String atributo) {
        if (!estaVacio()) {
            for (int i = 0; i < tamano() - 1; i++) {
                int k = i;
                for (int j = i + 1; j < tamano(); j++) {
                    if (Utiles.compareTo(obtenerPorPosicion(j), obtenerPorPosicion(k), atributo) == tipo_ordenacion) {
                        k = j;
                    }                    
                }
                Object aux = obtenerPorPosicion(i);                
                editar(i, obtenerPorPosicion(k));
                editar(k, aux);                
            }
        }
        return this;
    }
    /**
    *Metodo que permite realizar busqueda binaria 
    *@param dato    el identificador de dato
    *@param atributo   el identificador atributo
    *@return null
    */    
    public Object busquedaBinaria(String dato, String atributo) {
        System.out.println("DATO " + dato + " ATRIBUTO " + atributo);
        int n = tamano();
        int centro, inf = 0, sup = n - 1;

        while (inf <= sup) {
            centro = (sup + inf) / 2;

            System.out.println("centro " + centro + " ss " + obtenerPorPosicion(centro) + " saa " + dato);
            //if ((String.valueOf(obtenerPorPosicion(centro))).equalsIgnoreCase(dato)) {
            if(Utiles.comparar(dato, obtenerPorPosicion(centro), atributo)) {
                return obtenerPorPosicion(centro);
            } else if (Utiles.compareTo(dato, obtenerPorPosicion(centro), atributo) < 0) {//else if (dato.compareTo(String.valueOf(obtenerPorPosicion(centro))) < 0) {
                sup = centro - 1;
                System.out.println(" sup " + sup);
            } else {
                inf = centro + 1;
                System.out.println("inf " + inf);
            }

        }
        return null;
    }



   
    

}
