function sinProb = throwDarts(nDardos,nEx,nAlvos)
K = nEx;
noRepeat=0;
a = randi(nAlvos,nDardos,K);

for c = 1:K
    uniqueVals = unique(a(:,c));
    noRepeat = noRepeat + (size(uniqueVals,1) < nDardos);
end

sinProb = noRepeat/K
