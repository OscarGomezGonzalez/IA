function graficaConvergencia(J_history,iterations)
  
  plot(J_history,iterations,'-b');
  ylabel('Cost');
  xlabel('Number of iterations');
  
endfunction
