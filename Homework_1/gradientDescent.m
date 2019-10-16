function theta = gradientDescent(X, y, theta, alpha, iterations)
  
m = length(y);
  for iter = 1:iterations
    theta = theta - alpha * (1/m) * (X' * (X*theta-y));
  endfor
  
endfunction
