package aima.core.environment.farolillo;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

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
            FarolilloBoard board = (FarolilloBoard) state;

            Set<Action> actions = new LinkedHashSet<Action>();

            if (board.canMoveBoat(FarolilloBoard.A)) {
                actions.add(FarolilloBoard.A);
            }
            if (board.canMoveBoat(FarolilloBoard.B)) {
                actions.add(FarolilloBoard.B);
            }
            if (board.canMoveBoat(FarolilloBoard.C)) {
                actions.add(FarolilloBoard.C);
            }
            if (board.canMoveBoat(FarolilloBoard.D)) {
                actions.add(FarolilloBoard.D);
            }
            if (board.canMoveBoat(FarolilloBoard.AB)) {
                actions.add(FarolilloBoard.AB);
            }
            if (board.canMoveBoat(FarolilloBoard.AC)) {
                actions.add(FarolilloBoard.AC);
            }
            if (board.canMoveBoat(FarolilloBoard.AD)) {
                actions.add(FarolilloBoard.AD);
            }
            if (board.canMoveBoat(FarolilloBoard.BC)) {
                actions.add(FarolilloBoard.BC);
            }
            if (board.canMoveBoat(FarolilloBoard.BD)) {
                actions.add(FarolilloBoard.BD);
            }
            if (board.canMoveBoat(FarolilloBoard.CD)) {
                actions.add(FarolilloBoard.CD);
            }
            return actions;
        }
    }

    private static class MCResultFunction implements ResultFunction {

        public Object result(Object s, Action a) {
            FarolilloBoard board = (FarolilloBoard) s;

            if (FarolilloBoard.A.equals(a)
                    && board.canMoveBoat(FarolilloBoard.A)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson1();
                return newBoard;
            } else if (FarolilloBoard.B.equals(a)
                    && board.canMoveBoat(FarolilloBoard.B)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson2();
                return newBoard;
            } else if (FarolilloBoard.C.equals(a)
                    && board.canMoveBoat(FarolilloBoard.C)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson3();
                return newBoard;
            } else if (FarolilloBoard.D.equals(a)
                    && board.canMoveBoat(FarolilloBoard.D)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson4();
                return newBoard;
            } else if (FarolilloBoard.AB.equals(a)
                    && board.canMoveBoat(FarolilloBoard.AB)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson1Person2();
                return newBoard;
            } else if (FarolilloBoard.AC.equals(a)
                    && board.canMoveBoat(FarolilloBoard.AC)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson1Person3();
                return newBoard;
            } else if (FarolilloBoard.AD.equals(a)
                    && board.canMoveBoat(FarolilloBoard.AD)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson1Person4();
                return newBoard;
            } else if (FarolilloBoard.BC.equals(a)
                    && board.canMoveBoat(FarolilloBoard.BC)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson2Person3();
                return newBoard;
            } else if (FarolilloBoard.BD.equals(a)
                    && board.canMoveBoat(FarolilloBoard.BD)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson2Person4();
                return newBoard;
            } else if (FarolilloBoard.CD.equals(a)
                    && board.canMoveBoat(FarolilloBoard.CD)) {
                FarolilloBoard newBoard = new FarolilloBoard(board);
                newBoard.movePerson3Person4();
                return newBoard;
            } 
            // The Action is not understood or is a NoOp
            // the result will be the current state.
            return s;
        }
    }
}