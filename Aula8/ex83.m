T = rand(20);

for i = 1:20
    T(:,i)=T(:,i)./sum(T(:,i));
end

sum(T);

x0 = [1;zeros(19,1)];

%% probabilidade 20 transições
x20 = T^20 * x0;
prob20 = x20(20)

%% probabilidade 40 transições
x40 = T^40 * x0;
prob40 = x40(20)

%% probabilidade 100 transições
x100 = T^100 * x0;
prob100 = x100(20)



