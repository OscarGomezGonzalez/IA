%% Initialization
 clear ; close all; clc

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

%a�ade columna de ceros a conjunto de X
X_subDes = [ones(size(X_sub, 1), 1) X_sub];

% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,2);

%a�ade columna de ceros a conjunto de X
X_test_Des = [ones(size(X_test_aux, 1), 1) X_test_aux];

% aplica la regresion con la ec.normal 
theta_des = normalEqn(X_subDes, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_Des * theta_des;

% calcula error
error_des = errorCalculation(m, pre, y_test); 


%---------------------------------------
% subconjunto del peso
X_sub = X_train(:,4);

%a�ade columna de ceros a conjunto de X
X_subPes = [ones(size(X_sub, 1), 1) X_sub];

% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,4);

%a�ade columna de ceros a conjunto de X
X_test_Pes = [ones(size(X_test_aux, 1), 1) X_test_aux];

% aplica la regresion con la ec.normal 
theta_peso = normalEqn(X_subPes, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_Pes * theta_peso;

% calcula error
error_peso = errorCalculation(m, pre, y_test); 


%---------------------------------------
% subconjunto de la aceleracion
X_sub = X_train(:,5);

%a�ade columna de ceros a conjunto de X
X_subAce = [ones(size(X_sub, 1), 1) X_sub];

% selecciona el subconjunto de entrenamiento
X_test_aux = X_test(:,5);

%a�ade columna de ceros a conjunto de X
X_test_Ace = [ones(size(X_test_aux, 1), 1) X_test_aux];

% aplica la regresion con la ec.normal 
theta_aceleracion = normalEqn(X_subAce, y_train);

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test_Ace * theta_aceleracion;

% calcula error
error_aceleracion = errorCalculation(m, pre, y_test); 


%---------------------------------------
% calculo del conjunto total de datos

%a�ade columna de ceros a conjunto de X
X_train = [ones(size(X_train, 1), 1) X_train];

% aplica la regresion con la ec.normal 
theta_total = normalEqn(X_train, y_train);

%a�ade columna de ceros a conjunto de X
X_test = [ones(size(X_test , 1), 1) X_test];

% Predecir el conjunto de test X_test usando el modelo obtenido theta
pre = X_test * theta_total;

% calcula error
error_total = errorCalculation(m, pre, y_test); 

%---------------------------------------
% Impresion de resultados
fprintf('Valores de Theta:...\n')
fprintf('Theta desplazamiento: [%d,%d], Error desplazamiento %d\n', theta_des(1,1),theta_des(2,1), error_des)
fprintf('Theta peso: [%d,%d], Error peso %d\n', theta_peso(1,1), theta_peso(2,1), error_peso)
fprintf('Theta aceleracion: [%d,%d], Error aceleracion %d\n', theta_aceleracion(1,1), theta_aceleracion(2,1), error_aceleracion)

% Impresion de resultados totales
fprintf('Theta total: \n')
theta_total
fprintf('Error total: %d\n', error_total)

%% -----------------Apartado 3-------------------
% imprimir graficas con los modelos y estadisticas
visualizarDatos(theta_des,theta_peso,theta_aceleracion,data);


%% ======================= 4 =======================
% valores de iteraciones y alpha
iterationsDes=5000;
iterationsPes=30000;
iterationsAce=30000;
iterationsTotal=30000;
alphaDes=0.00001;
alphaPes=0.0000001;
alphaAce=0.00001;
alphaTotal=0.0000001;

%---------------------------------------
%desplazamiento
%inicializa la teta a 0
theta_ones = zeros(size(X_subDes , 2),1);
% calcula el historial de costes
J_historyDes = gradientDescent(X_subDes, y_train, theta_ones, alphaDes, iterationsDes, X_test_Des, y_test);

%---------------------------------------
%peso
%inicializa la teta a 0
theta_ones = zeros(size(X_subPes , 2),1);
% calcula el historial de costes
J_historyPes = gradientDescent(X_subPes, y_train, theta_ones, alphaPes, iterationsPes, X_test_Pes, y_test);

%---------------------------------------
%aceleracion
%inicializa la teta a 0
theta_ones = zeros(size(X_subAce , 2),1);
% calcula el historial de costes
J_historyAce = gradientDescent(X_subAce, y_train, theta_ones, alphaAce, iterationsAce, X_test_Ace, y_test);

%---------------------------------------
%conjunto completo
%inicializa la teta a 0
theta_ones = zeros(size(X_train , 2),1);
% calcula el historial de costes
J_history = gradientDescent(X_train, y_train, theta_ones, alphaTotal, iterationsTotal, X_test, y_test);

%datos de l tabla
fprintf('\t Con atributo 2 \t Con atributo 4 \t Con atributo 5 \t Conjunto completo \n')
fprintf('\n Error Ecuaci�n normal \t %d \t %d \t %d \t %d \n',error_des,error_peso,error_aceleracion,error_total)
fprintf('\n Error Gradiente \t %d \t %d \t %d \t %d',J_historyDes(iterationsDes),J_historyPes(iterationsPes),J_historyAce(iterationsAce),J_history(iterationsTotal))
%fprintf(' %d \n',J_history(iterationsTotal))
fprintf('\n Alpha \t %d \t %d \t %d \t %d \n',alphaDes,alphaPes,alphaAce,alphaTotal)
fprintf('\n N� de iteraciones \t %d \t %d \t %d \t %d \n',iterationsDes,iterationsPes,iterationsAce,iterationsTotal)

%%%%% pintamos la grafica de convergencia
graficaConvergencia(J_history);



