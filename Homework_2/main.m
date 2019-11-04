%% Initialization
 clear ; close all; clc

%% ======================= HOMEWORK 2 =======================
%% Apartado 1
fprintf('Loading Data ...\n')
data = load('data_flower.txt');
X = data(:,1:2);
y = data(:,3);

%plotData(X, y);

% cojemos las dimensiones de las matrices de datos
[m, n] = size(X);

% añadimos la columna de unos a X
X = [ones(m, 1) X];

% inicilizamos la theta con valores a cero
initial_theta = zeros(n+1, 1);

% calculamos el coste inicial
[initial_cost, grad] = costFunction(X, y, initial_theta);

% imprimimos el gradiente y coste inicial
fprintf('Function de coste:\n');
fprintf('Cost at initial theta(zeros): %f\n', initial_cost);
fprintf('Gradient at initial theta (zeros): %f\n', grad);

%inicializamos valores
alpha = 1;
iterations = 10;

%% Apartado 2
% calculamos el descenso del gradiente
% dentro del descenso del gradiente imprimos los diez primeros valores de thetas
[theta,J_history] = gradientDescent(X, y, initial_theta, alpha, iterations);

%gráfica de convergencia de descenso del gradiente
%graficaConvergencia(J_history);

%imprimir la tasa de acierto y la grafica con la frontera de decisión
%plotDecisionBoundary(theta, X, y);


%% Apartado 3
%alfa, número de iteraciones y tasa de acierto

%crear mas atributos atraves de mapFeature
mapFeature(); %devuelve una matriz de 28 atributos

%necesitamos que el gradiente converja
%gráfica de convergencia de descenso del gradiente

%necesitamos que la tasa de acierto sea mayor o igual que 82%
%imprimir la tasa de acierto y la grafica con la frontera de decisión
%plotDecisionBoundary();





