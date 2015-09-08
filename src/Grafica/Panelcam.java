/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Clases.Mensajes_emergentes;
import Clases.manejador_bd;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;;

/**
 *
 * @author Yanir
 */





public class Panelcam extends JPanel {

    private JPanel[] panel = panel = new JPanel[3]; ;
    private final JLabel[] label = new JLabel[12];  
    private final JButton Bserv;
    private Object[][] data2; //Matriz para la tabla de estado de servicio
    private int cont = 0;
    private boolean invent_cont[]; 
    private int KmActual;
    private ResultSet rs = null; 
    private final JButton atc_km [] = new JButton[2]; //Botones para editar el km actual de los camiones
    private final JTextField Km_TF; //JTextField que modifica el kilometraje actual de los camiones
    public  manejador_bd BD;
    private ArrayList lista; // Lista con todos los productos que seran rebajados de inventario
    private boolean advertencia_servicio = true;
    
    @SuppressWarnings("empty-statement")
    public Panelcam(final Object [][] camion, final int fila) throws SQLException {
        
        
    
    this.setPreferredSize(new Dimension(400,300));
    this.setMinimumSize(new Dimension(800, 600)); 
    this.setLayout(new BorderLayout());                 
    this.setLayout(null);
    
    BD = new manejador_bd ();
    
    /*Declaracion de variables */
        
    
    String consulta = (String) camion [fila][0]; /*Varialbe que posee La placa del camion*/
    consulta = '"'+consulta.trim()+'"';   
    
    
        

        panel[1] = new JPanel ();
        panel[2] = new JPanel ();
       
        
        label[0] = new JLabel("Camion: ");
        label[0].setLayout(null);
        label[0].setBounds(20,20, 100, 20);
        
        label[1] = new JLabel((String) camion [fila] [1]);
        label[1].setLayout(null);
        label[1].setBounds( 150, 20 , 100, 20);
        
        label[2] = new JLabel("Placa: ");
        label[2].setLayout(null);
        label[2].setBounds(20,50, 100, 20);
        
        label[3] = new JLabel((String) camion [fila] [0]);
        label[3].setLayout(null);
        label[3].setBounds( 150, 50 , 100, 20);
        
        label[4] = new JLabel("Chofer actual: ");
        label[4].setLayout(null);
        label[4].setBounds(20,80, 100, 20);
        
        label[5] = new JLabel(camion[fila][2].toString());
        label[5].setLayout(null);
        label[5].setBounds( 150, 80 , 100, 20);
        
        label[6] = new JLabel("Kilometraje: ");
        label[6].setLayout(null);
        label[6].setBounds(20,110, 100, 20);
        
        
        label[7] = new JLabel();
        KmActual = (int) camion[fila][3];
        
        label[7].setText((int) camion[fila][3] + " Km.");
        label[7].setLayout(null);
        label[7].setBounds( 150, 110 , 100, 20);
        
        label[8] = new JLabel("Est. de servicio:");
        label[8].setLayout(null);
        label[8].setBounds( 20, 140 , 100, 20);
        
        label[9] = new JLabel("OK ");
        label[9].setLayout(null);
        label[9].setBounds( 150, 140, 100, 20);
        
        label[10] = new JLabel("KM para prox serv: ");
        label[10].setLayout(null);
        label[10].setBounds( 20, 170 , 120, 20);
        
        label[11] = new JLabel("500 Km ");
        label[11].setLayout(null);
        label[11].setBounds( 150, 170 , 100, 20);
        
        atc_km [0] = new JButton ("+");
        atc_km [0].setLayout(null);
        atc_km [0].setBounds(250, 110, 40,20);

        atc_km [1] = new JButton ("Aceptar");
        atc_km [1].setLayout(null);
        atc_km [1].setBounds(280, 110, 110,20);
        
        Km_TF = new JTextField();
        Km_TF.setLayout(null);
        Km_TF.setBounds( 150, 110 , 110, 20);
        
        
        
        
        Bserv = new JButton("Agregar nuevo servicio");
        Bserv.setLayout(null);
        Bserv.setBounds(20, 200, 220, 20);
        
        
        /* Accion al presionar el boton agregar un nuevo servicio */
        
        Bserv.addActionListener (new ActionListener()
       {
         @Override
         public void actionPerformed (ActionEvent e)
         {
             
            if (cont == 0){
                JOptionPane.showMessageDialog(null, "Este camion no tiene agregado ningun servicio." ,"Informacion", JOptionPane.WARNING_MESSAGE);
                 
            }
            else
            {
                        advertencia_servicio = true;
                        final Servicio serv; 
                        int i = 0;
                        int j=0;
                        int x=20;
                        ArrayList servicios_asociados = new ArrayList();
                                
                         try {

                            serv = new  Servicio();
                            serv.addWindowListener( new WindowAdapter() { 
                            @Override
                            public void windowClosing( WindowEvent evt ) { 
                             serv.dispose();
                            } 
                            }); 


                            final  JLabel tipo [] = new JLabel [cont];
                            final  JCheckBox checkBox[] = new JCheckBox [cont] ;
                            final  JDateChooser calendario[] = new JDateChooser [cont];
                            final  JTextField costo [] = new JTextField [cont];
                            final  JTextField km [] = new JTextField [cont];
                            final  JTextField detalle [] = new JTextField [cont];
                            final  JButton btn [] = new JButton[cont];
                            final  JComboBox proveedor [] = new JComboBox [cont];
                            final  Productos servi [] = new Productos [cont];
                            invent_cont = new boolean[cont];


                            for (i=0; i!=cont;i++){

                                invent_cont [i] = false;
                                proveedor [i] = new JComboBox();
                            }

                            Toolkit tk = Toolkit.getDefaultToolkit();
                            Dimension tamano = tk.getScreenSize();
                            JPanel pn = new JPanel ();
                            pn.setPreferredSize(tamano);
                            pn.setLayout(null);
                            JLabel label [] = new JLabel [8];



                            
                            label [0] = new JLabel ("Tipo de servicio");
                            label [0].setBounds(x, 20, 200, 30);
                            pn.add(label[0]);
                            label [1] = new JLabel ("Check");
                            label [1].setBounds(x+=230, 20, 150, 30);
                            pn.add(label [1]);
                            label [2] = new JLabel ("Proveedor");
                            label [2].setBounds(x+=135, 20, 180, 30);
                            pn.add(label [2]);
                            label [3] = new JLabel ("Fecha");
                            label [3].setBounds(x+=182, 20, 180, 30);
                            pn.add(label [3]);
                            label [4] = new JLabel ("Costo");
                            label [4].setBounds(x+=180, 20, 40, 30);
                            pn.add(label [4]);
                            label [5] = new JLabel ("Productos");
                            label [5].setBounds(x+=130, 20, 100, 30);
                            pn.add(label [5]);
                            label [6] = new JLabel ("Kilometraje");
                            label [6].setBounds(x+=130, 20, 100, 30);
                            pn.add(label [6]);
                            label [7] = new JLabel ("Detalle");
                            label [7].setBounds(x+=125, 20, 40, 30);
                            pn.add(label [7]);
                            
                            rs = manejador_bd.st.executeQuery("SELECT idTipo_Servicio , Descripcion " +
                                                        "FROM  tipo_servicio " +
                                                        "inner join tipo_servicio_has_automovil " +
                                                        "on idTipo_Servicio = Tipo_Servicio_idTipo_Servicio " +
                                                        "where Automovil_Placa = '" + camion [fila] [0] +"' " +
                                                        "and Automovil_Model = '" +camion [fila] [1]  +"' ;");
                            
                            rs.beforeFirst();
                            while(rs.next()) {
                                servicios_asociados.add(rs.getString("Descripcion"));
                                servicios_asociados.add((int)rs.getInt("idTipo_Servicio"));
                            }
                            
                            
                            rs = manejador_bd.st.executeQuery("select Descripcion, tipo_servicio_has_proveedor.Razon_social, idTipo_Servicio " +
                                                    "from  tipo_servicio_has_proveedor, ( " +
                                                    "select Descripcion, idTipo_Servicio " +
                                                    "from tipo_servicio " +
                                                    "inner join tipo_servicio_has_automovil " +
                                                    "on idTipo_Servicio = Tipo_Servicio_idTipo_Servicio " +
                                                    "and Automovil_Placa = '"+ camion [fila][0] +"'" +
                                                    "and Automovil_Model = '"+camion [fila][1] + "' ) as servi " +
                                                    "where Tipo_Servicio_idTipo_Servicio = servi.idTipo_Servicio;");
                            rs.beforeFirst();
                            final ArrayList tipo_servi = new ArrayList();
                            
                            i=-1;
                            j=0;
                                
                            while(rs.next())   
                            {
                                
                                if (!tipo_servi.contains((int)rs.getInt("idTipo_Servicio"))){
                                    i++;
                                    tipo_servi.add(rs.getString("Descripcion"));
                                    tipo_servi.add((int)rs.getInt("idTipo_Servicio"));
                                    proveedor[i].addItem(rs.getString("tipo_servicio_has_proveedor.Razon_social"));
                                    j+=2;
                                }else{
                                    proveedor[i].addItem(rs.getString("tipo_servicio_has_proveedor.Razon_social"));
                                }
                                
                            }
                            
                            for(j=0;j/2<i;j+=2){
                                if(!tipo_servi.contains(servicios_asociados.get(j))){
                                    
                                    serv.dispose();
                                    Mensajes_emergentes mensaje = new Mensajes_emergentes();
                                    mensaje.clear();
                                    mensaje.add(servicios_asociados.get(j));
                                    mensaje.Mostrar_mensajes(2);
                                }
                            }

                           

                            if(proveedor[0].getItemAt(0) !=  null){ 



                            x=20;
                            int y=60;
                            j=0;
                            
                            for ( i=0 ; i<cont;i++, j+=2 ){
                                tipo [i] = new JLabel ( tipo_servi.get(j).toString()); 
                                tipo [i].setBounds(x,y, 200, 30);
                                pn.add(tipo [i]);
                                checkBox[i] = new JCheckBox () ;
                                checkBox [i].setBounds(x+=230,y+5, 30, 30);
                                pn.add(checkBox[i]);
                                proveedor[i].setBounds(x+=130,y, 150, 30);
                                pn.add(proveedor[i]);
                                calendario[i] = new JDateChooser ();
                                calendario [i].setBounds(x+=180,y, 150, 30);
                                pn.add(calendario [i]);
                                costo [i] = new JTextField ();
                                costo [i].setBounds(x+=180,y, 100, 30);
                                pn.add(costo [i]);
                                btn [i] = new JButton("Inventario");
                                btn [i].setBounds(x+=130,y, 100, 30);
                                pn.add(btn[i]);
                                km [i] = new JTextField ();
                                km [i].setBounds(x+=130,y, 100, 30);
                                pn.add(km [i]);
                                detalle [i] = new JTextField ();
                                detalle [i].setBounds(x+=130,y, 300, 30);
                                pn.add(detalle [i]);

                                servi [i] = new Productos ();
                              
                                final int f = i;
                                final int l = j;


                                /*Accion del boton "Inventario" para gregar productos del inventario */
                                btn [i].addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        try {
                                          servi[f].SetProducto((int) tipo_servi.get(l+1));
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                            servi[f].setVisible(true);

                                    }

                                });

                                x=20;
                                y+=50;

                            }  

                            JScrollPane scrollpane = new JScrollPane(pn);
                            scrollpane.setPreferredSize(new Dimension(1600 , y));
                            serv.setLayout(new BorderLayout());
                            serv.setContentPane(scrollpane);


                            serv.boton.setBounds(800, y+30, 100, 30);
                            pn.add(serv.boton);
                             serv.setVisible(true);       
                     }else {
                             JOptionPane.showMessageDialog(null, "Debe existir al menos 1 proveedor creado " ,"Informacion", JOptionPane.ERROR_MESSAGE);
                            }
                             /* Aqui se hace la interaccion del boton de agregar un servicio */

                             serv. boton.addActionListener(new ActionListener() {


                            @Override
                            public void actionPerformed(ActionEvent e) {

                            Object Proveedor [] = new Object [7];
                            SimpleDateFormat df = new SimpleDateFormat ("yyyy/MM/dd");
                            Object data [] = new Object [3];
                            ResultSet rs = null;
                            Date fecha;
                            fecha = new Date();
                            int flag = 1;
                            int k = 0;

                            
                            try{
                            while(k<cont){
                                if (checkBox[k].isSelected()){
                                    if (calendario[k].getDate().before(fecha) && (calendario[k].getDate() != null)  ){

                                            if (Integer.parseInt(km[k].getText()) < KmActual || km[k].getText() == null ){
                                                 JOptionPane.showMessageDialog(null, "El kilometraje no puede ser menor que el actual " ,"Informacion", JOptionPane.INFORMATION_MESSAGE); 
                                                 flag = 0;

                                            }else{
                                               if(costo[k].getText().equals("") || Integer.parseInt(costo[k].getText()) < 0 ){
                                                     JOptionPane.showMessageDialog(null, "El costo no puede ser menor que 0 " ,"Informacion", JOptionPane.INFORMATION_MESSAGE); 
                                                    flag = 0;
                                                 }
                                            } 

                                    }else{
                                        JOptionPane.showMessageDialog(null, "La Fecha introducida no puede ser mayor que la actual " ,"Informacion", JOptionPane.INFORMATION_MESSAGE); 
                                        flag = 0;
                                    }
                                }
                                k++;
                            }
                            
                            }
                                catch(NumberFormatException | HeadlessException exc){
                                    JOptionPane.showMessageDialog(null, exc,"Informacion", JOptionPane.WARNING_MESSAGE); 
                                     flag = 0;
                                } 

                            if (flag == 1){
                            k=0 ;   
                            for(int j = 0;k<cont;k++, j+=2){
                                if (checkBox[k].isSelected()){
                                    
                                    try{
                                        Proveedor [0] = tipo_servi.get(j);
                                        Proveedor [1] = df.format(calendario[k].getDate());
                                        Proveedor [2] = costo[k].getText();
                                        Proveedor [4] = Integer.parseInt(km[k].getText());
                                        Proveedor [5] = detalle[k].getText();
                                        Proveedor [6] = proveedor[k].getSelectedItem();
                                    }catch (Exception ex) {
                                          JOptionPane.showMessageDialog(null, ex + " "  + "Clase: Panelcam " + " " +  "Método: serv. boton.addActionListener(new ActionListener() { " ,"Error.", JOptionPane.ERROR_MESSAGE); 
                                          serv.dispose();
                                    }

                                    try {


                                        if(KmActual <=  (int) Proveedor [4])
                                          actualizar_km ( (int) Proveedor [4], camion, fila);

                                        
                                        BD.st.execute("INSERT INTO Servicios (Fecha,Costo,Km,Detalle) VALUES ('"+Proveedor[1]+"','"
                                                +Proveedor[2]+"','"+Proveedor[4]+"','"
                                                +Proveedor[5]+"');");
                                      } catch (SQLException ex) {
                                          Logger.getLogger(NuevoProveedor.class.getName()).log(Level.SEVERE, null, ex);
                                      }

                                    
                                       try {
                                           rs = BD.st.executeQuery("SELECT idServicios FROM servicios WHERE fecha = '"+Proveedor[1]+"' AND costo = '"+Proveedor[2]+"' AND Km = '"+Proveedor[4]+"' ;");
                                       } catch (SQLException ex) {
                                                JOptionPane.showMessageDialog(null, ex + " "  + "Clase: Panelcam " + " " +  "Método: serv. boton.addActionListener(new ActionListener() { " ,"Error.", JOptionPane.ERROR_MESSAGE); 
                                          
                                       }


                                   try {
                                       while (rs.next())
                                       {

                                           data [0] = rs.getInt("idServicios");
                                       }
                                   } catch (SQLException ex) {
                                        Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex); 
                                   }
                                   try {

                                        try {
                                       BD.st.execute("INSERT INTO servicios_has_automovil VALUES ('"+data[0]+"','"+camion [fila][0]+"','"
                                       +camion [fila][1]+"')");
                                       } catch (SQLException ex) {
                                            Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex);
                                       }

                                        
                                         
                                        data [1] = tipo_servi.get(j+1);
                                      
                                        
                                         
                                       BD.st.execute("INSERT INTO servicios_has_tipo_servicio VALUES ("+data[0]+","+data[1]+") ;");     

                                       
                                        rs = BD.st.executeQuery("SELECT Rif FROM proveedor WHERE RazonSocial= '"+Proveedor[6]+"' ;" );

                                             while (rs.next())
                                       {

                                           data [2] = rs.getString("Rif");
                                       }

                                       BD.st.execute("INSERT INTO proveedor_has_servicios VALUES ('" +data[2]+ "','"+data[0]+"') ;");
                                       
                                       
                                   } catch (SQLException ex) {
                                        Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex);
                                   }


                                  }

                                        if(servi [k].getInvent_cont()){
                                            lista = servi[k].GetProductos();
                                            servi [k].insertar((int) data[0]);
                                        }

                                          panel [1].removeAll();
                                          panel [2].removeAll();
                                      try {
                                          tabla_servicios(camion, fila);
                                          tabla_proximo_servicio(camion, fila );
                                      } catch (SQLException ex) {
                                          Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex);
                                      }


                              }

                                serv.dispose();
                }
                
                }
                
        });
                 
                 

             } catch (SQLException ex) {
                 Logger.getLogger(Panelcam.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
             
         }
         
       });
        
       
        
        this.add(panel[1]);
        this.add(panel[2]);
        this.add(label[0]);
        this.add(label[1]);
        this.add(label[2]);
        this.add(label[3]);
        this.add(label[4]);
        this.add(label[5]);
        this.add(label[6]);
        this.add(label[7]);
        this.add(label[8]);
        this.add(label[9]);
        this.add(label[10]);
        this.add(label[11]);
        this.add(Bserv);
        this.add(atc_km[0]);
        this.add(atc_km[1]);
        this.add(Km_TF);
        Km_TF.setVisible(false);
        atc_km[1].setVisible(false);
        tabla_servicios(camion, fila);
        tabla_proximo_servicio(camion, fila );
        
        
        
       atc_km [0].addActionListener (new ActionListener()
       {
            @Override
            public void actionPerformed(ActionEvent e) {
                   add_boton ();
            }
        });
       
        
        
    
        atc_km [1].addActionListener (new ActionListener()
       {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    add_boton2 ( camion, fila);
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"No se pudo ejecutar la función: " + ex.getMessage() ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
              
                }
            }
        });
       
    
    }  
    
    
    private void add_boton (){
        this.label [7].setVisible(false);
        this.atc_km[0].setVisible(false);
        this.Km_TF.setText(this.label[7].getText().substring(0, this.label[7].getText().indexOf(" ")));
        this.Km_TF.setVisible(true);
        this.atc_km[1].setVisible(true);
        repaint();
    }
    
    private void add_boton2 (final Object [][] camion, final int fila) throws SQLException{
        
        this.Km_TF.setVisible(false);
        this.atc_km[1].setVisible(false);
        actualizar_km (Integer.parseInt(Km_TF.getText()), camion, fila);
        advertencia_servicio = true;
        tabla_proximo_servicio(camion, fila );
        this.Km_TF.setText("");
        this.atc_km[0].setVisible(true);
        repaint();
        
    }
   
    public void actualizar_km ( int Km, final Object [][] camion, final int fila) throws SQLException{
      

        this.BD.st.execute(" UPDATE automovil " +
                           " SET Km = "+Km+" " +
                           " WHERE Placa = '"+this.label[3].getText()+"'  and Model = '"+this.label[1].getText()+"' ;");
        
        this.label[7].setText(Km + " Km.");
        this.label[7].setVisible(true);
        
        KmActual = Km;
                  
    }
    
    private void tabla_servicios ( final Object [][] camion, final int fila) throws SQLException{
        
                
                
             panel[1].removeAll();
             panel[2].removeAll();
             Object[][] data;  //Matriz para la tabla general
             SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Formato de fecha
             
             
             try{
                this.rs = BD.st.executeQuery("select count(idServicios_auto) as num " +
                                            "from servicios_has_automovil " +
                                            "where Automovil_Placa = '" + camion [fila] [0] +"' " +
                                            "and Automovil_Model = '" +camion [fila] [1]  +"' ;");
                
                int i=0;
                int j=0;

                while (rs.next())
                {
                 j = rs.getInt("num");
                }
                i=j;

                this.rs = BD.st.executeQuery("SELECT distinct ser.idServicios,ser.Km, ser.Fecha, tipo.Descripcion, ser.Costo, pro.RazonSocial, ser.Detalle " +
                                        "FROM servicios_has_automovil as sa, tipo_servicio as tipo, servicios as ser,  " +
                                        "proveedor as pro, proveedor_has_servicios as ps, servicios_has_tipo_servicio as st " +
                                        "WHERE sa.Automovil_Placa = '" + camion [fila] [0] +"'" +
                                        " AND sa.Automovil_Model = '" +camion [fila] [1]  +"'" +
                                        " AND ser.idServicios = sa.idServicios_auto " +
                                        " AND st.Servicios_idServicios = sa.idServicios_auto " +
                                        " AND tipo.idTipo_Servicio = st.Tipo_Servicio_idTipo_Servicio " +
                                        " AND ps.Servicios_idServicios = ser.idServicios " +
                                        " AND pro.Rif = ps.Proveedor_Rif" +
                                        " order by Fecha desc , ser.Km desc; ");
             
                
                data = new Object [j] [7];
                    
                rs.beforeFirst();
                j=0;    
                
                
                while (rs.next())
                {
                    data [j][0]= rs.getInt("ser.idServicios");   
                    data [j][1]= rs.getInt("KM");
                    data [j][2]= formato.format(rs.getDate("Fecha"));
                    data [j][3]= rs.getString("Descripcion");
                    data [j][4]= rs.getFloat("Costo");
                    data [j][5]= rs.getString("RazonSocial");
                    data [j][6]= rs.getString("Detalle");
                    j++;
                }
                

                    
               
                    //array de String's con los títulos de las columnas
                    String[] columnNames = {"idServicio","Km", "Fecha", "Servicio","Costo","Proveedor","Detalles"};       
                    

                    //CREAMOS LAS TABLAS
                    final JTable table = new JTable(data, columnNames){
                          @Override
                          public boolean isCellEditable (int row, int column)
                            {
                                return false;
                            }
                    };
                    table.setPreferredScrollableViewportSize(new Dimension(table.getSize()));
                    
                    
                    
                    
                    //Creamos un scrollpanel y se lo agregamos a la tabla 
                    JScrollPane scrollpane = new JScrollPane(table);
                    
                    
                    panel[1].setLayout(new BorderLayout());
                    panel[1].add(scrollpane, BorderLayout.CENTER);
                    panel[1].setBounds (450,20, 1200, 750);
                    this.add( panel[1]);
                    
             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() + ex.getSQLState() + ex.getErrorCode() ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
             }
            
    }
    
    
    
    
    private void tabla_proximo_servicio ( final Object [][] camion, final int fila) throws SQLException{
        
        panel[2].removeAll();
        int i = 0;
        int j = 0;
        ArrayList informacion_camion = new ArrayList();
        Mensajes_emergentes mensajes = new Mensajes_emergentes();
        boolean est_serv = true;
        Date Fecha;
        Calendar calendar = Calendar.getInstance();//Variable para modificar las fechas (agregar dias o meses)
        int posicion=0;//Variable auxiliar para determinar si existe la palabra MESES o Dias dentro del tiempo de sriivicio
        String palabra;//String de la fechas utlizado para calcular los tiempos de cada servicio
        int  Km=0;
        int tiempo=0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//Formato de fecha
        Calendar fecha_actual= GregorianCalendar.getInstance();
        fecha_actual.getTime().toLocaleString();
                   
        rs = BD.st.executeQuery("select count(Tipo_Servicio_idTipo_Servicio) as num " +
                                    "from tipo_servicio_has_automovil " +
                                    "where Automovil_Placa = '" + camion [fila] [0] +"' " +
                                    "and Automovil_Model = '" +camion [fila] [1]  +"' ;");

        while (rs.next()) {
            j = rs.getInt("num");
        }
        
        i=j;

        cont = j;
        
        data2 = new Object [j] [7];
        
        try{
            rs = BD.st.executeQuery ("SELECT distinct  ts.Descripcion, x2.Fecha, ta.Tiempo, ta.Km, x2.Km, ts.idTipo_Servicio " +
                                    "FROM  tipo_servicio as ts, " +
                                    "(select * " +
                                    "from  " +
                                    "(select *FROM servicios_has_tipo_servicio as st, servicios_has_automovil as sa, servicios " +
                                    "WHERE sa.Automovil_Placa =  '" + camion [fila] [0] +"' AND sa.Automovil_Model =  '" + camion [fila] [1] +"' AND  st.Servicios_idServicios = sa.idServicios_auto  " +
                                    "and st.Servicios_idServicios = idServicios " +
                                    "group by  Fecha desc, Km desc) x " +
                                    "group by Tipo_Servicio_idTipo_Servicio desc) x2,  " +
                                    "tipo_servicio_has_automovil as ta  " +
                                    "WHERE   ts.idTipo_Servicio = x2.Tipo_Servicio_idTipo_Servicio " +
                                    "and ta.Automovil_Placa =   '" + camion [fila] [0] +"' " +
                                    "and ta.Automovil_Model =   '" + camion [fila] [1] +"'  " +
                                    "and ta.Tipo_Servicio_idTipo_Servicio = ts.idTipo_Servicio  " +
                                    "group by  x2.Fecha desc, x2.Km  desc;" );

           }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage() ,"Informacion", JOptionPane.WARNING_MESSAGE);
        }
                

        rs.beforeFirst();



        j=0;    

        while (rs.next())
        {
            data2 [j][0]= rs.getString("ts.Descripcion");
            data2 [j][1]= formato.format(rs.getDate("Fecha"));
            data2 [j][2]= rs.getString("ta.Tiempo");
            data2 [j][3]= rs.getInt("ta.Km");
            data2 [j][4]= rs.getInt("ts.idTipo_Servicio");
            data2 [j][5]= rs.getInt("x2.Km");
            data2 [j][6]= rs.getDate("Fecha");
            j++;
        }
        
        for (j=0; j<i ; j++){
            
            
            if (data2 [j][2]!= null){
               palabra = (String) data2 [j][2]; 
               posicion = palabra.indexOf("Meses");
               if (posicion != -1){
                   Fecha = (Date) data2 [j][6];
                   calendar.setTime(Fecha);
                   palabra = palabra.replaceAll(" Meses", "");
                   tiempo = Integer.parseInt(palabra);
                   calendar.add(Calendar.MONTH, tiempo);
                   posicion=0;
               }else{
                    palabra = (String) data2 [j][2]; 
                    posicion = palabra.indexOf("Días");
                    Fecha = (Date) data2 [j][6];
                    calendar.setTime(Fecha);
                    palabra = palabra.replaceAll(" Días", "");
                    tiempo = Integer.parseInt(palabra);
                    calendar.add(Calendar.DATE, tiempo);

                    posicion=0;
               }


               if (Integer.parseInt(palabra) > 0){
                    if (calendar.before(fecha_actual)){ 
                        data2 [j][2]= "Falta servicio";
                        est_serv = false;

                        if(advertencia_servicio){
                            informacion_camion.add(camion[fila][0]);
                            informacion_camion.add(camion[fila][1]);
                            mensajes.setLista(informacion_camion);
                            mensajes.Mostrar_mensajes(1);
                            informacion_camion.clear();
                            advertencia_servicio = false;
                        }
                    }else{
                        data2 [j][2]= formato.format(calendar.getTime());
                    }
               }else{
                   data2 [j][2]= "Tiempo indefinido.";
               }

            }else{

                if(data2 [j][3]!=null){
                    if ((int) data2 [j][3] >0){
                        Km += ((int) data2 [j][3]+ (int) data2 [j][5]) ;
                        palabra = label[7].getText().substring(0,label[7].getText().indexOf(" Km."));
                        
                        if (Integer.parseInt(palabra = label[7].getText().substring(0,label[7].getText().indexOf(" Km.") ))>=Km ){
                            data2 [j][2] = "Falta servicio";
                            est_serv = false;
                            if(advertencia_servicio){
                                informacion_camion.add(camion[fila][0]);
                                informacion_camion.add(camion[fila][1]);
                                mensajes.setLista(informacion_camion);
                                mensajes.Mostrar_mensajes(1);
                                informacion_camion.clear();
                                advertencia_servicio = false;
                            }
                        }
                        else
                            data2 [j][2] = Km + " Km";
                    }else{
                        data2 [j][2]= "Kilometraje indefinido.";
                    }
                }
            }   
            
            Km = 0;
        }

        
        if(!est_serv){                        
            label[9].setText("Falta servicio!!!");
            label[9].setForeground(Color.red);

            if(advertencia_servicio){
                informacion_camion.add(camion[fila][0]);
                informacion_camion.add(camion[fila][1]);
                mensajes.setLista(informacion_camion);
                mensajes.Mostrar_mensajes(1);
                informacion_camion.clear();
                advertencia_servicio = false;
            }
        }else{
          label[9].setText(" Ok. "); 
          label[9].setForeground(Color.GREEN);
        }
        
        
        String[] columnNames2 = {"Servicio","Ultimo","Proximo"};
                    
        final JTable table2 = new JTable(data2, columnNames2){
              @Override
              public boolean isCellEditable (int row, int column)
                {
                    return false;
                }
        }; 
        
        table2.setPreferredScrollableViewportSize(new Dimension(table2.getSize()));
        
        
        JScrollPane scrollpane2 = new JScrollPane(table2);
        panel[2].setLayout(new BorderLayout());
        panel[2].add(scrollpane2, BorderLayout.CENTER);
        panel[2].setBounds (20,250, 400, 500);
        panel[2].repaint();
        
    }
    
    
    
    
}
