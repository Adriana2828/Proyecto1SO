/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.io.IOException;

public class Fabrica {
 
private LeerArchivo LA;    
    
private Cronometrador C;    
private Gerente G;

private int dia;                      //El numero de milisegundos que hay en un dia en el programa.   
private Almacen A;                         //Almacen tiene todos los recursos compartidos.
private Interfaz I;                        //Interfaz Grafica
private ContadorDias cd;                   //Cuenta los dias transcurridos en el programa.
private Productor[] prod_controles;        //Arreglo productores de controles. 
private Boolean[]   status_prod_controles; //Arreglo para indicar si cada productor esta contratado/despedido/inactivo
private int max_prod_controles;            //Indica el nro maximo de productor de controles que puede haber
private int nro_prod_controles;            //Indica el nro de productor de controles activos
private int nro_dias_pcontroles;           //Numero de dias que tarda la produccion de controles


private Productor[] prod_consolas;
private Boolean[]   status_prod_consolas;
private int max_prod_consolas;            
private int nro_prod_consolas;
private int nro_dias_pconsolas;           //Numero de dias que tarda la produccion de consolas

private Productor[] prod_paquetes;
private Boolean[]   status_prod_paquetes;
private int max_prod_paquetes;            
private int nro_prod_paquetes;
private int nro_dias_ppaquetes;           //Numero de dias que tarda la produccion de controles

private Ensamblador[] ensambladores;    //Arreglo de ensambladores
private Boolean[]     status_ensambladores; //Para indicar si cada ensamblador esta activo o no.
private int max_ensambladores; // indica nro maximo de ensambladores
private int nro_ensambladores; // indica nro de ensambladores activos
private int nro_dias_ensamblaje;  //numero de dias que toma ensamblar el producto final.


public Fabrica(Interfaz I){ //Inicia con los valores establecidos en el enunciado del proyecto.
    
    this.I=I;
    this.dia=4000;
    this.cd=new ContadorDias(this.dia,this.I);
    this.A=new Almacen(30,20,40,10); //Alm controles, Alm consolas, Alm Paquetes, Dias Despacho
    this.C=new Cronometrador(this.dia,this.A,this.I);
    this.G=new Gerente(this.dia,this.A,this.I);
    this.max_prod_controles=5;
    this.nro_prod_controles=3; //3
    this.nro_dias_pcontroles=1;
    this.max_prod_consolas=10;
    this.nro_prod_consolas=2;
    this.nro_dias_pconsolas=3;
    this.max_prod_paquetes=3;
    this.nro_prod_paquetes=1;
    this.nro_dias_ppaquetes=1;
    this.nro_ensambladores=1;//1 
    this.max_ensambladores=4;
    this.nro_dias_ensamblaje=2;
    this.inicializar_prod_controles();
    this.inicializar_prod_consolas();
    this.inicializar_prod_paquetes();
    this.inicializar_ensambladores();
    this.cd.start();//inicio contador de dias de programa
    this.C.start(); //inicio cromotrador
    this.G.start(); //iniciar al gerente
    this.producir();
    this.ensamblar();
   
}
public Fabrica(String nombre, Interfaz I) throws IOException{// Para iniciar con los valores leidos de un archivo.
    this.LA=new LeerArchivo(nombre);
    this.I=I;
    this.dia=1000*LA.getTiempo_Seg_UnDia(); //cantidad de milisegundos en un dia.
    this.cd=new ContadorDias(this.dia,this.I);  
    this.A=new Almacen(this.LA.getCap_Max_Alm_Controles(),this.LA.getCap_Max_Alm_Consolas(),this.LA.getCap_Max_Alm_Paquetes(),this.LA.getCant_dias_despachos());
    this.C=new Cronometrador(this.dia,this.A,this.I);
    this.G=new Gerente(this.dia,this.A,this.I);
    this.max_prod_controles=this.LA.getCant_Max_PControles();
    this.nro_prod_controles=this.LA.getCant_inic_PControles(); 
    this.nro_dias_pcontroles=1;
    this.max_prod_consolas=this.LA.getCant_Max_PConsolas();
    this.nro_prod_consolas=this.LA.getCant_inic_PConsolas();
    this.nro_dias_pconsolas=3;
    this.max_prod_paquetes=this.LA.getCant_Max_PPaquetes();
    this.nro_prod_paquetes=this.LA.getCant_inic_PPaquetes();
    this.nro_dias_ppaquetes=1;
    this.nro_ensambladores=this.LA.getCant_inic_Ensambladores(); 
    this.max_ensambladores=this.LA.getCant_Max_Ensambladores();
    this.nro_dias_ensamblaje=2;
    System.out.println("Tiempo de un programa en segundos:_"+this.dia+"\n");
    System.out.println("Cantidad de dias entre despachos:_"+this.LA.getCant_dias_despachos()+"\n");
    System.out.println("Cantidad Maxima de Almacen de Controles:_"+this.LA.getCap_Max_Alm_Controles()+"\n");
    System.out.println("Cantidad Maxima de Almacen de Consolas:_"+this.LA.getCap_Max_Alm_Consolas()+"\n");
    System.out.println("Cantidad Maxima de Almacen de Paquetes:_"+this.LA.getCap_Max_Alm_Paquetes()+"\n");
    System.out.println("Cantidad Inicial de productores de controles:_"+this.LA.getCant_inic_PControles()+"\n");
    System.out.println("Cantidad Inicial de productores de consolas:_"+this.LA.getCant_inic_PConsolas()+"\n");
    System.out.println("Cantidad Inicial de productores de paquetes:_"+this.LA.getCant_inic_PPaquetes()+"\n");
    System.out.println("Cantidad Inicial de ensambladores:_"+this.LA.getCant_inic_Ensambladores()+"\n");
    System.out.println("Cantidad Maxima de productores de controles:_"+this.LA.getCant_Max_PControles()+"\n");    
    System.out.println("Cantidad Maxima de productores de consolas:_"+this.LA.getCant_Max_PConsolas()+"\n");
    System.out.println("Cantidad Maxima de productores de paquetes:_"+this.LA.getCant_Max_PPaquetes()+"\n");
    System.out.println("Cantidad Maxima de ensambladores:_"+this.LA.getCant_Max_Ensambladores()+"\n"); 
    this.inicializar_prod_controles();
    this.inicializar_prod_consolas();
    this.inicializar_prod_paquetes();
    this.inicializar_ensambladores();
    this.cd.start();//inicio contador de dias de programa
    this.C.start(); //inicio cromotrador
    this.G.start(); //iniciar al gerente
    this.producir();
    this.ensamblar();
   
}

public Almacen get_Almacen() {
        return this.A;
    }
public void contratar_ensambladores(){
    
  
    if (this.nro_ensambladores==0){
        if(this.ensambladores[0]==null){
            
        this.ensambladores[0]=new Ensamblador(this.A,this.I,this.dia,this.nro_dias_ensamblaje);
        this.status_ensambladores[0]=true;
        this.ensambladores[0].start();        
        this.nro_ensambladores++;
        this.I.textarea12.setText("Nro de Ensambladores:_"+this.nro_ensambladores);
        }
        else {
             this.ensambladores[nro_ensambladores].reanudar();
             this.nro_ensambladores++;
             this.I.textarea12.setText("Nro de Ensambladores:_"+this.nro_ensambladores);
        }
    }
    
    else if (this.nro_ensambladores<this.max_ensambladores){
         if(this.ensambladores[nro_ensambladores]==null){
            
        this.ensambladores[this.nro_ensambladores]=new Ensamblador(this.A,this.I,this.dia,this.nro_dias_ensamblaje);
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
            
        this.prod_controles[this.nro_prod_controles]=new Productor(this.A,this.I,0,this.dia,this.nro_dias_pcontroles);
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
            
        this.prod_consolas[this.nro_prod_consolas]=new Productor(this.A,this.I,1,this.dia,this.nro_dias_pconsolas);
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
            
        this.prod_paquetes[this.nro_prod_paquetes]=new Productor(this.A,this.I,2,this.dia,this.nro_dias_ppaquetes);
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
      this.prod_controles[i]=new Productor(this.A,this.I,0,this.dia,this.nro_dias_pcontroles);
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
      this.prod_consolas[i]=new Productor(this.A,this.I,1,this.dia,this.nro_dias_pconsolas);
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
      this.prod_paquetes[i]=new Productor(this.A,this.I,2,this.dia,this.nro_dias_ppaquetes);
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
      this.ensambladores[i]=new Ensamblador(this.A,this.I,this.dia,this.nro_dias_ensamblaje);
      this.status_ensambladores[i]=true;
      i++;
    
    }

}
public Cronometrador getC() {
        return C;
    }
public Gerente getG() {
        return G;
    }
public ContadorDias getCd() {
        return cd;
    }



}
