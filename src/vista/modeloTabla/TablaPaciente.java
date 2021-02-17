/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.listas.ListaS;
import javax.swing.table.AbstractTableModel;
import modelo.Paciente;

/**
 *
 * @author javie
 */
public class TablaPaciente extends AbstractTableModel{
    private ListaS lista = new ListaS();

    public ListaS getLista() {
        return lista;
    }

    public void setLista(ListaS lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Paciente e = (Paciente)lista.obtenerPorPosicion(i);
        switch(i1) {
            case 0: return i+1;
            case 1: return e.getCedulaPaciente();
            case 2: return e.getNombrePaciente();
            case 3: return e.getApellidoPaciente();
            case 4: return e.getTelefono();
            case 5: return e.getCiudad();
            case 6: return e.getSexo();
            case 7: return e.getFecha_entrada();
            case 8: return e.getPatologia();  
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Nro";
            case 1: return "CEDULA";
            case 2: return "NOMBRE";
            case 3: return "APELLIDO";
            case 4: return "TELEFONO";
            case 5: return "CIUDAD";
            case 6: return "SEXO";
            case 7: return "FECHA";
            case 8: return "PATOLOGÍA";
            default:return null;
        }
    }
}
