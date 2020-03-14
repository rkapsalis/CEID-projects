function [SER] = ser(input, output)

symbols_error = 0; 

 for i = 1:length(input)
           if (input(i) ~= output(i)) 
              symbols_error = symbols_error + 1;
           end
 end
 
% calculate the bit error rate
SER = symbols_error/length(output);
 
end
