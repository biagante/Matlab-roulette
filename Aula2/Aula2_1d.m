%solucao
a = rand(2,1e5)>0.5;
b = sum(a)==2;
c = a(1,:);
res = sum(b)/sum(c)