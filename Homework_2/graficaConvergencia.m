function graficaConvergencia(J_history)
  
  figure
  plot(1:length(J_history),J_history, '-b', 'LineWidth',2);
  hold on;
  ylabel('Cost');
  xlabel('Number of iterations');
  hold off;
  
endfunction
