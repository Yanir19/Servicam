/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import Objetos.manejador_bd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class NuevoPro extends javax.swing.JFrame {

    /**
     * Creates new form NuevoCam
     */
    
    private static manejador_bd BD;
   
    
    
    public NuevoPro() throws SQLException {
        initComponents();
        this.setTitle("Crear un nuevo proveedor.");
        BD = new manejador_bd();
    }
    
    public void editar (){
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Razons = new javax.swing.JLabel();
        Rif = new javax.swing.JLabel();
        Tlf1 = new javax.swing.JLabel();
        Tlf2 = new javax.swing.JLabel();
        RazonsText = new javax.swing.JTextField();
        RifText = new javax.swing.JTextField();
        Tlf1text = new javax.swing.JTextField();
        Tlf2Text = new javax.swing.JTextField();
        Crepro = new javax.swing.JToggleButton();
        Fax = new javax.swing.JLabel();
        Faxtext = new javax.swing.JTextField();
        Persona = new javax.swing.JLabel();
        personatext = new javax.swing.JTextField();
        direccion = new javax.swing.JLabel();
        Direcciontext = new javax.swing.JTextField();
        Servicio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Razons.setText("Razón Social.");

        Rif.setText("Rif.");

        Tlf1.setText("Teléfono 1.");

        Tlf2.setText("Teléfono 2.");

        RazonsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RazonsTextActionPerformed(evt);
            }
        });

        RifText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RifTextActionPerformed(evt);
            }
        });

        Crepro.setText("Crear Proveedor");
        Crepro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreproMouseClicked(evt);
            }
        });
        Crepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreproActionPerformed(evt);
            }
        });

        Fax.setText("Fax.");

        Faxtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FaxtextActionPerformed(evt);
            }
        });

        Persona.setText("Persona de contacto.");

        personatext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personatextActionPerformed(evt);
            }
        });

        direccion.setText("Dirección.");

        Servicio.setText("Servicio.");

        jButton1.setText("Agregar servicios.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Razons, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rif, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RifText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RazonsText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tlf1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(Tlf1text, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Crepro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Fax, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tlf2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Faxtext, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(Tlf2Text, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Direcciontext, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2))
                                .addComponent(personatext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Razons, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RazonsText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rif, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RifText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tlf1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tlf1text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tlf2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tlf2Text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fax)
                    .addComponent(Faxtext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Persona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personatext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion)
                    .addComponent(Direcciontext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Servicio))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(Crepro)
                .addGap(25, 25, 25))
        );

        RazonsText.getAccessibleContext().setAccessibleName("Modelo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreproMouseClicked
           
        
        int cont = 0;
        ResultSet rs = null;
        
       
        try {
            rs=BD.st.executeQuery( " SELECT * " +
                    " FROM tipo_servicio_has_proveedor"+
                    " WHERE Proveedor_Rif = '"+ RifText.getText()  +"' ; ");
            rs.beforeFirst();
            for(cont = 0; rs.next(); cont++ );
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         System.out.println("Cont = " + cont);
         if (cont>0){
             dispose();
             cont = 0;
         }else
             JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun servicio" ,"Mensaje Plano", JOptionPane.ERROR_MESSAGE);
            
                   
       
    }//GEN-LAST:event_CreproMouseClicked

    private void FaxtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FaxtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FaxtextActionPerformed

    private void RazonsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RazonsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RazonsTextActionPerformed

    private void personatextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personatextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personatextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       Object Proveedor [] = new Object [9];
        ResultSet rs = null;

                        Proveedor [0] = RifText.getText();
                        Proveedor [1] = RazonsText.getText();
                        Proveedor [2] = Tlf1text.getText();
                        Proveedor [3] = Tlf2Text.getText();
                        Proveedor [4] = Faxtext.getText();
                        Proveedor [5] = personatext.getText();
                        Proveedor [6] = Direcciontext.getText();
                        
       if (!Proveedor [0].equals("")){
           if (!RazonsText.getText().equals("")){
               if (!Tlf1text.getText().equals("")){
                   if (!Direcciontext.getText().equals("")){
                      

                         try {

                             BD.st.execute("INSERT INTO proveedor VALUES ('"+Proveedor[0]+"','"+Proveedor[1]+"','"
                                     +Proveedor[6]+"','"+Proveedor[4]+"','"+Proveedor[3]+"','"
                                     +Proveedor[2]+"','"+Proveedor[5]+"')");
                         } catch (SQLException ex) {
                            if (ex.getErrorCode() == 1062) 
                             JOptionPane.showMessageDialog(null, "Este proveedor ya existe. " ,"Informacion", JOptionPane.ERROR_MESSAGE);    
                         }



                         try {
                             Serviciosasociados serv = new Serviciosasociados();
                             serv.AgregarServicioProveedor( RifText.getText(), RazonsText.getText());
                             serv.setVisible(true);
                         } catch (SQLException ex) {
                             Logger.getLogger(NuevoPro.class.getName()).log(Level.SEVERE, null, ex);
                         }
                       
                       
                    }else{
                        JOptionPane.showMessageDialog(null, "El campo 'Dirección' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El campo 'Teléfono 1' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "El campo 'Razón Social' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
       }else{
           JOptionPane.showMessageDialog(null, "El campo 'Rif' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
       }
           
       
       
       
      
        
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RifTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RifTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RifTextActionPerformed

    private void CreproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreproActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new NuevoPro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Crepro;
    private javax.swing.JTextField Direcciontext;
    private javax.swing.JLabel Fax;
    private javax.swing.JTextField Faxtext;
    private javax.swing.JLabel Persona;
    private javax.swing.JLabel Razons;
    private javax.swing.JTextField RazonsText;
    private javax.swing.JLabel Rif;
    private javax.swing.JTextField RifText;
    private javax.swing.JLabel Servicio;
    private javax.swing.JLabel Tlf1;
    private javax.swing.JTextField Tlf1text;
    private javax.swing.JLabel Tlf2;
    private javax.swing.JTextField Tlf2Text;
    private javax.swing.JLabel direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField personatext;
    // End of variables declaration//GEN-END:variables
}
