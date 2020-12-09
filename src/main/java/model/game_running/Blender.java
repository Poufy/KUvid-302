package model.game_running;

import model.game_entities.Atom;
import utils.MathUtils;


public class Blender {
    private final int ALPHA = 1, BETA = 2, GAMMA = 3, SIGMA = 4;
    private ProjectileContainer atomsContainer;

    public Blender(ProjectileContainer atomsContainer){
        this.atomsContainer = atomsContainer;
    }

    public void blendAtom(int sourceAtom, int targetAtom){

    }

    public void breakAtom(int sourceAtom, int targetAtom){
    }

    /**
     * Given the indices of the source and target atoms, returns the number of source atoms needed for the blend.
     *
     * @param sourceIndex the index of the source atom.
     * @param targetIndex the index of the target atom.
     * @return the number of source atoms needed for the blend.
     */
    private double getBlendCoefficient(int sourceIndex, int targetIndex){
        double[][] defaultMatrix = MathUtils.blendMatrix(new int[]{ALPHA, BETA, GAMMA, SIGMA}, 4);
        return defaultMatrix[sourceIndex][targetIndex];
    }

    public interface BlenderListener{
        /**
         * this method is called after game parameters get checked and proved valid.
         */
        void onBlend();
    }
}
