function [r] = demodulator(received)
% period of symbol
Tsymbol = 4*10^(-6);
% period of ferousa
Tc = 0.4*10^(-6);
% frequency of ferousa
fc = 1 / Tc;
Tsample = 0.1*10^(-6);
%rectangular pulse
gt = sqrt(2/Tsymbol);
 
%correlation of ferousa with rectangular pulse
for t = 1: (Tsymbol/Tsample) 
  rd = received.*gt.*cos(2*pi*fc*t)*Tsymbol;
end
%sum of lines, calculation of r vector
r = sum(rd,2);
end
