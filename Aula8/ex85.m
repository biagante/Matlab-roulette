%% alinea a
T = [0.7 0.2 0.1
     0.2 0.3 0.5
     0.3 0.3 0.4];

%% alinea b
V = [1
     0
     0];
 x0 = T*V;
 a = T^2 * x0;
 a(3);
 
%% alinea c
toPlotS = zeros(20,1);
toPlotN = zeros(20,1);
toPlotC = zeros(20,1);
prob = T;
for i = 1:20
    prob = prob*T;
    toPlotS(i) = prob(1);
    toPlotN(i) = prob(2);
    toPlotC(i) = prob(3);
end
x = 1:20;
plot(x, toPlotS);
plot(x, toPlotN);
plot(x, toPlotC);

%% alinea d
i = 1;
while(true)
    prob = prob*T;
    toPlotS2(i) = prob(1);
    toPlotN2(i) = prob(2);
    toPlotC2(i) = prob(3);
    if(i> 1)
       if( abs(toPlotS2(i)- toPlotS2(i-1) > 10^-4))
           break;
       end
       if( abs(toPlotN2(i)- toPlotN2(i-1) < 10^-4))
           break;
       end
       if( abs(toPlotC2(i)- toPlotC2(i-1) < 10^-4))
           break;
       end
    end
    i=i+1;
end
plot(toPlotS2);
plot(toPlotN2);
plot(toPlotC2);
    