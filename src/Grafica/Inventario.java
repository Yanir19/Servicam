/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Objetos.manejador_bd;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yanir
 */
public class Inventario extends javax.swing.JFrame {
     private String producto;
     private String marca;
     private ResultSet rs = null;
     private static manejador_bd BD;
     
     
    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * Creates new form Inventario2
     */
    
    
    
    
    
    public Inventario() throws SQLException {
       this.setTitle("Inventario.");
       this.setMinimumSize(new Dimension(800, 600)); 
       initComponents();
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       BD = new manejador_bd();
       
        Inventario_total();
     
    }

    
    
    
    public void Inventario_total () throws SQLException {
        
        int i=0;
        Object data [][];
        Panel.removeAll();
        rs = BD.st.executeQuery("select count(*) as cantidad from inventario ; ");
        
        while (rs.next())
        {
          i = rs.getInt("cantidad");
        }

  
        data = new Object [i] [9];
        
        rs = BD.st.executeQuery("select * , (Cantidad - Sugerido) as total from inventario ; ");    
        rs.beforeFirst();

        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        i=0;
            while (rs.next())
            {   
                data [i][0]=rs.getString("Producto");
                data [i][1]= rs.getString("Marca");
                data [i][2]= rs.getString("Costo");
                data [i][3]= rs.getString("Duracion");
                data [i][4]= rs.getString("Cantidad");   
                data [i][5]= rs.getInt("Sugerido"); 
                data [i][6]= rs.getInt("total"); 
                data [i][7]= formato.format(rs.getDate("fecha")); 
                data [i][8]= formato.format(rs.getDate("vencimiento")); 
                i++;
            }
            rs.close();

        
        String[] columnNames = {"Tipo.","Marca.","Costo.",
            "Duración.", "Cantidad.", "Mínimo sugerido.", "Cantidad mínima." 
            , "Fecha de compra.", "Fecha de vencimiento."};
        DefaultTableModel dtm= new DefaultTableModel(data,columnNames);
        final JTable table = new JTable(dtm){
                          public boolean isCellEditable (int row, int column)
                            {
                                return false;
                            }
                    }; 
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));

        //Creamos un scrollpanel y se lo agregamos a la tabla 
        JScrollPane scrollpane = new JScrollPane(table);
        Panel.add(scrollpane);
        repaint();    
        this.setVisible(true);
        
    }
    
    public void historial () throws SQLException{
           Object data [][];
          int i = 0;
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Panel.removeAll();
        rs = BD.st.executeQuery("select count(*) as cantidad from historico_inventario ; ");
        
        while (rs.next())
        {
          i = rs.getInt("cantidad");
        }

  
        data = new Object [i] [9];
        
        rs = BD.st.executeQuery("select * , (Cantidad - Sugerido) as total from historico_inventario " +
                             "where Inventario_Producto = '"+producto+"' and Inventario_Marca = '"+marca+"'  ; ");    
        rs.beforeFirst();

        
        
        i=0;
              while (rs.next())
            {   
                data [i][0]=rs.getString("Inventario_Producto");
                data [i][1]= rs.getString("Inventario_Marca");
                data [i][2]= rs.getString("Costo");
                data [i][3]= rs.getString("Duracion");
                data [i][4]= rs.getString("Cantidad");   
                data [i][5]= rs.getInt("Sugerido"); 
                data [i][6]= rs.getInt("total"); 
                data [i][7]= formato.format(rs.getDate("fecha")); 
                data [i][8]= formato.format(rs.getDate("vencimiento")); 
                i++;
            }
            rs.close();

        
       
        rs.close();
        repaint();
         String[] columnNames = {"Tipo.","Marca.","Costo.",
            "Duración.", "Cantidad.", "Mínimo sugerido.", "Cantidad mínima." 
            , "Fecha de compra.", "Fecha de vencimiento."};
        DefaultTableModel dtm= new DefaultTableModel(data,columnNames);
        final JTable table = new JTable(dtm){
                          public boolean isCellEditable (int row, int column)
                            {
                                return false;
                            }
                    }; 
        table.setPreferredScrollableViewportSize(new Dimension(800, 600));

        //Creamos un scrollpanel y se lo agregamos a la tabla 
        JScrollPane scrollpane = new JScrollPane(table);
        Panel.add(scrollpane);
        this.setMinimumSize(new Dimension(800, 600)); 
         
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Inven_total = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Historial");

        jMenuItem1.setText("Hsitorial de producto.");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        Inven_total.setText("Inventario.");
        Inven_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inven_totalActionPerformed(evt);
            }
        });
        jMenu1.add(Inven_total);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     
     formulario_producto formulario = new formulario_producto(this);
     formulario.setVisible(true);
     
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Inven_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inven_totalActionPerformed
         try {
             Inventario_total();
         } catch (SQLException ex) {
             Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_Inven_totalActionPerformed
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        
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
                    new Inventario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Inven_total;
    private javax.swing.JPanel Panel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
