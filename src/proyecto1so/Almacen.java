/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;
import java.util.concurrent.Semaphore;

public class Almacen {
   
   private int unidades_disponibles;      //Indica el nro de unidades disponibles, sin despachar.
   private int stock_juegos;              //Indica el nro de unidades FINALES disponibles
   private int nro_diasfijo_despacho;     //Esta variable no se modifica. Es el valor predeterminado de dias de despacho
   private int dias_para_despacho;        //Indica el nro de dias que falta para realizar un nuevo despacho.
   private int cont;                      //Contador de lectores de la variable dias_para_despacho.
   private Semaphore S_cont;              // Controla el acceso a la variable S_cont
   private Semaphore S_dias_para_despacho;// Controla el acceso a la variable dias_para_despacho 
   private Semaphore S_stockJuegos;       // Controla el acceso a la variable stock_juegos y unidades_disponibles.
   
   
   private int tam_controles;         //tamaño del almacen de controles.
   private int ap_Pcontroles;         //apuntador al espacio del almacen que se puede utilizar.
   private int ap_Ccontroles;         //apuntador al elemento del almacen que se puede consumir.
   private boolean[] Alm_controles;   //Almacen de controles. True indica espacio lleno, False indica espacio vacio.
   private Semaphore SP_controles;    //Semaforo para controlar la produccion de controles.
   private Semaphore SC_controles;    //Semaforo para controlar el consumo de controles.
   private Semaphore SE_controles;    //Semaforo para controlar la exclusion mutua del almacen de controles.
   private int stock_controles;       // Numero total de controles en almacen.
   
   private int tam_consolas;         //tamaño del almacen de consolas.
   private int ap_Pconsolas;         //apuntador al espacio del almacen que se puede utilizar.
   private int ap_Cconsolas;         //apuntador al elemento del almacen que se puede consumir.
   private boolean[] Alm_consolas;   //Almacen de consolas. True indica espacio lleno, False indica espacio vacio.
   private Semaphore SP_consolas;    //Semaforo para controlar la produccion de consolas.
   private Semaphore SC_consolas;    //Semaforo para controlar el consumo de consolas.
   private Semaphore SE_consolas;    //Semaforo para controlar la exclusion mutua del almacen de consolas.
   private int stock_consolas;       //Numero total de consolas en almacen.
   
   private int tam_paquetes;         //tamaño del almacen de paquetes.
   private int ap_Ppaquetes;         //apuntador al espacio del almacen que se puede utilizar.
   private int ap_Cpaquetes;         //apuntador al elemento del almacen que se puede consumir.
   private boolean[] Alm_paquetes;   //Almacen de paquetes. True indica espacio lleno, False indica espacio vacio.
   private Semaphore SP_paquetes;    //Semaforo para controlar la produccion de paquetes.
   private Semaphore SC_paquetes;    //Semaforo para controlar el consumo de paquetes.
   private Semaphore SE_paquetes;    //Semaforo para controlar la exclusion mutua del almacen de paquetes.
   private int stock_paquetes;       //Numero total de paquetes en almacen.
   
   public Almacen(int tam_cont, int tam_cons, int tam_paq, int dias_despacho)
   {
     this.tam_controles=tam_cont;
     this.tam_consolas=tam_cons;
     this.tam_paquetes=tam_paq;
     this.stock_juegos=0;
     this.ap_Pcontroles=0;
     this.ap_Ccontroles=0;
     this.ap_Pconsolas=0;
     this.ap_Cconsolas=0;
     this.ap_Ppaquetes=0;
     this.ap_Cpaquetes=0;
     this.Alm_controles=new boolean[this.tam_controles];
     this.Alm_consolas=new boolean[this.tam_consolas];
     this.Alm_paquetes=new boolean[this.tam_paquetes];
     this.SP_controles=new Semaphore(this.tam_controles);
     this.SC_controles=new Semaphore(0);
     this.SE_controles=new Semaphore(1);
     this.SP_consolas=new Semaphore(this.tam_consolas);
     this.SC_consolas=new Semaphore(0);
     this.SE_consolas=new Semaphore(1);
     this.SP_paquetes=new Semaphore(this.tam_paquetes);
     this.SC_paquetes=new Semaphore(0);
     this.SE_paquetes=new Semaphore(1);
     
     //------------------------------------------------------------------------
     this.S_cont=new Semaphore(1);
     this.S_dias_para_despacho=new Semaphore(1);
     this.nro_diasfijo_despacho=dias_despacho;
     this.dias_para_despacho=this.nro_diasfijo_despacho;
     this.cont=0;
     this.unidades_disponibles=0;
     this.S_stockJuegos=new Semaphore(1);
   }

    public int getNro_diasfijo_despacho() {
        return nro_diasfijo_despacho;
    }
   
   

    public int getUnidades_disponibles() {
        return unidades_disponibles;
    }

    public int getDias_para_despacho() {
        return dias_para_despacho;
    }

    public int getCont() {
        return cont;
    }

