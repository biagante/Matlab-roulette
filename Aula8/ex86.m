%% alinea a
Hji = [0.8 0.0 0.3 0.0
       0.2 0.9 0.2 0.0
       0.0 0.1 0.4 0.0
       0.0 0.0 0.1 1.0];
%% alinea b
V = [1
     0
     0
     0];

resp = Hji^1000 .* V;
B = resp(1);

%% alinea c
x1 = Hji * V;
c1 = x1(1);
x2 = Hji^2 * V;
c2 = x2(1);
x10 = Hji^10 * V;
c3 = x10(1);
x100 = Hji^100 * V;
c4 = x100(1);

%% alinea d
Q = Hji(1:3,1:3);

%% alinea e
aux = eye(size(Q)) - Q;
F = inv(aux);

%% alinea f = alinea g
passos = sum(F);
p1 = passos(1);
p2 = passos(2);
p3 = passos(3);

%% alinea h
H = [0.99 0.00 0.78 0.00
     0.01 0.99 0.20 0.00
     0.00 0.01 0.01 0.00
     0.00 0.00 0.01 1.00]; 
Q = H(1:3,1:3);
aux = eye(size(Q))-Q;
F = inv(aux);
passos = sum(F);
p4 = passos(1);
p5 = passos(2);
p6 = passos(3);


