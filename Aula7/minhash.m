function res = minhash(value,k)
    res=zeros(k,1);
    for(i=1:k)
        menor = hash(value(1)+i,k);
        for(b=2:length(value))
            j = hash(value(b)+i,k);
            if (j < menor)
                menor = hash(value(b)+i,k) ;
            end
        end
        res(i) = menor;
    end
end