package aima.core.environment.laberinto;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class LaberintoFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new LabActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new LabResultFunction();
		}
		return _resultFunction;
	}

	private static class LabActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			LaberintoBoard board = (LaberintoBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (board.canMoveRobot(LaberintoBoard.UP)) {
				actions.add(LaberintoBoard.UP);
			}
			if (board.canMoveRobot(LaberintoBoard.DOWN)) {
				actions.add(LaberintoBoard.DOWN);
			}
			if (board.canMoveRobot(LaberintoBoard.LEFT)) {
				actions.add(LaberintoBoard.LEFT);
			}
			if (board.canMoveRobot(LaberintoBoard.RIGHT)) {
				actions.add(LaberintoBoard.RIGHT);
			}

			return actions;
		}
	}

	private static class LabResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			LaberintoBoard board = (LaberintoBoard) s;

			if (LaberintoBoard.UP.equals(a)
					&& board.canMoveRobot(LaberintoBoard.UP)) {
				LaberintoBoard newBoard = new LaberintoBoard(board);
				newBoard.moveGapUp();
				return newBoard;
			} else if (LaberintoBoard.DOWN.equals(a)
					&& board.canMoveRobot(LaberintoBoard.DOWN)) {
				LaberintoBoard newBoard = new LaberintoBoard(board);
				newBoard.moveGapDown();
				return newBoard;
			} else if (LaberintoBoard.LEFT.equals(a)
					&& board.canMoveRobot(LaberintoBoard.LEFT)) {
				LaberintoBoard newBoard = new LaberintoBoard(board);
				newBoard.moveGapLeft();
				return newBoard;
			} else if (LaberintoBoard.RIGHT.equals(a)
					&& board.canMoveRobot(LaberintoBoard.RIGHT)) {
				LaberintoBoard newBoard = new LaberintoBoard(board);
				newBoard.moveGapRight();
				return newBoard;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}