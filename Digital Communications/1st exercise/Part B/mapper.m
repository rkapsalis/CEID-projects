function [symbols] = mapper(input, k, flag)
% k=log2(m)
% if flag=1->gray else if flag=0->simple encoding 
n = length(input);
 
% for cases that log2(m) doesnt divide size
temp = mod(n, k);
 
% the sequence which is dividable by log2(m)
new_bin_seq = input(1 : (n - temp), :);
 
% grouping of that sequence
reshaped_seq = reshape(new_bin_seq, k, (n - temp) / k);
symbols = zeros(round(n-temp)/k,1);
 
% tranform the sequence into binary code for every group of k bits
for i = 1: (n - temp) / k
    symbols(i) = bin2dec(num2str(reshaped_seq(:, i)'));
end
 
% the rest of the bits are separately transformed into a symbol in binary
% code
if temp ~= 0
    symbols(i + 1) = bin2dec(num2str(input(n - temp + 1 :n, 1)'));
end
 
% gray encoding if requested
if flag == 1
    symbols = bin2gray(symbols, 'pam', 2^k);
end
end
