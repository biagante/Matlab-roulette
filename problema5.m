x = 1:4;
y = [1/2 1/4 1/8 1/8];
a = y.*x
b = sum(a)
c = sqrt(sum(y.*x.^2)-b^2)