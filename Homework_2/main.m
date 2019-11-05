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
alpha = 0.6;
iterations = 10;

%% Apartado 2
% calculamos el descenso del gradiente
% dentro del descenso del gradiente imprimos los diez primeros valores de thetas
[theta,J_history] = gradientDescent(X, y, initial_theta, alpha, iterations);

%gráfica de convergencia de descenso del gradiente
graficaConvergencia(J_history);

%imprimir la tasa de acierto y la grafica con la frontera de decisión
plotDecisionBoundary(theta, X, y);


%% Apartado 3
%alfa, número de iteraciones y tasa de acierto
alpha = 0.000000002;
iterations = 900;

% separamos el conjunto en dos subconjuntos de cada columna del conjunto de datos original
% primer conjunto
X1 = data(:,1);
% segundo conjunto
X2 = data(:,2);

%crear mas atributos atraves de mapFeature
% obtenemos el conjunto nuevo
X3 = mapFeature(X1, X2); %devuelve una matriz de 28 atributos
%X3 es la X mapeada

% inicializamos la theta
[m,n] = size(X3);
initial_theta = zeros(n, 1);

%aplicar el descenso del gradiente regularizado
[theta, J_history] = gradientDescentR(X3, y, initial_theta, alpha, iterations);

%necesitamos que el gradiente converja
%gráfica de convergencia de descenso del gradiente
graficaConvergencia(J_history);

%necesitamos que la tasa de acierto sea mayor o igual que 82%
%imprimir la tasa de acierto y la grafica con la frontera de decisión
%prediccion
p = predict(theta',X3');
%tasa de acierto del modelo
percent = mean((p==y))*100;

%imprimimos tasa de acierto con el alfa y el num de iteraciones
fprintf('----- Resultados Ej3 -----\n');
fprintf('Valor de alfa:%f\n', alpha);
fprintf('Valor del numero de iteraciones: %d\n', iterations);
fprintf('La tasa de acierto: %d\n', percent);

%frontera de decision
plotDecisionBoundary(theta, X3, y);





