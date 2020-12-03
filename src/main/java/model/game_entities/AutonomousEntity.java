package model.game_entities;

import model.game_physics.hitbox.Hitbox;
import model.game_physics.path_patterns.PathPattern;
import utils.Coordinates;

/**
 * AutonomousEntity: a Superclass for all the game objects that move autonomously
 */
abstract public class AutonomousEntity extends Entity {

    private PathPattern pathPattern;

    public AutonomousEntity(Coordinates coordinates, Hitbox hitbox, PathPattern pathPattern) {
        super(coordinates, hitbox);
        this.pathPattern = pathPattern;
        this.pathPattern.setCurrentCoords(coordinates);
    }

    public void setPathPattern(PathPattern pathPattern) {
        this.pathPattern = pathPattern;
    }

    public PathPattern getPathPattern() {
        return this.pathPattern;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
        // update the path pattern coordinates
        this.pathPattern.setCurrentCoords(coordinates);
    }

    /**
     * move: moves the corresponding object according to the path variable.
     */
    public void move() {
        setCoordinates(this.getPathPattern().nextPosition());
    }
}
