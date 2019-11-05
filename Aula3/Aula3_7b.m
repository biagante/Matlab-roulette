alpha = 15;
cont = 0;
for k = 0:10
    cont = poisson(k,alpha);
end
p = 1 - cont

c = alpha.^(0:10)/factorial(0:10)*exp(-alpha);
pr = 1 - sum(c)
