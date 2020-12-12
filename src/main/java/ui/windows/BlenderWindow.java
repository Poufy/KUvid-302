package ui.windows;

import model.game_building.GameConstants;
import model.game_running.RunningMode;
import model.game_space.Blender;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BlenderWindow extends JFrame implements Blender.BlenderListener {
    private JPanel contentPane;

    // Labels
    private JLabel sourceLabel;
    private JLabel destinationLabel;
    private JLabel destinationQuantityLabel;

    // ComboBoxes
    private JComboBox sourceComboBox;
    private JComboBox destinationComboBox;

    private JTextField destinationQuantityField;
    private JButton blendButton;
    private RunningMode runningMode;

    Map<String, Integer> atomTypesRanks; // This map contains a mapping between atom types and their weights (1 to 4)
    Blender blender;
    public BlenderWindow(Blender blender, RunningMode runningMode) {
        super("blender");
        this.blender = blender;
        blender.setBlenderListener(this); // Pass this listener to Blender for the observer pattern
        this.atomTypesRanks = new HashMap<>();
        this.contentPane = new JPanel();

        this.runningMode = runningMode;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                runningMode.setRunningState(GameConstants.GAME_STATE_RESUMED);
            }
        });
        getContentPane().add(contentPane);
        addComponents(contentPane); // Add components to the panel
        this.pack(); // Pack the frame around the components
        setLocationRelativeTo(null);
        this.setVisible(false); // Keep it invisible by default
    }

    private void addComponents(JPanel contentPane) {
        this.atomTypesRanks.put("Alpha", 1);
        this.atomTypesRanks.put("Beta", 2);
        this.atomTypesRanks.put("Gamma", 3);
        this.atomTypesRanks.put("Sigma", 4);

        sourceLabel = new JLabel("Source");
        sourceComboBox = new JComboBox((atomTypesRanks.keySet().toArray()));
        destinationLabel = new JLabel("Destination");
        destinationComboBox = new JComboBox(atomTypesRanks.keySet().toArray());
        destinationQuantityLabel = new JLabel("Quantity");
        destinationQuantityField = new JTextField(3);
        destinationQuantityField.setText("1");
        blendButton = new JButton("Blend");
        addButtonActionListener(blendButton);

        contentPane.add(sourceLabel);
        contentPane.add(sourceComboBox);
        contentPane.add(destinationLabel);
        contentPane.add(destinationComboBox);
        contentPane.add(destinationQuantityLabel);
        contentPane.add(destinationQuantityField);
        contentPane.add(blendButton);
    }

    public Blender getBlender(){
        return this.blender;
    }

    private void addButtonActionListener(JButton btn) {
        btn.addActionListener(e -> {
            String source = String.valueOf(sourceComboBox.getSelectedItem());
            String destination = String.valueOf(destinationComboBox.getSelectedItem());
            int sourceRank = atomTypesRanks.get(source);
            int destinationRank = atomTypesRanks.get(destination);
            int destinationRankQuantity;
            try {
               destinationRankQuantity = Integer.parseInt(destinationQuantityField.getText());
            } catch (NumberFormatException exception){
                destinationRankQuantity = 1;
            }

            blender.blend(sourceRank, destinationRank, destinationRankQuantity);
        });
    }

    @Override
    public void onBlend() {
       this.setVisible(false);
       runningMode.setRunningState(GameConstants.GAME_STATE_RESUMED);
       // this.dispose();
    }

    @Override
    public void onShow() {
        this.setVisible(true);
    }
}

