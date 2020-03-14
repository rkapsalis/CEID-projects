function [output] = demapper(symbols, M, gray)
%  returns a binary vector based on the symbols received
    if gray == 1
       symbols = gray2bin(symbols, 'pam', M);
    end
    output = de2bi(symbols);

 [lines, columns] = size(output);
 
% reshape the matrix with the received bits to an array
output = reshape(output', lines*columns, 1);
 
end
