/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ensamblador extends Thread {
     private Boolean pausar=false;
     private Almacen A;
     private Interfaz I;
     private int dia; //valor en milisegundos de un dia en el programa
     private int nro_dias; //duracion del ensamblaje en dias.
     public Ensamblador (Almacen a, Interfaz I, int xdia, int xnro_dias){
     
     this.A=a;
     this.I=I;
     this.dia=xdia;
     this.nro_dias=xnro_dias;
     } 
    
     public void run(){
        int i=0;
        while (true)
        { 
            try {
                //Quiero dos controles del almacen de controles
                this.A.getSC_controles().acquire(2);
                //Quiero entrar al almacen a buscar los controles
                this.A.getSE_controles().acquire();
                //Tomo los controles
                this.A.consumir_control();
                this.A.consumir_control();
                this.A.setStock_controles(this.A.getStock_controles()-2);
                //Aviso que ya sali del almacen de controles
                this.A.getSE_controles().release();
                //Aviso al productor de controles que hay dos nuevos espacios disponibles en almacen
                this.A.getSP_controles().release(2);
                //Quiero Tomar una consola del almacen de consolas
                this.A.getSC_consolas().acquire();
                //Quiero entrar al almacen a buscar la consola
                this.A.getSE_consolas().acquire();
                this.A.consumir_consola();
                this.A.setStock_consolas(this.A.getStock_consolas()-1);
                //Aviso que ya sali del almacen de consolas
                this.A.getSE_consolas().release();
                //Aviso al productor de consolas que hay un nuevo espacio disponible en almacen
                this.A.getSP_consolas().release();
                //Quiero Tomar un paquete del almacen de paquetes
                this.A.getSC_paquetes().acquire();
                //Quiero entrar al almacen de paquetes a tomar el paquete
                this.A.getSE_paquetes().acquire();
                this.A.consumir_paquete();
                this.A.setStock_paquetes(this.A.getStock_paquetes()-1);
                //Aviso que ya sali del almacen de paquetes
                this.A.getSE_paquetes().release();
                //Aviso al productor de paquetes que hay un nuevo espacio disponible en almacen
                this.A.getSP_paquetes().release();
                  synchronized(this){ 
                          while(pausar==true){
                          wait();
                          }
                      }
                //Ensamblaje
                 Ensamblador.sleep(this.dia*this.nro_dias);
                //-----------------------------------------------------------------
                this.I.textarea8.setText("Ensamblando");
                if(this.I.F.getNro_prod_controles()==0){
                this.I.textarea5.setText("Controles en Almacen:\n"+"              "+this.A.getStock_controles());
                if((this.A.getStock_controles()==1)||(this.A.getStock_controles()==0)){
                   this.I.textarea8.setText("Ensamblaje a la espera de piezas");
                }
                 }
                if(this.I.F.getNro_prod_consolas()==0){
                this.I.textarea6.setText("Consolas en Almacen:\n"+"              "+this.A.getStock_consolas());
                 if(this.A.getStock_consolas()==0){
                   this.I.textarea8.setText("Ensamblaje a la espera de piezas");
                } 
                }
                if(this.I.F.getNro_prod_paquetes()==0){
                this.I.textarea7.setText("Paquetes en Almacen:\n"+"              "+this.A.getStock_paquetes());
                 if(this.A.getStock_paquetes()==0){
                   this.I.textarea8.setText("Ensamblaje a la espera de piezas");
                } 
                }
                //Aumentar el nro de unidades disponibles
                //Pido permiso para modificar el contador de unidades disponibles
                this.A.getS_stockJuegos().acquire();
                this.A.setUnidades_disponibles(this.A.getUnidades_disponibles()+1);
                //Aviso que ya deje de usar el contador de juegos terminados
                this.I.textarea4.setText("Nro de unidades sin despachar:\n"+"              "+this.A.getUnidades_disponibles());
                this.A.getS_stockJuegos().release();
                
                
               
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
            
            
        }
    
    
    
    
    
}
   public void pausar(){
     this.pausar=true;
    }
    
    synchronized void reanudar(){
     this.pausar=false;
     notify();
    }  
}
