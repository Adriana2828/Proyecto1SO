/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dearf
 */
public class Gerente extends Thread {
    
    private int dia; //milisegundos equivalentes a un dia en el programa
    private double horas6;
    private double horas18;
    private Almacen A;
    private Interfaz I;
    private Random ramdon;
    public Gerente(int dia, Almacen A,Interfaz I){
        this.I=I;
        this.dia=dia;
        this.ramdon=new Random();
        this.A=A;
        this.horas6=(6*dia)/24;
        this.horas18=(18*dia)/24;
    }
    
    @Override
    public void run (){
    int x;
       while (true){
       
           try {
               
               //this.A.getS_cont().acquire();
               //this.A.setCont(this.A.getCont()+1);
               //if(this.A.getCont()==1){
               x=this.ramdon.nextInt(18);
               if(x<6){ //El gerente duerme 6 horas
               this.I.textarea2.setText("\nGerente durmiendo\n");
               Gerente.sleep((dia*6)/24);
               }
               if(x>=6){//El gerente duerme durante x horas
               this.I.textarea2.setText("\nGerente durmiendo\n");
               Gerente.sleep((dia*x)/24);
               }
               this.I.textarea2.setText("\ngerente esperando\n");
               //Gerente.sleep((dia)*5/24);
               this.A.getS_dias_para_despacho().acquire();
               //} 
               //this.A.getS_cont().release();
               this.I.textarea2.setText("\ngerente verficando contador\n");
               Gerente.sleep((dia)*2/24);
               if(this.A.getDias_para_despacho()==0){//Autorizo el despacho
                  
                  this.A.getS_stockJuegos().acquire();
                  
                  this.I.textarea2.setText("\ngerente autorizando despacho\n");
                  Gerente.sleep((dia)*2/24);
                  this.A.setStock_juegos(this.A.getStock_juegos()+this.A.getUnidades_disponibles());
                  this.A.setUnidades_disponibles(0);
                  this.I.textarea4.setText("Nro de unidades sin despachar:      "+this.A.getUnidades_disponibles());
                  this.I.unidades_finales.setText("\nUnidades Finales:_"+this.A.getStock_juegos());
                  this.A.getS_stockJuegos().release();
                  //this.A.getS_cont().acquire();
                  //this.A.setCont(this.A.getCont()-1);
                  //if(this.A.getCont()==0){
                  //this.A.getS_dias_para_despacho().release();
                  //      }  
                 //this.A.getS_cont().release();
                 this.A.getS_dias_para_despacho().release();
               }else
               {
                this.I.textarea2.setText("\ngerente verficando contador\n");
                Gerente.sleep((dia)*5/24);
                //this.A.getS_cont().acquire();
                //this.A.setCont(this.A.getCont()-1);
                //if(this.A.getCont()==0){
                this.A.getS_dias_para_despacho().release();
                        //}  
               //this.A.getS_cont().release();
               }
            
             
           } catch (InterruptedException ex) {
               Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   
    }
    
    
}
