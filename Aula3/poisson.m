function f = poisson(k,alpha)
f = (alpha.^k)/factorial(k)*exp(-alpha);