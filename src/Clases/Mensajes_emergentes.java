/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yanir
 */
public class Mensajes_emergentes {
    
    private ArrayList lista;

    public Mensajes_emergentes() {
        this.lista = new ArrayList();
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
    
    public void add(Object lista) {
        this.lista.add(lista);
    }
    
    public void clear() {
        this.lista.clear();
    }
    
    public void Mostrar_mensajes (int id ){
        
        switch (id){
            case 1:
                 JOptionPane.showMessageDialog(null, "El camion "+ lista.get(0)+" - "+lista.get(1)+" posee 1 o más servicios que deben realizarse","Advertencia", JOptionPane.WARNING_MESSAGE);
                 break;
            case 2:
                 JOptionPane.showMessageDialog(null, "El servicio "+ lista.get(0)+ " no tiene ningun proveedor asociado.","Advertencia", JOptionPane.WARNING_MESSAGE);
                 break;
            case 3:
                JOptionPane.showMessageDialog(null, "Necesita realizar un pedido de algunos productos del inventario.","Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            
        }
        
    }
    
}
