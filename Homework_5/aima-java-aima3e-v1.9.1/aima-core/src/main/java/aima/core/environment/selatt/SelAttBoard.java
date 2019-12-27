package aima.core.environment.selatt;

import java.util.Arrays;

/**
 *
 * @author geral
 */
public class SelAttBoard {

    private int[] state;

    private final double[][] correlationsAtt = {
        {0.64491, 0.65459, 0.48636, 0.52182, 0.58730, 0.55843, 0.53583, 0.35003},
        {0.90688, 0.70558, 0.75180, 0.68680, 0.75572, 0.72286, 0.45869},
        {0.68308, 0.71967, 0.70961, 0.73595, 0.71945, 0.43891},
        {0.59960, 0.66505, 0.66672, 0.60335, 0.41763},
        {0.58126, 0.61610, 0.62888, 0.47910},
        {0.67590, 0.57736, 0.33874},
        {0.66588, 0.34417},
        {0.42834}
    };

    private final double[] correlationsClass = {
        0.71600, 0.81790, 0.81893, 0.69680, 0.68278, 0.81605, 0.75662, 0.71224, 0.42317
    };

    public SelAttBoard() {
        state = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public SelAttBoard(int[] state) {
        this.state = new int[state.length];
        System.arraycopy(state, 0, this.state, 0, state.length);
    }

    public SelAttBoard(SelAttBoard copyBoard) {
        this(copyBoard.getState());
    }
    
    public int getNumAtt(){
        return correlationsAtt[0].length;
    }

    public int[] getState() {
        return state;
    }

    public int get1() {
        return state[0];
    }

    public int get2() {
        return state[1];
    }

    public int get3() {
        return state[2];
    }

    public int get4() {
        return state[3];
    }

    public int get5() {
        return state[4];
    }

    public int get6() {
        return state[5];
    }

    public int get7() {
        return state[6];
    }

    public int get8() {
        return state[7];
    }

    public int get9() {
        return state[8];
    }

    /**
     * returns correlation between two attributes
     */
    public double getCorrelationAtt(int row, int col) {

        double res;
        int aux;

        if (row < col) {

            aux = col;
            col = row;
            row = aux;

            res = correlationsAtt[row][col];

        } else if (row == col) {
            res = 1;
        } else {
            res = correlationsAtt[row][col];
        }

        return res;
    }
    
    /**
     *  returns value of class correlation
     */
    public double getCorrelationClass(int pos){
        return correlationsClass[pos];
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        SelAttBoard aBoard = (SelAttBoard) o;

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
