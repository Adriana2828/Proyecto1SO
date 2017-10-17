/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfaz extends JFrame implements ActionListener {
    
    JPanel panelppal= new JPanel();
     Color rojo=new Color(255,0, 0x0);
     Color rojoOscuro= new Color(153,0,0x0);
     

    JPanel panelNorth=new JPanel(); 
    //Componentes de panelNorth
    
    JTextArea textarea1=new JTextArea("ARCHIVO \n \n \n \n \n \n");
    JTextArea textarea2=new JTextArea("GERENTE \n \n \n \n \n \n");
    JTextArea textarea3=new JTextArea("# DE DIAS \n \n \n \n \n \n");
    JTextArea textarea4=new JTextArea("# DE JUEGOS \n \n \n \n \n \n");
    JScrollPane scrollpane1= new JScrollPane(textarea1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JScrollPane scrollpane2= new JScrollPane(textarea2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JScrollPane scrollpane3= new JScrollPane(textarea3,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
    JScrollPane scrollpane4= new JScrollPane(textarea4,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JButton boton1=new JButton("Iniciar desde Archivo");
    JButton boton2=new JButton("Que esta haciendo el gerente?");
    JButton boton3=new JButton();
    JButton boton4=new JButton();
    //--------------------------
    JPanel panelEast= new JPanel();
    //Componentes de panelEast
    JButton boton5= new JButton("INICIAR TODO");
    //---------------------------
    JPanel panelCenter= new JPanel();
    //Componentes de panelCenter
    
     JTextArea textarea5= new JTextArea("Produccion de controles");
     JScrollPane scrollpane5= new JScrollPane(textarea5,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     JTextArea textarea51= new JTextArea("# DE CONTROLES:_");
     JScrollPane scrollpane51= new JScrollPane(textarea51,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     JTextArea textarea61= new JTextArea("# DE CONSOLAS:_");
     JScrollPane scrollpane61= new JScrollPane(textarea61,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     JTextArea textarea71= new JTextArea("# DE PAQUETES:_");
     JScrollPane scrollpane71= new JScrollPane(textarea71,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     JTextArea textarea81= new JTextArea("# DE PIEZAS ENSAMBLADAS:_");
     JScrollPane scrollpane81= new JScrollPane(textarea81,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JTextArea textarea6= new JTextArea("Produccion de consolas");
    JTextArea textarea7= new JTextArea ("Produccion de paquetes");  
    JScrollPane scrollpane6= new JScrollPane(textarea6,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane7= new JScrollPane(textarea7,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
    JTextArea textarea8= new JTextArea("Ensamblaje");
    JScrollPane scrollpane8= new JScrollPane(textarea8,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);    

//---------------------------
      JPanel panelWest=new JPanel();
    //Componentes de panelWest
    
      JButton boton6= new JButton("PARAR TODO");
     
    //---------------------------  
    JPanel panelSouth=new JPanel();
    JTextArea label1= new JTextArea("            ");
    JTextArea label2= new JTextArea("            ");
    JTextArea label3= new JTextArea("            ");
    JTextArea label4= new JTextArea("            ");
    JTextArea textarea9= new JTextArea("Nro de Productores de Controles:_");
    JTextArea textarea10= new JTextArea("Nro de Productores de Consolas:_");
    JTextArea textarea11= new JTextArea("Nro de Productores de Paquetes:_");
    JTextArea textarea12= new JTextArea("Nro de Ensambladores:_");
    JButton hire_Pcontroles=new JButton("Contratar");
    JButton fire_Pcontroles=new JButton("Despedir");
    JButton hire_Pconsolas=new JButton("Contratar");
    JButton fire_Pconsolas=new JButton("Despedir");
    JButton hire_Ppaquetes=new JButton("Contratar");
    JButton fire_Ppaquetes=new JButton("Despedir");
    JButton hire_ensamblador=new JButton("Contratar");
    JButton fire_ensamblador=new JButton("Despedir");
    
 
    public void Go() {
		
		setSize(600,400);
	 	setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                textarea1.setEditable(true);
		textarea1.setLineWrap(true);
		textarea1.setWrapStyleWord(true);
                textarea1.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea1.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea2.setEditable(true);
		textarea2.setLineWrap(true);
		textarea2.setWrapStyleWord(true);
                textarea2.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea2.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea3.setEditable(true);
		textarea3.setLineWrap(true);
		textarea3.setWrapStyleWord(true);
                textarea3.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea3.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea4.setEditable(true);
		textarea4.setLineWrap(true);
		textarea4.setWrapStyleWord(true);
                textarea4.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea4.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea5.setEditable(true);
		textarea5.setLineWrap(true);
		textarea5.setWrapStyleWord(true);
                textarea5.setFont(new Font("Arial ", Font.ITALIC, 14));
                textarea5.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea6.setEditable(true);
		textarea6.setLineWrap(true);
		textarea6.setWrapStyleWord(true);
                textarea6.setFont(new Font("Arial ", Font.ITALIC, 14));
                textarea6.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea7.setEditable(true);
		textarea7.setLineWrap(true);
		textarea7.setWrapStyleWord(true);
                textarea7.setFont(new Font("Arial ", Font.ITALIC, 14));
                textarea7.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea8.setEditable(true);
		textarea8.setLineWrap(true);
		textarea8.setWrapStyleWord(true);
                textarea8.setFont(new Font("Arial ", Font.ITALIC, 14));
                textarea8.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea9.setEditable(true);
		textarea9.setLineWrap(true);
		textarea9.setWrapStyleWord(true);
                textarea9.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea9.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea10.setEditable(true);
		textarea10.setLineWrap(true);
		textarea10.setWrapStyleWord(true);
                textarea10.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea10.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea11.setEditable(true);
		textarea11.setLineWrap(true);
		textarea11.setWrapStyleWord(true);
                textarea11.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea11.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea12.setEditable(true);
		textarea12.setLineWrap(true);
		textarea12.setWrapStyleWord(true);
                textarea12.setFont(new Font("Arial ", Font.BOLD, 14));
                textarea12.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea51.setEditable(true);
		textarea51.setLineWrap(true);
		textarea51.setWrapStyleWord(true);
                textarea51.setFont(new Font("Arial Bold", Font.BOLD, 14));
                textarea51.setBackground(Color.ORANGE);
                textarea51.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea51.setForeground(Color.BLUE);
                textarea51.setBackground(Color.ORANGE);
                textarea61.setEditable(true);
		textarea61.setLineWrap(true);
		textarea61.setWrapStyleWord(true);
                textarea61.setBackground(Color.ORANGE);
                textarea61.setFont(new Font("Arial Bold", Font.BOLD, 14));
                textarea61.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea61.setForeground(Color.BLUE);
                textarea61.setBackground(Color.ORANGE);
                textarea71.setEditable(true);
		textarea71.setLineWrap(true);
                textarea71.setForeground(Color.BLUE);
                textarea71.setBackground(Color.ORANGE);
		textarea71.setWrapStyleWord(true);
                textarea71.setFont(new Font("Arial Bold", Font.BOLD, 14));
                textarea71.setBorder(BorderFactory.createLineBorder(Color.black));
                textarea81.setEditable(true);
		textarea81.setLineWrap(true);
                textarea81.setForeground(Color.BLUE);
                textarea81.setBackground(Color.ORANGE);
		textarea81.setWrapStyleWord(true);
                textarea81.setFont(new Font("Arial Bold", Font.BOLD, 14));
                textarea81.setBorder(BorderFactory.createLineBorder(Color.black));
                panelppal.setLayout(new BorderLayout());
                panelppal.add(panelNorth,BorderLayout.PAGE_START);
                panelppal.add(panelEast,BorderLayout.LINE_START);
                panelppal.add(panelCenter,BorderLayout.CENTER);
                panelppal.add(panelWest,BorderLayout.LINE_END);
                panelppal.add(panelSouth,BorderLayout.PAGE_END);
                panelNorth.setLayout(new  GridLayout(2,4));
                panelNorth.add(scrollpane1);
                panelNorth.add(scrollpane2);
                panelNorth.add(scrollpane3);
                panelNorth.add(scrollpane4);
             
                panelNorth.add(boton1);
                panelNorth.add(boton2);
                panelNorth.add(boton3);
                panelNorth.add(boton4);
                panelEast.setLayout(new GridLayout(1,1));
                panelSouth.setLayout(new GridLayout(9,2));
                panelSouth.add(textarea9);
                panelSouth.add(label1);
                panelSouth.add(hire_Pcontroles);
                panelSouth.add(fire_Pcontroles);
                panelSouth.add(textarea10);
                panelSouth.add(label2);
                panelSouth.add(hire_Pconsolas);
                panelSouth.add(fire_Pconsolas);
                panelSouth.add(textarea11);
                panelSouth.add(label3);
                panelSouth.add(hire_Ppaquetes);
                panelSouth.add(fire_Ppaquetes);
                panelSouth.add(textarea12);
                panelSouth.add(label4);
                panelSouth.add(hire_ensamblador);
                panelSouth.add(fire_ensamblador);
                panelEast.add(boton5);
                panelCenter.setLayout(new GridLayout(1,8));
                panelCenter.add(scrollpane5);
                panelCenter.add(textarea51);//probar si hace falta meter esto en un scrollpane!!!
                panelCenter.add(scrollpane6);
                panelCenter.add(textarea61);
                panelCenter.add(scrollpane7);
                panelCenter.add(textarea71);
                panelCenter.add(scrollpane8);
                panelCenter.add(textarea81);
                panelWest.setLayout(new GridLayout(1,1));
                panelWest.add(boton6);
                boton3.setBorder(BorderFactory.createRaisedBevelBorder());
                boton3.setBackground(Color.LIGHT_GRAY);
                boton4.setBorder(BorderFactory.createRaisedBevelBorder());
                boton4.setBackground(Color.LIGHT_GRAY);
                boton5.setBorder(BorderFactory.createRaisedBevelBorder());
                boton5.setBackground(Color.BLUE);
                boton5.setForeground(Color.WHITE);
                boton6.setBorder(BorderFactory.createRaisedBevelBorder());
                boton6.setBackground(Color.BLUE);
                boton6.setForeground(Color.WHITE);
                add(panelppal);
                setVisible(true);
	} 
    
    @Override
    public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
		//test
               
		
        }
    
}
