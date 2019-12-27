package aima.core.environment.puente;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

public class PuenteFunctionFactory {

    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new BridgeActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new BridgeResultFunction();
        }
        return _resultFunction;
    }

    private static class BridgeActionsFunction implements ActionsFunction {

        public Set<Action> actions(Object state) {
            PuenteBoard board = (PuenteBoard) state;

            Set<Action> actions = new LinkedHashSet<Action>();

            if (board.canMove(PuenteBoard.A)) {
                actions.add(PuenteBoard.A);
            }
            if (board.canMove(PuenteBoard.B)) {
                actions.add(PuenteBoard.B);
            }
            if (board.canMove(PuenteBoard.C)) {
                actions.add(PuenteBoard.C);
            }
            if (board.canMove(PuenteBoard.D)) {
                actions.add(PuenteBoard.D);
            }
            if (board.canMove(PuenteBoard.AB)) {
                actions.add(PuenteBoard.AB);
            }
            if (board.canMove(PuenteBoard.AC)) {
                actions.add(PuenteBoard.AC);
            }
            if (board.canMove(PuenteBoard.AD)) {
                actions.add(PuenteBoard.AD);
            }
            if (board.canMove(PuenteBoard.BC)) {
                actions.add(PuenteBoard.BC);
            }
            if (board.canMove(PuenteBoard.BD)) {
                actions.add(PuenteBoard.BD);
            }
            if (board.canMove(PuenteBoard.CD)) {
                actions.add(PuenteBoard.CD);
            }
            return actions;
        }
    }

    private static class BridgeResultFunction implements ResultFunction {

        public Object result(Object s, Action a) {
            PuenteBoard board = (PuenteBoard) s;

            if (PuenteBoard.A.equals(a)
                    && board.canMove(PuenteBoard.A)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveA();
                return newBoard;
            } else if (PuenteBoard.B.equals(a)
                    && board.canMove(PuenteBoard.B)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveB();
                return newBoard;
            } else if (PuenteBoard.C.equals(a)
                    && board.canMove(PuenteBoard.C)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveC();
                return newBoard;
            } else if (PuenteBoard.D.equals(a)
                    && board.canMove(PuenteBoard.D)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveD();
                return newBoard;
            } else if (PuenteBoard.AB.equals(a)
                    && board.canMove(PuenteBoard.AB)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveAB();
                return newBoard;
            } else if (PuenteBoard.AC.equals(a)
                    && board.canMove(PuenteBoard.AC)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveAC();
                return newBoard;
            } else if (PuenteBoard.AD.equals(a)
                    && board.canMove(PuenteBoard.AD)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveAD();
                return newBoard;
            } else if (PuenteBoard.BC.equals(a)
                    && board.canMove(PuenteBoard.BC)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveBC();
                return newBoard;
            } else if (PuenteBoard.BD.equals(a)
                    && board.canMove(PuenteBoard.BD)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveBD();
                return newBoard;
            } else if (PuenteBoard.CD.equals(a)
                    && board.canMove(PuenteBoard.CD)) {
                PuenteBoard newBoard = new PuenteBoard(board);
                newBoard.moveCD();
                return newBoard;
            }
            // The Action is not understood or is a NoOp
            // the result will be the current state.
            return s;
        }
    }
}
