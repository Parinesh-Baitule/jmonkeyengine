/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.terraineditor;

import javax.swing.JPanel;
import javax.swing.JTextField;

public final class CreateTerrainVisualPanel1 extends JPanel {

    /** Creates new form CreateTerrainVisualPanel1 */
    public CreateTerrainVisualPanel1() {
        initComponents();
    }

    @Override
    public String getName() {
        return "Terrain Size";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        terrainSizeLabel = new javax.swing.JLabel();
        totalSizeLabel = new javax.swing.JLabel();
        totalSizeField = new javax.swing.JTextField();
        patchSizeLabel = new javax.swing.JLabel();
        patchSizeField = new javax.swing.JTextField();
        totalSizeHintLabel = new javax.swing.JLabel();
        patchSizeHintLabel = new javax.swing.JLabel();

        terrainSizeLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        org.openide.awt.Mnemonics.setLocalizedText(terrainSizeLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.terrainSizeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(totalSizeLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.totalSizeLabel.text")); // NOI18N

        totalSizeField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.totalSizeField.text")); // NOI18N
        totalSizeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSizeFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(patchSizeLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.patchSizeLabel.text")); // NOI18N

        patchSizeField.setText(org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.patchSizeField.text")); // NOI18N

        totalSizeHintLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(totalSizeHintLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.totalSizeHintLabel.text")); // NOI18N

        patchSizeHintLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(patchSizeHintLabel, org.openide.util.NbBundle.getMessage(CreateTerrainVisualPanel1.class, "CreateTerrainVisualPanel1.patchSizeHintLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(terrainSizeLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(patchSizeLabel)
                            .addComponent(totalSizeLabel))
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalSizeField)
                    .addComponent(patchSizeField, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalSizeHintLabel)
                    .addComponent(patchSizeHintLabel))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(terrainSizeLabel)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalSizeLabel)
                    .addComponent(totalSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalSizeHintLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patchSizeLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(patchSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(patchSizeHintLabel)))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void totalSizeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSizeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSizeFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField patchSizeField;
    private javax.swing.JLabel patchSizeHintLabel;
    private javax.swing.JLabel patchSizeLabel;
    private javax.swing.JLabel terrainSizeLabel;
    private javax.swing.JTextField totalSizeField;
    private javax.swing.JLabel totalSizeHintLabel;
    private javax.swing.JLabel totalSizeLabel;
    // End of variables declaration//GEN-END:variables

    public JTextField getPatchSizeField() {
        return patchSizeField;
    }

    public JTextField getTotalSizeField() {
        return totalSizeField;
    }


}