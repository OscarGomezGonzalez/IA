function [J grad] = nnCostFunction(nn_params, input_layer_size, hidden_layer_size, num_labels, X, y, lambda)
  
  % volvemos a "enrollar" las thetas en matrices para poder calcular el coste
  % el theta uno sera desde 1 hasta 25(hidden_layer) hasta input + 1(bias)
  theta1 = reshape(nn_params(1:(hidden_layer_size * (input_layer_size + 1))), ...
                hidden_layer_size, (input_layer_size+1));
                
  theta2 = reshape(nn_params((1+hidden_layer_size * (input_layer_size+1)):end), ...
                 num_labels, (hidden_layer_size+1));
     
  suma = 0;     
  m = size(X,1);  
% inicializamos una matriz de ceros, delta1 calculara la modificacion
  DELTA1 = zeros(size(theta1));
  DELTA2 = zeros(size(theta2));
  
  for i=1:m
    
    [a1 a2 a3] = fordward(theta1, theta2, X,i);
    %devuelve vector de 0 menos la posicion de i
    aux = (1:num_labels == y(i));
    h = a3;
    suma = suma + aux * log(h) + (1-aux) * log(1-h);
     
    delta3 = a3 - aux';
    delta2 = (theta2' * delta3) .* ((1-a2) .* a2);
    delta2 = delta2(2:end);
    
    DELTA1 = DELTA1 + delta2 * a1';
    DELTA2 = DELTA2 + delta3 * a2';
    
  endfor
     
  J = (-1/m) * suma;     
  % con delta1 y delta2 calculados obtenemos el gradiente
  DELTA1 = (1/m) * DELTA1;
  DELTA2 = (1/m) * DELTA2;
  % ahora tenemos que considerar que los vectores fueron reshaped
  % por lo que ahora debemos volverlos a su estado original en una sola fila
  grad = [DELTA1(:); DELTA2(:)];
  
endfunction
