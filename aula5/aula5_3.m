n = 1000;
W = round(1000/0.5);

for i= 1:n
    chave = randi([3,20],1);
    b = randi([1,2],1);
    c = random_string(chave,b);
    type = 'djb2';
    %type = 'sdbm';
    hash = mode(string2hash(c,type),W);
    res(hash+1) = res(hash+1)+1;
    subplot(1,2,1);
    drawnow
end

histogram(res,0:max(res))