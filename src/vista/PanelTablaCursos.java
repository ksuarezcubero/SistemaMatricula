/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlTablaEstudiantes;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class PanelTablaCursos extends javax.swing.JPanel {

    /**
     * Creates new form PanelTabla
     */
    public PanelTablaCursos() {
        initComponents();
        this.llenarComboBox();
        this.estadoTxtBuscar(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox();
        lblEtiqueta = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtEstudiantes = new javax.swing.JTable();

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregarStud.png"))); // NOI18N
        btnAgregar.setActionCommand("agregar");

        jLabel1.setText("Filtro:");

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEtiqueta.setText("Nombre:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setActionCommand("buscar");

        jtEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtEstudiantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEtiqueta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEtiqueta)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtEstudiantes;
    private javax.swing.JLabel lblEtiqueta;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public static final String BTN_BUSCAR="buscar";
    public static final String BTN_AGREGAR="agregar";
    
     public void llenarTabla(String [][] lista, String [] etiquetas){
        this.jtEstudiantes.setModel(new DefaultTableModel(lista, etiquetas));
        jScrollPane2.setViewportView(jtEstudiantes);
    }
    
    public void llenarComboBox(){
        String[] filtro={"--Seleccionar--","Todo","Siglas","Nombre","Creditos"};
        this.cbxFiltro.setModel(new DefaultComboBoxModel(filtro));
    }
    
    public void addEscucha(ControlTablaEstudiantes control){
        this.btnAgregar.addActionListener(control);
        this.btnBuscar.addActionListener(control);
        this.cbxFiltro.addItemListener(control);
        this.jtEstudiantes.addMouseListener(control);
    }
    
    public String[] getFila(){

        String fila[] = new String[jtEstudiantes.getColumnCount()];
        int filaSeleccionada= jtEstudiantes.getSelectedRow();
        System.out.print(filaSeleccionada);
        for(int columna=0; columna<2; columna++){
            
            fila[columna]=jtEstudiantes.getValueAt(filaSeleccionada, columna).toString().trim();
            
        }
        return fila;
    }
    
   
    
    public void setEtiquetaBuscar(String etiqueta){
        lblEtiqueta.setText(etiqueta);
    }
    
    public String getTxtBuscar(){
        return txtBuscar.getText();
    }
    
    public void estadoTxtBuscar(boolean estado){
        lblEtiqueta.setVisible(estado);
        txtBuscar.setVisible(estado);
        btnBuscar.setVisible(estado);
    }
    public void limpiar(){
        txtBuscar.setText("");
    }
}
