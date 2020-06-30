%% alinea a
p = 0.4;
q = 0.6;

T = [p^2 (1-p)^2 p*(1-p) p*(1-p)
      0     0       0      1
      0     0       0      1
      q^2 q*(1-q) q*(1-q) (1-q)^2];

%% alinea b
V = [1
     0
     0
     0]; %estado A
x0 = T * V; 
a = T^10 * x0;
a(1)


 