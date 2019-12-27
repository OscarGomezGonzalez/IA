package aima.core.environment.laberinto;


import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 * @author Ravi Mohan
 * @author R. Lunde
 */
public class LaberintoBoard {

    public static Action LEFT = new DynamicAction("Left");
    public static Action RIGHT = new DynamicAction("Right");
    public static Action UP = new DynamicAction("Up");
    public static Action DOWN = new DynamicAction("Down");
    
    private int row;
    private int column;
    
    private static char state[][] = 
       {{'O', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'X', 'X', 'X', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X'},
        {'O', 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X'}};

    //
    // PUBLIC METHODS
    //
    public LaberintoBoard() {
        this.row = 4;
        this.column = 0;
    }

    public LaberintoBoard(int r, int c) {
        this.row = r;
        this.column = c;
    }

    public LaberintoBoard(LaberintoBoard copyBoard) {
        this(copyBoard.getRow(),copyBoard.getColumn());
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // para escribir el camino
    public static void setValueState(int i, int j, char c) {
        if (state[i][j] != 'X')
            state[i][j] = c;
    }
    
    public static char getValueState(int i, int j) {
        return state[i][j];
    }
    public void moveGapLeft() {
        this.column--;
    }

    public void moveGapRight() {
        this.column++;
    }

    public void moveGapUp() {
        this.row--;
    }

    public void moveGapDown() {
        this.row++;
    }


    public boolean canMoveRobot(Action where) {
        boolean retVal = true;
        if (where.equals(LEFT)) {
            retVal = ((getColumn()!=0) && (state[getRow()][getColumn()-1]!='X'));
        } else if (where.equals(RIGHT)) {
            retVal = ((getColumn()!=9) && (state[getRow()][getColumn()+1]!='X'));
        } else if (where.equals(UP)) {
            retVal = ((getRow()!=0) && (state[getRow()-1][getColumn()]!='X'));
        } else if (where.equals(DOWN)) {
            retVal = ((getRow()!=9) && (state[getRow()+1][getColumn()]!='X'));
        }
        return retVal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LaberintoBoard other = (LaberintoBoard) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.row;
        hash = 31 * hash + this.column;
        return hash;
    }

    @Override
    public String toString() {
        return "LaberintoBoard{" + "row=" + row + ", column=" + column + '}';
    }    
}