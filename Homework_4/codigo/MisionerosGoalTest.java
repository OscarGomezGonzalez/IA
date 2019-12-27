package aima.core.environment.farolillo;

import aima.core.search.framework.problem.GoalTest;

public class MisionerosGoalTest implements GoalTest {
	FarolilloBoard goal = new FarolilloBoard(new int[] {0,0,0,0,0,15});

	public boolean isGoalState(Object state) {
		FarolilloBoard board = (FarolilloBoard) state;
		return board.equals(goal);
	}
}