/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Panel;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import static javax.swing.UIManager.getString;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class Serviciosasociados extends javax.swing.JFrame {

    /**
     * Creates new form Serviciosasociados
     */
    
    private JButton btn = new JButton ("Agregar");
    private Panel pane = new Panel();
    private Statement st = null;
    private Connection con = null;
    private ResultSet rs = null;
    public boolean bandera =false;
    
    
    public boolean getFlag() {
        return bandera;
    }

    public void setFlag( boolean  flag) {
        this.bandera = flag;
        
    }
   
    public Serviciosasociados() throws SQLException {
        initComponents();
        this.setTitle("Servicios asociados."); 
    }
    
    public void  AgregarProducto (final int idinv , final String Producto, final String Marca) throws SQLException{
        
        Statement st = null; 
        Connection con = null;
        int cont =0;
        
        System.out.println("Prodcuto : " + Producto);
        System.out.println("Marca : " + Marca);
        
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
            
                
            
            ResultSet rs = null;
            
            
                             rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " + 
                                    " FROM tipo_servicio ,Inventario_has_Tipo_Servicio as ta"+
                                    " WHERE ta.Inventario_Producto = '"+ Producto  +"' and  ta.Inventario_Marca = '"+ Marca  +"' AND idTipo_Servicio  = ta.Tipo_Servicio_idTipo_Servicio; ");
                            
                            rs.beforeFirst();
                             for (cont = 0; rs.next(); cont++);
                                 
                            
                            final Object id2 [] [] = new Object [4] [cont];
                            
                            
                               rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " + 
                                    " FROM tipo_servicio , Inventario_has_Tipo_Servicio as ta"+
                                    " WHERE ta.Inventario_Producto = '"+ Producto  +"' and  ta.Inventario_Marca = '"+ Marca  +"' AND idTipo_Servicio  = ta.Tipo_Servicio_idTipo_Servicio; ");
                               
                            rs.beforeFirst();
                            
                             for (cont = 0; rs.next(); cont++){
                                 
                                 id2[0][cont] = rs.getInt("Tipo_Servicio_idTipo_Servicio");
                                 id2[1][cont] = rs.getString("Descripcion");
                                 
                             }
                          
                             
                             final int aux = cont;
                             
                              rs=st.executeQuery("SELECT Descripcion FROM tipo_servicio ;");
                              rs.beforeFirst();
                              
                              cont = 0;
                              
                            while (rs.next())
                            {
                             cont++;
                            }

                            final  JCheckBox checkBox[] = new JCheckBox [cont] ;
                            final  JLabel tipo [] = new JLabel [cont];
                            final int id []= new int [cont];
                            
                            
                             rs=st.executeQuery("SELECT idTipo_Servicio, Descripcion FROM tipo_servicio ;");
                                rs.beforeFirst();

                            int y= 20;
                            
                            for (int i =0;rs.next();i++ )
                            {

                                tipo [i] = new JLabel (rs.getString("Descripcion"));
                                 id [i] = rs.getInt("idTipo_Servicio");
                                tipo [i].setBounds(50,y, 200, 30);
                                this.add(tipo [i]);
                                 
                                checkBox[i] = new JCheckBox () ;
                                checkBox [i].setBounds(20,y, 20, 30);
                                this.add(checkBox[i]);
                                
                                
                                if(aux>0){
                                if (id[i] <=  (int) id2[0][aux-1]){
                                    for (int k = 0; k<aux; k++){
                                        if (id [i] == (int ) id2[0][k]){
                                           checkBox [i].setSelected(true);
                                        }
                                                  
                                    }
                                }
                                }
                                
                                y+=30;
                                
                            }
                            
                            final int f= cont;

                            
                           
                          
                             
                            btn.setBounds(150, y+20, 100, 30);
                            this.add(btn);

          
                            btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Statement st = null; 
                            Connection con = null;


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
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            try {
                                st  = con.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            boolean flag2 = false;
                            int flag = 0;
                            System.out.println("Esto es F " + f);
                                    for (int j=0; j<f; j++ ){
                                       System.out.println("Esto es J " + j);
                                        if ( checkBox[j].isSelected() ){
                                            flag = 1;
                                            System.out.println("Entre por aqui ");
                                           if (aux > 0){
                                            if (id[j] <=  (int) id2[0][aux-1]){
                                                for (int k = 0; k<aux; k++){
                                                    if (id [j] == (int ) id2[0][k]){
                                                        flag = 2 ;
                                                               
                                                    }
                                                  
                                                }
                                            
                                        }else{
                                            flag  = 0;
                                             System.out.println("Estoy entrando aqui ");
                                        }
                                        }   
                                        }
                                  
                                        System.out.println("Este es flag : " + flag);
                                            if (flag == 1){
                                                    
                                                flag2= true;
                                                try {
                                                    System.out.println("id : " + idinv);
                                                    System.out.println("Producto : " + Producto);
                                                    System.out.println("Marca : " + Marca );
                                                    st.execute("INSERT INTO Inventario_has_Tipo_Servicio"
                                                            + " VALUES ( "+idinv+" , '"+ Producto+"' , '"+ Marca+"' , "+id[j]+" );");
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                
                                            }else{
                                                    
                                                if (flag == 0){
                                                    try {
                                                        st.execute(" DELETE FROM servi_cam.Inventario_has_Tipo_Servicio"
                                                                + " WHERE Tipo_Servicio_idTipo_Servicio = "+id[j]+ " and Inventario_Producto  = '"+ Producto +"' and  Inventario_Marca = '"+ Marca  +"' ;");

                                                    } catch (SQLException ex) {
                                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }   
                                            }
                                 }
                                    
                            if (flag2)
                            dispose();
                            else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 tipo de servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        
                    });
                            
            
   }
    
    
    public void AgregarServicioCamion (final String Placa, final String Modelo) throws SQLException{
         
        Statement st = null; 
        Connection con = null;
        int cont =0;
        
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
            
                
            
            ResultSet rs = null;
            
                        rs=st.executeQuery("SELECT Descripcion FROM tipo_servicio ;");
                         rs.beforeFirst();

                            while (rs.next())
                            {
                             cont++;
                            }


                    final  JCheckBox checkBox[] = new JCheckBox [cont] ;
                    final  JLabel tipo [] = new JLabel [cont];
                    final JSpinner spin [] = new JSpinner [cont];
                    final JComboBox combo [] = new JComboBox[cont];
                    final int id []= new int [cont];
                     rs=st.executeQuery("SELECT idTipo_Servicio, Descripcion FROM tipo_servicio ;");
                        rs.beforeFirst();

                            int y= 20;
                            
                            for (int i =0;rs.next();i++ )
                            {

                                tipo [i] = new JLabel (rs.getString("Descripcion"));
                                id [i] = rs.getInt("idTipo_Servicio");
                                tipo [i].setBounds(50,y, 200, 30);
                                this.add(tipo [i]);
                                checkBox[i] = new JCheckBox () ;
                                checkBox [i].setBounds(20,y, 20, 30);
                                this.add(checkBox[i]);
                                spin [i] = new JSpinner ();
                                spin [i].setBounds(230 , y, 80, 30);
                                this.add(spin [i]);
                                combo [i] = new JComboBox ();
                                combo [i].addItem("Días");
                                combo [i].addItem("Meses");
                                combo [i].addItem("Km");
                                combo [i].setBounds(320, y, 100, 30);
                                this.add(combo [i]);
                                y+=30;
                            }
                            
                            final int f= cont;

                            
                            rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " + 
                                    " FROM tipo_servicio, automovil ,tipo_servicio_has_automovil as ta"+
                                    " WHERE ta.Automovil_Placa = '"+ Placa +"' AND ta.Automovil_Model = '"+ Modelo +"' AND idTipo_Servicio  = ta.Tipo_Servicio_idTipo_Servicio; ");
                            
                            rs.beforeFirst();
                             for (cont = 0; rs.next(); cont++);
                                 
                            
                            final Object id2 [] [] = new Object [4] [cont];
                            
                            
                            rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion, Tiempo, ta.Km " + 
                                    " FROM tipo_servicio, automovil ,tipo_servicio_has_automovil as ta"+
                                    " WHERE ta.Automovil_Placa = '"+ Placa +"' AND ta.Automovil_Model = '"+ Modelo +"' AND idTipo_Servicio  = ta.Tipo_Servicio_idTipo_Servicio; ");
                            
                            rs.beforeFirst();
                            
                             for (cont = 0; rs.next(); cont++){
                                 
                                 id2[0][cont] = rs.getInt("Tipo_Servicio_idTipo_Servicio");
                                 id2[1][cont] = rs.getString("Descripcion");
                                 id2[2][cont] = rs.getString("Tiempo");
                                 id2[3][cont] = rs.getInt("Km");
                                 
                             }
                             
                             final int aux = cont;
                             System.out.println("esto es lo que tiene aux :" + aux);
                            
                           
                           int index = 0;
                           if (aux > 0){
                                for (int i =0; i< f ;i++ ){  

                                    if (id[i] <=  (int) id2[0][aux-1]){
                                        for (int j = 0; j<aux; j++){
                                            if (id [i] == (int ) id2[0][j]){
                                                System.out.println("entre");
                                                checkBox [i].setSelected(true);

                                                if ( (int) id2[3][j]  > 0){
                                                     spin [i].setValue((int) id2[3][j]);
                                                     combo [i].setSelectedItem("Km");
                                                }else{
                                                    System.out.println(id2[2][j]);
                                                   index =  id2[2][j].toString().indexOf(" Días"); 

                                                   if (index >0){
                                                       System.out.println(id2[2][j].toString().substring(0, index).toString());
                                                       spin [i].setValue(Integer.parseInt(id2[2][j].toString().substring(0, index).toString()));  

                                                       combo [i].setSelectedItem("Días");  
                                                       index = 0;
                                                    }else{

                                                       index = id2[2][j].toString().indexOf(" Meses"); 

                                                       spin [i].setValue( Integer.parseInt(id2[2][j].toString().substring(0, index).toString()));
                                                       combo [i].setSelectedItem("Meses");   
                                                       index = 0;
                                                   }
                                                }
                                            }
                                        }
                                    }
                                }
                           }
                            
                            
                            
                            btn.setBounds(150, y+20, 100, 30);
                            this.add(btn);

          
                            btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Statement st = null; 
                            Connection con = null;


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
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            try {
                                st  = con.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            boolean flag2 = false;
                            int flag = 0;
                            System.out.println("f : " + f);
                                    String tiempo = "";
                                    for (int j=0; j<f; j++ ){
                                       
                                        if ( checkBox[j].isSelected() ){
                                            tiempo = spin[j].getValue().toString() + " " + combo [j].getSelectedItem();
                                             flag = 1;
                                            if (aux >0){
                                            if (id[j] <=  (int) id2[0][aux-1] ){
                                                for (int k = 0; k<aux; k++){
                                                    if (id [j] == (int ) id2[0][k]){
                                                        
                                                        if(combo [j].getSelectedItem().equals("Días") || combo [j].getSelectedItem().equals("Meses")){
                                                            
                                                             if (!tiempo.equals( id2[2][k]) ){ 
                                                                flag = 3;
                                                            }else{
                                                                  flag = 4;
                                                             }
                                                        }else{
                                                            if( (int) spin[j].getValue() != (int) id2[3] [k]){
                                                                flag = 2;
                                                                System.out.println("active flag 2");
                                                            }else{
                                                                flag = 4;
                                                                System.out.println("active flag 4");
                                                            }
                                                                
                                                        }
                                                       
                                                            
                                                    }
                                                  
                                                }
                                            }
                                            }
                                        }else{
                                            flag  = 0;
                                        }
                                        
                                    
                                            
                                            if(flag >= 1){
                                                flag2=true;
                                                System.out.println("Flag 1: " + flag);
                                                
                                                if (flag == 1){
                                                    setFlag(true);
                                                    System.out.println("entre a flag 1  y no deberia");
                                                    try {
                                                        if (combo [j].getSelectedItem() == "Días" || combo [j].getSelectedItem() == "Meses"){
                                                        System.out.println(j);
                                                            System.out.println("hablame");
                                                        st.execute("INSERT INTO tipo_servicio_has_automovil"
                                                                + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Tiempo)"
                                                                + " VALUES ("+id[j]+",'"+Placa+"','"+Modelo+"' ,'"+ tiempo +"');");
                                                
                                                        }else{
                                                            st.execute("INSERT INTO tipo_servicio_has_automovil"
                                                                + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Km)"
                                                                + " VALUES ("+id[j]+",'"+Placa+"','"+Modelo+"' ,'"+ (int) spin[j].getValue()+"');");
                                                           
                                                        }
                                                    } catch (SQLException ex) {
                                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }else{
                                                    if (flag ==2){
                                                        try {
                                                            st.execute("UPDATE tipo_servicio_has_automovil"
                                                                    + " SET Km = '" + (int) spin[j].getValue() + "', Tiempo = NULL "
                                                                    + " WHERE Automovil_Placa = '"+ Placa +"' AND Automovil_Model = '"+ Modelo +"' AND Tipo_Servicio_idTipo_Servicio = '" +id [j] +"'; ");
                                                         
                                                        } catch (SQLException ex) {
                                                            Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                        
                                                    }else{
                                                        
                                                        if (flag == 3){
                                                            
                                                                  try {
                                                            st.execute("UPDATE tipo_servicio_has_automovil"
                                                                    + " SET Tiempo = '" + tiempo + "' , Km = NULL"
                                                                    + " WHERE Automovil_Placa = '"+ Placa +"' AND Automovil_Model = '"+ Modelo +"' AND Tipo_Servicio_idTipo_Servicio = '" +id [j] +"'; ");
                                                            st.close();
                                                        } catch (SQLException ex) {
                                                            Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                        }
                                                                
                                                    }
                                                    
                                                    
                                                    }
                                                
                                                
                                            }else {
                                        
                                                try {
                                                    st.execute(" DELETE FROM servi_cam.tipo_servicio_has_automovil"
                                                            + " WHERE Tipo_Servicio_idTipo_Servicio ='"+id[j]+ "' and Automovil_Placa = '"+ Placa +"' AND Automovil_Model = '"+ Modelo +"';");
                                                  
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                    }

                            if (flag2)
                            dispose();
                            else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 tipo de servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                            
            
      
            }
     
    public void AgregarServicioCamionNuevo (final String Placa, final String Modelo ,  final int Km, final Date fecha ) throws SQLException{
        
        Statement st = null; 
        Connection con = null;
        int cont =0;
        
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
            
                
            
            ResultSet rs = null;
            
                        rs=st.executeQuery("SELECT Descripcion FROM tipo_servicio ;");
                         rs.beforeFirst();

                            while (rs.next())
                            {
                             cont++;
                            }

                    final int f = cont;        
                    final  JCheckBox checkBox[] = new JCheckBox [cont] ;
                    final  JLabel tipo [] = new JLabel [cont];
                    final JSpinner spin [] = new JSpinner [cont];
                    final JComboBox combo [] = new JComboBox[cont];
                    final int id []= new int [cont];
                     rs=st.executeQuery("SELECT idTipo_Servicio, Descripcion FROM tipo_servicio ;");
                        rs.beforeFirst();

                            int y= 20;
                            
                            for (int i =0;rs.next();i++ )
                            {

                                tipo [i] = new JLabel (rs.getString("Descripcion"));
                                id [i] = rs.getInt("idTipo_Servicio");
                                tipo [i].setBounds(50,y, 200, 30);
                                this.add(tipo [i]);
                                checkBox[i] = new JCheckBox () ;
                                checkBox [i].setBounds(20,y, 20, 30);
                                this.add(checkBox[i]);
                                spin [i] = new JSpinner ();
                                spin [i].setBounds(230 , y, 80, 30);
                                this.add(spin [i]);
                                combo [i] = new JComboBox ();
                                combo [i].addItem("Días");
                                combo [i].addItem("Meses");
                                combo [i].addItem("Km");
                                combo [i].setBounds(320, y, 100, 30);
                                this.add(combo [i]);
                                y+=30;
                            }
                            
                              
                    
                            btn.setBounds(150, y+20, 100, 30);
                            this.add(btn);

          
                            btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Statement st = null; 
                            Connection con = null;
                            

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
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            try {
                                st  = con.createStatement();
                            } catch (SQLException ex) {
                                Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            boolean flag2 = false;
                            int flag = 0;
                            System.out.println("f : " + f);
                                    String tiempo = "";
                                    for (int j=0; j<f; j++ ){
                                       
                                        if ( checkBox[j].isSelected() ){
                                            tiempo = spin[j].getValue().toString() + " " + combo [j].getSelectedItem();
                                             flag = 1;
                                            
                                        }else{
                                            flag  = 0;
                                        }
                                        
                                    
                                            
                                            if(flag == 1){
                                            
                                                System.out.println("Flag 1: " + flag);
                                                flag2=true;
                                                if (flag == 1){
                                                    
                                                    try {
                                                        if (combo [j].getSelectedItem() == "Días" || combo [j].getSelectedItem() == "Meses"){
                                                        st.execute("INSERT INTO tipo_servicio_has_automovil"
                                                                + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Tiempo)"
                                                                + " VALUES ("+id[j]+",'"+Placa+"','"+Modelo+"' ,'"+ tiempo +"');");
                                                               
                                                        }else{
                                                            st.execute("INSERT INTO tipo_servicio_has_automovil"
                                                                + "  (Tipo_Servicio_idTipo_Servicio,Automovil_Placa, Automovil_Model, Km)"
                                                                + " VALUES ("+id[j]+",'"+Placa+"','"+Modelo+"' ,'"+ (int) spin[j].getValue()+"');");
                                                                
                                                        }
                                                    } catch (SQLException ex) {
                                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }
                                                   
                                                
                                                
                                            }
                                    }

                                    
                                    
                            if (flag2){        
                                ResultSet rs = null;
                                int cont = 0;

                                SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
                                System.out.println(Placa);
                                System.out.println(Modelo);
                                try {
                                    rs = st.executeQuery("SELECT Tipo_Servicio_idTipo_Servicio " +
                                                          " FROM Tipo_Servicio_has_automovil AS ta " +
                                                          " WHERE ta.Automovil_Placa = '"+Placa+"' AND ta.Automovil_Model = '"+Modelo+"'  ;" );
                                     rs.beforeFirst();
                                      for (;rs.next();cont++);


                                } catch (SQLException ex) {
                                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                    Object id2 [] = new Object[cont];
                                    System.out.println("Esto es cont : " + cont);
                                try {
                                     rs = st.executeQuery("SELECT Tipo_Servicio_idTipo_Servicio " +
                                                          " FROM Tipo_Servicio_has_automovil AS ta " +
                                                          " WHERE ta.Automovil_Placa = '"+Placa+"' AND ta.Automovil_Model = '"+Modelo+"'  ;" );
                                    rs.beforeFirst();

                                       for(int i = 0; rs.next();i++)
                                       id2[i] = rs.getInt("Tipo_Servicio_idTipo_Servicio");

                                       for (int i = 0; i<cont ; i++)
                                      st.execute("INSERT INTO Servicios (Fecha,Costo,Km, Detalle) VALUES ('"+formato.format(fecha)+"', 0 ,'"+ Km +"' , ' ') ;");

                                } catch (SQLException ex) {
                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                }



                                    int i = 0;
                                    try {
                                        rs = st.executeQuery("SELECT idServicios FROM servicios "
                                                + " WHERE fecha = '"+formato.format(fecha)+"' AND costo = 0 AND Km = '"+Km+"' ;");
                                        rs.beforeFirst();
                                        while (rs.next())
                                        i++;
                                    } catch (SQLException ex) {
                                       
                                    }


                                 Object [] data = new Object[i];


                                try {
                                      rs = st.executeQuery("SELECT idServicios FROM servicios "
                                                + " WHERE fecha = '"+formato.format(fecha)+"' AND costo = 0 AND Km = '"+Km+"' ;");
                                    for (i=0 ; rs.next(); i++)
                                        data [i] = rs.getInt("idServicios");
                                } catch (SQLException ex) {
                                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                int aux = i;

                                try {
                                    for ( i=0 ; i < aux; i++){
                                        System.out.println("data : " + data [i]);
                                        System.out.println("id 2 : " + id2 [i]);
                                        st.execute("INSERT INTO servicios_has_automovil "
                                                + "VALUES ('"+data [i] +"','"+Placa+"','" +Modelo+"')");
                                        st.execute("INSERT INTO servicios_has_tipo_servicio "
                                                + "VALUES ('"+data [i] +"','"+id2 [i]+"')");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(NuevoCam.class.getName()).log(Level.SEVERE, null, ex);
                                }



                            
                                dispose();
                            }else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 tipo de servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }

                        }
                        
                        
                    });
                            
                            
       
                            
    }
    
    
    public void AgregarServicioProveedor (final String Rif, final String Razon_Social) throws SQLException{
        
        Statement st = null; 
        Connection con = null;
        int cont =0;
        
        
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
            
                
            
            ResultSet rs = null;
            

            //Creamos un scrollpanel y se lo agregamos a la tabla 
            JScrollPane scrollpane = new JScrollPane();

            //Agregamos el scrollpanel al contenedor 
            getContentPane().add(scrollpane, BorderLayout.CENTER);


        
                        rs=st.executeQuery("SELECT Descripcion FROM tipo_servicio ;");
                         rs.beforeFirst();

                            while (rs.next())
                            {
                             cont++;
                            }


                    final  JCheckBox checkBox[] = new JCheckBox [cont] ;
                    final  JLabel tipo [] = new JLabel [cont];
                    final int id [] = new int[cont];
                     rs=st.executeQuery("SELECT Descripcion, idTipo_Servicio FROM tipo_servicio ;");
                        rs.beforeFirst();

                            int y= 20;
                            for (int i =0;rs.next();i++ )
                            {

                                tipo [i] = new JLabel (rs.getString("Descripcion"));
                                tipo [i].setBounds(50,y, 500, 30);
                                id [i] = rs.getInt("idTipo_Servicio");
                                this.add(tipo [i]);
                                checkBox[i] = new JCheckBox () ;
                                checkBox [i].setBounds(20,y, 20, 30);
                                this.add(checkBox[i]);
                                y+=30;
                            }

                            btn.setBounds(30, y+20, 100, 30);
                            this.add(btn);

                            final int f= cont;

                            btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Statement st = null; 
                            Connection con = null;


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
                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    try {
                                        st  = con.createStatement();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    boolean flag = false;
                                    for (int j=1 ; j<=f; j++ ){
                                        if ( checkBox[j-1].isSelected() ){
                                                try {
                                                    System.out.println(Rif);
                                                    System.out.println(j);
                                                    st.execute("INSERT INTO Tipo_Servicio_has_Proveedor VALUES ("+id[j-1]+",'"+Rif+"', '"+Razon_Social+"' ) ; ");
                                                    flag = true;
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                        }
                                    }
                            if (flag)
                            dispose();
                            else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 tipo de servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
                            
            
        
        
        
    }
    
    public void EditarServicioProveedor (final String Rif, final String Razon_Social) throws SQLException{
        
          Statement st = null; 
        Connection con = null;
        int cont =0;
        
        
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
            
                
            
            ResultSet rs = null;
            
        
          
                cont=0;
                rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " + 
                                    " FROM tipo_servicio, proveedor,tipo_servicio_has_proveedor as tp"+
                                    " WHERE tp.Proveedor_Rif = '"+ Rif +"' AND idTipo_Servicio  = tp.Tipo_Servicio_idTipo_Servicio ;");
                    rs.beforeFirst();
                    final Object [] servicios;
                    final Object [] [] servicios2;
                    while (rs.next())
                    {
                        cont++;
                    }
                    System.out.println(Rif);
                    final int aux = cont;
                    servicios = new Object [cont];

                
                    cont=0;
                     rs=st.executeQuery( " SELECT Distinct Tipo_Servicio_idTipo_Servicio, Descripcion " + 
                                    " FROM tipo_servicio, proveedor,tipo_servicio_has_proveedor as tp"+
                                    " WHERE tp.Proveedor_Rif = '"+ Rif +"' AND idTipo_Servicio  = tp.Tipo_Servicio_idTipo_Servicio; ");
                     rs.beforeFirst();
                     
                        while (rs.next())
                    {   
                       System.out.println( servicios [cont] = rs.getInt("Tipo_Servicio_idTipo_Servicio"));
                        cont++;
                    }
                            
                            
                    rs=st.executeQuery("SELECT Distinct Descripcion, idTipo_Servicio FROM tipo_servicio ;");
                    rs.beforeFirst();
                    cont=0;
                     while (rs.next())
                    {
                        cont++;
                    }
                     
                     final int f= cont;
                     
                    servicios2 = new Object [2] [cont];
                    final JCheckBox checkBox[] = new JCheckBox [cont] ;
                    final JLabel tipo [] = new JLabel [cont]; 
                     
                    rs=st.executeQuery("SELECT Descripcion, idTipo_Servicio FROM tipo_servicio ;");
                    rs.beforeFirst();
                    
                    int y= 20;
                        for(int i =0 ; rs.next(); i++)
                        {

                            servicios2 [0] [i] =rs.getString("Descripcion");
                            servicios2 [1] [i] = rs.getInt("idTipo_Servicio");
                            tipo [i] = new JLabel ((String) servicios2 [0] [i]);
                            tipo [i].setBounds(50,y, 500, 30);
                            this.add(tipo [i]);
                            checkBox[i] = new JCheckBox () ;
                            checkBox [i].setBounds(20,y, 20, 30);
                            
                            for (int j=0 ; j<aux ; j++){
                         
                                if (servicios [j] == servicios2 [1] [i]){
                                   
                                    checkBox [i].setSelected(true);

                                }
                            }
                            this.add(checkBox[i]);
                            y+=30;
                        }
                            
                            
                        
                        btn.setBounds(30, y+20, 100, 30);
                            this.add(btn);

                            

                            btn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Statement st = null; 
                            Connection con = null;


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
                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    try {
                                        st  = con.createStatement();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    
                                    int flag = 1;
                                    int flag2 = 1;
                                    
                                    
                                    
                                       
                                    for (int j=0 ; j<f; j++ ){
                                        if ( checkBox[j].isSelected() ){
                                            flag2 = 0;
                                        }
                                    }
                                    if (flag2 == 0){       
                                           
                                    
                                    for (int j=0 ; j<f; j++ ){
                                        if ( checkBox[j].isSelected() ){
                                            System.out.println("j: " + j );
                                            System.out.println("f: " + f );
                                            System.out.println(servicios2 [1] [j]);
                                            System.out.println( servicios [aux-1]);
                                           
                                            
                                            
                                            if ((int) servicios2 [1] [j] <= (int) servicios [aux-1]){
                                                 
                                                for (int k=0; k<aux ; k++){
                                                    System.out.println("Id servicios: " + servicios [k]  );
                                                    System.out.println("Id servicios2: " + servicios2 [1] [j]);
                                                    if ( (int) servicios [k] == (int) servicios2 [1] [j]){
                                                        System.out.println("entre al if que quieres");
                                                        flag = 0;
                                                     }
                                                } 
                                            }   
                                            
                                                         if (flag == 1){
                                                                 try {
                                                                    System.out.println(Rif);
                                                                    System.out.println(j);
                                                                    st.execute("INSERT INTO Tipo_Servicio_has_Proveedor VALUES ("+ (int) servicios2 [1] [j] +",'"+Rif+"', '"+Razon_Social+"' )");
                                                                } catch (SQLException ex) {
                                                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                         }else{
                                                             flag = 1;
                                                         }
                                                        
                                                    
                                                
                                            
                                            
                                        
                                        
                                        }else {
                                            
                                              if ((int) servicios2 [1] [j] <= (int) servicios [aux-1]){
                                                for (int k=0; k<aux ; k++){
                                                    
                                                    if ( (int) servicios [k] == (int) servicios2 [1] [j]){
                                                        flag = 0;
                                                     }
                                                } 
                                            }   
                                            
                                                         if (flag == 0){
                                                                try {
                                                                    st.execute(" DELETE FROM servi_cam.tipo_servicio_has_proveedor"
                                                                            + " WHERE Tipo_Servicio_idTipo_Servicio ='"+(int) servicios2 [1] [j]+ "' and Proveedor_Rif ='"+ Rif +"';");
                                                                } catch (SQLException ex) {
                                                                    Logger.getLogger(Serviciosasociados.class.getName()).log(Level.SEVERE, null, ex);
                                                                }
                                                         }else{
                                                             flag = 1;
                                                         }

                                        }
                                        
                                    }   
                                         
                                     
                                     dispose();
                                    }else {
                                        JOptionPane.showMessageDialog(null, "Debe seleccionar al menos 1 tipo de servicio. " ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    

                        }
                        
                    });

                
    
    
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(Serviciosasociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Serviciosasociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Serviciosasociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Serviciosasociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
