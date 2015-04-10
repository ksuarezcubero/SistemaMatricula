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

import vista.GUICursos;
import vista.GUIEstudiantes;
import vista.PanelBotonesCurso;
import vista.PanelDataCurso;
import vista.PanelTablaCursos;

/**
 *
 * @author kevin
 */
public class ControlCursos implements ActionListener{
    
    private GUICursos guiCursos;
    private PanelDataCurso panelData;
    private PanelBotonesCurso panelBotones;
    private Registro registro;
    private PanelTablaCursos panelTabla;
    
    public ControlCursos(GUICursos guiCursos, PanelDataCurso panelData, PanelBotonesCurso panelBotones, Registro registro,PanelTablaCursos panelTablaCurso){
        this.guiCursos=guiCursos;
        this.panelData=panelData;
        this.panelBotones=panelBotones;
        this.registro=registro;
        this.panelTabla=panelTablaCurso;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_AGREGAR)){
            if(panelData.getTxtNombre().equalsIgnoreCase("")){
                guiCursos.mensage("Debe agregar el nombre del curso");
            }else if(panelData.getTxtSiglas().equalsIgnoreCase("")){
                guiCursos.mensage("Debe agregar las siglas del curso");
            }else if(panelData.getTxtCreditos().equalsIgnoreCase("")){
                guiCursos.mensage("Debe agregar los creditos del curso");
            }else{
                guiCursos.mensage(registro.agregarCurso(new Curso(panelData.getTxtNombre(), panelData.getTxtSiglas(),Integer.parseInt(panelData.getTxtCreditos()))));
                panelTabla.llenarTabla(registro.getMatrizCursos(), Curso.getEtiquetas());
                panelData.limpiar();
                if(GUICursos.mensajeConfirmar("¿Desea ingresar otro curso?")==1){
                    guiCursos.dispose();
                }
                
            }
        }
 
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_ATRAS)){
            if(GUIEstudiantes.mensajeConfirmar("¿Desea salir?")==0){
                guiCursos.dispose();
            }
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_ELIMINAR)){
            guiCursos.mensage(registro.eliminarCurso(panelData.getTxtSiglas()));
            panelData.limpiar();
            panelTabla.llenarTabla(registro.getMatrizCursos(), Curso.getEtiquetas());
            panelBotones.estado(false);
            panelData.getTxSiglas().setEditable(true);
            guiCursos.dispose();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_MODIFICAR)){
            Curso curso;
            curso=registro.getCurso(panelData.getTxtSiglas());
            curso.setCurso(panelData.getTxtNombre());
            curso.setCreditos(Integer.parseInt(panelData.getTxtCreditos()));
            panelTabla.llenarTabla(registro.getMatrizCursos(), Curso.getEtiquetas());
            guiCursos.mensage("El curso fue modificado con exito");
            panelData.limpiar();
            panelBotones.estado(false);
            panelData.getTxSiglas().setEditable(true);
            guiCursos.dispose();
        }
        
    }
}