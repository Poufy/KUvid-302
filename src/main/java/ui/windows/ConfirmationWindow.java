package ui.windows;

import model.game_building.ConfigBundle;
import model.game_building.ConfigConfirmation;
import model.game_building.GameConstants;

import javax.swing.*;

public class ConfirmationWindow implements ConfigConfirmation.ParametersConfirmationListener {
    ConfigConfirmation configConfirmation;
    JFrame buildingGameFrame;

    public ConfirmationWindow(JFrame frame, ConfigBundle bundle) {
        this.buildingGameFrame = frame;
        this.configConfirmation = new ConfigConfirmation(this);


        int reply = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
        // TODO: View a summary of the bundle
        if (reply == JOptionPane.YES_OPTION)
            configConfirmation.confirm(bundle);
        else
            System.out.println("Returning to building window");
    }


    @Override
    public void onConfirmedParameters() {
        // Close the current game-building frame.
        buildingGameFrame.dispose();

        new RunningWindow(GameConstants.GAME_TITLE); //todo: maybe start somewhere else?
    }
}
