function W = randInitializeWeights(L_in, L_out)
  
  W = zeros(L_out, L_in + 1);
  epsilon = 0.12;
  
  W = rand(L_out, L_in + 1) * 2 * epsilon;
  
endfunction
