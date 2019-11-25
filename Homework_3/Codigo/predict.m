function p = predict(theta1, theta2, X)
  
  m = size(X, 1);

  p = zeros(size(X, 1), 1);
  
  h1 = sigmoid([ones(m,1) X] * theta1');
  h2 = sigmoid([ones(m,1) h1] * theta2');
  
  p = round(h2);
  
endfunction
