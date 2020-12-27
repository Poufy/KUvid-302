package model.game_running;

import model.game_entities.*;

public class CollisionHandler implements CollisionVisitor {

    RunningMode controller;

    CollisionHandler(RunningMode controller) {
        this.controller = controller;
    }

    /**
     * this method calls the removeEntity method of the runningMode object to remove the entities from the game view
     *
     * @param entity1 first autonomousEntity
     * @param entity2 second autonomousEntity
     */
    private void defaultCollision(AutonomousEntity entity1, AutonomousEntity entity2) {
        controller.removeEntity(entity1);
        controller.removeEntity(entity2);
    }


    @Override
    public void handleCollision(Atom atom, Molecule molecule) {
        if (atom.getType().getValue() == molecule.getType().getValue()) {
            controller.increaseScore();
            defaultCollision(atom, molecule);
        }
    }

    @Override
    public void handleCollision(Atom atom, Blocker blocker) {
        // this only breaks the atom if enters the AOE of a corresponding type blocker.
        if (atom.getType().getValue() == blocker.getType().getValue())
            controller.removeEntity(atom);
    }

    @Override
    public void handleCollision(Powerup powerup, Blocker blocker) {
        if (blocker.getType().getValue() == powerup.getType().getValue())
            defaultCollision(powerup, blocker);
    }

    @Override
    public void handleCollision(Shooter shooter, Powerup powerup) {
        controller.collectPowerUp(powerup);
        controller.removeEntity(powerup);
    }

    @Override
    public void handleCollision(Molecule molecule, Blocker blocker) {
//        defaultCollision(molecule, blocker);
        //nothing for now. this collision will be conditional: only when the blocker is exploding.
    }

    @Override
    public void handleCollision(Shooter shooter, Blocker blocker) {
        // decrease the health of the player.
        // check for close atom and molecules and destroy them.
    }


}
