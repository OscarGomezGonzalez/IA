package aima.core.environment.puente;

import static aima.core.environment.puente.PuenteBoard.*;
import aima.core.search.framework.evalfunc.HeuristicFunction;

public class PuenteHeuristicFunction implements HeuristicFunction {

    public double h(Object state) {
        PuenteBoard board = (PuenteBoard) state;
        return getNodesLeft(board);
    }

    private int getNodesLeft(PuenteBoard board) {
        //calculamos num personas
        int [] state = board.getState();
        int j = 0;
        
        for(int i = 0 ; i < state.length -2;i++){
           if(state[i]==1){
               j++;
           } 
        }
        
        return j;
    }
}
