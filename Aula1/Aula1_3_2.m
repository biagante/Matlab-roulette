probSimulacao = 0;   
N= 1e5; %número de experiências
p = 0.5; %probabilidade de cara
n = 15; %número de lançamentos
for k = 6:15
    lancamentos = rand(n,N) > p;
    sucessos= sum(lancamentos)==k;
    probSimulacao= probSimulacao + sum(sucessos)/N; 
end

