function  [theta,J_history]  = gradientDescent(X, y, theta, alpha, iterations)
  
m = length(y);
J_history = zeros(iterations,1);
  for iter = 1:iterations
    theta = theta - alpha * (1/m) * (X' * (X*theta-y));
     J_history(iter) = computeCost(X, y, theta);
  endfor
  
endfunction
