function graficaConvergencia(J_history,iterations)
  
  plot(J_history,iterations,'rx');
  ylabel('Cost');
  xlabel('Number of iterations');
  
endfunction
