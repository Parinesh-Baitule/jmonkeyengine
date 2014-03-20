 /*
 *  Copyright (c) 2009-2012 jMonkeyEngine
 *  All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 * 
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 *  * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 *  TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 *  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.gde.core.sceneexplorer.nodes.actions;

import com.jme3.animation.AnimControl;
import com.jme3.animation.Animation;
import com.jme3.animation.BoneTrack;
import com.jme3.animation.Track;
import com.jme3.gde.core.scene.SceneApplication;
import com.jme3.gde.core.sceneexplorer.nodes.JmeAnimControl;
import com.jme3.math.Quaternion;
import com.jme3.math.Transform;
import com.jme3.math.Vector3f;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.util.Exceptions;

/**
 *
 * @author tsr
 */
public class ExtractSubAnimationDialog extends javax.swing.JDialog {

    Animation _animation;
    JmeAnimControl _animControl;
    private int _splitAnimationCount;

    /**
     * Creates new form ChannelDialog
     */
    public ExtractSubAnimationDialog() {
        super((java.awt.Frame) null, true);

        initComponents();
        _radioGroup.add(_radFromFile);
        _radioGroup.add(_radManual);

        _radManual.setSelected(true);
        _txtCsvFilename.setEnabled(false);
        _btnBrowse.setEnabled(false);
        _splitAnimationCount = 0;
    }

    public void setAnimation(Animation animation) {
        _animation = animation;
        _txtStartFrame.setValue(0);
        if (animation.getTracks().length <= 0) {
            throw new IllegalArgumentException("No Tracks found");
        }
        if (animation.getTracks()[0].getClass() != BoneTrack.class) {
            throw new UnsupportedOperationException("Only Bonetracks are supported");
        }

        _txtEndFrame.setValue(((BoneTrack) animation.getTracks()[0]).getTimes().length);
    }

