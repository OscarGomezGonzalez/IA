function h = sigmoid(z)
   
   h = zeros(size(z));
  % funcion de activacion
   h = 1 ./ (1+(exp(-z)));
  
endfunction
