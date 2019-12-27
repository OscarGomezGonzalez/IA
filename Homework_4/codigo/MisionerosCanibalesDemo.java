package aima.gui.demo.search;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.environment.farolillo.*;
import aima.core.search.framework.*;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.UniformCostSearch;

public class MisionerosCanibalesDemo {

    static FarolilloBoard boardInicial = new FarolilloBoard(
            new int[]{1, 1, 1, 1, 1, 0});

    public static void main(String[] args) {
        mcBreadthDemo();
        mcDepthGraphDemo();
        mcDepthLimitedGraphDemo();
        mcUniformCostGraphDemo();
    }

    private static void mcBreadthDemo() {
        System.out.println("\nMisionerosCanibalesDemo breadth -->");
        try {
            Problem problem = new Problem(boardInicial, MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest());
            SearchForActions search = new BreadthFirstSearch();
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mcDepthGraphDemo() {
        System.out.println("\nMisionerosCanibalesDemo depth graph -->");
        try {
            Problem problem = new Problem(boardInicial, MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest());
            SearchForActions search = new DepthFirstSearch(new GraphSearch());
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void mcDepthLimitedGraphDemo() {
        System.out.println("\nFarolilloDemo depth limited graph -->");
        try {
            Problem problem = new Problem(boardInicial, MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest());
            int limitDepth = 6;
            SearchForActions search = new DepthLimitedSearch(limitDepth);
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void mcUniformCostGraphDemo() {
        System.out.println("\nFarolilloDemo uniform cost graph -->");
        try {
            Problem problem = new Problem(boardInicial, MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest());
            SearchForActions search = new UniformCostSearch(new GraphSearch());
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
