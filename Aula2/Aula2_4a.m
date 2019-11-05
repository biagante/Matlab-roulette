K = 100000;
noRepeat=0;
a = randi(100,20,K);

for c = 1:K
    uniqueVals = unique(a(:,c));
    noRepeat = noRepeat + (size(uniqueVals,1) == 20);
end

probabilidade = noRepeat/K
