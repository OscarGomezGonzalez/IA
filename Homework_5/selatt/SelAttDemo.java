/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.selatt;

import aima.core.search.framework.problem.GoalTest;
import aima.core.search.local.FitnessFunction;
import aima.core.search.local.GeneticAlgorithm;
import aima.core.search.local.Individual;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geral
 */
public class SelAttDemo {

    private static final int boardSize = 9;

    public static void main(String[] args) {

        selAttDemo();
    }

    private static void selAttDemo() {

        selAttGeneticAlgorithmSearch();
    }

    public static void selAttGeneticAlgorithmSearch() {
        System.out.println("\nSelAttDemo GeneticAlgorithm  -->");
        try {
            FitnessFunction<Integer> fitnessFunction = SelAttGenAlgoUtil.getFitnessFunction();
            GoalTest goalTest = SelAttGenAlgoUtil.getGoalTest();
            // Generate an initial population
            Set<Individual<Integer>> population = new HashSet<Individual<Integer>>();
            
            for (int i = 0; i < 50; i++) {
                population.add(SelAttGenAlgoUtil.generateRandomIndividual(boardSize));
            }

            GeneticAlgorithmSelAtt<Integer> ga = new GeneticAlgorithmSelAtt<Integer>(boardSize,
                    SelAttGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), 0.15);

            // Run for a set amount of time
            Individual<Integer> bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, goalTest, 1000L);

            System.out.println("Max Time (1 second) Best Individual=\n"
                    + SelAttGenAlgoUtil.getBoardForIndividual(bestIndividual));
            System.out.println("Board Size      = " + boardSize);
            System.out.println("# Board Layouts = " + (new BigDecimal(boardSize)).pow(boardSize));
            System.out.println("Fitness         = " + fitnessFunction.apply(bestIndividual));
            System.out.println("Is Goal         = " + goalTest.isGoalState(bestIndividual));
            System.out.println("Population Size = " + ga.getPopulationSize());
            System.out.println("Itertions       = " + ga.getIterations());
            System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
