function thetanormal = normalEqn(X,y)
  
  thetanormal = inv(X'*X)*X'*y;
  
endfunction
