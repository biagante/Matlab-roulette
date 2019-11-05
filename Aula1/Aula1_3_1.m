prob = 0;
p = 0.5;
n = 15;
for k= 6:15  
    prob= prob + factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k);
end

%exercicio 3
tic
prob=0;
p=0.5;
n=15;
for k=6:15
    prob = prob + factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k);
end
prob1 = prob;
toc
tic
k = 6:15;
prob = factorial(n)./(factorial(n-k).*factorial(k)).*p.^k.*(1-p).^(n-k);
prob = sum(prob);
toc