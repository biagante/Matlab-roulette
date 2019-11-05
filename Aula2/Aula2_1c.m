%probSimulacao = 0;   
%N= 1e5; %número de experiências
%p = 0.5; %probabilidade de rapaz
%n = 2; %número de filhos
%for k = 1:2
  %  lancamentos = rand(n,N) > p;
  %  sucessos= sum(lancamentos)==k;
  % probSimulacao= probSimulacao + sum(sucessos)/N; 
%end

%N= 1e5;
%lancamentos = rand(3,N) > 0.5;
%sucessos= sum(lancamentos)==2; % 1 = sucesso
%fabsol = cumsum(sucessos);
%frel = fabsol ./ (1:N)
%plot(1:N, frel);

%solucao
a = rand(2,1e5)>0.5;
b = sum(a)>=1;
c = sum(a)==2;
res = sum(c)/sum(b)
