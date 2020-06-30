function l = addElement(e,l,h)
for c = 1:h
   s = [e num2str(c)];
   loc = string2hash(s);
   lo2 = rem(loc,length(1))+1;
   l(lo2)=1;
end