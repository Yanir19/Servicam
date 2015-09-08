/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import Clases.manejador_bd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class NuevoCam extends javax.swing.JFrame {

    private final Serviciosasociados serv;
    private ResultSet rs = null;
    private static manejador_bd BD;
    private  static ArrayList lista_servicios_asociados = new ArrayList(); 
    
    public NuevoCam() throws SQLException {
        initComponents();
        this.setTitle("Crear un nuevo camión.");
        serv = new Serviciosasociados();
        BD = new manejador_bd();
        getContentPane().remove(atrasbtn);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        Model = new javax.swing.JLabel();
        Placa = new javax.swing.JLabel();
        Chofer = new javax.swing.JLabel();
        Kilometraje = new javax.swing.JLabel();
        Modelotext = new javax.swing.JTextField();
        Placatext = new javax.swing.JTextField();
        Chofertext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Kilometrajespin = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        Jdate = new com.toedter.calendar.JDateChooser();
        salirbtn = new javax.swing.JButton();
        CrearCamionbtn = new javax.swing.JButton();
        Editarbtn = new javax.swing.JButton();
        Asociarbtn = new javax.swing.JButton();
        atrasbtn = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Model.setText("Modelo");

        Placa.setText("Placa");

        Chofer.setText("Chofer");

        Kilometraje.setText("Kilometraje");

        Modelotext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelotextActionPerformed(evt);
            }
        });

        Chofertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChofertextActionPerformed(evt);
            }
        });

        jLabel1.setText("Servicios");

        jLabel2.setText("Fecha");

        salirbtn.setText("Salir");
        salirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirbtnActionPerformed(evt);
            }
        });

        CrearCamionbtn.setText("Crear Camión");
        CrearCamionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCamionbtnActionPerformed(evt);
            }
        });

        Editarbtn.setText("Editar");
        Editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarbtnActionPerformed(evt);
            }
        });

        Asociarbtn.setText("Asociar servicios");
        Asociarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsociarbtnActionPerformed(evt);
            }
        });

        atrasbtn.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Model)
                            .addComponent(Placa)
                            .addComponent(Chofer)
                            .addComponent(Kilometraje)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Modelotext, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(Placatext)
                            .addComponent(Chofertext)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Asociarbtn)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Kilometrajespin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CrearCamionbtn)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(atrasbtn)))
                        .addGap(18, 18, 18)
                        .addComponent(Editarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(salirbtn)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Placa)
                    .addComponent(Placatext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Model)
                    .addComponent(Modelotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Chofer)
                    .addComponent(Chofertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kilometraje)
                    .addComponent(Kilometrajespin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Asociarbtn))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearCamionbtn)
                    .addComponent(salirbtn)
                    .addComponent(Editarbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atrasbtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Modelotext.getAccessibleContext().setAccessibleName("Modelo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ModelotextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelotextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelotextActionPerformed

    private void CrearCamionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCamionbtnActionPerformed
             
        
           boolean flag = false;
        Object camion [] = new Object [5];
        camion [0]= Placatext.getText();
        camion [1]= Modelotext.getText();
        camion [2]= Chofertext.getText();
        camion [3] =Kilometrajespin.getValue();
        
        
        if ( !camion [0].equals("") ){
           if(!camion [1].equals("")){
               if( (int)camion [3] >= 0){   
                   if(Jdate.getDate()!= null){   
                       SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
                       camion [4] = formato.format(Jdate.getDate());
                       flag =true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El campo 'Fecha' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }     
                }else{
                    JOptionPane.showMessageDialog(null, "El campo 'Kilometraje' no puede ser negativo " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                }     
            }else{
                JOptionPane.showMessageDialog(null, "El campo 'Modelo' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
            }     
        }else{
            JOptionPane.showMessageDialog(null, " El campo 'Placa' no puede estar vacío" ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        
       if (flag){
      
       
       int cont = 0 ;
       int i = 0;
        try {
            manejador_bd.st.execute("INSERT INTO automovil VALUES ('"+camion[0]+"','"+camion[1]+"','"
                    +camion[2]+"',"+camion[3]+",'"+camion[4]+"') ; ");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        try {
            Asociar_camion_con_servicios();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
      
              JOptionPane.showMessageDialog(null, "Su camión fue creado exitosamente. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
       }

    }//GEN-LAST:event_CrearCamionbtnActionPerformed

    private void EditarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarbtnActionPerformed
    
        
        final String Pl;
        Pl = Placatext.getText();
         
        try {
            rs= manejador_bd.st.executeQuery("SELECT * FROM automovil WHERE Placa = '"+ Pl + "' ; ");
            rs.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(rs.next()){
                
                JButton btn = new JButton("Aceptar");
               
                btn.setBounds(Editarbtn.getBounds());
                this.add(btn);
                this.getContentPane().remove(Editarbtn);
                this.getContentPane().remove(CrearCamionbtn);
                repaint();
                
                Modelotext.setText(rs.getString("Model"));
                Chofertext.setText(rs.getString("Chofer"));
                Kilometrajespin.setValue (rs.getInt("Km"));
                SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
                Jdate.setDate(rs.getDate("FechaCompra"));

                btn.addActionListener( new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        try {
                            Asociar_camion_con_servicios();
                            manejador_bd.st.execute("UPDATE automovil"
                                    + " SET Placa = '" + Placatext.getText() + "' , Model = '" + Modelotext.getText() + "' , "
                                    + "Chofer = '" + Chofertext.getText() + "' , Km = " + Kilometrajespin.getValue()
                                    + " WHERE Placa = '"+ Pl +"' AND Model = '"+ Modelotext.getText() + "' ; ");
                            JOptionPane.showMessageDialog(null, "Los datos del camion fueron actualizados con éxito." ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } catch (SQLException ex) {
                              JOptionPane.showMessageDialog(null, "Codigo de error : " + ex.getErrorCode()  + " \n " + ex  + "\n" + 
                                      "Clase: NuevoCam " + "\n" +  "Método: AceptaractionPerformed ()" ,"Error.", JOptionPane.ERROR_MESSAGE);   
                               Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        
                        }
                        
                        
                    }
                    
                });
                
            }else{
                JOptionPane.showMessageDialog(null, "La placa ingresada no existe en la base de datos." ,"Informacion", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_EditarbtnActionPerformed

    @SuppressWarnings("empty-statement")
    private void AsociarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsociarbtnActionPerformed
           boolean flag = false;
        Object camion [] = new Object [5];
        camion [0]= Placatext.getText();
        camion [1]= Modelotext.getText();
        camion [2]= Chofertext.getText();
        camion [3] =Kilometrajespin.getValue();
        
        
        if ( !camion [1].equals("") ){
           if(!camion [0].equals("")){
               if( (int)camion [3] >= 0){   
                   if(Jdate.getDate()!= null){   
                       SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
                       camion [4] = formato.format(Jdate.getDate());
                       flag =true;
            }else{
                JOptionPane.showMessageDialog(null, "El campo 'Fecha' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
           }     
            }else{
                JOptionPane.showMessageDialog(null, "El campo 'Kilometraje' no puede ser negativo " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
           }     
            }else{
                JOptionPane.showMessageDialog(null, "El campo 'Placa' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
           }     
        }else{
            JOptionPane.showMessageDialog(null, "El campo 'Modelo' no puede estar vacío " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        
       if (flag){
      
       
       int cont = 0 ;
        
        try {
            rs=manejador_bd.st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " +
                    " FROM tipo_servicio, automovil ,tipo_servicio_has_automovil as ta"+
                    " WHERE ta.Automovil_Placa = '"+ camion [0] +"' AND ta.Automovil_Model = '"+ camion [1] +"' AND idTipo_Servicio  = ta.Tipo_Servicio_idTipo_Servicio; ");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.beforeFirst();
            for (cont = 0; rs.next(); cont++);
           
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          if (cont ==0 ){
              try {
  
                serv.setFlag(false);
                lista_servicios_asociados = serv.AgregarServicioCamionNuevo(Placatext.getText(),lista_servicios_asociados );
                serv.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                    }        // TODO add your handling code here:
              
              
      
              
              
         }else{   
        
            try {
                serv.setFlag(false);
                    lista_servicios_asociados =  serv.AgregarServicioCamion(Placatext.getText(), lista_servicios_asociados);
                serv.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                    }        // TODO add your handling code here:
        
         }
          
          
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_AsociarbtnActionPerformed

    private void salirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbtnActionPerformed
     dispose();
    }//GEN-LAST:event_salirbtnActionPerformed

    private void ChofertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChofertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChofertextActionPerformed

  private void  Asociar_camion_con_servicios () throws SQLException{
        
    for (int i = 0; i+2 <=  lista_servicios_asociados.size(); i+=3 ){
            
        switch ((int)lista_servicios_asociados.get(i)) {

            case 1:
                manejador_bd.st.execute("INSERT INTO tipo_servicio_has_automovil"
                                    + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Tiempo)"
                                    + " VALUES ("+lista_servicios_asociados.get(i+1)+",'"+Placatext.getText()+"','"+Modelotext.getText()+"' ,'"+ lista_servicios_asociados.get(i+2) +"');");
                break;

            case 2:
                manejador_bd.st.execute("INSERT INTO tipo_servicio_has_automovil"
                                + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Km)"
                                + " VALUES ("+lista_servicios_asociados.get(i+1)+",'"+Placatext.getText()+"','"+Modelotext.getText()+"' ,"+ lista_servicios_asociados.get(i+2) +");");
                break;

            case 3:
                
                manejador_bd.st.execute("UPDATE tipo_servicio_has_automovil"
                                    + " SET Km = '" + lista_servicios_asociados.get(i+2) + "', Tiempo = NULL "
                                    + " WHERE Automovil_Placa = '"+ Placatext.getText() +"' AND Automovil_Model = '"+ Modelotext.getText() +"' AND Tipo_Servicio_idTipo_Servicio = '" +lista_servicios_asociados.get(i+1) +"'; ");

                break;

            case 4:
                manejador_bd.st.execute("UPDATE tipo_servicio_has_automovil"
                                    + " SET Tiempo = '" + lista_servicios_asociados.get(i+2) + "' , Km = NULL"
                                    + " WHERE Automovil_Placa = '"+ Placatext.getText() +"' AND Automovil_Model = '"+ Modelotext.getText()+"' AND Tipo_Servicio_idTipo_Servicio = '" +lista_servicios_asociados.get(i+1) +"'; ");
                break;
        }
        
    }
    
    lista_servicios_asociados.clear();

}


    /**
     * @param args the command line arguments
     */
        
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
                    new NuevoCam().setVisible(true);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Asociarbtn;
    private javax.swing.JLabel Chofer;
    private javax.swing.JTextField Chofertext;
    private javax.swing.JButton CrearCamionbtn;
    private javax.swing.JButton Editarbtn;
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JLabel Kilometraje;
    private javax.swing.JSpinner Kilometrajespin;
    private javax.swing.JLabel Model;
    private javax.swing.JTextField Modelotext;
    private javax.swing.JLabel Placa;
    private javax.swing.JTextField Placatext;
    private javax.swing.JButton atrasbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton salirbtn;
    // End of variables declaration//GEN-END:variables
}
