/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Ρωμανός
 */

import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.table.*;


 public class adminGUI extends NewJFrame{
     protected String value1;
     protected String value2;
     protected String value3;
     private JComboBox box = new JComboBox();
     private JComboBox box1 = new JComboBox();
    private JTextField dateField = new JTextField(15);
    private JTextField date1Field = new JTextField(15);
     
    private JTextField usernameField = new JTextField(12);
    private JTextField pasField = new JTextField(10);
    private JTextField nameField = new JTextField(25);
    private JTextField surField = new JTextField(20);
    private JTextField regField = new JTextField(15);
    private JTextField emailField = new JTextField(30);   
    private JComboBox typeCombo = new JComboBox();
	 
     private JTextArea txt1 = new JTextArea(10, 15); 
     private JTextField tomeasField = new JTextField(30);
     private JTextField afmField = new JTextField(9);
     private JTextField titlosField = new JTextField(30);
     private JTextArea textArea = new JTextArea(10, 15);
     private JTextArea txt2 = new JTextArea(10, 15); 
     private JTextField titleField = new JTextField(36);
     private JTextField belField = new JTextField(36);
     JScrollPane scrollPane = new JScrollPane(textArea);        
     java.util.Date date;
     private JButton createButton = new JButton("Create Account");
     private JButton insButton = new JButton("Insert antikeim");
     private JButton ins1Button = new JButton("Insert tomeis");
     private JButton hisButton = new JButton("Show history");
     private JButton subButton = new JButton("Submit"); //user
     private JButton sub1Button = new JButton("Submit"); //antik
     private JButton sub2Button = new JButton("Submit"); //tomeis
     private JButton cancelButton = new JButton("Cancel"); //user
     private JButton cancel1Button = new JButton("Cancel"); //antik
     private JButton cancel2Button = new JButton("Cancel");//tomeis
    private JButton selectButton = new JButton("Select");
    private final static String PANEL5 = "panel 5";
    private final static String PANEL3 = "panel 3";
    private final static String PANEL1 = "panel 1";
    private final static String PANEL2 = "panel 2";
    private final static String PANEL21 = "panel 21";
    private final static String PANEL4 = "panel 4";
   // private final static String PANEL11 = "panel 11";
    private final static String PANEL6 = "panel 6";
    Connection conn=null;
    Statement stmt=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int rs1=0;
    int count1=0 ;
    int count2=0 ;
    int count3=0 ;
    int count4=0 ;
    int count5=0 ;
    
  public  adminGUI() {
   conn=project.ConnectDb(); 
   initComponents(); 
  }
  
  protected JPanel initFields() { //user
      JPanel panel1_1 = new JPanel();
      panel1_1.setLayout(new MigLayout());
      panel1_1.setBackground(new java.awt.Color(103,177,234));
      panel1_1.add(new JLabel("Username: "), "align label"); 
      panel1_1.add(usernameField, "wrap");
      usernameField.setEnabled(true);
      usernameField.setEditable(true);
      
      panel1_1.add(new JLabel("Password: "), "align label");
      panel1_1.add(pasField, "wrap");
      pasField.setEnabled(true);
      
      panel1_1.add(new JLabel("Name: "), "align label");
      panel1_1.add(nameField, "wrap");
      nameField.setEnabled(true);      
   
       panel1_1.add(new JLabel("Surname: "), "align label");
       panel1_1.add(surField, "wrap");
       surField.setEnabled(true);           
	   
       panel1_1.add(new JLabel("Registration Date: "), "align label");
       panel1_1.add(regField, "wrap");
       regField.setEnabled(true);
              
	   panel1_1.add(new JLabel("Type: "), "align label");
	   typeCombo.addItem("Candidate");
	   typeCombo.addItem("Recruiter");
       panel1_1.add(typeCombo, "wrap");
       typeCombo.setEnabled(true);
	   
	   panel1_1.add(new JLabel("Email: "), "align label");
       panel1_1.add(emailField, "wrap");
       emailField.setEnabled(true);
     
       panel1_1.add(initButtons());
    
       return panel1_1;
  }
   protected JPanel initFields1() {  //antikeim
      JPanel panel2_1 = new JPanel();
      panel2_1.setLayout(new MigLayout());
      panel2_1.setBackground(new java.awt.Color(103,177,234));
      panel2_1.add(new JLabel("Title: "), "align label"); 
      panel2_1.add(titleField,"wrap");
      titleField.setEnabled(true);
      titleField.setEditable(true);
      
      panel2_1.add(new JLabel("Belongs to: "), "align label");
      panel2_1.add(belField, "wrap");
      belField.setEnabled(true);
      
      panel2_1.add(new JLabel("Description: "), "align label");
      panel2_1.add(txt1, "wrap");
      txt1.setEnabled(true);     
      
       panel2_1.add(initButtons1());
    
       return panel2_1;
  }
  
  protected JPanel initFields2() {  //tomeas
      JPanel panel3_1 = new JPanel();
      panel3_1.setLayout(new MigLayout());
      panel3_1.setBackground(new java.awt.Color(103,177,234));
      panel3_1.add(new JLabel("Titlos: "), "align label"); 
      panel3_1.add(titlosField,"wrap");
      titlosField.setEnabled(true);
      titlosField.setEditable(true);
      
      panel3_1.add(new JLabel("AFM etaireias: "), "align label");
      panel3_1.add(afmField, "wrap");
      afmField.setEnabled(true);
      
      panel3_1.add(new JLabel("Related Text: "), "align label");
      panel3_1.add(txt2, "wrap");
      txt2.setEnabled(true);     
      
      panel3_1.add(new JLabel("Arxikos Tomeas: "), "align label");
      panel3_1.add(tomeasField, "wrap");
      tomeasField.setEnabled(true);
      panel3_1.add(initButtons2());
    
       return panel3_1;
  }
   
  private JPanel initButtons() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(subButton);     
      panel.add(cancelButton);
      //editButton.addActionListener(new ButtonHandler());     
      return panel;
   }  
    private JPanel initButtons1() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(sub1Button);     
      panel.add(cancel1Button);
      //editButton.addActionListener(new ButtonHandler());     
      return panel;
   }  
    private JPanel initButtons2() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(sub2Button);     
      panel.add(cancel2Button);
      //editButton.addActionListener(new ButtonHandler());     
      return panel;
   }  
  private void initComponents(){
      
      JFrame frame = new JFrame("Admin");
      setMaximumSize( new Dimension( 70, 60 ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground(new java.awt.Color(78, 108, 157));
      panel3.setPreferredSize(new Dimension(500,300));
      panel3.setLayout(new BorderLayout(5,5));  
       JPanel panel5 = new JPanel();
      panel5.setBackground(new java.awt.Color(78, 108, 157));
      panel5.setPreferredSize(new Dimension(500,300));
      JPanel panel1 = new JPanel();
      panel1.setBackground(new java.awt.Color(78, 108, 157));
     // panel1.setPreferredSize(new Dimension(500,300));
     JLabel label10=new JLabel("<html>Welcome " + NewJFrame.s);
     
      Font f=new Font("Calibri",Font.BOLD,20);
      label10.setFont(f);
       panel5.add(label10);
      JPanel panel2 = new JPanel();
      panel2.setBackground(new java.awt.Color(78, 108, 157));
      panel2.setPreferredSize(new Dimension(500,300));
      panel2.setLayout(new BorderLayout(5,5));  
      
      JPanel panel4 = new JPanel();
      panel4.setBackground(new java.awt.Color(78, 108, 157));
      panel4.setPreferredSize(new Dimension(500,300));
      panel4.setLayout(new BorderLayout(5,5));
           
        JPanel panel6 = new JPanel();
      panel6.setBackground(new java.awt.Color(78, 108, 157));
      panel6.setPreferredSize(new Dimension(500,300));
      panel6.setLayout(new BorderLayout(5,5));
        JPanel panel4_1=new JPanel();
      panel4_1.setLayout(new BorderLayout());
      panel4_1.setBackground(new java.awt.Color(103,177,234));
      panel4.add(panel4_1,BorderLayout.CENTER);
      
      JPanel panel4_2=new JPanel();
      panel4_2.setLayout(new BorderLayout());
      panel4_2.setBackground(new java.awt.Color(103,177,234));
      panel6.add(panel4_2,BorderLayout.CENTER);
      
      JPanel panel2_1=new JPanel();
      panel2_1.setLayout(new BorderLayout());
      panel2_1.setBackground(new java.awt.Color(103,177,234));
      panel2.add(panel2_1,BorderLayout.CENTER);
      
      TableColumnModel colmodel;
      DefaultTableModel model =new DefaultTableModel();
      panel1.setLayout(new BorderLayout(5,5));
      //panel1.add(this.initFields(),BorderLayout.SOUTH);
      scrollPane.setPreferredSize(new Dimension(380, 100));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     // initFields().setBorder(new TitledBorder
      //(new EtchedBorder(),"History"));      
      model.addColumn("Username");  
      model.addColumn("Date");
      model.addColumn("Executed");
      model.addColumn("Type"); 
      model.addColumn("Table");       
      JTable table = new JTable(model);
      //JScrollPane scrollpane1 = new JScrollPane(table);
     // add(new JScrollPane(table)); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
      
    final JPanel cards = new JPanel(new CardLayout());
       cards.add(panel5, PANEL5);
        cards.add(panel1, PANEL1);
        cards.add(panel2, PANEL2);
        cards.add(panel3, PANEL3);
	//cards.add(panel11,PANEL11);
	cards.add(panel2_1,PANEL21);
	cards.add(panel4,PANEL4);	
        cards.add(panel6,PANEL6);	
        CardLayout cl = (CardLayout) (cards.getLayout());//get cards
               // cl.show(panel3,PANEL3);   
   
   
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
                   count1++;
                if(count1>0 ){
                 panel1.removeAll();
                // textArea.setText(null);
                }
                    panel1.add(initFields(),BorderLayout.NORTH);                   
                    createButton.setVisible(false);
                    ins1Button.setVisible(true); 
                     insButton.setVisible(true);                      
                    CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                    c1.show(cards,PANEL1);
                   }  
           });     
    
           
        insButton.addActionListener(new ActionListener() {           
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                insButton.setVisible(false);
                createButton.setVisible(true);
                ins1Button.setVisible(true);
                 count2++;
                if(count2>0 ){
                 panel2.removeAll();
                 txt1.setText(null);
                }
                panel2.add(initFields1(),BorderLayout.NORTH); 
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL2);
            }
        }); 
     	 ins1Button.addActionListener(new ActionListener() {           
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                ins1Button.setVisible(false);
                createButton.setVisible(true);
                insButton.setVisible(true);
                count3++;
                if(count3>0 ){
                 panel3.removeAll();
                 txt2.setText(null);
                }
                panel3.add(initFields2(),BorderLayout.NORTH); 
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
            }
        });
	hisButton.addActionListener(new ActionListener() {           
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object[] options3 = {"Tables","User and date","Cancel"};
                         int m = JOptionPane.showOptionDialog(null,"Do you want to set specific table\n" + "or specific time interval and user?","Message",                  
                         JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options3,options3[2]);
				 if(m==0){   //if option is tables					
                                   EventQueue.invokeLater(new Runnable() {

                                        @Override
                                  public void run() {
                                       
                                     JPanel panel = new JPanel(new GridLayout(0, 1));                                    
                                     panel.add(new JLabel("Select table: "));
                                         panel.add(box);                         
                                         box.addItem("Candidate");
	                                 box.addItem("Recruiter");
					 box.addItem("User");
					 box.addItem("Etairia");
					 box.addItem("Job");
					
                                    
                                    int result1 = JOptionPane.showConfirmDialog(null, panel, "Tables",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                                    if (result1 == JOptionPane.OK_OPTION) {
                                         value1=String.valueOf(box.getSelectedItem());
                                      try{  
                                         
                                         if(count4>0 ){
                                       panel4.removeAll(); 
                                       model.setRowCount(0);
                                       }
                                           count4++;
                                       String query = "SELECT * FROM history WHERE name=?";
                                       pst=conn.prepareStatement(query);
                                       pst.setString(1, value1);
                                       rs=pst.executeQuery();                     
                                       while(rs.next()){
                                         String u = rs.getString("username");                                         
		                         String enum1 =  rs.getString("executed");
		                         String enum2 = rs.getString("type");                     
		                         String n = rs.getString("name");                                   
        	                         Timestamp timestamp = rs.getTimestamp("his_date");
                                         DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// Make the date format show the date in CET (central European time)
                                         df1.setTimeZone(TimeZone.getTimeZone("GMT +2"));

                                         String text12 = df1.format(timestamp);
                                      //if (timestamp != null){
                                       // date = new java.util.Date(timestamp.getTime());}                    				 
                                        model.addRow(new Object[]{u,text12,enum1,enum2,n});
                                          
                                   }   
                     panel4_1.add((new JScrollPane(table)));       
                                      
                     
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                } 
                                    CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                                    c1.show(cards,PANEL4);
                                  } else {
                                          System.out.println("Cancelled");
                                  }
                               }
                                    
                               });           
				 }
		else if(m==1){	 //if option is user and dates
		                     try{ 
                                         
                                         String query = "SELECT DISTINCT username FROM history";
                                         pst=conn.prepareStatement(query);                     
                                         rs=pst.executeQuery();               
                                      while(rs.next()){
				     String a = rs.getString("username");
				     box1.addItem(a);
				  }
                                 //value2=box1.getSelectedItem().toString();
                                 EventQueue.invokeLater(new Runnable() {

                                        @Override
                                  public void run() {
                                       
                                    JPanel panel = new JPanel(new GridLayout(0, 1)); 
                                    
                                    JTextField field1 = new JTextField();
                                    JTextField field2 = new JTextField();
                                    panel.add(new JLabel("Select user: "));
                                    panel.add(box1);
                                    panel.add(new JLabel("Since:"));
                                    panel.add(field1);
                                    panel.add(new JLabel("Until:"));
                                    panel.add(field2);
                                                            
                  
                 int result = JOptionPane.showConfirmDialog(null, panel, "User and date",
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
           if (result == JOptionPane.OK_OPTION) {
                     // panel4.add(new JLabel(value2));
                     value2=String.valueOf(box1.getSelectedItem());
                            try{  
                                  String  f1=field1.getText() + " 00:00:00";
                                   String  f2 = field2.getText() + " 23:59:59";
                                      
                                         if(count5>0 ){
                                       panel6.removeAll();                                
                                       }
                                         count5++; 
                                       String query = "SELECT * FROM history WHERE username=? AND his_date BETWEEN ? AND ?";
                                       pst=conn.prepareStatement(query);
                                       pst.setString(1, value2);
                                       pst.setString(2, f1);
                                       pst.setString(3, f2);
                                       rs=pst.executeQuery();                     
                                       while(rs.next()){
                                         String u = rs.getString("username");                                         
		                         String enum1 =  rs.getString("executed");
		                         String enum2 = rs.getString("type");                     
		                         String n = rs.getString("name"); 
                                         //Date date = rs.getDate("his_date");  
                                         Timestamp timestamp1 = rs.getTimestamp("his_date");
                                         
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// Make the date format show the date in CET (central European time)
df.setTimeZone(TimeZone.getTimeZone("GMT +2"));

String text = df.format(timestamp1);
        	                        
                                    //  if (timestamp1 != null){
                                      //  date = new java.util.Date(timestamp1.getTime());}                    				 
                                        model.addRow(new Object[]{u,text,enum1,enum2,n});
                                          
                                   }   
                     panel4_2.add((new JScrollPane(table)));       
                           CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL6);            
                     
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }  
             
        } else {
            System.out.println("Cancelled");
            CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL5);
        }
   }                                    
                               });
                            }
                             catch(Exception ex){
                              JOptionPane.showMessageDialog(null, ex.getMessage());
 
                                }   
						 }
						 else{
							CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                            cl.show(cards,PANEL1); 
						 }
               // CardLayout cl = (CardLayout) (cards.getLayout());//get cards
               // cl.show(cards,PANEL4);
            }
        });
	    
    sub1Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
        
		    String ti=titleField.getText();
                    String be=belField.getText();
                    String tx=txt1.getText();	
                 try{                     
                     String query = "INSERT INTO antikeim " + "VALUES (?,?,?)";
                     pst=conn.prepareStatement(query);  
                     pst.setString(1, ti);
                     pst.setString(2, tx);
                     pst.setString(3, be);                    
                     rs1=pst.executeUpdate();                
                     if (rs1>0){
						 Object[] options1 = {"Yes, please","No, thanks"};
                         int n = JOptionPane.showOptionDialog(null,"Message","Insertion completed successfuly!\n" + "Do you want to make another insertion?",                  
                         JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[1]);
						 if(n==0){
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                             c1.show(cards,PANEL21);
						 }
						 else{
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                             c1.show(cards,PANEL2);
						 }
					 }                   
                   
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL2);
                
            }
    });  
     sub2Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
                    String tx2=txt2.getText();
                    String tom=tomeasField.getText();
                    String af=afmField.getText();					
                    String titl=titlosField.getText();	
                    if(tom.equals("")){
                      tom=null;
                    }
                 try{                     
                     String query = "INSERT INTO tomeas " + "VALUES (?,?,?,?)";
                     pst=conn.prepareStatement(query);     
                     pst.setString(1, af);
                     pst.setString(2, titl);
                     pst.setString(3, tx2);
                     pst.setString(4, tom);                    
                     rs1=pst.executeUpdate();                
                     if (rs1>0){
						 Object[] options2 = {"Yes, please","No, thanks"};
                         int n = JOptionPane.showOptionDialog(null,"Message","Insertion completed successfuly!\n" + "Do you want to make another insertion?",                  
                         JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[1]);
						 if(n==0){
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                             c1.show(cards,PANEL3);
						 }
						 else{
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                             c1.show(cards,PANEL2);
						 }
					 }                   
                   
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL2);
                
            }
    });  
     subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {        
                    
                    createButton.setVisible(false);
                    String us=usernameField.getText();
                    String pas=pasField.getText();
                    String na=nameField.getText();
                    String sur=surField.getText();
                    String reg=regField.getText();
                    String em=emailField.getText();
                  
					
                 try{
                       String value=typeCombo.getSelectedItem().toString();
                     String query = "INSERT INTO user " + "VALUES (?,?,?,?,?,?,?)";                     
                     pst=conn.prepareStatement(query);   
                     pst.setString(1, us);
                     pst.setString(2, pas);
                     pst.setString(3, na);
                     pst.setString(4, sur);
                     pst.setString(5, reg);
                     pst.setString(6, em);
                     pst.setString(7, value);
                     rs1=pst.executeUpdate();                
                     if (rs1>0){
			 Object[] options = {"Yes, please","No, thanks"};
                         int n = JOptionPane.showOptionDialog(null,"Insertion completed successfuly!\n" + "Do you want to make another insertion?", 
                                 "Message",                 
                         JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
						 if(n==0){
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                                               c1.show(cards,PANEL2);
						 }
						 else{
							 CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                             c1.show(cards,PANEL5);
						 }
					 }                   
                   
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL2);
                
            }
        });
		cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL1);
      }  
    });
	cancel1Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL2);
      }  
    });
	cancel1Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
      }  
    });
		
      JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(insButton);
        buttonPanel.add(ins1Button);
        buttonPanel.add(hisButton);
        frame.add(cards);
        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
  }
 }
 
 
