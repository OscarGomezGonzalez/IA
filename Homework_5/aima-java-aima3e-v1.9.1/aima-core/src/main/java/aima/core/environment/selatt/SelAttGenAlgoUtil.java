/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.selatt;

import aima.core.search.local.FitnessFunction;
import aima.core.search.local.Individual;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 *
 * @author geral
 */
public class SelAttGenAlgoUtil {

    public static FitnessFunction<Integer> getFitnessFunction() {
        return new SelAttFitnessFunction();
    }

    public static Individual<Integer> generateRandomIndividual(int boardSize) {
        List<Integer> individualRepresentation = new ArrayList<Integer>();
        for (int i = 0; i < boardSize; i++) {
            individualRepresentation.add(new Random().nextInt(1));
        }
        Individual<Integer> individual = new Individual<Integer>(individualRepresentation);
        return individual;
    }

    public static Collection<Integer> getFiniteAlphabetForBoardOfSize(int size) {
        Collection<Integer> fab = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            fab.add(i);
        }

        return fab;
    }

    public static class SelAttFitnessFunction implements FitnessFunction<Integer> {

        public double apply(Individual<Integer> individual) {
            double fitness = 0;

            SelAttBoard board = getBoardForIndividual(individual);
            int[] boardState = board.getState();
            int[] selectedAtt = {};
            int aux = 0;

            /*
             search attributes that are 1
             */
            for (int i = 0; i < boardState.length; i++) {

                if (boardState[i] == 1) {
                    selectedAtt[aux] = i;
                    aux++;
                }
            }

            int medAtt = 0;
            int medClass = 0;
            int numCorr = 0;
            int numCorrClass = 0;

            for (int i = 0; i < selectedAtt.length; i++) {

                medClass += board.getCorrelationClass(selectedAtt[i]);
                numCorrClass++;

                if (i < selectedAtt.length - 1) {

                    for (int j = i + 1; j < selectedAtt.length; j++) {

                        medAtt += board.getCorrelationAtt(selectedAtt[i], selectedAtt[j]);
                        numCorr++;
                    }
                }
            }

            // calculamos la media
            medAtt = medAtt / numCorr;
            medClass = medClass / numCorrClass;
            int numAtt = selectedAtt.length;

            fitness = (numAtt * medClass) / Math.sqrt(numAtt + numAtt * (numAtt - 1) * medAtt);

            return fitness;
        }
    }

    public static SelAttBoard getBoardForIndividual(Individual<Integer> individual) {
        int boardSize = individual.length();
        int newState[] = {};
        for (int i = 0; i < boardSize; i++) {
            int pos = individual.getRepresentation().get(i);
            newState[i] = pos;
        }

        SelAttBoard board = new SelAttBoard(newState);

        return board;
    }

}
