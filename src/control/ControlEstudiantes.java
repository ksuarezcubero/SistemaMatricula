/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estudiante;
import modelo.Registro;

import vista.GUIEstudiantes;
import vista.PanelBotonesEstudiante;
import vista.PanelDataEstudiante;

/**
 *
 * @author kevin
 */
public class ControlEstudiantes implements ActionListener{
    
    private GUIEstudiantes guiEstudiantes;
    private PanelDataEstudiante panelData;
    private PanelBotonesEstudiante panelBotones;
    private Registro registro;
    
    public ControlEstudiantes(GUIEstudiantes guiEstudiantes, PanelDataEstudiante panelData, PanelBotonesEstudiante panelBotones, Registro registro){
        this.guiEstudiantes=guiEstudiantes;
        this.panelData=panelData;
        this.panelBotones=panelBotones;
        this.registro=registro;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_AGREGAR)){
            if(panelData.getTxtCarnet().equalsIgnoreCase("")){
                guiEstudiantes.mensage("Debe ingresar un carné");
            }else if(panelData.getTxtNombre().equalsIgnoreCase("")){
                guiEstudiantes.mensage("Debe ingresar el nombre");
            }else{
                guiEstudiantes.mensage(registro.agregarEstudiante(new Estudiante(panelData.getTxtNombre(), panelData.getTxtCarnet())));
                panelData.limpiar();
            }
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_ATRAS)){
            guiEstudiantes.dispose();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_CONSULTAR)){
            
            panelData.limpiar();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_ELIMINAR)){
            guiEstudiantes.mensage(registro.eliminarEstudiante(panelData.getTxtCarnet()));
            panelData.limpiar();
            panelBotones.estadoBtn(false);
            panelData.getTxCarnet().setEditable(true);
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_MODIFICAR)){
            Estudiante estudiante;
            estudiante=registro.getEstudiante(panelData.getTxtCarnet());
            estudiante.setNombre(panelData.getTxtNombre());
            guiEstudiantes.mensage("El estudiante fue modificado");
            panelData.limpiar();
            panelData.getTxCarnet().setEditable(true);
            panelBotones.estadoBtn(false);
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelDataEstudiante.BTNE_BUSCAR)){
            Estudiante estudiante;
            estudiante=registro.getEstudiante(panelData.getTxtCarnet());
            if(panelData.getTxtCarnet().equalsIgnoreCase("")){
                guiEstudiantes.mensage("Debe introducir un carnet");
            }else{
                if(estudiante==null){
                    guiEstudiantes.mensage("El carné ingresado no existe");
                }else{
                    panelData.setTxtNombre(estudiante.getNombre());
                    
                    panelBotones.estadoBtn(true);
                    panelData.getTxCarnet().setEditable(false);
                    
                }
            }
        }
    }
}
