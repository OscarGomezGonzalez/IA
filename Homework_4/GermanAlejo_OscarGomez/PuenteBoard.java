package aima.core.environment.puente;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.Arrays;

public class PuenteBoard {

    public static Action A = new DynamicAction("A");
    public static Action B = new DynamicAction("B");
    public static Action C = new DynamicAction("C");
    public static Action D = new DynamicAction("D");
    public static Action AB = new DynamicAction("AB");
    public static Action AC = new DynamicAction("AC");
    public static Action AD = new DynamicAction("AD");
    public static Action BC = new DynamicAction("BC");
    public static Action BD = new DynamicAction("BD");
    public static Action CD = new DynamicAction("CD");

    private int[] state;

    private final int[] crossingTimes = new int[]{1, 2, 4, 8};

    public PuenteBoard() {
        state = new int[]{1, 1, 1, 1, 1, 15};
    }

    public PuenteBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    public PuenteBoard(PuenteBoard copyBoard) {
        this(copyBoard.getState());
    }

    public int[] getCrossingTimes() {
        return this.crossingTimes;
    }

    public int[] getState() {
        return state;
    }

    public int getA() {
        return state[0];
    }

    public int getB() {
        return state[1];
    }

    public int getC() {
        return state[2];
    }

    public int getD() {
        return state[3];
    }

    public int getFarol() {
        return state[4];
    }

    public int getTiempo() {
        return state[5];
    }

    public int getPeopleLeft() {
        int retVal = 0;
        for (int i = 0; i < 5; i++) {

            if (state[i] == 0) {
                retVal++;
            }
        }

        return retVal;
    }
    
    public boolean canMove(Action where) {

        boolean retVal = true;

        if (where.equals(A)) {

            retVal = (getA() == getFarol()) && (getTiempo() + crossingTimes[0] <= 15);

        } else if (where.equals(B)) {

            retVal = (getB() == getFarol()) && (getTiempo() + crossingTimes[1] <= 15);

        } else if (where.equals(C)) {

            retVal = (getC() == getFarol()) && (getTiempo() + crossingTimes[2] <= 15);

        } else if (where.equals(D)) {

            retVal = (getD() == getFarol()) && (getTiempo() + crossingTimes[3] <= 15);

        } else if (where.equals(AB)) {

            retVal = (getA() == getB() && getFarol() == getA()) && (getTiempo() + crossingTimes[1] <= 15);

        } else if (where.equals(AC)) {

            retVal = (getA() == getC() && getA() == getFarol()) && (getTiempo() + crossingTimes[2] <= 15);

        } else if (where.equals(AD)) {

            retVal = (getA() == getD() && getA() == getFarol()) && (getTiempo() + crossingTimes[3] <= 15);

        } else if (where.equals(BC)) {

            retVal = (getB() == getC() && getB() == getFarol()) && (getTiempo() + crossingTimes[2] <= 15);

        } else if (where.equals(BD)) {

            retVal = (getB() == getD() && getB() == getFarol()) && (getTiempo() + crossingTimes[3] <= 15);

        } else if (where.equals(CD)) {

            retVal = (getC() == getD() && getC() == getFarol()) && (getTiempo() + crossingTimes[3] <= 15);
            //System.out.println("P3 " + getP3() + " Farol"+ getFarol() + " P4 " + getP4() + " " + retVal);
        }
        return retVal;
    }

    public void moveA() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[5] += crossingTimes[0];
    }

    public void moveB() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[5] += crossingTimes[1];
    }

    public void moveC() {
        state[4] = 1 - state[4];
        state[2] = state[4];
        state[5] += crossingTimes[2];
    }

    public void moveD() {
        state[4] = 1 - state[4];
        state[3] = state[4];
        state[5] += crossingTimes[3];
    }

    public void moveAB() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[1] = state[4];
        state[5] += crossingTimes[1];
    }

    public void moveAC() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[2] = state[4];
        state[5] += crossingTimes[2];
    }

    public void moveAD() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[3] = state[4];
        state[5] += crossingTimes[3];
    }

    public void moveBC() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[2] = state[4];
        state[5] += crossingTimes[2];
    }

    public void moveBD() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[3] = state[4];
        state[5] += crossingTimes[3];
    }

    public void moveCD() {
        state[4] = 1 - state[4];
        state[2] = state[4];
        state[3] = state[4];
        state[5] += crossingTimes[3];
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        PuenteBoard aBoard = (PuenteBoard) o;

        for (int i = 0; i < state.length; i++) {

            if (this.state[i] != aBoard.state[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this.state);
        return hash;
    }

    @Override
    public String toString() {
        String retVal = "[" + state[0] + ", " + state[1] + ", " + state[2] + ", " + state[3] + "] " + state[4];
        return retVal;
    }
}
