function [ signal ] = adm_decode( cn,bn )
step_min = 0.01;   % minimum step size
L = length(cn);     % length of input signal
k = 1.5;        % optimal constant
 
% initializations
signal = zeros(1,L);  
delta = ones(1,L);
delta(1) =step_min;
 
for n=2:L
 
    if bn(n) == bn(n-1) % if two sequential input values are equal
        delta(n) = k*delta(n-1); % scale step size
    else        
        delta(n) = delta(n-1)/k;% otherwise decrease step size 
    end
 signal(n) = signal(n-1) + delta(n)*bn(n); % calculate output of adm
end
end
