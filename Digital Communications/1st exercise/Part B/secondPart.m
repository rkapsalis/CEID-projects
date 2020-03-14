%number of bits
input_length = 10.^5;
%binary input sequence
input_seq = randsrc( input_length, 1,[0 1]);
i=1;

BER_pam4 = zeros(11, 1);
BER_pam8_gray = zeros(11, 1);
SER_pam4 = zeros(11, 1);
SER_pam8 = zeros(11, 1);

%BER calculation
for SNR = 0: 2: 20
    %ber for m=4    
    A4 = 1/sqrt(5);
    map4 = mapper(input_seq, 2, 0);
    mod4 = modulator(map4, 4, A4);
    awgn4 = noise(mod4,SNR, 4);
    demod4 = demodulator(awgn4);
    dd4 = decision_device(demod4, 4, A4);
    demap4 = demapper(dd4', 4, 0);
    BER_pam4(i, 1) = ber(input_seq,demap4,4);
    
    %ber for m=8 Gray
    A8 = 1/sqrt(21);
    map8 = mapper(input_seq, 3, 1);
    mod8 = modulator(map8, 8, A8);
    awgn8 = noise(mod8, SNR, 8);
    demod8 = demodulator(awgn8);
    dd8 = decision_device(demod8, 8, A8);
    demap8 = demapper(dd8', 8, 1);
    BER_pam8_gray(i, 1) = ber(input_seq,demap8,8);
    i = i+1;
end
 
x = (0: 2: 20); 
figure();
semilogy(x, BER_pam4, 'r-*');
hold on
semilogy(x, BER_pam8_gray, 'b-o');
title('BER');
xlabel('SNR');
legend('4-PAM','8-PAM-GRAY'); 
hold off

%SER calculation
k=1;
for SNR = 0: 2: 20
    
   %ser for m=4    
    A4 = 1/sqrt(5);
    map4_ser = mapper(input_seq, 2, 0);
    mod4_ser = modulator(map4_ser, 4, A4);
    awgn4_ser = noise(mod4_ser,SNR, 4);
    demod4_ser = demodulator(awgn4_ser);
    dd4_ser = decision_device(demod4_ser, 4, A4);
    demap4_ser = demapper(dd4_ser', 4, 0);
    SER_pam4(k, 1) = ser(map4_ser,dd4_ser);
    
    %ser for m=8    
    A8 = 1/sqrt(21);
    map8_ser = mapper(input_seq, 3, 0);
    mod8_ser = modulator(map8_ser, 8, A8);
    awgn8_ser = noise(mod8_ser,SNR, 8);
    demod8_ser = demodulator(awgn8_ser);
    dd8_ser = decision_device(demod8_ser, 8, A8);
    demap8_ser = demapper(dd8_ser', 8, 0);
    SER_pam8(k, 1) = ser(map8_ser,dd8_ser);    
       
  k = k+1;  
end
y = (0: 2: 20);
figure();
semilogy(y, SER_pam4, 'r-*');
hold on
semilogy(y, SER_pam8, 'b-o');
title('SER');
xlabel('SNR');
legend('4-PAM','8-PAM');
 
hold off
