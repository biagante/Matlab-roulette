x = 1:4;
f = funcao(x);
if min(f)>=0 && max(f)<=1 && sum(f)==1
    fprintf('Sim\n')
else
    fprintf('Não\n')
end
