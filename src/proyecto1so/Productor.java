/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {
    private Almacen A;
    private Interfaz I;
    private int tipo; // tipo==0 (controles), tipo==1(consola), tipo==2(paquetes)
    public Productor(Almacen a, Interfaz i,int t){
       this.A=a;
       this.I=i;
       this.tipo=t;
    }
    @Override
     public void run(){
         
        while(true){
        
              if (this.tipo==0){
                  try {
                      //producir controles
                      //OJO AQUI FALTA PRODUCIR POR UN DIA OJOJOJOJOJOJO!!!
                       Productor.sleep(1000);
                      //Produzco el control (esto toma un dia)
                      //Quiero guardar el control si hay espacio
                       this.A.getSP_controles().acquire();
                      //Quiero entrar al almacen para dejar el control
                       this.A.getSE_controles().acquire();
                      //Dejo el control en el almacen
                       this.A.almacenar_control();
                       this.A.setStock_controles(this.A.getStock_controles()+1);
                       I.textarea5.setText("Controles en almacen:\n          "+A.getStock_controles());
                      //Ya sali del almacen
                       this.A.getSE_controles().release();
                      //Aviso q se puede consumir un nuevo control
                       this.A.getSC_controles().release();
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
              if (this.tipo==1){
                  try {
                      //producir consolas
                      //OJO AQUI FALTA PRODUCIR  OJOJOJOJOJOJO!!!
                       Productor.sleep(1000);
                      //Produzco la consolas (esto toma un dia)
                      //Quiero guardar la consola si hay espacio
                      this.A.getSP_consolas().acquire();
                      //Quiero entrar al almacen para dejar el control
                      this.A.getSE_consolas().acquire();
                      //Dejo la consola en el almacen
                      this.A.almacenar_consola();
                      this.A.setStock_consolas(this.A.getStock_consolas()+1);
                      I.textarea6.setText("Consolas en almacen:\n          "+A.getStock_consolas());
                      //Ya sali del almacen
                      this.A.getSE_consolas().release();
                      //Aviso q se puede consumir una nueva consola
                      this.A.getSC_consolas().release();
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                  }
              
              
              }
              if (this.tipo==2){
                  try {
                      //producir paquetes
                      //OJO AQUI FALTA PRODUCIR  OJOJOJOJOJOJO!!!
                       Productor.sleep(1000);
                      //Produzco los paquetes ---
                      //Quiero guardar el paquete si hay espacio
                      this.A.getSP_paquetes().acquire();
                      //Quiero entrar al almacen para dejar el control
                      this.A.getSE_paquetes().acquire();
                      //Dejo la consola en el almacen
                      this.A.almacenar_paquete();
                      this.A.setStock_paquetes(this.A.getStock_paquetes()+1);
                      I.textarea7.setText("Paquetes en almacen:\n          "+A.getStock_paquetes());
                      //Ya sali del almacen
                      this.A.getSE_paquetes().release();
                      //Aviso q se puede consumir una nueva consola
                      this.A.getSC_paquetes().release();
                  } catch (InterruptedException ex) {
                      Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
        
        }              
}
}
    
    
    
    

