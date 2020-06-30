paises_test = {'Portugal','Suíça'};
paises = {'Alemanha','Espanha','Portugal'};
n = 100; %length of Bloom filter
k = 3; %nº of Hash functions
F = init(n);
for i = 1:length(paises)
    F = addElement(paises{i},F,k);
end
for i = 1:length(paises_test)
    aux = isElement(paises_test{i},F,k);
    if aux == 1
        fprint('%s is an element\n',paises_tes{i});
    else
        fprint('%s is not an element\n',paises_test{i});
    end
end
