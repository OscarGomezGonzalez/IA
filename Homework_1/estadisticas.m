function t_estadisticas = estadisticas(data)
  
  %iterations = 1;
  iterations = length(data(1,:));
  %t_estadisticas = ones(iterations, 4);
  %calcular media, std, min y max por cada iteracion de cada atributo
  for i = 1:iterations
    media = mean(data(:,i));
    desv = std(data(:,i));
    mini = min(data(:,i));
    maxi = max(data(:,i));
    
    %guardar por cada iteracion los valores en una matriz
    t_estadisticas(i,:) = [media,desv,mini,maxi];
   
    
  endfor
  
   t_estadisticas = t_estadisticas';
  
endfunction
