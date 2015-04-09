/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Registro;
import vista.GUICursos;
import vista.GUIEstudiantes;
import vista.GUIMatricula;
import vista.GUIReporte;
import vista.GUIPrincipal;
import vista.GUITablaEstudiantes;

/**
 *
 * @author kevin
 */
public class ControlPrincipal implements ActionListener{
    
    private Registro registro;
    private GUIPrincipal guiPricipal;
    
    public ControlPrincipal(GUIPrincipal guiPrincipal){
        this.registro=new Registro();
        this.guiPricipal=guiPrincipal;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(GUIPrincipal.MENU_ESTUDIANTES)){
            guiPricipal.dispose();
            GUITablaEstudiantes guitablaEstudiantes=new GUITablaEstudiantes(registro);
            guitablaEstudiantes.show();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(GUIPrincipal.MENU_CURSOS)){
            
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(GUIPrincipal.MENU_MATRICULA)){
            
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(GUIPrincipal.MENU_SALIR)){
            System.exit(0); 
        }
        
    }
}