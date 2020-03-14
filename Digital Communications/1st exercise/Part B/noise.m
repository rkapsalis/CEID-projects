function [received] = noise(sm, SNR, m)
 
Es = 1; 
Eb = Es / log2(m);
% we solve the equation
% 10 * log10(Eb / N0) = SNR =>
% SNR/10 = log10(Eb / N0)
% and we have as a result
N0 = Eb / (10^(SNR/10));
 
% deviation
sigma = sqrt(N0 / 2);
 
% the AWGN noise is added to every sample taken by the modulator
noise = sigma * randn(size(sm));
 
% added it to the signal
received = sm + noise;
    
end

