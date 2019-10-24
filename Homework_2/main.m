%% Initialization
 clear ; close all; clc

%% ======================= HOMEWORK 2 =======================
%% Apartado 1
fprintf('Loading Data ...\n')
data = load('data_flower.txt');
X=data(:,1:2);
y=data(:,3);

plotData(X,y);


%% Apartado 2


%gr�fica de convergencia de descenso del gradiente

%imprimir la tasa de acierto y la grafica con la frontera de decisi�n
plotDecisionBoundary();


%% Apartado 3
%alfa, n�mero de iteraciones y tasa de acierto

%crear mas atributos atraves de mapFeature
mapFeature(); %devuelve una matriz de 28 atributos

%necesitamos que el gradiente converja
%gr�fica de convergencia de descenso del gradiente

%necesitamos que la tasa de acierto sea mayor o igual que 82%
%imprimir la tasa de acierto y la grafica con la frontera de decisi�n
plotDecisionBoundary();





