/*
    Copywrite 2015-2016 Will Winder

    This file is part of Universal Gcode Sender (UGS).

    UGS is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    UGS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with UGS.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.willwinder.ugs.nbp.core.control;

import com.willwinder.ugs.nbp.core.control.Bundle;
import com.willwinder.ugs.nbp.lookup.CentralLookup;
import com.willwinder.universalgcodesender.i18n.Localization;
import com.willwinder.universalgcodesender.listeners.ControllerListener;
import com.willwinder.universalgcodesender.model.BackendAPI;
import com.willwinder.universalgcodesender.model.Position;
import com.willwinder.universalgcodesender.types.GcodeCommand;
import com.willwinder.universalgcodesender.utils.Settings;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.willwinder.ugs.nbp.control//Status//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "StatusTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "bottom_left", openAtStartup = true)
@ActionID(category = "Window", id = "com.willwinder.ugs.nbp.control.StatusTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_StatusAction",
        preferredID = "StatusTopComponent"
)
@Messages({
    "CTL_StatusAction=Controller State (DRO)",
    "CTL_StatusTopComponent=Controller State (DRO)",
    "HINT_StatusTopComponent=Current controller state."
})
public final class LocationStatusTopComponent extends TopComponent implements ControllerListener {
    BackendAPI backend;
    Settings settings;
    
    public LocationStatusTopComponent() {
        initComponents();
        setName(Bundle.CTL_StatusTopComponent());
        setToolTipText(Bundle.HINT_StatusTopComponent());
        
        backend = CentralLookup.getDefault().lookup(BackendAPI.class);
        settings = CentralLookup.getDefault().lookup(Settings.class);

        backend.addControllerListener(this);
        
        String fontPath="/resources/";
        String fontName="LetsGoDigitalRegular.ttf";
        InputStream is = LocationStatusTopComponent.class.getResourceAsStream(fontPath+fontName);
        Font font;
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(Font.BOLD,28);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(fontName + " not loaded.  Using serif font.");
            font = new Font("serif", Font.PLAIN, 24);
        }
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        
        this.machinePositionXValueLabel.setFont(font);
        this.machinePositionYValueLabel.setFont(font);
        this.machinePositionZValueLabel.setFont(font);
        
        this.workPositionXValueLabel.setFont(font);
        this.workPositionYValueLabel.setFont(font);
        this.workPositionZValueLabel.setFont(font);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        machinePositionXValueLabel = new javax.swing.JLabel();
        machinePositionYValueLabel = new javax.swing.JLabel();
        machinePositionZValueLabel = new javax.swing.JLabel();
        machinePosition = new javax.swing.JLabel();
        machinePositionXLabel = new javax.swing.JLabel();
        machinePositionYLabel = new javax.swing.JLabel();
        machinePositionZLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        workPositionLabel = new javax.swing.JLabel();
        workPositionXLabel = new javax.swing.JLabel();
        workPositionXValueLabel = new javax.swing.JLabel();
        workPositionYLabel = new javax.swing.JLabel();
        workPositionYValueLabel = new javax.swing.JLabel();
        workPositionZLabel = new javax.swing.JLabel();
        workPositionZValueLabel = new javax.swing.JLabel();
        activeStateLabel = new javax.swing.JLabel();
        latestCommentLabel = new javax.swing.JLabel();
        activeStateValueLabel = new javax.swing.JLabel();
        latestCommentValueLabel = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(250, 146));

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionXValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionXValueLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionYValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionYValueLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionZValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionZValueLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePosition, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePosition.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionXLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionXLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionYLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionYLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(machinePositionZLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.machinePositionZLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(machinePositionZLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(machinePositionZValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(machinePositionYLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(machinePositionYValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(machinePositionXLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(machinePositionXValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(machinePosition, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(machinePosition)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(machinePositionXLabel)
                    .addComponent(machinePositionXValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(machinePositionYLabel)
                    .addComponent(machinePositionYValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(machinePositionZLabel)
                    .addComponent(machinePositionZValueLabel))
                .addGap(30, 30, 30))
        );

        org.openide.awt.Mnemonics.setLocalizedText(workPositionLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionXLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionXLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionXValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionXValueLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionYLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionYLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionYValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionYValueLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionZLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionZLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(workPositionZValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.workPositionZValueLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(workPositionZLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workPositionZValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(workPositionYLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workPositionYValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(workPositionXLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workPositionXValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(workPositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(workPositionLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workPositionXLabel)
                    .addComponent(workPositionXValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workPositionYLabel)
                    .addComponent(workPositionYValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workPositionZLabel)
                    .addComponent(workPositionZValueLabel))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(activeStateLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.activeStateLabel.text")); // NOI18N
        activeStateLabel.setOpaque(true);

        org.openide.awt.Mnemonics.setLocalizedText(latestCommentLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.latestCommentLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(activeStateValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.activeStateValueLabel.text")); // NOI18N
        activeStateValueLabel.setOpaque(true);

        org.openide.awt.Mnemonics.setLocalizedText(latestCommentValueLabel, org.openide.util.NbBundle.getMessage(LocationStatusTopComponent.class, "LocationStatusTopComponent.latestCommentValueLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(activeStateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(latestCommentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(latestCommentValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activeStateValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeStateLabel)
                    .addComponent(activeStateValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(latestCommentLabel)
                    .addComponent(latestCommentValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeStateLabel;
    private javax.swing.JLabel activeStateValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel latestCommentLabel;
    private javax.swing.JLabel latestCommentValueLabel;
    private javax.swing.JLabel machinePosition;
    private javax.swing.JLabel machinePositionXLabel;
    private javax.swing.JLabel machinePositionXValueLabel;
    private javax.swing.JLabel machinePositionYLabel;
    private javax.swing.JLabel machinePositionYValueLabel;
    private javax.swing.JLabel machinePositionZLabel;
    private javax.swing.JLabel machinePositionZValueLabel;
    private javax.swing.JLabel workPositionLabel;
    private javax.swing.JLabel workPositionXLabel;
    private javax.swing.JLabel workPositionXValueLabel;
    private javax.swing.JLabel workPositionYLabel;
    private javax.swing.JLabel workPositionYValueLabel;
    private javax.swing.JLabel workPositionZLabel;
    private javax.swing.JLabel workPositionZValueLabel;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public LocationStatusTopComponent(Lookup lookup) {
        super(lookup);
    }
    
    
    ////////////////////////////
    // ControllerListener API //
    ////////////////////////////

    @Override
    public void fileStreamComplete(String string, boolean bln) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commandSkipped(GcodeCommand gc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commandSent(GcodeCommand gc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commandComplete(GcodeCommand gc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commandComment(String string) {
        this.latestCommentValueLabel.setText(string);
    }

    @Override
    public void messageForConsole(String string, Boolean bln) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void statusStringListener(String state, Position machineCoord, Position workCoord) {
        this.activeStateValueLabel.setText(state);
        setStatusColorForState(state);
        
        this.machinePositionXValueLabel.setText(machineCoord.getX() + "");
        this.machinePositionYValueLabel.setText(machineCoord.getY() + "");
        this.machinePositionZValueLabel.setText(machineCoord.getZ() + "");
        
        this.workPositionXValueLabel.setText(workCoord.getX() + "");
        this.workPositionYValueLabel.setText(workCoord.getY() + "");
        this.workPositionZValueLabel.setText(workCoord.getZ() + "");

    }

    @Override
    public void postProcessData(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // ControllerListener helpers
    private void setStatusColorForState(String state) {
        if (settings.isDisplayStateColor()) {
            java.awt.Color color = null; // default to a transparent background.
            if (state.equals(Localization.getString("mainWindow.status.alarm"))) {
                color = Color.RED;
            } else if (state.equals(Localization.getString("mainWindow.status.hold"))) {
                color = Color.YELLOW;
            } else if (state.equals(Localization.getString("mainWindow.status.queue"))) {
                color = Color.YELLOW;
            } else if (state.equals(Localization.getString("mainWindow.status.run"))) {
                color = Color.GREEN;
            }

            this.activeStateLabel.setBackground(color);
            this.activeStateValueLabel.setBackground(color);
        } else {
            this.activeStateLabel.setBackground(null);
            this.activeStateValueLabel.setBackground(null);
        }
    }
}
