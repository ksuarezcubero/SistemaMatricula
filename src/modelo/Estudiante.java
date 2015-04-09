/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kevin
 */
public class Estudiante {

    private String nombre;
    private String carnet;
    private static String[] etiquetas={"Nombre","Carné"}; 

    public Estudiante(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
        
    }
    
    public Estudiante() {
        this.nombre = "";
        this.carnet = "";
    }

    public static String[] getEtiquetas(){
        return etiquetas;
    }
    
    public static int getTamannoEtiquetas(){
        return etiquetas.length;
    }
    
    public String getDatos(int posicion){
        switch(posicion){
            case 0:
                return nombre;
            
            case 1:
                return carnet;
            
            default:
                return null;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " -- Carné: " + carnet;
    }   
    
}
