/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlPrincipal;
import java.awt.event.ActionListener;

/**
 *
 * @author kevin
 */
public class GUIPrincipal extends javax.swing.JFrame {

    
    /**
     * Creates new form Principal
     */
    public GUIPrincipal() {
        initComponents();
        ControlPrincipal control=new ControlPrincipal(this);
        addEscucha(control);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();
        jmRegistro = new javax.swing.JMenu();
        jmiEstudiantes = new javax.swing.JMenuItem();
        jmiCursos = new javax.swing.JMenuItem();
        jmiMatricula = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Matricula");
        setForeground(new java.awt.Color(102, 102, 102));

        jmArchivo.setText("Archivo");
        jmArchivo.setActionCommand("archivo");

        jmiSalir.setText("Salir");
        jmArchivo.add(jmiSalir);

        jMenuBar1.add(jmArchivo);

        jmRegistro.setText("Registro");

        jmiEstudiantes.setText("Estudiantes");
        jmRegistro.add(jmiEstudiantes);

        jmiCursos.setText("Cursos");
        jmRegistro.add(jmiCursos);

        jmiMatricula.setText("Matricula");
        jmRegistro.add(jmiMatricula);

        jMenuBar1.add(jmRegistro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmRegistro;
    private javax.swing.JMenuItem jmiCursos;
    private javax.swing.JMenuItem jmiEstudiantes;
    private javax.swing.JMenuItem jmiMatricula;
    private javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables

    public void addEscucha(ActionListener control){
        this.jmiCursos.addActionListener(control);
        this.jmiEstudiantes.addActionListener(control);
        this.jmiMatricula.addActionListener(control);
        this.jmiSalir.addActionListener(control);
    }
    
    public static final String MENU_SALIR="Salir";
    public static final String MENU_ESTUDIANTES="Estudiantes";
    public static final String MENU_CURSOS="Cursos";
    public static final String MENU_MATRICULA="Matricula";
    
}
