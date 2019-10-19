import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class GUI{
    public static JPanel mainPanel = new JPanel();
    public static JButton[] buttonList = new JButton[8];
    public static String[] buttonText = {
    "Next",
    "Add Reservation",
    "Cancel Reservation",
    "Show Reservations",
    "Show Rooms",
    "Show Reservation's Plan",
    "Show Income",
    "Exit"
    };
    private static Hotel hotel = Creator.createHotel("Hotel Lakis");
    private static JFrame mainFrame = new JFrame("Visual Reservations");
    private static Random rand = new Random();
  public static void main(){ 
       
        
        mainFrame.setSize(200,480);
        mainFrame.setResizable(false);
       
        Reservation res = Creator.createRandomReservation();
         for(int i = 0;i<hotel.getRoomArray().size();i++){
               if(hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode()) instanceof RoomD){
                   Object[] options = {"Yes","No"};
                          if( ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).addReservationGUI(res) == true){
                                int choice1 = rand.nextInt(2) ;
                                    ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).setDinner(res,(choice1==1)?"yes":"no");
                                    System.out.println("Reservation "+res.getResCode()+" was made with success in room " +hotel.getRoomArray().get(i).getCode()+((choice1==1)?" with dinner":" without dinner"));
                                    hotel.getReservationArray().add(res);
                                     break;
                                }else{System.out.println("Reservation "+res.getResCode()+" was failed to register in room " +hotel.getRoomArray().get(i).getCode());}
                                }
                                else{if(hotel.roomAddReservation(res,hotel.getRoomArray().get(i).getCode())==true){
                                     break;
                                }}}
	     Creator.cancelRandomReservation25(hotel);
	    
        mainPanel.setLayout(new GridLayout(8,1));
        for(int i =0;i<=7;i++){
            buttonList[i] = new JButton();
            buttonList[i].addActionListener(main);
            buttonList[i].setActionCommand(Integer.toString(i));
            buttonList[i].setFocusPainted(false);
            buttonList[i].setText(buttonText[i]);
            mainPanel.add(buttonList[i]);
        }
        
        
        mainFrame.add(mainPanel);
        
        mainFrame.setVisible(true);
        
    }
    public static ActionListener main = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         int choise = Integer.parseInt(e.getActionCommand()); 
         if(choise == 7){mainFrame.dispose();System.exit(0);}
         else{
         Reservation res = Creator.createRandomReservation();
         for(int i = 0;i<hotel.getRoomArray().size();i++){
               if(hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode()) instanceof RoomD){
                   Object[] options = {"Yes","No"};
                          if( ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).addReservationGUI(res) == true){
                                int choice1 = rand.nextInt(2) ;
                                    ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).setDinner(res,(choice1==1)?"yes":"no");
                                    System.out.println("Reservation "+res.getResCode()+" was made with success in room " +hotel.getRoomArray().get(i).getCode()+((choice1==1)?" with dinner":" without dinner"));
                                     hotel.getReservationArray().add(res);
                                     break;
                                }else{System.out.println("Reservation "+res.getResCode()+" was failed to register in room " +hotel.getRoomArray().get(i).getCode());}
                                }
                                else{if(hotel.roomAddReservation(res,hotel.getRoomArray().get(i).getCode())==true){
                                     break;
                                }}}
	     Creator.cancelRandomReservation25(hotel); 
	     switch(choise){
           case 0:break;
           case 1:
           JFrame reservFrame = new JFrame("New Reservation");
          reservFrame.setResizable(false);
          JPasswordField name = new JPasswordField();
          name.setEchoChar((char)0);
          JPasswordField people = new JPasswordField();
          people.setEchoChar((char)0);
         JComboBox arrival = new JComboBox();
         for(int i = 1;i<=Creator.monDays;i++)
                  arrival.addItem(i);
         JComboBox days = new JComboBox();
         for(int i = 1;i<Creator.monDays;i++)
                  days.addItem(i);
         ActionListener actionListenerArrival = new ActionListener() {
             public void actionPerformed(ActionEvent actionEvent) {
                  int max_days = Creator.monDays - (int)arrival.getSelectedItem();
                  days.removeAllItems();
                  for(int i = 1;i<=max_days;i++)
                  days.addItem(i);
                 }
            };
            arrival.addActionListener(actionListenerArrival);
            JComboBox room = new JComboBox();
            for(int i = 0;i<=hotel.getRoomArray().size() -1;i++)
            room.addItem(hotel.getRoomArray().get(i).getCode());
            JButton okButton =new JButton("OK");
            okButton.setEnabled(false);
            JButton cancelButton =new JButton("Cancel");ActionListener okpress = new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent) {
                    if(!(String.valueOf(name.getPassword()).equals(""))&&(Creator.isInt(String.valueOf(people.getPassword())))){okButton.setEnabled(true);}else{okButton.setEnabled(false);}
                    }
                };
                people.addActionListener(okpress);
                name.addActionListener(okpress);
                  Object[] options = {"Yes","No"};
                  int choice = JOptionPane.showOptionDialog(null,"Do you want to give specific Room Code?","Room Code?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);      
                   
                       reservFrame.setSize(200,200);
                       reservFrame.setLayout(new GridLayout(6,2));
                       reservFrame.add(new JLabel("Client's Name:"));
                       reservFrame.add(name);
                       reservFrame.add(new JLabel("Arrival day:"));
                       reservFrame.add(arrival);
                       reservFrame.add(new JLabel("Days:"));
                       reservFrame.add(days);
                       reservFrame.add(new JLabel("People:"));
                       reservFrame.add(people);
                       reservFrame.add(new JLabel("Room's Code:"));
                       if(choice == 0){reservFrame.add(room);}else{reservFrame.add(new JLabel("first available"));}
                       reservFrame.add(okButton);
                       reservFrame.add(cancelButton);
                       reservFrame.setVisible(true);
                       ActionListener actionListenerOC2 = new ActionListener(){
                        public void actionPerformed(ActionEvent actionEvent) {
                         boolean flag = true;
                         boolean flag0 =true;
                           if (actionEvent.getActionCommand().equals("OK")) {
                               Reservation res = new Reservation(String.valueOf(name.getPassword()),(int)arrival.getSelectedItem(),(int)days.getSelectedItem(),Integer.parseInt(String.valueOf(people.getPassword())));
                               if(choice == 0){
                               if(hotel.codeRoomRetrieval((int)room.getSelectedItem()) instanceof RoomD){
                                   if(((RoomD)hotel.codeRoomRetrieval((int)room.getSelectedItem())).addReservationGUI(res)==true){
                                      int choice1 = JOptionPane.showOptionDialog(null,"Do you want Dinner?","Room Type D",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
                                     ((RoomD)hotel.codeRoomRetrieval((int)room.getSelectedItem())).setDinner(res,((choice1==1)?"yes":"no"));
                                     System.out.println("Reservation "+res.getResCode()+" was made with success in room " +((RoomD)hotel.codeRoomRetrieval((int)room.getSelectedItem())).getCode()+((choice1==0)?" with dinner":" without dinner"));
                                     JOptionPane.showMessageDialog(null,"Reservation was registered with success");
                                     reservFrame.dispose();
                                     hotel.getReservationArray().add(res);
                                    }else{
                                        System.out.println("Reservation "+res.getResCode()+" was failed to register in room " +((RoomD)hotel.codeRoomRetrieval((int)room.getSelectedItem())).getCode());
                                     Object[] options = {"Yes","No"};
                                   int option = JOptionPane.showOptionDialog(null,"Reservation was failed to register in this room,do you want to try again?","Reservation unsuccessful",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,options,null);
                                  if(option ==0){flag = false;}else{reservFrame.dispose();}
                               if(flag == true){reservFrame.dispose();}
                                    }
                                }else{
                                   if(hotel.roomAddReservation(res,(int)room.getSelectedItem()) == false)
                               {
                                   Object[] options = {"Yes","No"};
                                   int option = JOptionPane.showOptionDialog(null,"Reservation was failed to register in this room,do you want to try again?","Reservation unsuccessful",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,options,null);
                                  if(option ==0){flag = false;}
                                }else{reservFrame.dispose();JOptionPane.showMessageDialog(null,"Reservation was registered with success");}
                               if(flag == true){reservFrame.dispose();}}
                            }else{
                                for(int i = 0;i<hotel.getRoomArray().size();i++){
                                if(hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode()) instanceof RoomD){
                                     if( ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).addReservationGUI(res) == true){
                                    int choice1 = JOptionPane.showOptionDialog(null,"Do you want Dinner?","Room Type D",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
                                    System.out.println("Reservation "+res.getResCode()+" was made with success in room " +hotel.getRoomArray().get(i).getCode()+((choice1==0)?" with dinner":" without dinner"));
                                    ((RoomD)hotel.codeRoomRetrieval(hotel.getRoomArray().get(i).getCode())).setDinner(res,(choice1==0)?"yes":"no"); 
                                     JOptionPane.showMessageDialog(null,"Reservation was registered with success");
                                     reservFrame.dispose();
                                     flag0 = false;
                                     hotel.getReservationArray().add(res);
                                     break;
                                    }else{System.out.println("Reservation "+res.getResCode()+" was failed to register in the room " +hotel.getRoomArray().get(i).getCode());}
                                }
                                else{if(hotel.roomAddReservation(res,hotel.getRoomArray().get(i).getCode())==true)
                                    {
                                    JOptionPane.showMessageDialog(null,"Reservation was registered with success");
                                     reservFrame.dispose();
                                     flag0 = false;
                                     break;
                                }
                            }}
                            if(flag0 == true){
                                Object[] options = {"Yes","No"};
                                   int option = JOptionPane.showOptionDialog(null,"Reservation was failed to register in this room,do you want to try again?","Reservation unsuccessful",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,options,null);
                                   if(option == 1){reservFrame.dispose();}
                            }
                            }
                            }else{reservFrame.dispose();}
                           }
                   };
                    okButton.addActionListener(actionListenerOC2);
                   okButton.setActionCommand("OK");
                   cancelButton.addActionListener(actionListenerOC2);
                   cancelButton.setActionCommand("CANCEL");
                  break;
           case 2:
                   JFrame reservQFrame = new JFrame("Reservation Cancellation"); 
                   reservQFrame.setResizable(false);
                   reservQFrame.setSize(250,100);
                   reservQFrame.setLayout(new GridLayout(2,2));
                   reservQFrame.add(new JLabel("Room's Code:"));
                   JPasswordField resCode = new JPasswordField();
                    JButton okButton0 =new JButton("OK");
                    JButton cancelButton0 =new JButton("Cancel");
            okButton0.setEnabled(false);
                   resCode.setEchoChar((char)0);
                   ActionListener isint = new ActionListener(){
                             
                public void actionPerformed(ActionEvent actionEvent) {
                    if(Creator.isInt(String.valueOf(resCode.getPassword())) ){
                    okButton0.setEnabled(true);
                   }
                   }
              };
              resCode.addActionListener(isint);
              reservQFrame.add(resCode);
              reservQFrame.add(okButton0);
              reservQFrame.add(cancelButton0);
              JButton okButton1 =new JButton();
              JButton cancelButton1 =new JButton();
              ActionListener actionListenerOC01 = new ActionListener(){
                 public void actionPerformed(ActionEvent actionEvent) {
                     if(actionEvent.getActionCommand().equals("OKA")){
                         if(hotel.resCancellation(Integer.parseInt(String.valueOf(resCode.getPassword()))) == false){
                             JOptionPane.showMessageDialog(null,"Cancellation was unsuccesful");
                            }else{JOptionPane.showMessageDialog(null,"Cancellation was Succesful");}
                         reservQFrame.dispose();
                         }else{reservQFrame.dispose();}
                    }
                     };
                    okButton0.addActionListener(actionListenerOC01);
                   okButton0.setActionCommand("OKA");
                   cancelButton0.addActionListener(actionListenerOC01);
                   cancelButton0.setActionCommand("CANCEL");  
              reservQFrame.setVisible(true);
             break;
             
         case 3:
         JFrame resFrame = new JFrame("Reservation's List");
         resFrame.setSize(450,300);
         resFrame.setLayout(new BorderLayout());
         JTextArea psTerminR = new JTextArea();
         psTerminR.setText(Creator.showReservations(hotel,"GUI"));
         psTerminR.setEnabled(false);
         psTerminR.setDisabledTextColor(Color.black);
         JScrollPane scrollR = new JScrollPane(psTerminR,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         resFrame.add(scrollR,BorderLayout.CENTER);
         JButton okButton3 = new JButton("OK");
         resFrame.add(okButton3,BorderLayout.PAGE_END);
          ActionListener listen3 = new ActionListener(){
                 public void actionPerformed(ActionEvent actionEvent) {
                             resFrame.dispose(); 
                    }};
         okButton3.addActionListener(listen3);
         resFrame.setVisible(true);
         break;
         case 4:
         JFrame roomFrame = new JFrame("Room's List");
         roomFrame.setSize(450,320);
         roomFrame.setLayout(new BorderLayout());
         JTextArea psTerminRo = new JTextArea();
         psTerminRo.setText(Creator.showRooms(hotel,"GUI"));
         psTerminRo.setEnabled(false);
         psTerminRo.setDisabledTextColor(Color.black);
         JScrollPane scrollRo = new JScrollPane(psTerminRo,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         roomFrame.add(scrollRo,BorderLayout.CENTER);
         JButton okButton4 = new JButton("OK");
         roomFrame.add(okButton4,BorderLayout.PAGE_END);
          ActionListener listen4 = new ActionListener(){
                 public void actionPerformed(ActionEvent actionEvent) {
                             roomFrame.dispose(); 
                    }};
         okButton4.addActionListener(listen4);
         roomFrame.revalidate();
         roomFrame.setVisible(true);
         break;
         case 5:
         JFrame planFrame = new JFrame("Reservation plan");
         planFrame.setSize(1000,350);
         planFrame.setLayout(new BorderLayout());
         JTextArea psTermin = new JTextArea();
         psTermin.setText(hotel.reservPlan());
         psTermin.setEnabled(false);
         psTermin.setDisabledTextColor(Color.black);
         JScrollPane scroll = new JScrollPane(psTermin,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         planFrame.add(scroll,BorderLayout.CENTER);
         JButton okButton5 = new JButton("OK");
         planFrame.add(okButton5,BorderLayout.PAGE_END);
          ActionListener listen5 = new ActionListener(){
                 public void actionPerformed(ActionEvent actionEvent) {
                             planFrame.dispose(); 
                    }};
        okButton5.addActionListener(listen5);
         planFrame.setVisible(true);
         break;
         case 6:
         JFrame incomFrame = new JFrame("Hotel income");
         incomFrame.setSize(300,100);
         incomFrame.setLayout(new GridLayout(2,2));
         incomFrame.add(new JLabel("Total Hotel income:"));
         incomFrame.add(new JLabel("\t"+String.valueOf(hotel.incomeCalc())));
         JLabel RC = new JLabel("Give Specific Room Code:");
         incomFrame.add(RC);
         JComboBox room1 = new JComboBox();
          for(int i = 0;i<=hotel.getRoomArray().size() -1;i++)
          room1.addItem(hotel.getRoomArray().get(i).getCode());
          incomFrame.add(room1);
          ActionListener listen6 = new ActionListener(){
                 public void actionPerformed(ActionEvent actionEvent) {
                             int i = (int)room1.getSelectedItem();
                             RC.setText("Room's "+i+" total income:");
                             incomFrame.remove(room1);
                             incomFrame.add(new JLabel("\t"+String.valueOf(hotel.incomeCalc(i))));
                             incomFrame.revalidate();
                       }};
           
          room1.addActionListener(listen6);
          incomFrame.setVisible(true);
         break;
        }  
    }
}
};
}
