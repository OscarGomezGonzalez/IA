function error = errorCalculation(m, pre, y_test)
  
  error = (1/m) * sum(abs(pre-y_test));
  
endfunction
