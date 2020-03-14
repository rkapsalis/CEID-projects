function [xq, centers, D, p] = lloyd_max(x, N, min_value, max_value)

range = max_value - min_value;
levels = 2 ^ N;  %quantization levels
step = range/levels; %quantization step

%centers of a uniform quantizer calculation
centers = zeros(levels,1); % Initialization.
centers(1) = min_value + step/2; %(min_value+(min_value+step))/2=(2min_value+step)/2
for i=2:levels
    centers(i) = centers(i-1) + step; 
end

%signal size
x_sz = size(x);
x_rows = x_sz(1); %number of rows of vector

%initializations needed for Lm algorithm
count = 2;
D(1)= 1;
xq = zeros((length(x)),1);
Tk = zeros((levels+1),1);

%we need a finite signal
for i = 1:x_sz
  if x(i)> max_value
      x(i) = max_value ;
  elseif x(i) < min_value
     x(i) = min_value ;
  end
end

%Lloyd max algorithm implementation
while 1
    
    counter = zeros(levels);
    sum = zeros(levels);
    
    %first step of algorithm   
    Tk(1) = min_value;
    for j=2:(length(centers))
        Tk(j) = (centers(j) + centers(j-1))/2;
    end
    Tk(j+1) = max_value;
    
    %quantization
    for i=1:x_rows %rows iteration         
        for j=1:(levels) %zones iteration
            if ((x(i) > Tk(j)) && (x(i) <= Tk(j+1)))
                    xq(i) = j; %the new signal 
                    counter(j) = counter(j)+1;
                    sum(j)= sum(j)+x(i);
            end
        end      
    end    
    %the case in which the signal is equal to the min value
        if x(i) == Tk(1)           
            xq(i) = 1; %the new signal 
            %we need to calculate the sum and the counter 
             %for the zones
            sum(1) = sum(1) + x(i);
            counter(1)   = counter(1) + 1;
        end
    end    

    %calculation of new centers
    for j=1:levels
        if (counter(j)> 0)
            centers(j)= sum(j)/counter(j);  
            p(j) = counter(j)/length(x);
        end
    end    
    %distortion calculation
    D(count)= mean((x-xq).^2); 
    
    %check if condition is true
    if ((abs(D(count)-D(count-1)))< eps)
        break;
    end
    count=count+1;
end
end
