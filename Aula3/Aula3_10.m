a = 10 * rand(1,1e5);


proba = sum((a < 3)/1e5)
probb = sum((a > 7)/1e5)
probc = sum((a < 6 & a > 1)/1e5)