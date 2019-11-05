xi=[1,2,3,4,5,6];
% p=[0.0828 0.0084 0.0201 0.0342 0.0792]; % PT real
px=[0.2 0.2 0.2 0.2 0.2 0.6];% fake
px=px/sum(px); 

X= zeros(1,60);
for j =1:60
    U=rand();
    i = 1 + sum( U > cumsum (px));
    % out sera valor entre 1 e 5
    % de acordo com as probabilidades p
    X(j)=xi(i);
end
hist(X)