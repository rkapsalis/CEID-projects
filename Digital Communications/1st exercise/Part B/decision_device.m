function symbols = decision_device(received, M, A)
%initilization
Sm = zeros(M,1);
symbols = zeros(length(received),1);
distance = zeros(M,1);
 
for m = 1:M
   Sm(m) = (2*m-1-M)*A;
end
 
%we find the min euclidean distance between r & sm vectors
for i = 1:length(received)
    for j = 1:M
        distance(j) = norm((received(i, 1)-Sm(j)));        
    end
    [min_diff, symbols1] = min(distance);
    symbols(i)=symbols1-1;
end
 
end
