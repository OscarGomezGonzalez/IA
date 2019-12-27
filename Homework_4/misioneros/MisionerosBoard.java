package aima.core.environment.misioneros;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.Arrays;

public class MisionerosBoard {

    public static Action M1C1 = new DynamicAction("M1C1");
    public static Action M1C0 = new DynamicAction("M1C0");
    public static Action M0C1 = new DynamicAction("M0C1");
    public static Action M2C0 = new DynamicAction("M2C0");
    public static Action M0C2 = new DynamicAction("M0C2");
    private int[] state;

    public MisionerosBoard() {
        // 0: misioneros, 1: canibales y 2: barca (1-izq.)
        state = new int[]{3, 3, 1};
    }

    public MisionerosBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    public MisionerosBoard(MisionerosBoard copyBoard) {
        this(copyBoard.getState());
    }

    public int[] getState() {
        return state;
    }

    public int getMisioneros() {
        return state[0];
    }

    public int getCanibales() {
        return state[1];
    }

    public int getBarca() {
        return state[2];
    }

    public void moveBoatM1C1() {
        if (getBarca() == 1) {
            state[2] = 0;
            state[0]--;
            state[1]--;
        } else {
            state[2] = 1;
            state[0]++;
            state[1]++;
        }
    }

    public void moveBoatM1C0() {
        if (getBarca() == 1) {
            state[2] = 0;
            state[0]--;
        } else {
            state[2] = 1;
            state[0]++;
        }
    }

    public void moveBoatM0C1() {
        if (getBarca() == 1) {
            state[2] = 0;
            state[1]--;
        } else {
            state[2] = 1;
            state[1]++;
        }
    }

    public void moveBoatM2C0() {
        if (getBarca() == 1) {
            state[2] = 0;
            state[0] -= 2;
        } else {
            state[2] = 1;
            state[0] += 2;
        }
    }

    public void moveBoatM0C2() {
        if (getBarca() == 1) {
            state[2] = 0;
            state[1] -= 2;
        } else {
            state[2] = 1;
            state[1] += 2;
        }
    }

    public boolean canMoveBoat(Action where) {
        boolean retVal = true;

        if (where.equals(M1C1)) {
            if (getBarca() == 1) {
                retVal = (getMisioneros() >= 1 && getCanibales() >= 1
                        && !estadoPeligroso(getMisioneros()-1, getCanibales()-1));
            } else {
                retVal = (3-getMisioneros() >= 1 && 3-getCanibales() >= 1
                        && !estadoPeligroso(getMisioneros()+1, getCanibales()+1));
            }
        } else if (where.equals(M1C0)) {
            if (getBarca() == 1) {
                retVal = (getMisioneros() >= 1
                        && !estadoPeligroso(getMisioneros()-1, getCanibales()));
            } else {
                retVal = (3-getMisioneros() >= 1
                        && !estadoPeligroso(getMisioneros()+1, getCanibales()));
            }
        } else if (where.equals(M0C1)) {
            if (getBarca() == 1) {
                retVal = (getCanibales() >= 1
                        && !estadoPeligroso(getMisioneros(), getCanibales()-1));
            } else {
                retVal = (3-getCanibales() >= 1
                        && !estadoPeligroso(getMisioneros(), getCanibales()+1));
            }
        } else if (where.equals(M2C0)) {
            if (getBarca() == 1) {
                retVal = (getMisioneros() >= 2
                        && !estadoPeligroso(getMisioneros()-2, getCanibales()));
            } else {
                retVal = (3-getMisioneros() >= 2
                        && !estadoPeligroso(getMisioneros()+2, getCanibales()));
            }
        } else if (where.equals(M0C2)) {
            if (getBarca() == 1) {
                retVal = (getCanibales() >= 2
                        && !estadoPeligroso(getMisioneros(), getCanibales()-2));
            } else {
                retVal = (3-getCanibales() >= 2
                        && !estadoPeligroso(getMisioneros(), getCanibales()+2));
            }
        }


        return retVal;
    }

    private boolean estadoPeligroso(int m,int c){
        return (m < c && m != 0) || (m > c && m != 3);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        MisionerosBoard aBoard = (MisionerosBoard) o;

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
        String retVal = state[0] + " " + state[1] + " " + state[2];
        return retVal;
    }
}