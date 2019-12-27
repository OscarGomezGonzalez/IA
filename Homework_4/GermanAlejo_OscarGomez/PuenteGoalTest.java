package aima.core.environment.puente;

import aima.core.search.framework.problem.GoalTest;

public class PuenteGoalTest implements GoalTest {
	PuenteBoard goal = new PuenteBoard(new int[] {0,0,0,0,0,15});

	public boolean isGoalState(Object state) {
		PuenteBoard board = (PuenteBoard) state;
		return board.equals(goal);
	}
}