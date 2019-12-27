package aima.core.environment.puente;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.environment.puente.*;
import aima.core.search.framework.*;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.UniformCostSearch;

public class PuenteDemo {

    static PuenteBoard boardInicial = new PuenteBoard(
            new int[]{1, 1, 1, 1, 1, 0});

    public static void main(String[] args) {
        PuenteBreadthDemo();
        PuenteDepthGraphDemo();
        PuenteDepthLimitedGraphDemo();
        PuenteUniformCostGraphDemo();
        puenteHeuristicCostDemo();
    }

    private static void PuenteBreadthDemo() {
        System.out.println("\nPuenteDemo breadth -->");
        try {
            Problem problem = new Problem(boardInicial, PuenteFunctionFactory.getActionsFunction(), PuenteFunctionFactory.getResultFunction(), new PuenteGoalTest());
            SearchForActions search = new BreadthFirstSearch();
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void PuenteDepthGraphDemo() {
        System.out.println("\nPuenteDemo depth graph -->");
        try {
            Problem problem = new Problem(boardInicial, PuenteFunctionFactory.getActionsFunction(), PuenteFunctionFactory.getResultFunction(), new PuenteGoalTest());
            SearchForActions search = new DepthFirstSearch(new GraphSearch());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void PuenteDepthLimitedGraphDemo() {
        System.out.println("\nPuenteDemo depth limited graph -->");
        try {
            Problem problem = new Problem(boardInicial, PuenteFunctionFactory.getActionsFunction(), PuenteFunctionFactory.getResultFunction(), new PuenteGoalTest());
            int limitDepth = 6;
            SearchForActions search = new DepthLimitedSearch(limitDepth);
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void PuenteUniformCostGraphDemo() {
        System.out.println("\nPuenteDemo uniform cost graph -->");
        try {
            Problem problem = new Problem(boardInicial, PuenteFunctionFactory.getActionsFunction(), PuenteFunctionFactory.getResultFunction(), new PuenteGoalTest());
            SearchForActions search = new UniformCostSearch(new GraphSearch());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void puenteHeuristicCostDemo() {
        System.out.println("\nPuente Heuristic graph -->");
        try {
            Problem problem = new Problem(boardInicial, PuenteFunctionFactory.getActionsFunction(), PuenteFunctionFactory.getResultFunction(), new PuenteGoalTest());
            SearchForActions search = new AStarSearch(new GraphSearch(), new PuenteHeuristicFunction());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printInstrumentation(Properties properties) {
        Iterator<Object> keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List<Action> actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i).toString();
            System.out.println(action);
        }
    }
}
