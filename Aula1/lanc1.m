function prob = lanc1(n,k)
    p = 0.5;
    prob= factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k);
    
    N= 1e5; %n�mero de experi�ncias
    p = 0.5; %probabilidade de cara
    k = 2; %n�mero de caras
    n = 3; %n�mero de lan�amentos
    lancamentos = rand(n,N) > p;
    sucessos= sum(lancamentos)==k;
    probSimulacao= sum(sucessos)/N;