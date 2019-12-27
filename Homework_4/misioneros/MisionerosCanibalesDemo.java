package aima.gui.demo.search;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.environment.misioneros.*;
import aima.core.search.framework.*;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;

public class MisionerosCanibalesDemo {

    static MisionerosBoard boardInicial = new MisionerosBoard(
            new int[]{3, 3, 1});

    public static void main(String[] args) {
        mcBreadthDemo();
        mcDepthGraphDemo();
    }

    private static void mcBreadthDemo() {
        System.out.println("\nMisionerosCanibalesDemo breadth -->");
        try {
            Problem problem = new Problem(boardInicial, MisionerosFunctionFactory.getActionsFunction(), MisionerosFunctionFactory.getResultFunction(), new MisionerosGoalTest());
            Search search = new BreadthFirstSearch();
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
            Search search = new DepthFirstSearch(new GraphSearch());
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