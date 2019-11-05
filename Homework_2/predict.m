function p = predict(theta, X)
  
  p = round(sigmoid(theta*X));
  
endfunction