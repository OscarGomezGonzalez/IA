function [theta, J_history] = gradientDescentR(X, y, theta, alpha, iterations)
  
  %inicializamos lamda a 1
  lambda = 1;
  %m sera el tamaño de la X
  m = length(X);
  %n sera el tamañao de la theta
  n = length(theta);
  %inicializamos el historial a 0
  J_history = zeros(iterations,1);
 
  
  for iter = 1:iterations
    
    h = sigmoid(X*theta);
    % theta se calcula con regularizacion multiplicando por la formula del gradiente del coste
    theta = theta - alpha * (1/m)*X'*(h-y) + (lambda/m)*[0;theta(2:n)];
    % obtenemos el historial de coste
    J_history(iter) = costFunctionR(X, y, m, n, theta, lambda);
    
    
  endfor
  
endfunction
