/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/**
 *
 * @author Yanir
 */
public class servicios_camion {
    
    public JCheckBox servicio;
    public JCheckBox habilitar_duracion;
    public JLabel descripcion_servicio;
    public JSpinner cantidad;
    public JComboBox unidades ;

    public servicios_camion() {
        servicio = new JCheckBox();
        habilitar_duracion = new JCheckBox ();
        descripcion_servicio  = new JLabel ();
        cantidad  = new JSpinner ();
        unidades  = new JComboBox ();
       
        
    }
    
    
}
