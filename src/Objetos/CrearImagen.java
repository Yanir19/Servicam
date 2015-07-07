/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Yanir
 */
public class CrearImagen extends JPanel {
          private  ImageIcon image;
          Dimension dimension;
          String Ruta; 
    public CrearImagen( JPanel Panel, String url) {
         Ruta = url;
         dimension = new Dimension(Panel.getWidth(),Panel.getHeight());
          
        this.setPreferredSize(dimension);
         this.setSize(dimension);
         this.setLayout(null);
         
    }

    @Override
    public void paintComponent(Graphics g) {
       image =  new ImageIcon( new ImageIcon (getClass().getResource(Ruta)).getImage()); 
       g.drawImage(image.getImage(), 0, 0,dimension.width,dimension.height, null); //To change body of generated methods, choose Tools | Templates.
       
    }
    
    

}
