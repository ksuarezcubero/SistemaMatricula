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
import vista.GUIReporte;

/**
 *
 * @author kevin
 */
public class ControlReporte implements ActionListener{

    private GUIReporte reporte;
    private Registro registro;
    
    public ControlReporte(Registro registro, GUIReporte reporte) {
        this.reporte=reporte;
        this.registro=registro;
    }
    
    
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(reporte.BTN_SALIR)){
            reporte.dispose();
        }
        if(evento.getActionCommand().equalsIgnoreCase(reporte.BTN_CONSULTAR)){
            if(reporte.getTxtCarnet().equalsIgnoreCase("")){
                reporte.mensage("Debe indicar el carné del estudiante");
            }else{
                if(registro.verificarEstudiante(reporte.getTxtCarnet())){
                    reporte.setTxtNombre(registro.getEstudiante(reporte.getTxtCarnet()).getNombre());
                    reporte.getPanelTabla().llenarTabla(registro.getMatrizCursosMatriculados(reporte.getTxtCarnet()), Curso.getEtiquetas());
                    reporte.setTxtCreditos(""+registro.getCreditos());
                }else{
                    reporte.mensage("El estudiante no existe");
                    
                }
            }
        }
    }
}
