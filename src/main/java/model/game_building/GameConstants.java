package model.game_building;

import java.awt.*;

public final class GameConstants {

    private GameConstants() {
    }//this class should not be initialized.

    // Strings
    public static final String GAME_TITLE = "KUvid";

    // Game state constants.
    public static final int GAME_STATE_PAUSED = -1;
    public static final int GAME_STATE_RESUMED = 1;
    public static final int GAME_STATE_STOP = -10;

    // Shooter movement and rotation constants.
    public static final int SHOOTER_MOVEMENT_LEFT = 9;
    public static final int SHOOTER_MOVEMENT_RIGHT = 3;
    public static final int SHOOTER_MOVEMENT_STILL = 12;
    public static final int SHOOTER_ROTATION_LEFT = -5;
    public static final int SHOOTER_ROTATION_RIGHT = 5;
    public static final int SHOOTER_ROTATION_STILL = 0;

    public static final double GAME_SIZE_RATIO = (16.0 / 9.0);

    // Game difficulty delay values
    public static final int EASY_MODE_GAME_THREAD_DELAY = 45;
    public static final int MEDIUM_MODE_GAME_THREAD_DELAY = 30;
    public static final int HARD_MODE_GAME_THREAD_DELAY = 15;

    // Game difficulty drop rate values
    public static final int EASY_MODE_GAME_DROP_RATE = 5000;
    public static final int MEDIUM_MODE_GAME_DROP_RATE = 3000;
    public static final int HARD_MODE_GAME_DROP_RATE = 1000;

    public static final int GAME_THREAD_DELAY = 15;

    // Objects Dimensions.
    public static final Dimension BUILDING_WINDOW_SIZE = new Dimension(800, 800);
    public static final Dimension BLENDER_WINDOW_SIZE = new Dimension(300, 100);
    public static final int FPS = 60;

    //drawable sizes with regard to L
    public static final double ATOM_RADIUS = 0.1;
    public static final double MOLECULE_RADIUS = 0.25;
    public static final double BLOCKER_DIAMETER = 1.0;
    public static final double POWERUP_RADIUS = 0.5; //not specified
    public static final double SHOOTER_HEIGHT = 1;
    public static final double SHOOTER_WIDTH = 0.5;

    public static final double[][] BLENDING_MATRIX = {{1, 2, 3, 4}, {.5, 1, 1, 1.5}, {0.333, 0.333, 1, 0.666}, {.25, .25, .25, 1}}; // Contains the values corresponding to blending/breaking atoms.
    public static final int ICON_WIDTH = 50;
    public static final int ICON_HEIGHT = 50;

    public static final double STATISTICS_PANEL_WIDTH_RATIO = 0.2;
    public static final double GAME_PANEL_WIDTH_RATIO = 0.8;
    public static final int PANEL_SEPARATOR_WIDTH = 3;

}