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
hidden_layer_size = 6;   % 25 hidden units
num_labels = 2;          %  tenemos una etiqueta por cada clase
                          
% tamaño de X
m = size(X, 1);

% declaracion de las Thetas
Theta1 =  randInitializeWeights(input_layer_size, hidden_layer_size);
Theta2 =  randInitializeWeights(hidden_layer_size, num_labels);

% Unroll parameters 
nn_params = [Theta1(:) ; Theta2(:)];

fprintf('\nFeedforward Using Neural Network ...\n')

% Weight regularization parameter (we set this to 0 here).
lambda = 0;

[J grad] = nnCostFunction(nn_params, input_layer_size, hidden_layer_size, ...
                   num_labels, X, y, lambda);

fprintf(['Cost at parameters (loaded from ex4weights): %f '...
         '\n(this value should be about 0.287629)\n'], J);

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

% Unroll parameters
initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:)];


%% =================== EJ4. Training NN ===================
%  You have now implemented all the code necessary to train a neural 
%  network. To train your neural network, we will now use "fmincg", which
%  is a function which works similarly to "fminunc". Recall that these
%  advanced optimizers are able to train our cost functions efficiently as
%  long as we provide them with the gradient computations.
%
fprintf('\nTraining Neural Network... \n')

%  After you have completed the assignment, change the MaxIter to a larger
%  value to see how more training helps.



% Create "short hand" for the cost function to be minimized



% Now, costFunction is a function that takes in only one argument (the
% neural network parameters)



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



