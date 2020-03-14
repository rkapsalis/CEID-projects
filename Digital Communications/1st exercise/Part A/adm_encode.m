function [ cn,bn ] = adm_encode( signal )
step_min = 0.01; % minimum step size initialization
k = 1.5; % constant
L = length(signal);  % length of input signal 
%arrays initilization
cn = zeros(1,L);        
bn = zeros(1,L);  
delta = ones(1,L); 
delta(1) = step_min;
 
for i=2:L
 
    diff = signal(i) - cn(i-1); % error or difference between input signal and approximation
    %1 bit quantizer
    if diff>=0  % if difference is > 0
        bn(i) = 1; % output is equal to 1
    else
        bn(i) = -1; % output is equal to -1
    end
    
    %step control logic
    if (bn(i) == bn(i-1))  % if the previous outputs is equal
        delta(i) = k*delta(i-1); % scale step size
    else         
       delta(i) = delta(i-1)/k; % we decrease step size
    end
     cn(i) = cn(i-1) + delta(i)*bn(i); % calculate approximation signal (delay)
end
end
