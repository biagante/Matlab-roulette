function f = binomial(n,k,p)
f = (factorial(n)./(factorial(n-k).*factorial(k)).*p^k*(1-p).^(n-k));