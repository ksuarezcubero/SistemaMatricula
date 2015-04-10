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
import modelo.Registro;
import vista.GUICursos;
import vista.GUITablaCursos;
import vista.PanelBotonesCurso;
import vista.PanelTablaCursos;

/**
 *
 * @author kevin
 */
public class ControlTablaCursos implements ActionListener, ItemListener, MouseListener{

    private Registro registro;
    private GUITablaCursos guiTablaCursos;
    
    public ControlTablaCursos(GUITablaCursos guiTablaCurso, Registro registro) {
       this.registro=registro;
       this.guiTablaCursos=guiTablaCurso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_AGREGAR)){
            GUICursos guiCursos=new GUICursos(null, true, registro);
            guiCursos.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_BUSCAR)){
            
        }
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_SALIR)){
            guiTablaCursos.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
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
