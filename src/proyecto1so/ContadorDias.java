/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContadorDias extends Thread{
    private Interfaz I;
    private int dia; //valor de un dia en milisegundos en el programa
    private int contador;
    public ContadorDias(int dia,Interfaz I){ //d=cantidad en milisegundos de un dia en el programa.
        this.I=I;
        this.dia=dia;
        this.contador=0;
    
}
    @Override
   public void run()
   {
     while (true){
         try {
             ContadorDias.sleep(this.dia);
             contador++;
             this.I.nro_dias_programa.setText("Dias transcurridos en el programa:     "+contador);
         } catch (InterruptedException ex) {
             Logger.getLogger(ContadorDias.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
   }
    
}