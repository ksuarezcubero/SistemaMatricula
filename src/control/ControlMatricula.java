    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Registro;
import vista.GUIMatricula;
import vista.GUIReporte;

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
        if(evento.getActionCommand().equalsIgnoreCase(GUIMatricula.BTN_REPORTE)){
            GUIReporte guiReporte=new GUIReporte(registro);
            guiReporte.show();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        Curso curso=(Curso)guiMatricula.getCbxCurso().getSelectedItem();
        Estudiante estudiante=new Estudiante();
        String[] fila=guiMatricula.getFila();
        estudiante.setNombre(fila[0]);
        estudiante.setCarnet(fila[1]);
        guiMatricula.mensage(curso.agregarEstudiante(estudiante));
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
