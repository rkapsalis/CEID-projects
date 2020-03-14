%signal loading and picture show
load cameraman.mat
imshow(uint8(i));
 
x=i(:);
x=(x-128)/128;
 
%2 bits
N=2;
[xq, centers, D] = lloyd_max(x,N,min(x),max(x));
SQNR2 = (mean(x.^2)./D);
a2 = 128*centers(xq) + 128;
y2 = reshape(a2,256,256);
imshow(uint8(y2));
%plot SQNR changes compared to Lloyd Max iterations
figure; 
plot(SQNR2,'b','LineWidth',2);
title('SQNR (N=2, Lloyd-Max)');
xlabel('LM Iterations'); 
ylabel('SQNR'); 
grid on;
pause(10);
%entropy
entropy2 = edropia(centers(xq));
disp(entropy2);
 
 
%4 bits
N=4;
[xq, centers, D] = lloyd_max(x,N,min(x),max(x));
SQNR4 = (mean(x.^2)./D);
a4 = 128*centers(xq) + 128;
y4 = reshape(a4,256,256);
imshow(uint8(y4));
%plot SQNR changes compared to Lloyd Max iterations
figure; 
plot(SQNR4,'b','LineWidth',2); 
title('SQNR (N=4, Lloyd-Max)');
xlabel('LM Iterations');
ylabel('SQNR');
grid on;
%entropy
entropy4 = edropia(centers(xq));
disp(entropy4);

