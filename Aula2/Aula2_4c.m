mm = [1e3 1e4 1e5 1e6];
nn = 1:10:100;
cont = 0;
for i=1:length(mm)
    m = mm(i);
    subplot(1,4,i);
    res =[length(nn)]; 
    for n = nn
        cont = cont + 1;
        res(cont)=throwDarts(n,m,1e5);
    end
    plot(nn,res)
end


        

