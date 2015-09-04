/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yanir
 */
public class Mensajes_emergentes {
    
    ArrayList lista;

    public Mensajes_emergentes() {
        
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
            
    public void Mostrar_mensajes (int id ){
        
        switch (id){
            case 1:
                 JOptionPane.showMessageDialog(null, "El camion "+ lista.get(0)+" - "+lista.get(1)+" posee 1 o más servicios que deben realizarse","Advertencia", JOptionPane.WARNING_MESSAGE);
                 break;
        }
        
    }
    
}
