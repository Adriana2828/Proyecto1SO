/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;


public class Fabrica {
    
private Almacen A;    
    

public Fabrica(Interfaz I){ //Para iniciar con los valores definidos desde la clase.
     
    this.A=new Almacen(30,20,40);
}

public Fabrica(String nombre, Interfaz I){// Para iniciar con los valores leidos de un archivo.
}
    
}
