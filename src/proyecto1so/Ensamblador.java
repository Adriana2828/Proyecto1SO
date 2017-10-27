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
    
     public Ensamblador (Almacen a, Interfaz I){
     
     this.A=a;
     this.I=I;
         
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
                //Dura dos dias ensamblando
                //this.I.textarea8.setText("Ensamblando...");
                //Aumentar el nro de juegos terminados disponibles
                //Pido permiso para modificar el contador de juegos terminados
                this.A.getS_stockJuegos().acquire();
                this.A.setStock_juegos(this.A.getStock_juegos()+1);
                //Aviso que ya deje de usar el contador de juegos terminados
                this.I.textarea4.setText("Nro de Juegos:\n"+"              "+this.A.getStock_juegos());
                this.A.getS_stockJuegos().release();
                
                
                 synchronized(this){ 
                          while(pausar==true){
                          wait();
                          }
                      }
                
                
               
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
