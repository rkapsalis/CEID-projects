%loading signal
[y,fs] = audioread('speech.wav'); 

%2 bits
N=2;
[xq, centers, D] = lloyd_max(y,N,min(y),max(y));
SQNR2 = (mean(y.^2)./D);
%plot SQNR changes compared to Lloyd Max iterations
figure;
plot(SQNR2,'b','LineWidth',2);
title('SQNR (N=2, Lloyd-Max)');
xlabel('LM Iterations');
ylabel('SQNR');
grid on;
%plot signal
figure;
plot(centers(xq),'b','LineWidth',2);
title('Signal (N=2, Lloyd-Max)');
grid on;
%play audio
player2 = audioplayer(centers(xq),fs);
play(player2);
%entropy calculation
[entropy] = edropia(centers(xq));
entropy2 = entropy;
disp(entropy2);

%4 bits
N=4;
[xq, centers, D] = lloyd_max(y,N,min(y),max(y));
SQNR4 = (mean(y.^2)./D);
%plot SQNR changes compared to Lloyd Max iterations
figure;
plot(SQNR4,'b','LineWidth',2);
title('SQNR (N=4, Lloyd-Max)');
xlabel('LM Iterations');
ylabel('SQNR');
grid on;
%plot signal
figure;
plot(centers(xq),'b','LineWidth',2);
title('Signal (N=4, Lloyd-Max)');
grid on;
%play audio
player4 = audioplayer(centers(xq),fs);
play(player4);
%entropy calculation
entropy4 = edropia(centers(xq));
disp(entropy4);

%8 bits
N=8;
[xq, centers, D] = lloyd_max(y,N,min(y),max(y));
SQNR8 = ( mean(y.^2)./D);
%plot SQNR changes compared to Lloyd Max iterations
figure;
plot(SQNR8,'b','LineWidth',2);
title('SQNR (N=8, Lloyd-Max)');
xlabel('LM Iterations');
ylabel('SQNR');
grid on;
%plot signal
figure;
plot(centers(xq),'b','LineWidth',2);
title('Signal (N=8, Lloyd-Max)');
grid on;
%play audio
player8 = audioplayer(centers(xq),fs);
play(player8);

%plot initial signal
figure; plot(y,'b','LineWidth',2);
title('Initial signal');
grid on;
%entropy calculation
entropy8 = edropia(centers(xq));
disp(entropy8);

%adm
N=2;
y2=interp(y,N);
[cn]=adm_encode(y2);
[signal]=adm_decode(cn);
figure(1)
plot(signal)
title(['Quantization bits  = ',num2str(N),' bits'])
ylabel('')
xlabel('')
grid on
%play audio
player2_adm = audioplayer(signal,N*fs);
play(player2_adm);

N=4;
y4=interp(y,N);
[cn]=adm_encode(y4);
[signal]=adm_decode(cn);
plot(signal)
title(['Quantization bits = ',num2str(N),' bits'])
ylabel('')
xlabel('')
grid on
%play audio
player4_adm = audioplayer(signal,N*fs);
play(player4_adm);

N=8;
y8=interp(y,N);
[cn]=adm_encode(y8);
[signal]=adm_decode(cn);
plot(signal)
title(['Quantization bits  = ',num2str(N),' bits'])
ylabel('')
xlabel('')
grid on
%play audio
player8_adm = audioplayer(signal,N*fs);
play(player8_adm);
