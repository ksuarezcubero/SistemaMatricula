    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Registro;
import vista.GUIMatricula;

/**
 *
 * @author kevin
 */
public class ControlMatricula implements ActionListener{
    
    private Registro registro;
    private GUIMatricula guiMatricula;

    public ControlMatricula(Registro registro, GUIMatricula guiMatricula) {
        this.registro = registro;
        this.guiMatricula=guiMatricula;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(guiMatricula.BTN_ATRAS)){
            guiMatricula.dispose();
        }
        if(evento.getActionCommand().equalsIgnoreCase(guiMatricula.BTN_ACEPTAR)){
            
            Curso curso=(Curso)guiMatricula.getCbxCurso().getSelectedItem();
            Estudiante estudiante=(Estudiante)guiMatricula.getCbxEstudiante().getSelectedItem();
            guiMatricula.mensage(curso.agregarEstudiante(estudiante));            
        }
    }
}
