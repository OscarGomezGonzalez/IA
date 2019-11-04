function [cost, grad] = costFunction(X, y, theta)
  
    m = length(y);
    
    % calcula el sigmoide
    h = sigmoid(X*theta);
    % calcula el coste
    cost = (-1/m)*sum(y.*log(h) + (1-y).*log(1-h));
    % calcula el gradiente en el coste
    grad = (1/m)*(X'*(h-y));
  
endfunction
