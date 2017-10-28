/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cronometrador extends Thread {
    private int contador; //Contador de dias que faltan para despachar 
    private int dia; //el nro de milisegundos que equivalen a un dia en el programa
    private double duracion_escritura;// tiempo en milisegundos que tarda en escribir.
    private Almacen A; //Para acceder a los recursos compartidos.
    private Interfaz I;
    
    public Cronometrador(int xdia, Almacen A, Interfaz I){
       this.dia=xdia;
       this.duracion_escritura=(this.dia*(1.2))/(24);
       this.A=A;
       this.contador=this.A.getDias_para_despacho();
       this.I=I;
    }
    
    @Override
    public void run ()
            
    {
        while (true){
             
          
            try {
                
                //Pasa un dia
                this.I.cronometrador.setText("\nCronometrador durmiendo\n");
                Cronometrador.sleep(this.dia);    
                //----------------------------
                this.A.getS_dias_para_despacho().acquire(); //Pedir acceso al contador
                this.I.cronometrador.setText("\nCronometrador escribiendo\n");
                if(this.A.getDias_para_despacho()==0){
                    //Reinicio el contador
                    this.A.setDias_para_despacho(this.A.getNro_diasfijo_despacho());          
                    Cronometrador.sleep((long)this.duracion_escritura);
                    this.I.textarea3.setText("Nro de dias para despacho:_"+this.A.getDias_para_despacho());
                    this.A.getS_dias_para_despacho().release(); //Contador disponible para lectura o escritura
                }
                else{
                this.A.setDias_para_despacho(this.A.getDias_para_despacho()-1);
                //--Me tardo 1,2 horas
                Cronometrador.sleep((long)this.duracion_escritura);
                this.I.textarea3.setText("Nro de dias para despacho:_"+this.A.getDias_para_despacho());
                //--------------------------------------------
                this.A.getS_dias_para_despacho().release(); //Contador disponible para lectura o escritura
                }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    
    }
    
}
