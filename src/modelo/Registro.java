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
public class Registro {
    
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private int creditos;

    public Registro() {
        this.estudiantes = new ArrayList<Estudiante>();
        this.cursos = new ArrayList<Curso>();
    }
    
    public String agregarEstudiante(Estudiante estudiante){
        if(estudiante!=null){
            if(verificarEstudiante(estudiante.getCarnet())==false){
                estudiantes.add(estudiante);
                return "Estudiante ingresado correctamente";
            }else{
                return "El estudiante ya fue ingresado, verifique la información";
            }
        }else{
            return "El estudiante es null";
        }
    }
    
    public boolean verificarEstudiante(String carnet){
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
    
    public String eliminarEstudiante(String carnet){
        if(verificarEstudiante(carnet)){
            for(Estudiante estudiante:estudiantes){
                if(estudiante.getCarnet().equalsIgnoreCase(carnet)){
                    estudiantes.remove(estudiante);
                    return "Estudiante el fue eliminado correctamente.";
                }
            }
        }else{
            return "El carné ingresado no corresponce a ningun estudiante.";
        }
        return "454";
    }
    
    public String consultarEstudiante(){
        String mensage="";
        for(Estudiante estudiante: estudiantes){
            mensage += estudiante+"\n";
        }
        return mensage;
    }
    
    public Estudiante getEstudiante(String carnet){
        Estudiante estudiant = null;
        for(Estudiante estudiante: estudiantes){
            if(estudiante.getCarnet().equalsIgnoreCase(carnet)){
                estudiant=estudiante;
            }
        }
        return estudiant;
    }
    
    public ArrayList<Estudiante> getListaEstudiantes(){
        return estudiantes;
    }
    
    public String agregarCurso(Curso curso){
        if(curso!=null){
            if(!verificarCurso(curso.getSiglas())){
                cursos.add(curso);
                return "Curso ingresado con exito";
            }else{
                return "El curso que intenta agregar ya fue registrado.";
            }
        }else{
            return "El curso es null.";
        }
    }
    
    public boolean verificarCurso(String siglas){
        if(!siglas.equalsIgnoreCase("")){
            if(cursos.size()!=0){
                for(Curso curso:cursos){
                    if(curso.getSiglas().equalsIgnoreCase(siglas)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
     public String eliminarCurso(String siglas){
        if(verificarCurso(siglas)){
            for(Curso curso:cursos){
                if(curso.getSiglas().equalsIgnoreCase(siglas)){
                    cursos.remove(curso);
                    return "El curso fue eliminado correctamente.";
                }
            }
        }else{
            return "Las siglas no corresponce a ningun curso registrado.";
        }
        return "";
    }
    
    public String consultarCursos(){
        String salida="";
        for(Curso curso:cursos){
            salida+= curso+"\n";
        }
        return salida;
    }
    
    public Curso getCurso(String siglas){
        Curso curs = null;
        for(Curso curso: cursos){
            if(curso.getSiglas().equalsIgnoreCase(siglas)){
                curs=curso;
            }
        }
        return curs;
    }
    
    public ArrayList<Curso> getListaCursos(){
        return cursos;
    }
    
    public String[][] getMatrizCursosMatriculados(String carnet){
        ArrayList<Curso> arrayAux=new ArrayList<Curso>();
        for(Curso curso:cursos){
            ArrayList<Estudiante> estudiants=curso.getArray();
            for(Estudiante estudiante:estudiants){
                if(estudiante.getCarnet().equalsIgnoreCase(carnet)){
                    arrayAux.add(curso);
                }
            }
        }
        creditos=0;
        for(Curso curso:arrayAux){
            creditos+=curso.getCreditos();
        }
        
        String [][] matriz=new String [arrayAux.size()][Curso.getTamannoEtiquetas()];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j]=arrayAux.get(i).datosCurso(j);
            }
        }
        return matriz;
    }
    
    public String[][] getMatrizBuscarEstudiante(int filtro, String busqueda){
        ArrayList<Estudiante> arrayAux=new ArrayList<Estudiante>();
        for(Estudiante estudiante:estudiantes){
            if(filtro==1){
                if(estudiante.getNombre().equalsIgnoreCase(busqueda)){
                    arrayAux.add(estudiante);
                }
            }else{
                if(estudiante.getCarnet().equalsIgnoreCase(busqueda)){
                    arrayAux.add(estudiante);
                }
            }
        }
        String[][] matriz=new String[arrayAux.size()][Estudiante.getTamannoEtiquetas()];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j]=arrayAux.get(i).getDatos(j);
            }
        }
        return matriz;
    }
    
    public int getCreditos(){
        return creditos;
    }
    
    public String[][] getMatrizCursos(){
        String [][] matriz=new String[cursos.size()][Curso.getTamannoEtiquetas()];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j]=cursos.get(i).datosCurso(j);
            }
        }
        return matriz;
    }
    
    public String[][] getMatrizEstudiantes(){
        String[][] matriz=new String[estudiantes.size()][Estudiante.getTamannoEtiquetas()];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j]=estudiantes.get(i).getDatos(j);
            }
        }
        return matriz;
    }
    
}
