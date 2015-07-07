/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import Objetos.manejador_bd;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class NuevoProducto extends javax.swing.JFrame {

    /**
     * Creates new form NuevoCam
     */
    

    private static manejador_bd BD;
    private ResultSet rs = null;
    private boolean acept = true; 
    private int idproducto ;
    private  static ArrayList lista_servicios_asociados = new ArrayList(); 
    public NuevoProducto() {
        initComponents();
        this.setTitle("Crear un nuevo producto.");
        this.getContentPane().remove(Aceptar);
        java.util.Date date = new Date();
        
        try {
            Fecha.setDate(date);
            date = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-0001");
            Vencimiento_Date.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        
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
         BD.con = DriverManager.getConnection("jdbc:mysql://localhost/servi_cam", "root", "");
     } catch (SQLException ex) {
         Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         BD.st  = BD.con.createStatement();
     } catch (SQLException ex) {
         Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
     }
     
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
        button1 = new java.awt.Button();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Producto = new javax.swing.JLabel();
        Marca = new javax.swing.JLabel();
        Costo = new javax.swing.JLabel();
        Kilometraje = new javax.swing.JLabel();
        Productotext = new javax.swing.JTextField();
        Marcatext = new javax.swing.JTextField();
        Costotext = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        CantidadSpinner = new javax.swing.JSpinner();
        ServicioLabel = new javax.swing.JLabel();
        SugeridoSpin = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DuracionSpinner = new javax.swing.JSpinner();
        FechaLb = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        Vencimiento_Date = new com.toedter.calendar.JDateChooser();
        jRadioButton4 = new javax.swing.JRadioButton();
        Aceptar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Crear = new javax.swing.JButton();
        AgregarServicio = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField3.setText("jTextField3");

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Producto.setText("Producto");

        Marca.setText("Marca");

        Costo.setText("Costo");

        Kilometraje.setText("Cantidad");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Días");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Meses");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Km's");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        ServicioLabel.setText("Servicios");

        jLabel2.setText("Sugerido");

        jLabel3.setText("Duración");

        FechaLb.setText("Fecha");

        jLabel1.setText("Vencimiento");

        Vencimiento_Date.setMinSelectableDate(new java.util.Date(-62135749709000L));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Litros");

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });

        AgregarServicio.setText("Agregar servicio");
        AgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarServicioActionPerformed(evt);
            }
        });

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Producto)
                            .addComponent(Marca)
                            .addComponent(Costo)
                            .addComponent(FechaLb)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Kilometraje)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DuracionSpinner)
                                .addComponent(SugeridoSpin, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CantidadSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Vencimiento_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Productotext)
                                .addComponent(Marcatext)
                                .addComponent(Costotext, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ServicioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AgregarServicio)
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Editar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Producto)
                    .addComponent(Productotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Marca)
                    .addComponent(Marcatext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Costo)
                    .addComponent(Costotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FechaLb)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(Vencimiento_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Kilometraje))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SugeridoSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(DuracionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServicioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarServicio))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Crear)
                    .addComponent(Agregar)
                    .addComponent(Editar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Salir)
                    .addComponent(Eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Productotext.getAccessibleContext().setAccessibleName("Modelo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void AgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarServicioActionPerformed
      
        Serviciosasociados servi;
        try {
            servi = new Serviciosasociados();
            System.out.println("id : " + idproducto);
            
            if ((!Productotext.getText().equals("") && !Marcatext.getText().equals(""))  ){               
               lista_servicios_asociados  = servi.AgregarProducto(idproducto,Productotext.getText(), Marcatext.getText(), lista_servicios_asociados );
                servi.setVisible(true);
            }else{
                 JOptionPane.showMessageDialog(null, "Los campos 'Producto' y 'Marca' no pueden estar vacios. "  ,"Informacion", JOptionPane.WARNING_MESSAGE);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_AgregarServicioActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
         int cont = 0;  
        try {
            rs = BD.st.executeQuery("select count(Inventario_Producto) " +
                                    "FROM inventario_has_tipo_servicio " +
                                    "WHERE Inventario_Producto = '"+Productotext.getText()+"' AND Inventario_Marca = '"+Marcatext.getText()+"' ;");
            rs.beforeFirst();
            for (; rs.next();cont++);
            if (cont>0)
                dispose();
            
            else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_CrearActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
       
        
            if (!Productotext.getText().equals("")){
                if (!Marcatext.getText().equals("")){
                   if (!Costotext.getText().equals("")){
                       if ((int) DuracionSpinner.getValue() >= 0){

                        if ((int) CantidadSpinner.getValue() >= 0){

                            Object producto [] = new Object [8];


                           producto [0]= Productotext.getText();
                           producto [1]= Marcatext.getText();
                           producto [2]= Integer.parseInt(Costotext.getText());
                           producto [3] = (int) CantidadSpinner.getValue();
                           producto [4] =DuracionSpinner.getValue().toString();
                           producto [5] =SugeridoSpin.getValue();
                           SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
                           producto [6] = formato.format(Fecha.getDate());
                           producto [7] = formato.format(Vencimiento_Date.getDate());
                           if (jRadioButton1.isSelected()){
                               producto [4] = producto [4] + " Dias";
                           }else{

                                if (jRadioButton2.isSelected()){
                                    producto [4] = producto [4] + " Meses";
                                }else{
                                        if (jRadioButton3.isSelected()){
                                            producto [4] = producto [4] + " Km";
                                        }else{
                                            if (jRadioButton4.isSelected()){
                                             producto [4] = producto [4] + " Litros";
                                        }
                                        }
                                }
                           }


                                System.out.println(Marcatext.getText());

                          if (acept){      
                            try {
                                BD.st.execute("SET SQL_SAFE_UPDATES = 0;" );
                                BD.st.execute("UPDATE  Inventario SET  Producto = '"+(String)producto[0]+"' ,Marca = '"+(String)producto[1]+"', Costo =  "+(int)producto[2]+" , "
                                        +" Cantidad = "+(int) producto[3]+" , Duracion = '"+(String)producto[4]+"' , Sugerido = '"+(int)producto[5]+"' , Fecha = '"+producto[6]+"', "
                                        +" Vencimiento = '"+producto[7]+"' "
                                        +" WHERE Producto = '"+(String)producto[0]+"' AND Marca = '"+(String)producto[1]+"' and Fecha = '"+producto[6]+"' ;" );
                            } catch (SQLException ex) {
                                Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            dispose();
                            
                          }else{
                              
                                try {
                                    System.out.println("Entre a donde debo");
                                    rs=BD.st.executeQuery("SELECT *  FROM Inventario "
                                            + "WHERE Producto = '"+ Productotext.getText()+"' AND Marca = '"+Marcatext.getText() +"' ;");
                                    rs.beforeFirst();
                                    if(rs.next()){
                                        System.out.println("rs.getInt(\"Inventario_id\") : " + rs.getInt("id") );
                                        BD.st.execute("insert into historico_inventario (Inventario_id, Inventario_Producto, Inventario_Marca, Costo, Cantidad, Sugerido,Duracion, Fecha, Vencimiento) "
                                            + " values ( "+rs.getInt("id")+", '"+rs.getString("Producto")+"' , '"+rs.getString("Marca")+"' , "+rs.getFloat("Costo")+", "
                                            + " "+rs.getFloat("Cantidad")+", "+rs.getInt("Sugerido")+",'"+rs.getInt("Duracion")+"' , '"+rs.getDate("Fecha")+"', '"+rs.getDate("Vencimiento")+"' );" );
                              
                                    }
                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                
                                
                                try {
                                BD.st.execute("SET SQL_SAFE_UPDATES = 0;" );
                                BD.st.execute("UPDATE  Inventario SET  Producto = '"+(String)producto[0]+"' ,Marca = '"+(String)producto[1]+"', Costo =  "+(int)producto[2]+" , "
                                        +" Cantidad = "+(int) producto[3]+" , Duracion = '"+(String)producto[4]+"' , Sugerido = '"+(int)producto[5]+"' , Fecha = '"+producto[6]+"', "
                                        +" Vencimiento = '"+producto[7]+"' "
                                        +" WHERE Producto = '"+(String)producto[0]+"' AND Marca = '"+(String)producto[1]+"' and Fecha = '"+producto[6]+"' ;" );
                            } catch (SQLException ex) {
                                Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                
                          }
                            
                          
                          
                            this.add(Crear);
                            this.add(Editar);
                            this.add(Agregar);
                            this.getContentPane().remove(Aceptar);
                            repaint();
                            dispose();
                           }else{
                            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
                        }   
                        }else{
                            JOptionPane.showMessageDialog(null, "La duración debe ser mayor a 0. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar un costo. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El campo 'Marca' no puede estar vacío. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
                }
           }else{
               JOptionPane.showMessageDialog(null, "El campo 'Producto' no puede estar vacío. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
           }
            
            
       
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       rellenar();
       acept = true;
       
    }//GEN-LAST:event_EditarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
  
        if (!Productotext.getText().equals("") && !Marcatext.getText().equals("") ){
            
            if(!lista_servicios_asociados.isEmpty()){
                int idinv = 0 ;
                SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");

                Iterator iterador_de_lista  = lista_servicios_asociados.iterator();
                try {
                    BD.st.execute("INSERT INTO `servi_cam`.`inventario` (`Producto`, `Marca`, `Costo`, "
                            + "`Cantidad`, `Duracion`, `Sugerido`, `Fecha`, `Vencimiento`) "
                            + "VALUES ('"+ Productotext.getText()+"', '"+ Marcatext.getText()+"', '"+ Costotext.getText()+"', "
                            + " '"+ CantidadSpinner.getValue()+"', '"+ DuracionSpinner.getValue()+"', '"+ SugeridoSpin.getValue()+"', "
                            + " '"+ formato.format(Fecha.getDate())+"', '"+ formato.format(Vencimiento_Date.getDate())+"');");
                    
                    rs = BD.st.executeQuery("select last_insert_id(); ");

                    rs.beforeFirst();



                    if (rs.next()){
                        idinv = rs.getInt("id");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                }


                if (idinv != 0){
                    while(iterador_de_lista.hasNext()){
                        try {
                            BD.st.execute("INSERT INTO Inventario_has_Tipo_Servicio"
                                    + " VALUES ( "+idinv+" , '"+ Producto+"' , '"+ Marca+"' , "+iterador_de_lista.next()+" );");
                        } catch (SQLException ex) {
                            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
                
                JOptionPane.showMessageDialog(null, "El producto fue agregado BD.con exito. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 servicio. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos 'Producto' y 'Marca' no pueden estar vacios. " ,"Informacion", JOptionPane.WARNING_MESSAGE);
        }
        
       acept = false;
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try {
            BD.st.execute("DELETE FROM `servi_cam`.`inventario` WHERE `Producto`='"+Productotext.getText()+"' and`Marca`='"+Marcatext.getText()+"' ;");
        } catch (SQLException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    
    public void rellenar (){
        
          System.out.println("entre a rellenar.");
        
           if (!Productotext.getText().equals("")){
            if (!Marcatext.getText().equals("")){
              
       if ( Productotext.getText()!= null & Marcatext.getText()!= null ){
           
           System.out.println("entre a rellenar.");
           

                      


            System.out.println(Productotext.getText());
            System.out.println(Marcatext.getText());

           try {
               rs=BD.st.executeQuery("SELECT *  FROM Inventario "
                       + "WHERE Producto = '"+ Productotext.getText()+"' AND Marca = '"+Marcatext.getText() +"' ;");
               
               
               rs.beforeFirst();
               

                      if (rs.next()){
                       
                                this.getContentPane().remove(Crear);
                                this.getContentPane().remove(Editar);
                                this.Aceptar.setBounds(this.Agregar.getBounds());
                                this.getContentPane().remove(Agregar);
                                this.add(Aceptar);
                                repaint();
                                idproducto = rs.getInt("id");
                                Costotext.setText(Integer.toString(rs.getInt("Costo")));
                                CantidadSpinner.setValue(rs.getInt("Cantidad"));
                                String palabra = rs.getString("Duracion");
                                Fecha.setDate(rs.getDate("Fecha"));
                                Vencimiento_Date.setDate(rs.getDate("Vencimiento"));
                                int posicion = palabra.indexOf(" ");
                                System.out.println(posicion);
                                DuracionSpinner.setValue(Integer.parseInt(palabra.substring(0 , posicion)));
                                System.out.println(palabra.substring(0 , posicion));
                                palabra = palabra.substring(posicion+1);
                                if (palabra.equals("Dias")){
                                    jRadioButton1.setSelected(true);
                                }else{
                                    if (palabra.equals("Meses")){
                                        jRadioButton2.setSelected(true);
                                    }else{
                                        if (palabra.equals("Km")){
                                            jRadioButton3.setSelected(true);
                                        }else {
                                            if (palabra.equals("Litros")){
                                            jRadioButton4.setSelected(true);
                                            }
                                        }
                                    }
                                }
                    
                                
                          
                            }
                            else{
                                    JOptionPane.showMessageDialog(null, "El producto no existe en el inventario. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);

               }
           } catch (SQLException ex) {
               Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
           }



       }

    }else{
    JOptionPane.showMessageDialog(null, "El campo 'Marca' no puede estar vacío. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    }else{
    JOptionPane.showMessageDialog(null, "El campo 'Producto' no puede estar vacío. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    
    
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
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new NuevoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton AgregarServicio;
    private javax.swing.JSpinner CantidadSpinner;
    private javax.swing.JLabel Costo;
    private javax.swing.JTextField Costotext;
    private javax.swing.JButton Crear;
    private javax.swing.JSpinner DuracionSpinner;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JLabel FechaLb;
    private javax.swing.JLabel Kilometraje;
    private javax.swing.JLabel Marca;
    private javax.swing.JTextField Marcatext;
    private javax.swing.JLabel Producto;
    private javax.swing.JTextField Productotext;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel ServicioLabel;
    private javax.swing.JSpinner SugeridoSpin;
    private com.toedter.calendar.JDateChooser Vencimiento_Date;
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
