/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import Clases.manejador_bd;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import java.sql.*;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Yanir
 */


public class Cam extends javax.swing.JFrame {

    /**
     * Creates new form Cam
     */
    
    
    private JTabbedPane pestana = new JTabbedPane();
    private static manejador_bd BD; 
    
    
    
    
    public Cam() throws ClassNotFoundException, InstantiationException, SQLException {
        initComponents();
        
        this.setTitle("Camiones.");
        this.setExtendedState(MAXIMIZED_BOTH);   
        this.setMinimumSize(new Dimension(800, 600)); 
        BD = new manejador_bd();
        Object[][] data;      
        ResultSet rs = null;
        int i=0;
        int aux=0;
        
        rs = BD.st.executeQuery("SELECT * FROM automovil");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamano = tk.getScreenSize();
        pestana.setPreferredSize(new Dimension(tamano));
       
        
        while (rs.next())
        {
            i++;
        }
        
        aux=i;
        i=0;
        data = new Object [aux] [4];
        rs.beforeFirst();
        
        while (rs.next())
        {
            data [i][0]= rs.getString("placa");
            data [i][1]= rs.getString("Model");
            data [i][2]= rs.getString("chofer");
            data [i][3] = rs.getInt("Km");
            i++;
        }


        rs.close();
  
        Panelcam[] panel = new Panelcam [aux];
        
        for (i=0; i!=aux;i++){
          
          System.out.println("Km en Cam : " + (int) data[i][3] );  
          panel [i] = new Panelcam(data,i);
          panel [i].setSize(new Dimension(300, 300));
          panel [i].setMaximumSize(new Dimension(300, 300));
          panel [i].setMinimumSize(new Dimension(300, 300));
          pestana.addTab ((String) data[i][1], panel[i]);
        }
        
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setPreferredSize(new Dimension(tamano));
        scrollpane.setMaximumSize(new Dimension(300, 300));
        scrollpane.setMinimumSize(new Dimension(300, 300));
        scrollpane.add(pestana);

        this.setLayout(new BorderLayout());
        this.setContentPane(scrollpane);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new Cam().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Cam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


}
