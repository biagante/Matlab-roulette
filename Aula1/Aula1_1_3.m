N= 1e5; %n�mero de experi�ncias
p = 0.5; %probabilidade de cara
k = 2; %n�mero de caras
n = 3; %n�mero de lan�amentos
lancamentos = rand(n,N) > p;
sucessos= sum(lancamentos)==k;
probSimulacao= sum(sucessos)/N