function y = isELement(e,l,h)
y = 1;
for c = 1:h
   s = [e num2str(c)];
   loc = string2hash(s);
   lo2 = rem(loc,length(1))+1;
   if l(lo2) == 0
       y = 0;
       break
   end
end