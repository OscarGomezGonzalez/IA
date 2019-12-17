package aima.core.environment.misioneros;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class MisionerosFunctionFactory {

    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new MCActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new MCResultFunction();
        }
        return _resultFunction;
    }

    private static class MCActionsFunction implements ActionsFunction {

        public Set<Action> actions(Object state) {
            MisionerosBoard board = (MisionerosBoard) state;

            Set<Action> actions = new LinkedHashSet<Action>();

            if (board.canMoveBoat(MisionerosBoard.M1C0)) {
                actions.add(MisionerosBoard.M1C0);
            }
            if (board.canMoveBoat(MisionerosBoard.M2C0)) {
                actions.add(MisionerosBoard.M2C0);
            }
            if (board.canMoveBoat(MisionerosBoard.M0C1)) {
                actions.add(MisionerosBoard.M0C1);
            }
            if (board.canMoveBoat(MisionerosBoard.M0C2)) {
                actions.add(MisionerosBoard.M0C2);
            }
            if (board.canMoveBoat(MisionerosBoard.M1C1)) {
                actions.add(MisionerosBoard.M1C1);
            }

            return actions;
        }
    }

    private static class MCResultFunction implements ResultFunction {

        public Object result(Object s, Action a) {
            MisionerosBoard board = (MisionerosBoard) s;

            if (MisionerosBoard.M1C1.equals(a)
                    && board.canMoveBoat(MisionerosBoard.M1C1)) {
                MisionerosBoard newBoard = new MisionerosBoard(board);
                newBoard.moveBoatM1C1();
                return newBoard;
            } else if (MisionerosBoard.M1C0.equals(a)
                    && board.canMoveBoat(MisionerosBoard.M1C0)) {
                MisionerosBoard newBoard = new MisionerosBoard(board);
                newBoard.moveBoatM1C0();
                return newBoard;
            } else if (MisionerosBoard.M0C1.equals(a)
                    && board.canMoveBoat(MisionerosBoard.M0C1)) {
                MisionerosBoard newBoard = new MisionerosBoard(board);
                newBoard.moveBoatM0C1();
                return newBoard;
            } else if (MisionerosBoard.M2C0.equals(a)
                    && board.canMoveBoat(MisionerosBoard.M2C0)) {
                MisionerosBoard newBoard = new MisionerosBoard(board);
                newBoard.moveBoatM2C0();
                return newBoard;
            } else if (MisionerosBoard.M0C2.equals(a)
                    && board.canMoveBoat(MisionerosBoard.M0C2)) {
                MisionerosBoard newBoard = new MisionerosBoard(board);
                newBoard.moveBoatM0C2();
                return newBoard;
            }

            // The Action is not understood or is a NoOp
            // the result will be the current state.
            return s;
        }
    }
}