package aima.core.environment.laberinto;

import aima.core.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */
public class LaberintoGoalTest implements GoalTest {
	LaberintoBoard goal = new LaberintoBoard(0,9);

	public boolean isGoalState(Object state) {
		LaberintoBoard board = (LaberintoBoard) state;
		return board.equals(goal);
	}
}