    public void setUnidades_disponibles(int unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    public void setDias_para_despacho(int dias_para_despacho) {
        this.dias_para_despacho = dias_para_despacho;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
   
    public Semaphore getS_cont() {
        return S_cont;
    }

    public Semaphore getS_dias_para_despacho() {
        return S_dias_para_despacho;
    }
   
    public int getStock_juegos() {
        return stock_juegos;
    }

    public void setStock_juegos(int stock_juegos) {
        this.stock_juegos = stock_juegos;
    }

    public Semaphore getS_stockJuegos() {
        return S_stockJuegos;
    }

    public void setS_stockJuegos(Semaphore S_stockJuegos) {
        this.S_stockJuegos = S_stockJuegos;
    }

    public int getTam_controles() {
        return tam_controles;
    }

    public int getAp_Pcontroles() {
        return ap_Pcontroles;
    }

    public int getAp_Ccontroles() {
        return ap_Ccontroles;
    }

    public boolean[] getAlm_controles() {
        return Alm_controles;
    }

    public Semaphore getSP_controles() {
        return SP_controles;
    }

    public Semaphore getSC_controles() {
        return SC_controles;
    }

    public Semaphore getSE_controles() {
        return SE_controles;
    }

    public int getTam_consolas() {
        return tam_consolas;
    }

    public int getAp_Pconsolas() {
        return ap_Pconsolas;
    }

    public int getAp_Cconsolas() {
        return ap_Cconsolas;
    }

    public boolean[] getAlm_consolas() {
        return Alm_consolas;
    }

    public Semaphore getSP_consolas() {
        return SP_consolas;
    }

    public Semaphore getSC_consolas() {
        return SC_consolas;
    }

    public Semaphore getSE_consolas() {
        return SE_consolas;
    }

    public int getTam_paquetes() {
        return tam_paquetes;
    }

    public int getAp_Ppaquetes() {
        return ap_Ppaquetes;
    }

    public int getAp_Cpaquetes() {
        return ap_Cpaquetes;
    }

    public boolean[] getAlm_paquetes() {
        return Alm_paquetes;
    }

    public Semaphore getSP_paquetes() {
        return SP_paquetes;
    }

    public Semaphore getSC_paquetes() {
        return SC_paquetes;
    }

    public Semaphore getSE_paquetes() {
        return SE_paquetes;
    }

 
    public void setTam_controles(int a) {
        this.tam_controles = a;
    }

    public void setAp_Pcontroles(int a) {
        this.ap_Pcontroles = a;
    }

    public void setAp_Ccontroles(int a) {
        this.ap_Ccontroles = a;
    }

    public void almacenar_control() {
        
        this.Alm_controles[this.ap_Pcontroles] =true;
        this.ap_Pcontroles=(ap_Pcontroles+1)%this.tam_controles;
        
        
    }

    public void consumir_control() {
        
        this.Alm_controles[this.ap_Ccontroles] =false;
        this.ap_Ccontroles=(ap_Ccontroles+1)%this.tam_controles;
        
        
    }

    public void setTam_consolas(int a) {
        this.tam_consolas = a;
    }

    public void setAp_Pconsolas(int a) {
        this.ap_Pconsolas = a;
    }

    public void setAp_Cconsolas(int a) {
        this.ap_Cconsolas = a;
    }

    public void almacenar_consola() {
        this.Alm_consolas[this.ap_Pconsolas] =true;
        this.ap_Pconsolas=(ap_Pconsolas+1)%this.tam_consolas;
    }

    public void consumir_consola() {
        
        this.Alm_consolas[this.ap_Cconsolas] =false;
        this.ap_Cconsolas=(ap_Cconsolas+1)%this.tam_consolas;
        
        
    }
    
    public void setTam_paquetes(int a) {
        this.tam_paquetes = a;
    }

    public void setAp_Ppaquetes(int a) {
        this.ap_Ppaquetes = a;
    }

    public void setAp_Cpaquetes(int a) {
        this.ap_Cpaquetes = a;
    }

    public void almacenar_paquete() {
        
        this.Alm_paquetes[this.ap_Ppaquetes] =true;
        this.ap_Ppaquetes=(ap_Ppaquetes+1)%this.tam_paquetes;
        
        
    }

    public void consumir_paquete() {
        
        this.Alm_paquetes[this.ap_Cpaquetes] =false;
        this.ap_Cpaquetes=(ap_Cpaquetes+1)%this.tam_paquetes;
        
        
    }

    public int getStock_controles() {
        return stock_controles;
    }

    public void setStock_controles(int stock_controles) {
        this.stock_controles = stock_controles;
    }

    public int getStock_consolas() {
        return stock_consolas;
    }

    public void setStock_consolas(int stock_consolas) {
        this.stock_consolas = stock_consolas;
    }

    public int getStock_paquetes() {
        return stock_paquetes;
    }

    public void setStock_paquetes(int stock_paquetes) {
        this.stock_paquetes = stock_paquetes;
    }

}
