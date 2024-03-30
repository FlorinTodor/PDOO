/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
/**
 *
 * @author josev
 */
public class PropiedadDialog extends javax.swing.JDialog {
    private int propiedadElegida = -1;
    /**
     * Creates new form PropiedadDialog
     */
    public PropiedadDialog(java.awt.Frame parent, boolean modal, Jugador jugadorActual) {
        super(parent, modal);
        initComponents();
        
        DefaultListModel propiedades = new DefaultListModel<>();
        ArrayList<String> opciones = new ArrayList<String> ();
        for(int i=0; i < jugadorActual.getPropiedades().size(); i++){
            opciones.add(jugadorActual.getPropiedades().get(i).getNombre());
        }
        for(String s: opciones){
            propiedades.addElement(s);
        }
        listaPropiedades.setModel(propiedades);
        
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPropiedades = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("PROPIEDADES JUGADOR ACTUAL");

        listaPropiedades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPropiedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPropiedadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaPropiedades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaPropiedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPropiedadesMouseClicked
        // TODO add your handling code here:
        propiedadElegida = listaPropiedades.getSelectedIndex();
        dispose();
    }//GEN-LAST:event_listaPropiedadesMouseClicked

    public int getPropiedadElegida(){
        return propiedadElegida;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaPropiedades;
    // End of variables declaration//GEN-END:variables
}
