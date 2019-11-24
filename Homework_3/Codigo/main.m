%% EPD 8: Machine Learning  Redes Neuronales

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

% Apartado 2

% declaracion de las Thetas con pesos iniciales en el enunciado
initial_Theta1 = [-0.0893, -0.0789, 0.0147
          0.1198, -0.1122, 0.0916];
initial_Theta2 = [0.0406, -0.0743, -0.0315];

% Unroll parameters 
initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:)];

fprintf('\nFeedforward Using Neural Network ...\n')

% Weight regularization parameter (we set this to 0 here).
lambda = 0;

[J grad] = nnCostFunction(initial_nn_params, input_layer_size, hidden_layer_size, ...
                   num_labels, X, y, lambda);

% imprime el coste inicial
fprintf(['Cost: %f '...
         '\n(this value should be about 0.6932)\n'], J);
         
% imprime el gradiente
fprintf('Grad: ');
grad

% descenso del gradiente
options = optimset('GradObj', 'on','MaxIter', 1000);
nn_params = fminunc(@(t)(nnCostFunction(t,input_layer_size,hidden_layer_size,num_labels,X,y)), initial_nn_params, options);

%Reshape thetas
Theta1 =  reshape(nn_params(1:hidden_layer_size * (input_layer_size +1)),
  hidden_layer_size,(input_layer_size +1));;
Theta2 = reshape(nn_params(((hidden_layer_size * (input_layer_size +1)) +1):
  end),num_labels,(hidden_layer_size +1));

printf("Thetas tras la optimizacion.\n");
Theta1
printf("\n");
Theta2
printf("\n");

% Para terminar el Apartado 2 imprimimos la grafica con la frontera de decision
plot_decision_boundary(Theta1,Theta2, X, y)

fprintf('\nProgram paused. Press enter to continue.\n');
pause;

fprintf('\nChecking Backpropagation... \n');

%  Check gradients by running checkNNGradients
checkNNGradients;

fprintf('\nProgram paused. Press enter to continue.\n');
pause;

fprintf('\nInitializing Neural Network Parameters ...\n')

% se crean los thetas inicializados
initial_Theta1 = randInitializeWeights(input_layer_size, hidden_layer_size);
initial_Theta2 = randInitializeWeights(hidden_layer_size, num_labels);




%% =================== EJ4. Training NN ===================
%  You have now implemented all the code necessary to train a neural 
%  network. To train your neural network, we will now use "fmincg", which
%  is a function which works similarly to "fminunc". Recall that these
%  advanced optimizers are able to train our cost functions efficiently as
%  long as we provide them with the gradient computations.
%
fprintf('\nTraining Neural Network... \n')

% Obtain Theta1 and Theta2 back from nn_params
% opciones de la funcion
options = optimset('MaxIter', 50);

% prepara la funcion
costFunction = @(p) nnCostFunction(p, input_layer_size, hidden_layer_size, ...
                                    num_labels, X, y, lambda);
% llamada a la funcion
[nn_params, cost] = fmincg(costFunction, initial_nn_params, options);

% volvemos a enrrollar las thetas en matrices
theta1 = reshape(nn_params(1:(hidden_layer_size * (input_layer_size + 1))), ...
                hidden_layer_size, (input_layer_size+1));
                
theta2 = reshape(nn_params((1+hidden_layer_size * (input_layer_size+1)):end), ...
                 num_labels, (hidden_layer_size+1));

fprintf('Program paused. Press enter to continue.\n');
pause;


%% ================= EJ5. Implement Predict =================
%  After training the neural network, we would like to use it to predict
%  the labels. You will now implement the "predict" function to use the
%  neural network to predict the labels of the training set. This lets
%  you compute the training set accuracy.
pred = predict(theta1, theta2, X);

fprintf('Exactitud: %f\n', mean(p == y)*100);



