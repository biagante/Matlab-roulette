function f = hash(value,k)
    f = mod(value*k, nextprime(k));
end