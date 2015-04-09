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
import modelo.Estudiante;
import modelo.Registro;
import vista.GUIEstudiantes;
import vista.GUITablaEstudiantes;
import vista.PanelBotonesEstudiante;
import vista.PanelDataEstudiante;
import vista.PanelTablaEstudiantes;

/**
 *
 * @author kevin
 */
public class ControlTablaEstudiantes implements ActionListener, ItemListener, MouseListener{

    private Registro registro;
    private PanelTablaEstudiantes panelTabla;
    private int busqueda=0;
    private PanelBotonesEstudiante panelBotones;
   
    
    public ControlTablaEstudiantes(Registro registro, PanelTablaEstudiantes panelTabla){
        this.registro=registro;
        this.panelTabla=panelTabla;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(panelTabla.BTN_AGREGAR)){
            GUIEstudiantes guiEstudiantes=new GUIEstudiantes(null,true,registro,panelTabla);
            panelBotones=guiEstudiantes.getPanelBotones();
            guiEstudiantes.setVisible(true);
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(panelTabla.BTN_BUSCAR)){
            if(busqueda==1){
                panelTabla.llenarTabla(registro.getMatrizBuscarEstudiante(busqueda, panelTabla.getTxtBuscar()), Estudiante.getEtiquetas());
                panelTabla.limpiar();
            }
            
            if(busqueda==2){
                panelTabla.llenarTabla(registro.getMatrizBuscarEstudiante(busqueda, panelTabla.getTxtBuscar()), Estudiante.getEtiquetas());
                panelTabla.limpiar();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent iEvento){
        if(iEvento.getStateChange() == iEvento.SELECTED){
            if(iEvento.getItem().toString().equalsIgnoreCase("Todo")){
                panelTabla.estadoTxtBuscar(false);
                panelTabla.llenarTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetas());
            }
            if(iEvento.getItem().toString().equalsIgnoreCase("Nombre")){
                panelTabla.estadoTxtBuscar(true);
                panelTabla.setEtiquetaBuscar("Nombre:");
                busqueda=1;
            }
            if(iEvento.getItem().toString().equalsIgnoreCase("Carné")){
                panelTabla.estadoTxtBuscar(true);
                panelTabla.setEtiquetaBuscar("Carné:");
                busqueda=2;
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent mEvent){
        String[] fila=panelTabla.getFila();
        GUIEstudiantes guiEstudiantes=new GUIEstudiantes(null, true, registro,panelTabla);
        PanelDataEstudiante panelData;
        panelData=guiEstudiantes.getPanelData();
        panelData.setTxtNombre(fila[0]);
        panelData.setTxtCarnet(fila[1]);
        panelBotones=guiEstudiantes.getPanelBotones();
        panelBotones.estadoBtn(true);
        guiEstudiantes.setVisible(true);
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
