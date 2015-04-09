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
import vista.PanelTablaEstudiantes;

/**
 *
 * @author kevin
 */
public class ControlEstudiantes implements ActionListener{
    
    private GUIEstudiantes guiEstudiantes;
    private PanelDataEstudiante panelData;
    private PanelBotonesEstudiante panelBotones;
    private Registro registro;
    private PanelTablaEstudiantes panelTabla;
    
    public ControlEstudiantes(GUIEstudiantes guiEstudiantes, PanelDataEstudiante panelData, PanelBotonesEstudiante panelBotones, Registro registro, PanelTablaEstudiantes panelTabla){
        this.guiEstudiantes=guiEstudiantes;
        this.panelData=panelData;
        this.panelBotones=panelBotones;
        this.registro=registro;
        this.panelTabla=panelTabla;
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
                panelTabla.llenarTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetas());
                if(GUIEstudiantes.mensajeConfirmar("¿Desea agregar otro estudiante?")==1){
                    guiEstudiantes.dispose();
                }
            }
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_ATRAS)){
            if(GUIEstudiantes.mensajeConfirmar("¿Desea salir?")==0){
                guiEstudiantes.dispose();
            }
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_ELIMINAR)){
            registro.eliminarEstudiante(panelData.getTxtCarnet());
            panelTabla.llenarTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetas());
            guiEstudiantes.dispose();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(PanelBotonesEstudiante.BTNE_MODIFICAR)){
            Estudiante estudiante;
            estudiante=registro.getEstudiante(panelData.getTxtCarnet());
            estudiante.setNombre(panelData.getTxtNombre());
            guiEstudiantes.mensage("El estudiante fue modificado");
            panelData.limpiar();
            panelData.getTxCarnet().setEditable(true);
            panelBotones.estadoBtn(false);
            panelTabla.llenarTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetas());
            guiEstudiantes.dispose();
        }
    }
}
