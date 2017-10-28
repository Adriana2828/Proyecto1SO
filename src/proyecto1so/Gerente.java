/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;

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
    public Gerente(int dia, Almacen A,Interfaz I){
        this.I=I;
        this.dia=dia;
        this.A=A;
        this.horas6=(6*dia)/24;
        this.horas18=(18*dia)/24;
    }
    
    @Override
    public void run (){
    
       while (true){
       
           try {
               this.A.getS_cont().acquire();
               this.A.setCont(this.A.getCont()+1);
               if(this.A.getCont()==1){
                   this.A.getS_dias_para_despacho().acquire();
               } 
               this.A.getS_cont().release();
               //Aqui es donde yo digo, si diahs_para_despacho==0 autorizo despacho.
               if(this.A.getDias_para_despacho()==0){//Autorizo el despacho
                  this.I.textarea2.setText("gerente autorizando despacho");
                  this.A.getS_stockJuegos().acquire();
             
                  this.A.setStock_juegos(this.A.getStock_juegos()+this.A.getUnidades_disponibles());
                  this.A.setUnidades_disponibles(0);
                  
                  this.I.textarea4.setText("Nro de unidades sin despachar:\n"+"              "+this.A.getUnidades_disponibles());
                  this.I.unidades_finales.setText("Unidades Finales:_"+this.A.getStock_juegos());
                  this.A.getS_stockJuegos().release();
                  this.A.getS_cont().acquire();
                  this.A.setCont(this.A.getCont()-1);
                  if(this.A.getCont()==0){
                        this.A.getS_dias_para_despacho().release();
                        }  
               this.A.getS_cont().release();
               }else
               {
                this.A.getS_cont().acquire();
                  this.A.setCont(this.A.getCont()-1);
                  if(this.A.getCont()==0){
                        this.A.getS_dias_para_despacho().release();
                        }  
               this.A.getS_cont().release();
               this.I.textarea2.setText("Gerente durmiendo");
               Gerente.sleep(dia/2);//ESTO HAY Q PONERLO RANDOM ENTRE 6 Y 18 HORAS FALTA OJO
               }
             
           } catch (InterruptedException ex) {
               Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   
    }
    
    
}
