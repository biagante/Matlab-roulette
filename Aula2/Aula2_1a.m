    
    %probSimulacao = 0;   
    %N= 1e5; %n�mero de experi�ncias
    %p = 0.5; %probabilidade de rapaz
    %n = 2; %n�mero de filhos
    %for k = 1:2
    %    lancamentos = rand(n,N) > p;
    %   sucessos= sum(lancamentos)==k;
    %    probSimulacao= probSimulacao + sum(sucessos)/N; 
    %end
%%solucao
a = rand(2,1e5)>0.5;
b = sum (a)>=1;
res = sum(b)/1e5
