probSimulacao = 0;   
N= 1e5; %n�mero de experi�ncias
p = 0.5; %probabilidade de cara
n = 15; %n�mero de lan�amentos
for k = 6:15
    lancamentos = rand(n,N) > p;
    sucessos= sum(lancamentos)==k;
    probSimulacao= probSimulacao + sum(sucessos)/N; 
end

