function J = nnCostFunctionSinRegSinGrad(nn_params, input_layer_size, hidden_layer_size, num_labels, X, y, lambda)
  
  % volvemos a "enrollar" las thetas en matrices para poder calcular el coste
  % el theta uno sera desde 1 hasta 25(hidden_layer) hasta input + 1(bias)
  theta1 = reshape(nn_params(1:(hidden_layer_size * (input_layer_size + 1))), ...
                hidden_layer_size, (input_layer_size+1));
                
  theta2 = reshape(nn_params((1+hidden_layer_size * (input_layer_size+1)):end), ...
                 num_labels, (hidden_layer_size+1));
            
   m = size(X,1);     
   for i=1:m
     [a1 a2 a3] = forward(theta1, theta2, X,i);
   endfor
                      
  
endfunction
