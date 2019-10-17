function visualizarDatos(theta_des,theta_peso,theta_aceleracion,data)
  
  % -----visualiza datos MPG-------
  figure
  
  hist(data(:,8), 'b');
  
  hold off;

% -----visualiza datos del desplazamiento-------
  % segunda figura desplazamiento/MPG
  figure
  
  % encuentra las filas que tengan en la col 7 el valor 1(usa)
  inx = find(data(:,7)==1);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del desplazamiento
  usa_x = aux(:,2);
  % guardamos los datos de MPG
  usa_y = aux(:,8);
  % pintamo los datos de usa
  plot(usa_x,usa_y,'xr');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(EU)
  inx = find(data(:,7)==2);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del desplazamiento
  eu_x = aux(:,2);
  % guardamos los datos de MPG
  eu_y = aux(:,8);
  % pintamo los datos de usa
  plot(eu_x,eu_y,'xg');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(jap)
  inx = find(data(:,7)==3);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del desplazamiento
  jap_x = aux(:,2);
  % guardamos los datos de MPG
  jap_y = aux(:,8);
  % pintamo los datos de usa
  plot(jap_x,jap_y,'xb');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % repretamos el modelo con theta, recta de regresion
  % selecciona la columna de X
  X = data(:,2);
  m = length(X);
  % añade una col de unos para porder obtener el modelo con theta
  X = [ones(m, 1) X];
  % calcula la prediccion, la recta de regresion del modelo
  aux = X*theta_des;
  % quitamos la fila de unos de la X para que no la muestre el plot
  X = X(:,2);
  plot(X, aux,'-b');
  
  hold on;
    
  % añadimos texto en ejes y leyenda
  ylabel('MPG');
  xlabel('Desplazamiento');
  legend ("USA", "Europe", "Japan");

  
  % Don't put any more plots on this figure
  hold off;
  
  
% -----visualiza datos del peso/mpg-------
  % tercera figura, peso
  figure
 
  % encuentra las filas que tengan en la col 7 el valor 1(usa)
  inx = find(data(:,7)==1);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del peso
  usa_x = aux(:,4);
  % guardamos los datos de MPG
  usa_y = aux(:,8);
  % pintamo los datos de usa
  plot(usa_x,usa_y,'xr');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(EU)
  inx = find(data(:,7)==2);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del peso
  eu_x = aux(:,4);
  % guardamos los datos de MPG
  eu_y = aux(:,8);
  % pintamo los datos de usa
  plot(eu_x,eu_y,'xg');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(jap)
  inx = find(data(:,7)==3);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos del peso
  jap_x = aux(:,4);
  % guardamos los datos de MPG
  jap_y = aux(:,8);
  % pintamo los datos de usa
  plot(jap_x,jap_y,'xb');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % repretamos el modelo con theta, recta de regresion
  % selecciona la columna de X
  X = data(:,4);
  m = length(X);
  % añade una col de unos para porder obtener el modelo con theta
  X = [ones(m, 1) X];
  % calcula la prediccion, la recta de regresion del modelo
  aux = X*theta_peso;
  % quitamos la fila de unos de la X para que no la muestre el plot
  X = X(:,2);
  plot(X, aux,'-b');
  
    hold on;
    
   % añadimos texto en ejes y leyenda
  ylabel('MPG');
  xlabel('Peso');
  legend ("USA", "Europe", "Japan");
  
  % Don't put any more plots on this figure
  hold off;
  
% -----visualiza datos del aceleracion/mpg-------

  figure
  % tercera figura, aceleracion
  
  % encuentra las filas que tengan en la col 7 el valor 1(usa)
  inx = find(data(:,7)==1);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos de la aceleracion
  usa_x = aux(:,5);
  % guardamos los datos de MPG
  usa_y = aux(:,8);
  % pintamo los datos de usa
  plot(usa_x,usa_y,'xr');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(EU)
  inx = find(data(:,7)==2);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos de la aceleracion
  eu_x = aux(:,5);
  % guardamos los datos de MPG
  eu_y = aux(:,8);
  % pintamo los datos de usa
  plot(eu_x,eu_y,'xg');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % encuentra las filas que tengan en la col 7 el valor 1(jap)
  inx = find(data(:,7)==3);
  %nos quedamos con el conjunto a representar(usa)
  aux = data(inx,:);
  % guardamos los datos de la aceleracion
  jap_x = aux(:,5);
  % guardamos los datos de MPG
  jap_y = aux(:,8);
  % pintamo los datos de usa
  plot(jap_x,jap_y,'xb');
  
  % añadimos mas datos sobre la mis grafica
  hold on;
  
  % repretamos el modelo con theta, recta de regresion
  % selecciona la columna de X
  X = data(:,5);
  m = length(X);
  % añade una col de unos para porder obtener el modelo con theta
  X = [ones(m, 1) X];
  % calcula la prediccion, la recta de regresion del modelo
  aux = X*theta_aceleracion;
  % quitamos la fila de unos de la X para que no la muestre el plot
  X = X(:,2);
  plot(X, aux,'-b');
  
  hold on;
  
  % añadimos texto en ejes y leyenda
  ylabel('MPG');
  xlabel('Aceleracion');
  legend ("USA", "Europe", "Japan");

  % Don't put any more plots on this figure
  hold off;
  
  
endfunction
