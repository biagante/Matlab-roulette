%a = rand(11,1e7)>0.5;
%b = sum(a)>=10;
%c = sum(a)==11;
%res = sum(c)/1e7

%solucao
a = rand(11,1e7)>0.5;
b = sum(a(1:10,:))==10;
c = sum(a)==11;
res = sum(c)/sum(b)