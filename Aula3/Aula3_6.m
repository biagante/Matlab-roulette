p = 1/1000;
n = 8000;
alpha = n*p;
k = 7;
f = poisson(k,alpha)
prob = binomial(n,k,p)
bin = nchoosek(n,k)