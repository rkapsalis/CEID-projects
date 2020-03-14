function [BER] = ber(input, output, m)
%length of input array
l = length(input);
% see if it can be divided by log2(m)
modular = mod(l, log2(m));
 
% if not, that means that we send more bits than the length of input
if modular ~= 0
    % calculate the reduntant bits of the output
    further_elements = log2(m) - modular;
    
    % we concatenate at the end of the transmitted string the reduntant
    % bits in order to compare the same ammount of bits at both ends
   input(l + further_elements)=input(l);
   input(l) = 0;
 
end
 bits_error = 0; 
 for i = 1:l
           if (input(i) ~= output(i)) 
              bits_error = bits_error + 1;
           end
 end
% calculate the bit error rate
BER = bits_error/length(output); 
end
