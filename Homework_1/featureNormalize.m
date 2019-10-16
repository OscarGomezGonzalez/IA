function X = featureNormalize(X)
  
  %calcula mediana
  mu = mean(X);
  
  %calcula desviacion tipica
  sigma = std(X);
  
  X = (X - mu)./sigma;
  
endfunction
