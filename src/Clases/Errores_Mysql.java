/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yanir
 */
public class Errores_Mysql {
    
   
    
    public void Manejador_codigo_error (SQLException ex ){
        
        StackTraceElement[] trace = ex.getStackTrace(); 
        
        switch (ex.getErrorCode()){
            case 1265:
                JOptionPane.showMessageDialog(null, "Codigo de error : " + ex.getErrorCode()  + " \n " + ex  + " \n "  
                                                                             + trace[9].toString()+ " \n " + "Posible solución: " + 
                                                                             "Intente utilizar . como separador de decimales en el campo de 'costo'."  ,"Error.", JOptionPane.ERROR_MESSAGE);
                break;
            case 1062:
                JOptionPane.showMessageDialog(null, "Codigo de error : " + ex.getErrorCode()  + " \n " + ex  + " \n "  
                                                                     + "Este elemento ya existe en la base de datos." ,"Error.", JOptionPane.ERROR_MESSAGE);    
                break;
        }
        
    }
    
    
}
