/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Grafica.Cam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanir
 */



public class manejador_bd {
    
    public static Statement st = null; 
    public static Connection con = null;

    public manejador_bd() throws SQLException {
        try {
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");

        st  = con.createStatement();
    }
    
   
    
}
