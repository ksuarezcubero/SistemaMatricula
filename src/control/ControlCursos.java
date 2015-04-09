/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import modelo.Registro;

import vista.GUICursos;
import vista.PanelBotonesCurso;
import vista.PanelDataCurso;

/**
 *
 * @author kevin
 */
public class ControlCursos implements ActionListener{
    
    private GUICursos guiCursos;
    private PanelDataCurso panelData;
    private PanelBotonesCurso panelBotones;
    private Registro registro;
    
    public ControlCursos(GUICursos guiCursos, PanelDataCurso panelData, PanelBotonesCurso panelBotones, Registro registro){
        this.guiCursos=guiCursos;
        this.panelData=panelData;
        this.panelBotones=panelBotones;
        this.registro=registro;
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
                panelData.limpiar();
                
            }
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_CONSULTAR)){
            
            
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_ATRAS)){
            guiCursos.dispose();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_ELIMINAR)){
            guiCursos.mensage(registro.eliminarCurso(panelData.getTxtSiglas()));
            panelData.limpiar();
            panelBotones.estado(false);
            panelData.getTxSiglas().setEditable(true);
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesCurso.BTNC_MODIFICAR)){
            Curso curso;
            curso=registro.getCurso(panelData.getTxtSiglas());
            curso.setCurso(panelData.getTxtNombre());
            curso.setCreditos(Integer.parseInt(panelData.getTxtCreditos()));
            guiCursos.mensage("El curso fue modificado con exito");
            panelData.limpiar();
            panelBotones.estado(false);
            panelData.getTxSiglas().setEditable(true);
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelDataCurso.BTNC_Buscar)){
            Curso curso;
            curso=registro.getCurso(panelData.getTxtSiglas());
            if(panelData.getTxtSiglas().equalsIgnoreCase("")){
                guiCursos.mensage("Debe indicar las siglas del curso");
            }else{
                if(curso==null){
                    guiCursos.mensage("El carné ingresado no existe");
                }else{
                    panelData.setTxtCreditos(""+curso.getCreditos());
                    panelData.setTxtNombre(curso.getCurso());
                   
                    
                    panelBotones.estado(true);
                    panelData.getTxSiglas().setEditable(false);
                    
                }
            }
        }
        
    }
}