function res = distJ(movies1,movies2)
    res = 1- length(intersect(movies1,movies2))/length(union(movies1,movies2));
end