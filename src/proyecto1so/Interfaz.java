/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;
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
    JTextArea textarea4=new JTextArea("");// Nro de Juegos terminados en stock
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
  
    //---------------------------
    JPanel panelCenter= new JPanel();
    //Componentes de panelCenter
    
     JTextArea textarea5= new JTextArea("");//Nro de Controles
     JScrollPane scrollpane5= new JScrollPane(textarea5,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JTextArea textarea6= new JTextArea("");//Nro de Consolas
    JTextArea textarea7= new JTextArea ("");//Nro de Paquetes  
    JScrollPane scrollpane6= new JScrollPane(textarea6,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane7= new JScrollPane(textarea7,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
    JTextArea textarea8= new JTextArea("");//Nro de Productos ensamblados
    JScrollPane scrollpane8= new JScrollPane(textarea8,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);    

//---------------------------
      JPanel panelWest=new JPanel();
    //Componentes de panelWest
    
  
     
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
    JButton boton5= new JButton("INICIAR TODO");
    JButton boton6= new JButton("PARAR TODO");
//------------------------------------------------------------------------------
    Fabrica F;
 
    public void Go() {
		
		setSize(600,400);
	 	setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.textarea1.setEditable(true);
		this.textarea1.setLineWrap(true);
		this.textarea1.setWrapStyleWord(true);
                this.textarea1.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea1.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea2.setEditable(true);
		this.textarea2.setLineWrap(true);
		this.textarea2.setWrapStyleWord(true);
                this.textarea2.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea2.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea3.setEditable(true);
		this.textarea3.setLineWrap(true);
		this.textarea3.setWrapStyleWord(true);
                this.textarea3.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea3.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea4.setEditable(true);
		this.textarea4.setLineWrap(true);
		this.textarea4.setWrapStyleWord(true);
                this.textarea4.setFont(new Font("Arial ", Font.BOLD, 48));
                this.textarea4.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea4.setForeground(Color.red);
                this.textarea5.setEditable(true);
		this.textarea5.setLineWrap(true);
		this.textarea5.setWrapStyleWord(true);
                this.textarea5.setFont(new Font("Arial ", Font.BOLD, 48));
                this.textarea5.setForeground(Color.blue);             
                this.textarea5.setBorder(BorderFactory.createLineBorder(Color.blue));
                this.textarea6.setEditable(true);
		this.textarea6.setLineWrap(true);
		this.textarea6.setWrapStyleWord(true);
                this.textarea6.setForeground(Color.black);
                this.textarea6.setFont(new Font("Arial ", Font.BOLD, 48));
                this.textarea6.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea7.setEditable(true);
		this.textarea7.setForeground(Color.blue);
                this.textarea7.setLineWrap(true);
		this.textarea7.setWrapStyleWord(true);
                this.textarea7.setFont(new Font("Arial ", Font.BOLD, 48));
                this.textarea7.setBorder(BorderFactory.createLineBorder(Color.blue));
                this.textarea8.setForeground(Color.black);
                this.textarea8.setEditable(true);
		this.textarea8.setLineWrap(true);
		this.textarea8.setWrapStyleWord(true);
                this.textarea8.setFont(new Font("Arial ", Font.BOLD, 48));
                this.textarea8.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea9.setEditable(true);
		this.textarea9.setLineWrap(true);
		this.textarea9.setWrapStyleWord(true);
                this.textarea9.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea9.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea10.setEditable(true);
		this.textarea10.setLineWrap(true);
		this.textarea10.setWrapStyleWord(true);
                this.textarea10.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea10.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea11.setEditable(true);
		this.textarea11.setLineWrap(true);
		this.textarea11.setWrapStyleWord(true);
                this.textarea11.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea11.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea12.setEditable(true);
		this.textarea12.setLineWrap(true);
		this.textarea12.setWrapStyleWord(true);
                this.textarea12.setFont(new Font("Arial ", Font.BOLD, 14));
                this.textarea12.setBorder(BorderFactory.createLineBorder(Color.black));
                this.panelppal.setLayout(new BorderLayout());
                this.panelppal.add(panelNorth,BorderLayout.PAGE_START);
                this.panelppal.add(panelEast,BorderLayout.LINE_START);
                this.panelppal.add(panelCenter,BorderLayout.CENTER);
                this.panelppal.add(panelWest,BorderLayout.LINE_END);
                this.panelppal.add(panelSouth,BorderLayout.PAGE_END);
                this.panelNorth.setLayout(new  GridLayout(2,4));
                this.panelNorth.add(scrollpane1);
                this.panelNorth.add(scrollpane2);
                this.panelNorth.add(scrollpane3);
                this.panelNorth.add(scrollpane4);             
                this.panelNorth.add(boton1);
                this.panelNorth.add(boton2);
                this.panelNorth.add(boton3);
                this.panelNorth.add(boton4);
                this.panelEast.setLayout(new GridLayout(1,1));
                this.panelSouth.setLayout(new GridLayout(9,2));
                this.panelSouth.add(textarea9);
                this.panelSouth.add(label1);
                this.panelSouth.add(hire_Pcontroles);
                this.panelSouth.add(fire_Pcontroles);
                this.panelSouth.add(textarea10);
                this.panelSouth.add(label2);
                this.panelSouth.add(hire_Pconsolas);
                this.panelSouth.add(fire_Pconsolas);
                this.panelSouth.add(textarea11);
                this.panelSouth.add(label3);
                this.panelSouth.add(hire_Ppaquetes);
                this.panelSouth.add(fire_Ppaquetes);
                this.panelSouth.add(textarea12);
                this.panelSouth.add(label4);
                this.panelSouth.add(hire_ensamblador);
                this.panelSouth.add(fire_ensamblador);
                this.panelSouth.add(boton5);
                this.panelSouth.add(boton6);
                this.panelCenter.setLayout(new GridLayout(1,8));
                this.panelCenter.add(scrollpane5);
                this.panelCenter.add(scrollpane6);
                this.panelCenter.add(scrollpane7);
                this.panelCenter.add(scrollpane8);
                this.panelWest.setLayout(new GridLayout(1,1));
                this.boton3.setBorder(BorderFactory.createRaisedBevelBorder());
                this.boton3.setBackground(Color.LIGHT_GRAY);
                this.boton4.setBorder(BorderFactory.createRaisedBevelBorder());
                this.boton4.setBackground(Color.LIGHT_GRAY);
                this.boton5.setFont(new Font("Arial ", Font.BOLD, 28));
                this.boton5.setBorder(BorderFactory.createRaisedBevelBorder());
                this.boton5.setBackground(Color.black);
                this.boton5.setForeground(Color.WHITE);
                this.boton6.setFont(new Font("Arial ", Font.BOLD, 28));
                this.boton6.setBorder(BorderFactory.createRaisedBevelBorder());
                this.boton6.setBackground(Color.black);
                this.boton6.setForeground(Color.WHITE);
                this.boton1.addActionListener(this);
                this.boton2.addActionListener(this);
                this.boton3.addActionListener(this);
                this.boton4.addActionListener(this);
                this.boton5.addActionListener(this);
                this.boton6.addActionListener(this);
                this.hire_Pcontroles.addActionListener(this);
                this.fire_Pcontroles.addActionListener(this);
                this.hire_Pconsolas.addActionListener(this);
                this.fire_Pconsolas.addActionListener(this);
                this.hire_Ppaquetes.addActionListener(this);
                this.fire_Ppaquetes.addActionListener(this);
                this.hire_ensamblador.addActionListener(this);
                this.fire_ensamblador.addActionListener(this);
                add(this.panelppal);
                setVisible(true);
	} 
    
    @Override
    public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
		if (src.equals(this.boton1)){
                   this.textarea1.setText("Introduzca el nombre del archivo:_"); 
                   String nombre="";//Falta guardar el nombre del archivo.
                   this.F=new Fabrica(nombre,this);
                }
                if (src.equals(this.boton2)){
                    this.textarea2.setText("Esta fumando un cigarro!!!"); 
                }
		if (src.equals(this.boton3)){
                }
                if (src.equals(this.boton4)){
                }
                
                if (src.equals(this.boton5)){//Iniciar todo con valores por defecto
                    this.F=new Fabrica(this);
                    this.textarea9.setText(this.textarea9.getText()+this.F.getNro_prod_controles());
                    this.textarea10.setText(this.textarea10.getText()+this.F.getNro_prod_consolas());
                    this.textarea11.setText(this.textarea11.getText()+this.F.getNro_prod_paquetes());
                    this.textarea12.setText(this.textarea12.getText()+this.F.getNro_ensambladores());
                }
                if (src.equals(this.boton6)){
                }
                if (src.equals(this.hire_Pconsolas)){
                    
                    this.F.contratar_pconsolas();
                }
                if (src.equals(this.fire_Pconsolas)){
                
                    this.F.despedir_pconsolas();
                }
                if (src.equals(this.hire_Pcontroles)){
                    
                    this.F.contratar_pcontroles();
                }
                if (src.equals(this.fire_Pcontroles)){
                
                    this.F.despedir_pcontroles();
                    
                }
                if (src.equals(this.hire_Ppaquetes)){
                          this.F.contratar_ppaquetes();
                }
                if (src.equals(this.fire_Ppaquetes)){
                       this.F.despedir_ppaquetes();
                }
                if (src.equals(this.hire_ensamblador)){
                       this.F.contratar_ensambladores();
                }
                if (src.equals(this.fire_ensamblador)){
                       this.F.despedir_ensambladores();
                }
                
        }
    

}
