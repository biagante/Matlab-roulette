experiencias = rand(4,1e5);
p = experiencias > 0.5;     %1==coroa
res = sum(p);
a = [0:4];
b = [];
for k = 0:4
    c = sum(res==k)/1e5;
    b = [b,c];
end
stem(a,b);
hold on
plot(a,b,'go');
plot(a,b,'rx');