    public void setAnimControl(JmeAnimControl control) {
        _animControl = control;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _radioGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        _txtName = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        _txtStartFrame = new javax.swing.JFormattedTextField();
        _txtEndFrame = new javax.swing.JFormattedTextField();
        _radManual = new javax.swing.JRadioButton();
        _radFromFile = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        _txtCsvFilename = new javax.swing.JTextField();
        _btnBrowse = new javax.swing.JButton();
        _btnOk = new javax.swing.JButton();
        _btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExctractSubAnimationDialog.border.title"))); // NOI18N
        jPanel1.setName(""); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog.jLabel2.text")); // NOI18N

        _txtName.setText(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._txtName.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog.jLabel3.text")); // NOI18N

        _txtStartFrame.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        _txtStartFrame.setText(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._txtStartFrame.text")); // NOI18N

        _txtEndFrame.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        _txtEndFrame.setText(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._txtEndFrame.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(_radManual, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._radManual.text")); // NOI18N
        _radManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRadioClick(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(_radFromFile, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._radFromFile.text")); // NOI18N
        _radFromFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onRadioClick(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog.jLabel4.text")); // NOI18N

        _txtCsvFilename.setText(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._txtCsvFilename.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(_btnBrowse, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._btnBrowse.text")); // NOI18N
        _btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBrowseClick(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_txtName)
                            .addComponent(_txtStartFrame)
                            .addComponent(_txtEndFrame)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(_txtCsvFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(_btnBrowse))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_radManual)
                            .addComponent(_radFromFile))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(_radManual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(_txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(_txtStartFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(_txtEndFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_radFromFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_txtCsvFilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_btnBrowse)))
        );

        org.openide.awt.Mnemonics.setLocalizedText(_btnOk, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._btnOk.text")); // NOI18N
        _btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOkClick(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(_btnCancel, org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._btnCancel.text")); // NOI18N
        _btnCancel.setActionCommand(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExtractSubAnimationDialog._btnCancel.actionCommand")); // NOI18N
        _btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancelClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btnOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_btnOk)
                    .addComponent(_btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ExtractSubAnimationDialog.class, "ExctractSubAnimationDialog.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onOkClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOkClick
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.setEnabled(false);

        new SwingWorker<Boolean, Boolean>() {
            @Override
            protected void done() {
                super.done();
                try {
                    if (get() == true) {
                        ExtractSubAnimationDialog.this.setCursor(Cursor.getDefaultCursor());
                        setVisible(false);
                    }

                    ExtractSubAnimationDialog.this.setEnabled(true);
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }

            @Override
            protected Boolean doInBackground() throws Exception {
                try {
                    if (_radManual.isSelected()) {
                        splitAnimation(_txtName.getText(), (Integer) _txtStartFrame.getValue(), (Integer) _txtEndFrame.getValue());
                    } else {
                        processCsv(_txtCsvFilename.getText());
                    }

                    return true;
                } catch (IllegalStateException ex) {
                    final Exception l_ex = ex;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            ExtractSubAnimationDialog.this.setCursor(Cursor.getDefaultCursor());
                            JOptionPane.showMessageDialog(ExtractSubAnimationDialog.this, l_ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                    return false;
                }
            }
        }.execute();
    }//GEN-LAST:event_onOkClick

    private void processCsv(String filename) {
        BufferedReader l_reader = null;
        try {
            String l_line;

            l_reader = new BufferedReader(new FileReader(filename));
            //read each l_line of text file
            while ((l_line = l_reader.readLine()) != null) {
                String[] l_parts = l_line.split(";");

                if (l_parts.length != 3) {
                    throw new IllegalStateException("Wrong structure of Csv. Need to be 'name;start frame;end frame'");
                }

                splitAnimation(l_parts[0], Integer.parseInt(l_parts[1]), Integer.parseInt(l_parts[2]));
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalStateException("Could not find csv");
        } catch (IOException ex) {
            throw new IllegalStateException("Error reading csv");
        } finally {
            if (l_reader != null) {
                try {
                    l_reader.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    private void splitAnimation(String name, int start, int end) {
        final int l_start = start;
        final int l_end = end;
        final String l_name = name;

        if ("".equals(name) || name == null) {
            throw new IllegalStateException("Please enter name for new animation");
        }

        if (_animControl.getLookup().lookup(AnimControl.class).getAnim(l_name) != null) {
            throw new IllegalStateException("Please enter unique name for new animation");
        }

        if (start >= end) {
            throw new IllegalStateException("Start frame must not be greater than end frame");
        }

        if (end >= ((BoneTrack) _animation.getTracks()[0]).getTimes().length) {
            throw new IllegalStateException("End frame must not be greater than source animation end frame");
        }

        try {
            SceneApplication.getApplication().enqueue(new Callable<Void>() {
                public Void call() throws Exception {
                    Animation l_newAnim;
                    float l_newTimes[];
                    Vector3f l_newTranslations[];
                    Quaternion l_newRotations[];
                    Vector3f l_newScales[];
                    float l_newLength;
                    Track[] l_tracks = new Track[_animation.getTracks().length];

                    l_newLength = (_animation.getLength() / (float) ((BoneTrack) _animation.getTracks()[0]).getTimes().length) * (float) (l_end - l_start);
                    l_newAnim = new Animation(l_name, l_newLength);

                    for (int j = 0; j < _animation.getTracks().length; j++) {
                        BoneTrack l_track = (BoneTrack) _animation.getTracks()[j];
                        l_newTimes = new float[l_end - l_start];
                        l_newTranslations = new Vector3f[l_end - l_start];
                        l_newRotations = new Quaternion[l_end - l_start];
                        l_newScales = new Vector3f[l_end - l_start];

                        for (int i = l_start; i < l_end; i++) {
                            int l_newFrame = i - l_start;

                            Vector3f l_trans = l_track.getTranslations()[i];
                            Vector3f l_scale = l_track.getScales()[i];
                            Quaternion l_rot = l_track.getRotations()[i];

                            l_newTimes[l_newFrame] = l_track.getTimes()[i] - l_track.getTimes()[l_start];
                            l_newTranslations[l_newFrame] = l_trans.clone();
                            l_newRotations[l_newFrame] = l_rot.clone();
                            l_newScales[l_newFrame] = l_scale.clone();
                        }

                        l_tracks[j] = new BoneTrack(l_track.getTargetBoneIndex(), l_newTimes, l_newTranslations, l_newRotations, l_newScales);
                    }

                    l_newAnim.setTracks(l_tracks);
                    _animControl.getLookup().lookup(AnimControl.class).addAnim(l_newAnim);

                    return null;
                }
            }).get();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ExecutionException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void onCancelClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancelClick
        setVisible(false);
    }//GEN-LAST:event_onCancelClick

    private void onBrowseClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBrowseClick
        JFileChooser l_chooser = new JFileChooser();
        FileNameExtensionFilter l_filter = new FileNameExtensionFilter(
                "CSV Animation Split file", "csv");
        l_chooser.setFileFilter(l_filter);

        if (l_chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            _txtCsvFilename.setText(l_chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_onBrowseClick

    private void onRadioClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onRadioClick
        if (_radManual.isSelected()) {
            _txtCsvFilename.setEnabled(false);
            _btnBrowse.setEnabled(false);
            _txtName.setEnabled(true);
            _txtStartFrame.setEnabled(true);
            _txtEndFrame.setEnabled(true);
        } else {
            _txtCsvFilename.setEnabled(true);
            _btnBrowse.setEnabled(true);
            _txtName.setEnabled(false);
            _txtStartFrame.setEnabled(false);
            _txtEndFrame.setEnabled(false);
        }
    }//GEN-LAST:event_onRadioClick
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnBrowse;
    private javax.swing.JButton _btnCancel;
    private javax.swing.JButton _btnOk;
    private javax.swing.JRadioButton _radFromFile;
    private javax.swing.JRadioButton _radManual;
    private javax.swing.ButtonGroup _radioGroup;
    private javax.swing.JTextField _txtCsvFilename;
    private javax.swing.JFormattedTextField _txtEndFrame;
    private javax.swing.JTextField _txtName;
    private javax.swing.JFormattedTextField _txtStartFrame;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
