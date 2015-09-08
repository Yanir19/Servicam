/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Clases.Mensajes_emergentes;
import Clases.manejador_bd;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
     private final manejador_bd BD;
     public int tipo_historial;
     
     
    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTipo_historial() {
        return tipo_historial;
    }

    public void setTipo_historial(int tipo_historial) {
        this.tipo_historial = tipo_historial;
    }
    /**
     * Creates new form Inventario2
     */
    
    /**
     * Creates new form Inventario2
     * @throws java.sql.SQLException
     */
    public Inventario() throws SQLException {
       this.setTitle("Inventario.");
       this.setMinimumSize(new Dimension(800, 600)); 
       initComponents();
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       BD = new manejador_bd();
       
        Inventario_total();
     
    }

    
    
    
    private void Inventario_total () throws SQLException {
        
        int i=0;
        Object data [][];
        Panel.removeAll();
        rs = manejador_bd.st.executeQuery("select count(*) as cantidad from inventario ; ");
        boolean advertencia_inventario = true;
        
                
        while (rs.next())
        {
          i = rs.getInt("cantidad");
        }

  
        data = new Object [i] [9];
        
        rs = manejador_bd.st.executeQuery("select * , (Cantidad - Sugerido) as total from inventario ; ");    
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
                
                if( advertencia_inventario && (int)data [i][6] <= 0 ){
                    Mensajes_emergentes mensajes = new Mensajes_emergentes();
                    mensajes.Mostrar_mensajes(3);
                    advertencia_inventario = false;
                }
                i++;
            }
            rs.close();

        
        String[] columnNames = {"Tipo.","Marca.","Costo.",
            "Duración.", "Cantidad.", "Mínimo sugerido.", "Cantidad mínima." 
            , "Fecha de compra.", "Fecha de vencimiento."};
        DefaultTableModel dtm= new DefaultTableModel(data,columnNames);
        final JTable table = new JTable(dtm){
                          @Override
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
    
    public void historial_movimientos () throws SQLException{
        
        Object data [][];
        int i = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Panel.removeAll();
        
        rs = manejador_bd.st.executeQuery("Select count(*) as cantidad " +
                                "from inventario_has_servicios, ( " +
                                                                    "select Descripcion  " +
                                                                    "from tipo_servicio " +
                                                                    "inner join inventario_has_tipo_servicio " +
                                                                    "on Inventario_Producto =  '"+producto+"' " +
                                                                    "and Inventario_Marca = '"+marca+"' " +
                                                                    "and idTipo_Servicio = Tipo_Servicio_idTipo_Servicio ) as TS , " +
                
                                "servicios_has_automovil, servicios " +
                                "where Inventario_Producto =  '"+producto+"' " +
                                "and Inventario_Marca = '"+marca+"'  " +
                                "and idServicios = inventario_has_servicios.Servicios_idServicios " +
                                "and servicios_has_automovil.idServicios_auto = idServicios; ");
        
        
        while (rs.next())
          i = rs.getInt("cantidad");
        
        if (i >0){
            
            data = new Object [i] [5];
            rs = manejador_bd.st.executeQuery("Select Inventario_Producto, Inventario_Marca, Automovil_Model, Automovil_Placa, Descripcion, inventario_has_servicios.Cantidad, Fecha " +
                                    "from inventario_has_servicios, ( " +
                                                                        "select Descripcion  " +
                                                                        "from tipo_servicio " +
                                                                        "inner join inventario_has_tipo_servicio " +
                                                                        "on Inventario_Producto =  '"+producto+"' " +
                                                                        "and Inventario_Marca = '"+marca+"' " +
                                                                        "and idTipo_Servicio = Tipo_Servicio_idTipo_Servicio ) as TS , " +

                                    "servicios_has_automovil, servicios " +
                                    "where Inventario_Producto =  '"+producto+"' " +
                                    "and Inventario_Marca = '"+marca+"'  " +
                                    "and idServicios = inventario_has_servicios.Servicios_idServicios " +
                                    "and servicios_has_automovil.idServicios_auto = idServicios; ");



            i=0;
                  while (rs.next())
                {   
                    data [i][0]=rs.getString("Inventario_Producto") + " - " + rs.getString("Inventario_Marca");
                    data [i][1]= rs.getString("Automovil_Model") + " - " + rs.getString("Automovil_Placa");
                    data [i][2]= rs.getString("Descripcion");   
                    data [i][3]= rs.getInt("inventario_has_servicios.Cantidad"); 
                    data [i][4]= formato.format(rs.getDate("fecha"));  
                    i++;
                }
                rs.close();



            rs.close();
            repaint();
             String[] columnNames = {"Prodcuto.","Camion.","Servicio.",
                "Cantidad.", "Fecha." };
            DefaultTableModel dtm= new DefaultTableModel(data,columnNames);
            final JTable table = new JTable(dtm){
                              @Override
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
        }else{
            JOptionPane.showMessageDialog(null,"El producto introducido aun no ha sido utilizado. ","Informacion", JOptionPane.WARNING_MESSAGE);
            Inventario_total();
        }
        
    }
    
    public void historial () throws SQLException{
        
        Object data [][];
        int i = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Panel.removeAll();
        
        rs = manejador_bd.st.executeQuery("select count(*) as cantidad  " +
                                "from inventario_has_servicios " +
                                "inner join servicios " +
                                "on idServicios = Servicios_idServicios " +
                                "where Inventario_Marca = '"+marca+"' " +
                                "AND Inventario_Producto = '"+producto+"' " +
                                "group by month(Fecha) and Year (Fecha)  ; ");  
        
        while (rs.next())
          i = rs.getInt("cantidad");
        
        if (i >0){
            

            data = new Object [i] [3];

            rs = manejador_bd.st.executeQuery("select Inventario_Producto, Inventario_Marca, sum(inventario_has_servicios.Cantidad) as Total_utilizado, servicios.Fecha  " +
                                    "from inventario_has_servicios " +
                                    "inner join servicios " +
                                    "on idServicios = Servicios_idServicios " +
                                    "where Inventario_Marca = '"+marca+"' " +
                                    "AND Inventario_Producto = '"+producto+"' " +
                                    "group by month(Fecha) and Year (Fecha)  ; ");    
            rs.beforeFirst();



            i=0;
                  while (rs.next())
                {   
                    data [i][0]=rs.getString("Inventario_Producto") + " - " + rs.getString("Inventario_Marca");
                    data [i][1]= rs.getString("Total_utilizado");
                    data [i][2]= formato.format(rs.getDate("servicios.Fecha"));
                    i++;
                }
                rs.close();



            rs.close();
            repaint();
            String[] columnNames = {"Producto.","Total.", "Fecha." };
            DefaultTableModel dtm= new DefaultTableModel(data,columnNames);
            final JTable table = new JTable(dtm){
                              @Override
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
        }else{
            JOptionPane.showMessageDialog(null,"El producto introducido aun no ha sido utilizado. ","Informacion", JOptionPane.WARNING_MESSAGE);
            Inventario_total();
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

        jComboBox1 = new javax.swing.JComboBox();
        Panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Inven_total = new javax.swing.JMenuItem();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Historial");

        jMenuItem1.setText("Historial de compra y uso.");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Historico de movimientos.");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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
     
        
        formulario_producto formulario;
         try {
             tipo_historial = 1;
             formulario = new formulario_producto(this);
             formulario.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Inven_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inven_totalActionPerformed
         try {
             Inventario_total();
         } catch (SQLException ex) {
             Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_Inven_totalActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     
         try {
             tipo_historial = 2;
             formulario_producto formulario = new formulario_producto(this);
             formulario.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
