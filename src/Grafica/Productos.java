/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

import Clases.manejador_bd;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    private JCheckBox checkBox[];
    private JLabel producto [];
    private int acumlador;
    private JSpinner contador [];
    private static manejador_bd BD;
    private ResultSet rs = null;
    private Boolean invent_cont = new Boolean(false);
    private Object producto1 [] [];
    private int aux;
    private int valor [];
    private int id [];
    private int f;
  
    
    
    
    public Productos() throws SQLException {
       initComponents();
       this.setTitle("Productos.");
       BD = new manejador_bd();
            
    }

    
    
    public Boolean getInvent_cont() {
        return invent_cont;
    }
    
    public void SetProducto (int idTipoServicio ) throws SQLException{
        
        Panel pn = new Panel ();
        invent_cont = false;
        
     
            System.out.println("idTipoServicio : "  + idTipoServicio);
            
               rs=BD.st.executeQuery( " SELECT Distinct Producto , Marca  " +
                                    "FROM tipo_servicio ,inventario_has_tipo_servicio as ta, Inventario " +
                                    "WHERE   tipo_servicio.idTipo_Servicio = "+idTipoServicio+" AND ta.Tipo_Servicio_idTipo_Servicio = tipo_servicio.idTipo_Servicio " +
                                    "AND Producto=  ta.Inventario_Producto and Marca =  ta.Inventario_Marca ;");
                               
            rs.beforeFirst();
            int i=0;
            
            for (;rs.next();i++);
            acumlador = i;
            
            System.out.println(" i : " + i);
            
            this.producto = new JLabel [i] ;
            this.contador = new JSpinner [i];
            this.checkBox = new JCheckBox [i] ;
            producto1 = new Object[i][2];
            
              rs=BD.st.executeQuery( " SELECT Distinct Producto , Marca, cantidad, duracion " +
                                    "FROM tipo_servicio ,inventario_has_tipo_servicio as ta, Inventario " +
                                    "WHERE   tipo_servicio.idTipo_Servicio = "+idTipoServicio+" AND ta.Tipo_Servicio_idTipo_Servicio = tipo_servicio.idTipo_Servicio " +
                                    "AND Producto =  ta.Inventario_Producto and Marca =  ta.Inventario_Marca ;");
                               
            rs.beforeFirst();
            
            
               for(i = 0 ; rs.next(); i ++)
                {
                    producto [i] = new JLabel(rs.getString("Producto") + " - " + rs.getString("Marca"));
                    producto1 [i] [0] = rs.getInt("cantidad");
                    producto1 [i] [1] = rs.getString("duracion");
                }
               
               int y=20;
                      
               for (int j=0; j<i;j++){
                   this.checkBox [j]= new JCheckBox();
                   this.checkBox [j].setBounds(20, y, 30, 30);
                   this.producto[j].setBounds(50, y, 300, 30);
                   pn.add(this.checkBox[j]);
                   pn.add(this.producto[j]);
                   this.contador [j] = new JSpinner();
                   this.contador [j].setBounds(330, y, 40, 30);
                   pn.add(this.contador[j]);
                   y+=50;
               }
               
               
               JButton btn = new JButton ("Agregar");
                btn.setBounds(30, y+20, 100, 30);
                pn.add(btn);
                
                ScrollPane scrollpane = new ScrollPane();
                scrollpane.add(pn);
                pn.setLayout(new BorderLayout());
                pn.setPreferredSize(new Dimension(390 , y+50));
                System.out.println(y);
                scrollpane.setPreferredSize(new Dimension(390 , y+50));
                System.out.println(scrollpane.getPreferredSize());
      
                this.setLayout(new BorderLayout());
                this.add(scrollpane);
                f= i;
                
                btn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0 ;i < f;i++)
                            if (checkBox [i].isSelected())
                                invent_cont = true;
                        setVisible(false);
                        
                    }
                        
                        
                    
            });
                
           
            
    }
    
   public ArrayList GetProductos (){
        
        ArrayList lista = new ArrayList ();
        String palabra = null;
        for (int i = 0 ; i<acumlador; i++){
            if (checkBox[i].isSelected()){
                
                lista.add( (int) producto1 [i][0]);
                System.out.println("index : " + producto[i].getText().indexOf(" - "));
                lista.add(palabra= producto[i].getText().substring(0,producto[i].getText().indexOf(" - ")+1));
                System.out.println("Prodcuto : " + palabra);
                lista.add(palabra = producto[i].getText().substring(producto[i].getText().indexOf(" - ")+3));
                System.out.println("Marca : " + palabra);
                lista.add(contador[i].getValue());
                System.out.println("Cantidad : " + contador[i].getValue());
                        
            }
        }
        
        
        return lista ;
    }
    
public void insertar (final int idServicio){
        
                    
System.out.println("entre a Productos.insertar");

    float diferencia = 0 ;
    int posicion=0; 
    int litros = 0;
    String duracion;
    float cantidad = 0;

    for (int k=0; k<f;k++){
        if (checkBox[k].isSelected()== true){
            System.out.println("producto : " + producto [k].getText() );
            posicion = producto [k].getText().indexOf(" - ");
            System.out.println(" producto1[k][1].toString() :" + producto1[k][1].toString());
            duracion = producto1[k][1].toString();
            litros = duracion.indexOf("litros");
            System.out.println("litros : " + litros);
            
              System.out.println("litros : " + litros);  


                if(litros>0){
                    cantidad = Integer.parseInt(producto1[k][1].toString().substring(0 , litros));
                    System.out.println("cantidad : " +cantidad);
                    System.out.println(" contador : " + (int)contador [k].getValue());
                    diferencia = ( (int) contador [k].getValue()/cantidad);
                    System.out.println("diferencia : " +diferencia);
                }else{
                    diferencia = (int) contador [k].getValue();
                }


                try {
                    System.out.println("diferencia :" + diferencia );
                    BD.st.execute("UPDATE Inventario SET Cantidad = Cantidad - "+ diferencia + " "+
                     " WHERE Producto = '"+producto [k].getText().substring(0,posicion) +"' and Marca =  '"+ producto [k].getText().substring(posicion+3)+"' ;");
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                     BD.st.execute("INSERT INTO servi_cam.inventario_has_servicios  "
                        + " VALUES ('"+producto [k].getText().substring(0,posicion)+"','"+ producto [k].getText().substring(posicion+3) +"' "
                             + ", "+idServicio+", "+ diferencia+" ) ;");
                    } catch (SQLException ex) {
                        Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println("Inserte los datos en inventario_has_servicios ");
            }   
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

        panel2 = new java.awt.Panel();
        label1 = new java.awt.Label();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
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
    private java.awt.Label label1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
