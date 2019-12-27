package aima.core.environment.farolillo;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.Arrays;

public class FarolilloBoard {

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

    private int[] timePerson = new int[]{1, 2, 4, 8};

    public FarolilloBoard() {
        state = new int[]{1, 1, 1, 1, 1, 15};
    }

    public FarolilloBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    public FarolilloBoard(FarolilloBoard copyBoard) {
        this(copyBoard.getState());
    }

    public int[] getState() {
        return state;
    }

    public int getP1() {
        return state[0];
    }

    public int getP2() {
        return state[1];
    }

    public int getP3() {
        return state[2];
    }

    public int getP4() {
        return state[3];
    }

    public int getFarol() {
        return state[4];
    }

    public int getTiempo() {
        return state[5];
    }

    public boolean canMoveBoat(Action where) {

        boolean retVal = true;

        if (where.equals(A)) {

            retVal = (getP1() == getFarol()) && (getTiempo() + 1 <= 15);

        } else if (where.equals(B)) {

            retVal = (getP2() == getFarol()) && (getTiempo() + 2 <= 15);

        } else if (where.equals(C)) {

            retVal = (getP3() == getFarol()) && (getTiempo() + 4 <= 15);

        } else if (where.equals(D)) {

            retVal = (getP4() == getFarol()) && (getTiempo() + 8 <= 15);

        } else if (where.equals(AB)) {

            retVal = (getP1() == getP2() && getFarol() == getP1()) && (getTiempo() + 2 <= 15);

        } else if (where.equals(AC)) {

            retVal = (getP1() == getP3() && getP1() == getFarol()) && (getTiempo() + 4 <= 15);

        } else if (where.equals(AD)) {

            retVal = (getP1() == getP4() && getP1() == getFarol()) && (getTiempo() + 8 <= 15);

        } else if (where.equals(BC)) {

            retVal = (getP2() == getP3() && getP2() == getFarol()) && (getTiempo() + 4 <= 15);

        } else if (where.equals(BD)) {

            retVal = (getP2() == getP4() && getP2() == getFarol()) && (getTiempo() + 8 <= 15);

        } else if (where.equals(CD)) {

            retVal = (getP3() == getP4() && getP3() == getFarol()) && (getTiempo() + 8 <= 15);
            //System.out.println("P3 " + getP3() + " Farol"+ getFarol() + " P4 " + getP4() + " " + retVal);
        }
        return retVal;
    }

    public void movePerson1() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[5] += timePerson[0];
    }

    public void movePerson2() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[5] += timePerson[1];
    }

    public void movePerson3() {
        state[4] = 1 - state[4];
        state[2] = state[4];
        state[5] += timePerson[2];
    }

    public void movePerson4() {
        state[4] = 1 - state[4];
        state[3] = state[4];
        state[5] += timePerson[3];
    }

    public void movePerson1Person2() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[1] = state[4];
        state[5] += timePerson[1];
    }

    public void movePerson1Person3() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[2] = state[4];
        state[5] += timePerson[2];
    }

    public void movePerson1Person4() {
        state[4] = 1 - state[4];
        state[0] = state[4];
        state[3] = state[4];
        state[5] += timePerson[3];
    }

    public void movePerson2Person3() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[2] = state[4];
        state[5] += timePerson[2];
    }

    public void movePerson2Person4() {
        state[4] = 1 - state[4];
        state[1] = state[4];
        state[3] = state[4];
        state[5] += timePerson[3];
    }

    public void movePerson3Person4() {
        state[4] = 1 - state[4];
        state[2] = state[4];
        state[3] = state[4];
        state[5] += timePerson[3];
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        FarolilloBoard aBoard = (FarolilloBoard) o;

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
