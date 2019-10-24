%% Initialization
 clear ; close all; clc

%% ======================= HOMEWORK 2 =======================
%% Apartado 1
fprintf('Loading Data ...\n')
data = load('data_flower.txt');
X=data(:,1:2);
y=data(:,3);

plotData(X,y);
