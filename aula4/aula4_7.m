for i=1:6
subplot(2,3,i)
N=10^i;
[X,Y]=BoxMuller(N);
hist(X,50)
title(['N=' num2str(N)]);
ax=axis;
ax(1)=-5;
ax(2)=5;
axis(ax)
end