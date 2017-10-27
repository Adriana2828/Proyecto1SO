/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;


public class Fabrica {
    
private Almacen A;                         //Almacen tiene todos los recursos compartidos.
private Interfaz I;                        //Interfaz Grafica

private Productor[] prod_controles;        //Arreglo productores de controles. 
private Boolean[]   status_prod_controles; //Arreglo para indicar si cada productor esta contratado/despedido/inactivo
private int max_prod_controles;            //Indica el nro maximo de productor de controles que puede haber
private int nro_prod_controles;            //Indica el nro de productor de controles activos

private Productor[] prod_consolas;
private Boolean[]   status_prod_consolas;
private int max_prod_consolas;            
private int nro_prod_consolas;

private Productor[] prod_paquetes;
private Boolean[]   status_prod_paquetes;
private int max_prod_paquetes;            
private int nro_prod_paquetes;

private Ensamblador[] ensambladores;    //Arreglo de ensambladores
private Boolean[]     status_ensambladores; //Para indicar si cada ensamblador esta activo o no.
private int max_ensambladores; // indica nro maximo de ensambladores
private int nro_ensambladores; // indica nro de ensambladores activos

private void producir(){
         producir_controles();
         producir_consolas();
         producir_paquetes();
}
private void ensamblar(){

      int i=0;
  while(i<this.nro_ensambladores){
        this.ensambladores[i].start();
        i++;
  }

}
private void producir_paquetes(){
    
  int i=0;
  while(i<this.nro_prod_paquetes){
        this.prod_paquetes[i].start();
        i++;
  }
}
private void producir_consolas(){
    
      int i=0;
      while(i<this.nro_prod_consolas){
        this.prod_consolas[i].start();
        i++;
    }
}
private void producir_controles(){
    
  int i=0;
  while(i<this.nro_prod_controles){
        this.prod_controles[i].start();
        i++;
  }
}
private void inicializar_prod_controles(){
    this.prod_controles=new Productor[this.max_prod_controles];
    this.status_prod_controles=new Boolean[this.max_prod_controles];
    int i=0;
    while(i<this.nro_prod_controles)
    {
      this.prod_controles[i]=new Productor(this.A,this.I,0);
      this.status_prod_controles[i]=true;
      i++;
    }
    
}
private void inicializar_prod_consolas(){
    this.prod_consolas=new Productor[this.max_prod_consolas];
    this.status_prod_consolas=new Boolean[this.max_prod_consolas];
    int i=0;
    while(i<this.nro_prod_consolas)
    {
      this.prod_consolas[i]=new Productor(this.A,this.I,1);
      this.status_prod_consolas[i]=true;
      i++;
    
    }
    
}     
private void inicializar_prod_paquetes(){
    this.prod_paquetes=new Productor[this.max_prod_paquetes];
    this.status_prod_paquetes=new Boolean[this.max_prod_paquetes];
    int i=0;
    while(i<this.nro_prod_paquetes)
    {
      this.prod_paquetes[i]=new Productor(this.A,this.I,2);
      this.status_prod_paquetes[i]=true;
      i++;
    
    }
    
}
private void inicializar_ensambladores(){

    this.ensambladores=new Ensamblador[this.max_ensambladores];
    this.status_ensambladores=new Boolean[this.max_ensambladores];
    int i=0;
    while(i<this.nro_ensambladores)
    {
      this.ensambladores[i]=new Ensamblador(this.A,this.I);
      this.status_ensambladores[i]=true;
      i++;
    
    }

}



public Fabrica(Interfaz I){ //Inicia con los valores establecidos en el enunciado del proyecto.
    this.I=I;  
    this.A=new Almacen(30,20,40);
    this.max_prod_controles=5;
    this.nro_prod_controles=3;
    this.max_prod_consolas=10;
    this.nro_prod_consolas=2;
    this.max_prod_paquetes=3;
    this.nro_prod_paquetes=1;
    this.nro_ensambladores=1;
    this.max_ensambladores=4;
    this.inicializar_prod_controles();
    this.inicializar_prod_consolas();
    this.inicializar_prod_paquetes();
    this.inicializar_ensambladores();
    this.producir();
    this.ensamblar();
    
    
}
public Almacen get_Almacen() {
        return this.A;
    }
public Fabrica(String nombre, Interfaz I){// Para iniciar con los valores leidos de un archivo.
}
public void contratar_ensambladores(){

    if (this.nro_ensambladores<this.max_ensambladores){
        if(this.ensambladores[nro_ensambladores]==null){
            
        this.ensambladores[this.nro_ensambladores]=new Ensamblador(this.A,this.I);
        this.status_ensambladores[this.nro_ensambladores]=true;
        this.ensambladores[this.nro_ensambladores].start();        
        this.nro_ensambladores++;
        this.I.textarea12.setText("Nro de Ensambladores:_"+this.nro_ensambladores);
    }
        else{
             this.ensambladores[nro_ensambladores].reanudar();
             this.nro_ensambladores++;
             this.I.textarea12.setText("Nro de Ensambladores:_"+this.nro_ensambladores);
        }
    
    }
    
}
public void contratar_pcontroles(){

    if (this.nro_prod_controles<this.max_prod_controles){
        if(this.prod_controles[nro_prod_controles]==null){
            
        this.prod_controles[this.nro_prod_controles]=new Productor(this.A,this.I,0);
        this.status_prod_controles[this.nro_prod_controles]=true;
        this.prod_controles[this.nro_prod_controles].start();        
        this.nro_prod_controles++;
        this.I.textarea9.setText("Nro de Productores de Controles:_"+this.nro_prod_controles);
    }
        else{
             this.prod_controles[nro_prod_controles].reanudar();
             this.nro_prod_controles++;
             this.I.textarea9.setText("Nro de Productores de Controles:_"+this.nro_prod_controles);
        }
    
    }
    
}
public void contratar_pconsolas(){

    if (this.nro_prod_consolas<this.max_prod_consolas){
        if(this.prod_consolas[nro_prod_consolas]==null){
            
        this.prod_consolas[this.nro_prod_consolas]=new Productor(this.A,this.I,1);
        this.status_prod_consolas[this.nro_prod_consolas]=true;
        this.prod_consolas[this.nro_prod_consolas].start();        
        this.nro_prod_consolas++;
        this.I.textarea10.setText("Nro de Productores de Consolas:_"+this.nro_prod_consolas);
    }
        else{
             this.prod_consolas[nro_prod_consolas].reanudar();
             this.nro_prod_consolas++;
             this.I.textarea10.setText("Nro de Productores de Consolas:_"+this.nro_prod_consolas);
        }
    
    }
    
}
public void contratar_ppaquetes(){

    if (this.nro_prod_paquetes<this.max_prod_paquetes){
        if(this.prod_paquetes[nro_prod_paquetes]==null){
            
        this.prod_paquetes[this.nro_prod_paquetes]=new Productor(this.A,this.I,2);
        this.status_prod_paquetes[this.nro_prod_paquetes]=true;
        this.prod_paquetes[this.nro_prod_paquetes].start();        
        this.nro_prod_paquetes++;
        this.I.textarea11.setText("Nro de Productores de Paquetes:_"+this.nro_prod_paquetes);
    }
        else{
             this.prod_paquetes[nro_prod_paquetes].reanudar();
             this.nro_prod_paquetes++;
             this.I.textarea11.setText("Nro de Productores de Paquetes:_"+this.nro_prod_paquetes);
        }
    
    }
    
}
public void despedir_pcontroles(){

        this.status_prod_controles[this.nro_prod_controles-1]=false;
        this.prod_controles[this.nro_prod_controles-1].pausar();        
        this.nro_prod_controles--;
        this.I.textarea9.setText("Nro de Productores de Controles:_"+this.nro_prod_controles);

}
public void despedir_ppaquetes(){

        this.status_prod_paquetes[this.nro_prod_paquetes-1]=false;
        this.prod_paquetes[this.nro_prod_paquetes-1].pausar();        
        this.nro_prod_paquetes--;
        this.I.textarea11.setText("Nro de Productores de Paquetes:_"+this.nro_prod_paquetes);
        
}
public void despedir_pconsolas(){

        this.status_prod_consolas[this.nro_prod_consolas-1]=false;
        this.prod_consolas[this.nro_prod_consolas-1].pausar();        
        this.nro_prod_consolas--;
        this.I.textarea10.setText("Nro de Productores de Consolas:_"+this.nro_prod_consolas);
       
}
public void despedir_ensambladores(){

        this.status_ensambladores[this.nro_ensambladores-1]=false;
        this.ensambladores[this.nro_ensambladores-1].pausar();        
        this.nro_ensambladores--;
        this.I.textarea12.setText("Nro de Ensambladores:_"+this.nro_ensambladores);
        if(this.nro_ensambladores==0){
            this.I.textarea8.setText("Ensamblaje detenido");
        }
}
public int getNro_prod_controles() {
        return nro_prod_controles;
    }
public int getNro_prod_consolas() {
        return nro_prod_consolas;
    }
public int getNro_prod_paquetes() {
        return nro_prod_paquetes;
    }
public int getNro_ensambladores() {
        return nro_ensambladores;
    }

}
