%% HOMERWORK 3 Redes Neuronales

%% Initialization
clear ; close all; clc

%% Apartado 1
fprintf('Loading Data ...\n')
data = load('data_15.txt');
X = data(:,1:2);
y = data(:,3);

%% imprime el conjunto de datos
plotData(X, y);

%% Setup the parameters you will use for this exercise
input_layer_size  = 2;  % tenemos una por cada atributo
hidden_layer_size = 2;   % 
num_labels = 1;          %  tenemos dos clases
                          
% tamaño de X
m = size(X, 1);

##% Apartado 2
##
##% declaracion de las Thetas con pesos iniciales en el enunciado
##initial_Theta1 = [-0.0893, -0.0789, 0.0147;
##                  0.1198, -0.1122, 0.0916];
##initial_Theta2 = [0.0406, -0.0743, -0.0315];
##
##% Unroll parameters 
##%initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:)];
##
##fprintf('\nFeedforward Using Neural Network ...\n')
##
##%[J grad] = nnCostFunction(initial_nn_params, input_layer_size, hidden_layer_size, ...
##%                   num_labels, X, y, lambda);
##
##% imprime el coste inicial
##fprintf(['Cost: %f '...
##         '\n(El valor del coste deberia ser: 0.6932)\n'], J);
##         
##% imprime el gradiente
##fprintf('Grad: ');
##grad
##
##% descenso del gradiente
##options = optimset('GradObj', 'on','MaxIter', 100);
##%nn_params = fminunc(@(t)(nnCostFunction(t,input_layer_size,hidden_layer_size,num_labels,X,y)), initial_nn_params, options);
##
##%Reshape thetas
##%Theta1 =  reshape(nn_params(1:hidden_layer_size * (input_layer_size +1)),
##%  hidden_layer_size,(input_layer_size +1));;
##%Theta2 = reshape(nn_params(((hidden_layer_size * (input_layer_size +1)) +1):
##%  end),num_labels,(hidden_layer_size +1));
##
##printf("Thetas tras el descenso.\n");
##Theta1
##printf("\n");
##Theta2
##printf("\n");
##
##% Para terminar el Apartado 2 imprimimos la grafica con la frontera de decision
##%plot_decision_boundary(Theta1,Theta2, X, y, 'Resultado para 2 neuronas en la capa oculta Apartado 2')
##
##fprintf('\nProgram paused. Press enter to continue.\n');
##pause;
##
##fprintf('\nChecking Backpropagation... \n');
##
##%  Check gradients by running checkNNGradients
##checkNNGradients;
##
##fprintf('\nProgram paused. Press enter to continue.\n');
##pause;

% Apartado 3
%% experimentamos con diferentes numero de neuronas en la capa oculta

%Guardamos en un array los tamaños de la capa a probar para iterar sobre ellos
##hidden_layer_sizes= [1,2,3,4,5,20,50];
##
##printf("Thetas tras la optimizacion.\n");
##
##% bucle que imprime que imprime las predicciones para cada prueba de num de neuronas
##for i=1:length(hidden_layer_sizes)
##  printf("Comienzo de la iteracion\n");
##  
##  % Obtenemos el tamaño de la iteracion actual
##  hidden_layer_size=hidden_layer_sizes(i);
##
##  %Generamos las thetas aleatoriamente
##  initial_Theta1 = randInitializeWeights(input_layer_size,hidden_layer_size);
##  initial_Theta2 = randInitializeWeights(hidden_layer_size,num_labels);
##  
##  % Unroll parameters
##  initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:)];
##
##  %Descenso del gradiente
##  options = optimset('GradObj', 'on','MaxIter', 100);
##  nn_params = fminunc(@(t)(nnCostFunction(t,input_layer_size,hidden_layer_size,num_labels,X,y)), initial_nn_params, options);
##
##  %Reshape Thetas
##  Theta1 =  reshape(nn_params(1:hidden_layer_size * (input_layer_size +1)),
##   hidden_layer_size,(input_layer_size +1));;
##  Theta2 = reshape(nn_params(((hidden_layer_size * (input_layer_size +1)) +1):
##   end),num_labels,(hidden_layer_size +1));
##
##  printf("Thetas tras la optimizacion para %d neuronas.\n", hidden_layer_size);
##  Theta1
##  printf("\n");
##  Theta2
##  printf("\n");
##
##  
##  %Imprime los resultados
##  plot_decision_boundary(Theta1, Theta2, X, y);
##
##
##  pred = predict(Theta1, Theta2, X);
##
##  fprintf('Exactitud con %d neuronas: %f\n', hidden_layer_size, mean(pred == y)*100);
##  
##  printf("Fin de la iteracion\n");
##endfor

%% Apartado 4

%% Setup the parameters you will use for this exercise
input_layer_size  = 2;  % tenemos una por cada atributo
hidden_layer_size = 10;   % nos piden 10 neuronas en la capa oculta
num_labels = 1;          %  tenemos dos clases
                 
% tamaño de X
m = size(X, 1);

% todos los valores de lambda a probar
lambdas= [0.01,0.03,0.1,0.3,1,3];


% bucle que imprime que imprime las predicciones para cada prueba con lamda distinta
%for i=1:length(lambdas)

%Generamos las thetas aleatoriamente
initial_Theta1 = randInitializeWeights(input_layer_size,hidden_layer_size);
initial_Theta2 = randInitializeWeights(hidden_layer_size,num_labels);

% Unroll parameters 
initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:)];

fprintf('\nFeedforward Using Neural Network ...\n')

% Weight regularization parameter (we set this to 0 here).
lambda = lambdas(1);

[J grad] = nnCostFunctionReg(initial_nn_params, input_layer_size, hidden_layer_size, ...
                   num_labels, X, y, lambda);

% imprime el coste inicial
fprintf(['Cost: %f \n'], J);
         
% imprime el gradiente
fprintf('Grad: ');
grad

% descenso del gradiente
options = optimset('GradObj', 'on','MaxIter', 1000);
nn_params = fminunc(@(t)(nnCostFunctionReg(t,input_layer_size,hidden_layer_size,num_labels,X,y, lambda)), initial_nn_params, options);

%Reshape thetas
Theta1 =  reshape(nn_params(1:hidden_layer_size * (input_layer_size +1)),
  hidden_layer_size,(input_layer_size +1));;
Theta2 = reshape(nn_params(((hidden_layer_size * (input_layer_size +1)) +1):
  end),num_labels,(hidden_layer_size +1));

printf("Thetas tras el descenso.\n");
Theta1
printf("\n");
Theta2
printf("\n");

%titulo de la iteracion
titulo = "APARTADO 4 Resultado con 10 neuronas y lambda:";
strcat(titulo, int2str(lambda));

% Imprimimos frontera de decision
plot_decision_boundary(Theta1,Theta2, X, y, titulo)

pred = predict(Theta1, Theta2, X);

fprintf('Exactitud con %d neuronas: %f\n', hidden_layer_size, mean(pred == y)*100);

%endfor