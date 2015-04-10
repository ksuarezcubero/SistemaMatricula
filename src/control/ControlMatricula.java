    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Registro;
import vista.GUIMatricula;

/**
 *
 * @author kevin
 */
public class ControlMatricula implements ActionListener, MouseListener{
    
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
           // guiMatricula.mensage(curso.agregarEstudiante(estudiante));            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
