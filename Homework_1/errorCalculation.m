function error = errorCalculation(m, pre, y_test)
  
  % calculo del error absoluto medio
  error = (1/m) * sum(abs(pre-y_test));
  
endfunction