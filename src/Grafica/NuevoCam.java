/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class NuevoCam extends javax.swing.JFrame {

    private Serviciosasociados serv;
    private Statement st = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public NuevoCam() throws SQLException {
        initComponents();
        this.setTitle("Crear un nuevo camión.");
        serv = new Serviciosasociados();
        conexion();
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
        Editarbtn = new java.awt.Button();
        Asociarbtn = new java.awt.Button();
        CrearCamionbtn = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        Jdate = new com.toedter.calendar.JDateChooser();

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

        jLabel1.setText("Servicios");

        Editarbtn.setActionCommand("Editar");
        Editarbtn.setLabel("Editar");
        Editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarbtnActionPerformed(evt);
            }
        });

        Asociarbtn.setActionCommand("Asociarbtn");
        Asociarbtn.setLabel("Asociar Servicios");
        Asociarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsociarbtnActionPerformed(evt);
            }
        });

        CrearCamionbtn.setActionCommand("Crearcamionbtn");
        CrearCamionbtn.setLabel("Crear Camión");
        CrearCamionbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCamionbtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(CrearCamionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Editarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                            .addComponent(Asociarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Kilometrajespin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Model)
                    .addComponent(Modelotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Placa)
                    .addComponent(Placatext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Asociarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Editarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearCamionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        Modelotext.getAccessibleContext().setAccessibleName("Modelo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conexion (){
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
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st  = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void EditarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarbtnActionPerformed
       
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
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st  = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }

        Button btn = new Button("Aceptar.");
        btn.setBounds(100, 280, 100, 30);
        this.add(btn);
        this.getContentPane().remove(Editarbtn);
        this.getContentPane().remove(CrearCamionbtn);
         final String Pl, Ml;
         Pl = Placatext.getText();
         Ml = Modelotext.getText();
         
        try {
            rs= st.executeQuery("SELECT * FROM automovil WHERE Placa = '"+ Pl + "'  AND Model = '" + Ml + "' ; ");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while (rs.next()){
                Chofertext.setText(rs.getString("Chofer"));
                Kilometrajespin.setValue (rs.getInt("Km"));
                SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
                Jdate.setDate(rs.getDate("FechaCompra"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                   Statement st = null;
        Connection con = null;
         ResultSet rs = null;
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
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st  = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                try {
                    st.execute("UPDATE automovil"
                            + " SET Placa = '" + Placatext.getText() + "' , Model = '" + Modelotext.getText() + "' , "
                            + "Chofer = '" + Chofertext.getText() + "' , Km = " + Kilometrajespin.getValue()
                            + " WHERE Placa = '"+ Pl +"' AND Model = '"+ Ml + "' ; ");
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
            dispose();
            
            }
            
        });
        /*
       
        */ // TODO add your handling code here:
    }//GEN-LAST:event_EditarbtnActionPerformed

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
            st.execute("INSERT INTO automovil VALUES ('"+camion[0]+"','"+camion[1]+"','"
                    +camion[2]+"',"+camion[3]+",'"+camion[4]+"') ; ");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " +
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
                serv.AgregarServicioCamionNuevo(Placatext.getText(), Modelotext.getText(), (int) Kilometrajespin.getValue(), Jdate.getDate() );
                serv.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                    }        // TODO add your handling code here:
              
              
      
              
              
         }else{   
        
            try {
                serv.setFlag(false);
                serv.AgregarServicioCamion(Placatext.getText(), Modelotext.getText());
                serv.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                    }        // TODO add your handling code here:
        
         }
          
          
       }
       
       
    }//GEN-LAST:event_AsociarbtnActionPerformed

    private void CrearCamionbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCamionbtnActionPerformed
        
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
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st  = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        int cont =0;
        try {
            rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio" +
                    " FROM tipo_servicio_has_automovil as ta"+
                    " WHERE ta.Automovil_Placa = '"+ Placatext.getText()  +"' AND ta.Automovil_Model = '"+ Modelotext.getText() +"' ; ");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (cont = 0; rs.next();cont++);
        } catch (SQLException ex) {
            Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (cont>0){
             dispose();
             cont = 0;
         }else
             JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun servicio" ,"Mensaje Plano", JOptionPane.ERROR_MESSAGE);
            
    }//GEN-LAST:event_CrearCamionbtnActionPerformed

    private void ModelotextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelotextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelotextActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
                    new NuevoCam().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Asociarbtn;
    private javax.swing.JLabel Chofer;
    private javax.swing.JTextField Chofertext;
    private java.awt.Button CrearCamionbtn;
    private java.awt.Button Editarbtn;
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JLabel Kilometraje;
    private javax.swing.JSpinner Kilometrajespin;
    private javax.swing.JLabel Model;
    private javax.swing.JTextField Modelotext;
    private javax.swing.JLabel Placa;
    private javax.swing.JTextField Placatext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
