/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1so;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeerArchivo {
    private int Tiempo_Seg_UnDia; //Hay q convertir a milisegundos despues ojo.
    private int cant_dias_despachos;
    private int Cap_Max_Alm_Controles;
    private int Cap_Max_Alm_Consolas;
    private int Cap_Max_Alm_Paquetes;
    private int Cant_inic_PControles;
    private int Cant_inic_PConsolas;
    private int Cant_inic_PPaquetes;
    private int Cant_inic_Ensambladores;
    private int Cant_Max_PControles;
    private int Cant_Max_PConsolas;
    private int Cant_Max_PPaquetes;
    private int Cant_Max_Ensambladores;
   
   public LeerArchivo(String name) throws IOException{
   int linenumber=1;
     String namefile=name;
     
        try {
            BufferedReader in= new BufferedReader(new FileReader(namefile));
            String line=null;
            while(((line=in.readLine())!=null)||linenumber==13){
                 switch (linenumber) {
            case 1:  this.Tiempo_Seg_UnDia= Integer.parseInt(line);
                     break;
            case 2:  this.cant_dias_despachos = Integer.parseInt(line);
                     break;
            case 3:  this.Cap_Max_Alm_Controles = Integer.parseInt(line);
                     break;
            case 4:  this.Cap_Max_Alm_Consolas = Integer.parseInt(line);
                     break;
            case 5:  this.Cap_Max_Alm_Paquetes= Integer.parseInt(line);
                     break;
            case 6:  this.Cant_inic_PControles= Integer.parseInt(line);
                     break;
            case 7:  this.Cant_inic_PConsolas= Integer.parseInt(line);
                     break;
            case 8:  this.Cant_inic_PPaquetes = Integer.parseInt(line);
                     break;
            case 9:  this.Cant_inic_Ensambladores= Integer.parseInt(line);
                     break;
            case 10:  this.Cant_Max_PControles= Integer.parseInt(line);
                     break;
            case 11:  this.Cant_Max_PConsolas= Integer.parseInt(line);
                     break;
            case 12:  this.Cant_Max_PPaquetes= Integer.parseInt(line);
                     break;
            case 13:  this.Cant_Max_Ensambladores= Integer.parseInt(line);
                     break;
        }
                 linenumber++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
    }

    public int getTiempo_Seg_UnDia() {
        return Tiempo_Seg_UnDia;
    }

    public int getCant_dias_despachos() {
        return cant_dias_despachos;
    }

    public int getCap_Max_Alm_Controles() {
        return Cap_Max_Alm_Controles;
    }

    public int getCap_Max_Alm_Consolas() {
        return Cap_Max_Alm_Consolas;
    }

    public int getCap_Max_Alm_Paquetes() {
        return Cap_Max_Alm_Paquetes;
    }

    public int getCant_inic_PControles() {
        return Cant_inic_PControles;
    }

    public int getCant_inic_PConsolas() {
        return Cant_inic_PConsolas;
    }

    public int getCant_inic_PPaquetes() {
        return Cant_inic_PPaquetes;
    }

    public int getCant_inic_Ensambladores() {
        return Cant_inic_Ensambladores;
    }

    public int getCant_Max_PControles() {
        return Cant_Max_PControles;
    }

    public int getCant_Max_PConsolas() {
        return Cant_Max_PConsolas;
    }

    public int getCant_Max_PPaquetes() {
        return Cant_Max_PPaquetes;
    }

    public int getCant_Max_Ensambladores() {
        return Cant_Max_Ensambladores;
    }
    
   
   
   
}
