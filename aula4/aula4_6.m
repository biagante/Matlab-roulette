N=1e6
X=exponencial(10,N);
[n,xout]= hist(X,100);
bar(xout,n/N)
