%% Initialization
%% clear ; close all; clc

%% ======================= HOMEWORK 1 =======================

fprintf('Loading Data ...\n')
data = load('autos.csv');

%% Apartado 1
t_estadisticas = estadisticas(data);

%% Apartado 2
% X matriz de entrada de datos y datos a predecir
% seleccionamos todo el conjunto
X = data(:,1:7);
y = data(:,8);

% dividimos aleatoriamente en dos conjuntos de entrenamiento del 70% y el 30%
m = length(y); % calcula la longitud de y
% el enunciado indica un porcentaje del 70% para el entrenamiento
% el resto sera test
percent = 0.7;

% aplicamos la funcion holdout para separar los conjuntos
[X_train y_train X_test y_test] = holdout(X,y,m,percent);

% calculamos el num de elementos de y para calcular el error por cada theta
m = length(y_test);

%---------------------------------------
% seleccion de los subconjuntos
% primero subconjunto del desplazamiento
X_sub = X_train(:,2);

% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,2);

% aplica la regresion con la ec.normal 
theta_des = normalEqn(X_sub, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_aux * theta_des;

% calcula error
error_des = errorCalculation(m, pre, y_test); 


%---------------------------------------
% subconjunto del peso
X_sub = X_train(:,4);
% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,4);

% aplica la regresion con la ec.normal 
theta_peso = normalEqn(X_sub, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_aux * theta_peso;

% calcula error
error_peso = errorCalculation(m, pre, y_test); 


%---------------------------------------
% subconjunto de la aceleracion
X_sub = X_train(:,5);

% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,5);

% aplica la regresion con la ec.normal 
theta_aceleracion = normalEqn(X_sub, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_aux * theta_aceleracion;

% calcula error
error_aceleracion = errorCalculation(m, pre, y_test); 


%---------------------------------------
% calculo del conjunto total de datos
% aplica la regresion con la ec.normal 
theta_total = normalEqn(X_train, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test * theta_total;

% calcula error
error_total = errorCalculation(m, pre, y_test); 

%---------------------------------------
% Impresion de resultados
fprintf('Valores de Theta:...\n')
fprintf('Theta desplazamiento: %d, Error desplazamiento %d\n', theta_des, error_des)
fprintf('Theta peso: %d, Error peso %d\n', theta_peso, error_peso)
fprintf('Theta aceleracion: %d, Error aceleracion %d\n', theta_aceleracion, error_aceleracion)

% Impresion de resultados totales
fprintf('Theta total: \n')
theta_total
fprintf('Error total: %d\n', error_total)


%% ======================= 4 =======================

%------------desplazamiento----------




