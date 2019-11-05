function [cost, grad] = costFunctionR(X, m, n, theta)
  
 
  % calcula el sigmoide
  h = sigmoid(X*theta);
  % calcula el coste
  cost = (-1 / m) * sum(y.*log(h) + (1-y).* log(1-h)) + (lambda/(2*m)) * sum(theta(2:n).^2);
  % calcula el gradiente en el coste
  grad = (1/m)*X'*(h-y) + (lambda/m)*[0;theta(2:n)];
  
endfunction
