a = rand(1,4);
unique(a);
c = lcg(a,a,a,5,1000);

histograma(c)