a = rand(10,1e7)>0.5;
b = sum(a)>=10;
c = sum(a)==11;
res = sum(b)/1e7