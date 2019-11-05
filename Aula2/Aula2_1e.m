a = rand(5,1e5)>0.5;
b = sum(a)>=1;
c = sum(a)==2;
res = sum(c)/sum(b)