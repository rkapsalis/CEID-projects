function [sm] = modulator(symbols, M, A)
Tsymbol = 4*10^(-6);
tc = 0.4*10^(-6);
fc = 1/tc;
Tsample = 0.1*10^(-6);
%initializations
signal = zeros(length(symbols),1);
sm = zeros(length(symbols),length(Tsymbol/Tsample));
 
%2k-ary PAM maps k bits (which can be expressed as integers in the range
%[0,2k?1] to 2k levels that are equally-spaced and symmetric about 0.
%The levels are odd integers and 0 is not included
m = 1:M;
   pam_alphabet = 2*m-1-M;
signal = pam_alphabet(symbols+1);
signal = signal*A;
%rectangular pulse
gt = sqrt(2/Tsymbol); 
 
%signal construction
for i = 1:length(symbols)
    for t = 1:(Tsymbol/Tsample) 
        sm(i,t) = signal(i)*gt*cos(2*pi*fc*t);
    end
end
end
