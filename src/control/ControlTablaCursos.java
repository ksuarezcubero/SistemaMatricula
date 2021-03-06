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
import vista.GUICursos;
import vista.GUITablaCursos;
import vista.PanelBotonesCurso;
import vista.PanelDataCurso;
import vista.PanelTablaCursos;

/**
 *
 * @author kevin
 */
public class ControlTablaCursos implements ActionListener, ItemListener, MouseListener{

    private Registro registro;
    private GUITablaCursos guiTablaCursos;
    private int consulta;
    private PanelTablaCursos panelTablaCursos;
    
    public ControlTablaCursos(GUITablaCursos guiTablaCurso, Registro registro, PanelTablaCursos panelTablaCursos) {
       this.registro=registro;
       this.guiTablaCursos=guiTablaCurso;
       this.panelTablaCursos=panelTablaCursos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_AGREGAR)){
            GUICursos guiCursos=new GUICursos(null, true, registro,panelTablaCursos);
            guiCursos.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_BUSCAR)){
            if(consulta==1){
                panelTablaCursos.llenarTabla(registro.getMatrizBuscarCursos(consulta, panelTablaCursos.getTxtBuscar()), Curso.getEtiquetas());
            }
            if(consulta==2){
                panelTablaCursos.llenarTabla(registro.getMatrizBuscarCursos(consulta, panelTablaCursos.getTxtBuscar()), Curso.getEtiquetas());
            }
            if(consulta==3){
                panelTablaCursos.llenarTabla(registro.getMatrizBuscarCursos(consulta, panelTablaCursos.getTxtBuscar()), Curso.getEtiquetas());
            }
        }
        if(e.getActionCommand().equalsIgnoreCase(PanelTablaCursos.BTN_SALIR)){
            guiTablaCursos.dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==e.SELECTED){
            if(e.getItem().toString().equalsIgnoreCase("Todo")){
                panelTablaCursos.llenarTabla(registro.getMatrizCursos(), Curso.getEtiquetas());
                panelTablaCursos.estadoTxtBuscar(false);
            }
            if(e.getItem().toString().equalsIgnoreCase("Siglas")){
                consulta=1;
                panelTablaCursos.estadoTxtBuscar(true);
                panelTablaCursos.setEtiquetaBuscar("Siglas:");
            }
            if(e.getItem().toString().equalsIgnoreCase("Nombre")){
                consulta=2;
                panelTablaCursos.estadoTxtBuscar(true);
                panelTablaCursos.setEtiquetaBuscar("Nombre:");
            }
            if(e.getItem().toString().equalsIgnoreCase("Creditos")){
                consulta=3;
                panelTablaCursos.estadoTxtBuscar(true);
                panelTablaCursos.setEtiquetaBuscar("Creditos");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String [] fila=panelTablaCursos.getFila();
        GUICursos guiCurso=new GUICursos(null, true, registro, panelTablaCursos);
        PanelDataCurso panelDataCurso;
        panelDataCurso=guiCurso.getPanelData();
        panelDataCurso.setTxtSiglas(fila[1]);
        panelDataCurso.setTxtNombre(fila[0]);
        panelDataCurso.setTxtCreditos(fila[2]);
        PanelBotonesCurso panelBotonesCurso;
        panelBotonesCurso=guiCurso.getPanelBotones();
        panelBotonesCurso.estado(true);
        guiCurso.setVisible(true);
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
