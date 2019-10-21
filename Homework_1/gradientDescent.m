function  J_history  = gradientDescent(X, y, theta, alpha, iterations, X_test, y_test)
  
% calcula tamaño de y
m = length(y);
% calcula tamaño del conjuto de test de y
m_test=length(y_test);
% por cada iteracion calcula theta y la prediccion
J_history = zeros(iterations,1);
  for iter = 1:iterations
    % calculo de theta
    theta = theta - alpha * (1/m) * (X' * (X*theta-y));
    % calculo de la prediccion
    pre = X_test * theta;
    % por cada iteracion calcula el error con esa prediccion y la theta
    J_history(iter)=errorCalculation(m_test, pre, y_test);
  endfor
  
endfunction