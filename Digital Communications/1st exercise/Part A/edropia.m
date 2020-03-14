function [entropy] = edropia(x)
%we calculate the probability
uniq = unique(x);
freq = [uniq,histc(x(:),uniq)];
freq(:,2) = freq(:,2)./length(x);
freq(:,1) = [];
 
%calculation of entropy
entropy = 0;
for i=1:length(freq)
    if (freq(i) ~= 0)
        entropy = entropy + freq(i) * log2(1/freq(i));
    end
end
end
