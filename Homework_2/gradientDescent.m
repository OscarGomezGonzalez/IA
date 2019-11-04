function [theta, J_history] = gradientDescent(X, y, theta, alpha, iterations)
  
  m = length(y);
  J_history = zeros(iterations,1);
  
  for iter = 1:iterations
    
    theta = theta - alpha * (1/m) * (X' * (X*theta-y));
    J_history(iter) = costFunction(X, y, theta);
    
    fprintf('Funcion descenso del gradiente para iteraciones=%d y alfa=%d', iterations, alpha);
    % el problema 2 nos pide imprimir las diez primeras iteraciones
    fprintf('Theta at iteration %d:\t%.6f\t%.6f\t%.6f\n', iter,theta(1,1),theta(2,1),theta(3,1));
    
  endfor
  
endfunction