/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlMatricula;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Registro;

/**
 *
 * @author kevin
 */
public class GUIMatricula extends javax.swing.JFrame {

    private Registro registro;
    private ControlMatricula control;
    
    /**
     * Creates new form GUIMatricula
     */
    public GUIMatricula(Registro registro) {
        initComponents();
        this.registro=registro;
        this.control=new ControlMatricula(registro, this);
        llenarCmbx();
        agregarEscucha(control);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxMateria = new javax.swing.JComboBox();
        cbxEstudiantes = new javax.swing.JComboBox();
        btnMatricular = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matricula");
        setBackground(new java.awt.Color(0, 0, 0));

        btnMatricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matricular.png"))); // NOI18N
        btnMatricular.setActionCommand("aceptar");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnAtras.setActionCommand("atras");

        jLabel1.setFont(new java.awt.Font("Droid Sans", 3, 24)); // NOI18N
        jLabel1.setText("Matricula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMatricular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnMatricular;
    private javax.swing.JComboBox cbxEstudiantes;
    private javax.swing.JComboBox cbxMateria;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    public void llenarCmbx(){
        ArrayList<Curso> cursos=registro.getListaCursos();
        ArrayList<Estudiante> estudiantes=registro.getListaEstudiantes();
        
        cbxEstudiantes.removeAllItems();
        cbxMateria.removeAllItems();
        
        for(Curso curso:cursos){
            cbxMateria.addItem(curso);
        }
        
        for(Estudiante estudiante:estudiantes){
            cbxEstudiantes.addItem(estudiante);
        }
    }
    
    public JComboBox getCbxCurso(){
        return cbxMateria;
    }
    
    public JComboBox getCbxEstudiante(){
        return cbxEstudiantes;
    }
    
    public void agregarEscucha(ControlMatricula control){
        btnAtras.addActionListener(control);
        btnMatricular.addActionListener(control);
    }
    
    public static final String BTN_ATRAS="atras";
    public static final String BTN_ACEPTAR="aceptar";
    
    public void mensage(String mensage){
        JOptionPane.showMessageDialog(null,mensage);
    }
    
}
