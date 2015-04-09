/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Curso {
       
    private String curso;
    private String siglas;
    private int creditos;
    private ArrayList<Estudiante> estudiantes;
    private static String[] etiquetas={"Curso","Siglas","Creditos"};

    public Curso(String curso, String siglas, int creditos) {
        this.curso = curso;
        this.siglas = siglas;
        this.creditos = creditos;
        estudiantes=new ArrayList<Estudiante>();
    }

    public Curso() {
        this.curso = "";
        this.siglas = "";
        this.creditos = 0;
    }
    
    public static String[] getEtiquetas(){
        return etiquetas;
    }
    
    public static int getTamannoEtiquetas(){
        return etiquetas.length;
    }
    
    public String datosCurso(int posicion){
        switch(posicion){
            case 0:
                return curso;
            case 1:
                return siglas;
            case 2:
                return ""+creditos;
            default:
                return null;
        }
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    public String agregarEstudiante(Estudiante estudiante){
        if(estudiante!=null){
            if(verificar(estudiante.getCarnet())){
                return "El estudiante ya se encuentra matriculado.";
            }else{
                estudiantes.add(estudiante);
                return "El estudiante se matriculo en el curso";
            }
        }
        return"El estudiante es null";
    } 
    
    public boolean verificar(String carnet){
        if(!carnet.equalsIgnoreCase("")){
            if(estudiantes.size()!=0){
                for(Estudiante estudiante:estudiantes){
                    if(estudiante.getCarnet().equalsIgnoreCase(carnet)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public ArrayList<Estudiante> getArray(){
        return estudiantes;
    }

    @Override
    public String toString() {
        return "Curso: " + curso + " -- Siglas: " + siglas + " -- N creditos: " + creditos;
    }
    
    
}
