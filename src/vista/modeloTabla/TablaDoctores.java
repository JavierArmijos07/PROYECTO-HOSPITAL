/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.listas.ListaS;
import javax.swing.table.AbstractTableModel;
import modelo.Medico;

/**
 *
 * @author javie
 */
public class TablaDoctores extends AbstractTableModel{
    private ListaS lista = new ListaS();

    public ListaS getLista() {
        return lista;
    }

    public void setLista(ListaS lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Medico e = (Medico)lista.obtenerPorPosicion(i);
        switch(i1) {
            case 0: return i+1;
            case 1: return e.getNombreMedico();
            case 2: return e.getDireccion();
            case 3: return e.getCorreo();
            case 4: return e.getTelefono();
              
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Nro Carnet";
            case 1: return "NOMBRE";
            case 2: return "DIRECCION";
            case 3: return "CORREO";
            case 4: return "TELEFONO";
            default:return null;
        }
    }
}
