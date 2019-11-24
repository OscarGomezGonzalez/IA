function [a1 a2 a3] = fordward(Theta1,Theta2,X,i)
  
a1 = X(i,:)';
a1 = [1; a1]; %bias+ neuronasde la capa 1
z2 = Theta1 * a1;
a2 = sigmoid(z2);
a2 = [1; a2];%bias+ neuronasde la capa 2
z3 = Theta2 * a2;
a3 = sigmoid(z3);%salida capa3
 
endfunction
