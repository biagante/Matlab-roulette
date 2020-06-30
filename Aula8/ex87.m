T = [0.8 0.1 0.05
     0.2 0.6 0.2
     0   0.3 0.75];
x0 = [100
      200
      30];
  
%% alinea a 
a = T^3 * x0

%% alinea b
b = T^365 * x0

%% alinea c
day = 1;
while true
    temp = T^day * x0;
    if(temp(3) >= 130)
        day   
        break;
    end
    day=day+1;
end