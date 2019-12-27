package aima.core.environment.misioneros;

import aima.core.search.framework.GoalTest;

public class MisionerosGoalTest implements GoalTest {
	MisionerosBoard goal = new MisionerosBoard(new int[] { 0, 0, 0 });

	public boolean isGoalState(Object state) {
		MisionerosBoard board = (MisionerosBoard) state;
		return board.equals(goal);
	}
}