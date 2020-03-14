[y,fs] = audioread('speech.wav');
 
%loading signal
N=2;
[xq, centers, D,p] = lloyd_max(y,N,min(y),max(y));
 
% Calculation of segment limits.
T = zeros((4+1),1); % Initialization.
T(1) = -inf; % lower level limit.
for i=2:4 % the other levels.
    T(i) = (centers(i)+centers(i-1))/2;
end
T(5) = inf; % higher level limit.
 
%mean value
m = -0.04;
%standard deviation
sd = sqrt(0.11);
p_l = zeros(4,1);

for i=1:4 % Calculating probabilities of every level.
    p_l(i) = normcdf(T(i+1),m,sd) - normcdf(T(i),m,sd) ;
end

% Calculation of mean distortion.
% Initialization.
syms y; 
D_t = 0; 
for i=4:-1:1 % Calculation of integrals.
    f = ((y-centers(i))^2)*normpdf(y,m,sd);
    D_t = D_t + double(int(f,T(i),T(i+1))); %mean distortion
end
