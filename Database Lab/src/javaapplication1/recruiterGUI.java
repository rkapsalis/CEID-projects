/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

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
import javax.swing.table.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

   public class recruiterGUI extends NewJFrame{
	 //My Profile
     private JTextField usernameField = new JTextField(12);
     private JTextField exp_yearsField = new JTextField(4);
     private JTextField firmField = new JTextField(9);
	 
	 //CompanyProfile
	 private JTextField afmField = new JTextField(9);
     private JTextField douField = new JTextField(15);
	 private JTextField nameField = new JTextField(35);
     private JTextField telephoneField = new JTextField(16);
	 private JTextField streetField = new JTextField(15);
     private JTextField numberField = new JTextField(4);
     private JTextField cityField = new JTextField(15);
	 private JTextField countryField = new JTextField(15);
	 private JTextArea textArea = new JTextArea(10, 15);
	 //Create Position
     private JTextField idField = new JTextField(4);
	 private JTextField start_dateField = new JTextField(10);
     private JTextField moneyField = new JTextField(7);
	 private JTextField posField = new JTextField(40);
	 private JTextField locField = new JTextField(45);
     private JTextField recField = new JTextField(12);
     private JTextField annDateField = new JTextField(19);
	 private JTextField subDateField = new JTextField(10);
	 int plithos=0;
         private JTextField antTitleField = new JTextField(36);
	 private JTextArea antDescField = new JTextArea(10,15);
	 private JTextField antFatherField = new JTextField(36);
	 //MY CURRENT JOB POSITIONS
     private JTextField AllpidField = new JTextField(4);
	 private JTextField Allpstart_dateField = new JTextField(10);
     private JTextField AllmoneyField = new JTextField(7);
	 private JTextField AllposField = new JTextField(40);
	 private JTextField AlllocField = new JTextField(45);
     private JTextField AllrecField = new JTextField(12);
     private JTextField AllannDateField = new JTextField(19);
	 private JTextField AllsubDateField = new JTextField(10);
	 
	 //Interviews
	private JTextField InterviewCandField = new JTextField(12);
	 private JTextField InterviewRecField = new JTextField(12);
     private JTextField InterviewJobIdField = new JTextField(4);
	 private JTextField InterviewIdField = new JTextField(4);
	 private JTextField InterviewDateField = new JTextField(19);
	 private JTextField InterviewDurField = new JTextField(8);
     private JTextArea InterviewComField = new JTextArea(10,15);
     private JTextField InterviewPerField = new JTextField(2);
	 private JTextField InterviewEduField = new JTextField(2);
	 private JTextField InterviewExpField = new JTextField(2);
	 
	 //COMPANYS POSITIONS
     private JTextField CidField = new JTextField(4);
	 private JTextField Cstart_dateField = new JTextField(10);
     private JTextField CmoneyField = new JTextField(7);
	 private JTextField CposField = new JTextField(40);
	 private JTextField ClocField = new JTextField(45);
     private JTextField CrecField = new JTextField(12);
     private JTextField CannDateField = new JTextField(19);
	 private JTextField CsubDateField = new JTextField(10);
	 Object id4=null;
     //JScrollPane sp = new JScrollPane(textArea);
     JScrollPane scrollPane = new JScrollPane(textArea);       
     java.util.Date date;
     //textArea.setEditable(false);
     private JButton editButton1 = new JButton("Edit");
	 private JButton editButton2 = new JButton("Edit");
	 private JButton editButton3 = new JButton("Insert");
	 private JButton editButton4 = new JButton("Edit");
	 private JButton editButton4_1 = new JButton("Insert Eval.");
	  private JButton editButton5 = new JButton("Edit");
           private JButton editButtonSP = new JButton("Interview Results");
	 
     private JButton submitButton1 = new JButton("Submit");
	 private JButton submitButton2 = new JButton("Submit");
	 private JButton submitButton3 = new JButton("Submit");
	 private JButton submitButton4 = new JButton("Submit");
	 private JButton submitButton4_1 = new JButton("Submit");
	 private JButton submitButton5 = new JButton("Submit");
         
     private JButton cancelButton1 = new JButton("Cancel");
	 private JButton cancelButton2 = new JButton("Cancel");
	 private JButton cancelButton3 = new JButton("Cancel");
	 private JButton cancelButton4 = new JButton("Cancel");
	 private JButton cancelButton4_1 = new JButton("Cancel");
          private JButton cancelButton5 = new JButton("Cancel");
            private JButton cancelButton10 = new JButton("Cancel");
            private JButton cancelButton555 = new JButton("Back");
            
	 private JButton applyButton1 = new JButton("Apply");
	 private JButton applyButton2 = new JButton("Apply");
	 private JButton applyButton3 = new JButton("Apply");
	 private JButton applyButton4 = new JButton("Apply");
	 private JButton applyButton5 = new JButton("Proceed"); 
     //private JButton appButton = new JButton("My applications");
     private JButton aplButton = new JButton("Submit");
     private JButton canButton = new JButton("Cancel");
    NewJFrame r;

	private final static String PANELA = "panel A";
    private final static String PANEL1 = "panel 1";
    private final static String PANEL2 = "panel 2";
    private final static String PANEL3 = "panel 3";
    private final static String PANEL4 = "panel 4";
	private final static String PANEL5 = "panel 5";
        private final static String PANELR4_1 = "panel R4_1";
        private final static String PANEL6 = "panel 6";
         private final static String PANEL10 = "panel 10";
          private final static String PANELSP = "panel SP";
          private final static String PANEL7 = "panel 7";
            private final static String PANEL8 = "panel 8";
    Connection connect=null;
    Statement state=null;
    PreparedStatement prepstate=null;
    PreparedStatement prepstate1=null;
    PreparedStatement prepstate2=null;
    PreparedStatement prepstate3=null;
    ResultSet ress=null;
     int ress1=0;
      ResultSet ress2=null;
       ResultSet ress3=null;
      int count1=0 ;
	  int count2=0;
	  int count3=0;
	  int count4=0;
	  int count5=0;
    int  count4_1=0;
    
  public  recruiterGUI() {
   connect=project.ConnectDb(); 
   initialComponents(); 
  }
	
  protected JPanel initialFieldEtaireias() {
      JPanel panelR1 = new JPanel();
      panelR1.setLayout(new MigLayout());
      panelR1.setBackground(new java.awt.Color(103,177,234));
      panelR1.add(new JLabel("AFM: "), "align label"); 
      panelR1.add(afmField, "wrap");
      afmField.setEnabled(true);
      afmField.setEditable(false);
      
      panelR1.add(new JLabel("DOY: "), "align label");
       panelR1.add(douField, "wrap");
      douField.setEnabled(true);
      douField.setEditable(false);
      
      panelR1.add(new JLabel("Name: "), "align label");
      panelR1.add(nameField, "wrap");
      nameField.setEnabled(true);
      nameField.setEditable(false);
   
      panelR1.add(new JLabel("Telephone: "), "align label");
       panelR1.add(telephoneField, "wrap");
       telephoneField.setEnabled(true);
       telephoneField.setEditable(false);
	   
	   panelR1.add(new JLabel("Street: "), "align label");
       panelR1.add(streetField, "wrap");
       streetField.setEnabled(true);
       streetField.setEditable(false);
	   
	   panelR1.add(new JLabel("Number: "), "align label");
       panelR1.add(numberField, "wrap");
       numberField.setEnabled(true);
       numberField.setEditable(false);
	   
	   panelR1.add(new JLabel("City: "), "align label");
       panelR1.add(cityField, "wrap");
       cityField.setEnabled(true);
       cityField.setEditable(false);
	   
	   panelR1.add(new JLabel("Country: "), "align label");
       panelR1.add(countryField, "wrap");
       countryField.setEnabled(true);
       countryField.setEditable(false);   
	   
       panelR1.add(initialButtons1());
    
       return panelR1;
  }
  
    protected JPanel initialFieldProfile() {
      JPanel panelR2 = new JPanel();
      panelR2.setLayout(new MigLayout());
      panelR2.setBackground(new java.awt.Color(103,177,234));
      panelR2.add(new JLabel("Username: "), "align label"); 
      panelR2.add(usernameField, "wrap");
      usernameField.setEnabled(true);
      usernameField.setEditable(false);
      
      panelR2.add(new JLabel("Years of Experience: "), "align label");
      panelR2.add(exp_yearsField, "wrap");  
      exp_yearsField.setEnabled(true);
      exp_yearsField.setEditable(false);
      
      panelR2.add(new JLabel("Firm Name: "), "align label");
      panelR2.add(firmField, "wrap");
      firmField.setEnabled(true);
      firmField.setEditable(false);  
	   
       panelR2.add(initialButtons2());
    
       return panelR2;
  }
  
      protected JPanel initialFieldCreatePosition() {//TO CREATEEE
      JPanel panelR3 = new JPanel();
      panelR3.setLayout(new MigLayout());
      panelR3.setBackground(new java.awt.Color(103,177,234));
      panelR3.add(new JLabel("Job id: "), "align label"); 
      panelR3.add(idField, "wrap");
      idField.setEnabled(true);   
      idField.setEditable(false);
      
      panelR3.add(new JLabel("Start Date "), "align label");
      panelR3.add(start_dateField, "wrap");
      start_dateField.setEnabled(true);
      start_dateField.setEditable(true);
      
      panelR3.add(new JLabel("Salary: "), "align label");
      panelR3.add(moneyField, "wrap");
      moneyField.setEnabled(true);
      moneyField.setEditable(true);
	  
	        panelR3.add(new JLabel("Position: "), "align label");
      panelR3.add(posField, "wrap");
      posField.setEnabled(true);
      posField.setEditable(true);
	  
	        panelR3.add(new JLabel("Location: "), "align label");
      panelR3.add(locField, "wrap");
      locField.setEnabled(true);
      locField.setEditable(true);
	  
	        panelR3.add(new JLabel("Recruiter: "), "align label");
      panelR3.add(recField, "wrap");
      recField.setEnabled(true);
      recField.setEditable(false);
	  
	        panelR3.add(new JLabel("Anounce Date: "), "align label");
      panelR3.add(annDateField, "wrap");
      annDateField.setEnabled(true);
      annDateField.setEditable(true);
	  
	        panelR3.add(new JLabel("Submission Date: "), "align label");
      panelR3.add(subDateField, "wrap");
      subDateField.setEnabled(true);
      subDateField.setEditable(true);
      panelR3.add(new JLabel("Antikeim Title: "), "align label");      
      panelR3.add(antTitleField, "wrap");
      antTitleField.setEnabled(true);
      antTitleField.setEditable(true);
	  
	  panelR3.add(new JLabel("Description: "), "align label");
      panelR3.add(antDescField, "wrap");
      antDescField.setEnabled(true);
      antDescField.setEditable(true);
	  
	  panelR3.add(new JLabel("Antikeim Belongs to: "), "align label");
      panelR3.add(antFatherField, "wrap");
      antFatherField.setEnabled(true);
      antFatherField.setEditable(true);

	   
       panelR3.add(initialButtons3());
    
       return panelR3;
  }
  

  protected JPanel initialFieldInterviews() {  //*********************panel gia interviews
      JPanel panelR4_2 = new JPanel();
      panelR4_2.setLayout(new MigLayout());
      panelR4_2.setBackground(new java.awt.Color(103,177,234));
      panelR4_2.add(new JLabel("Candidate: "), "align label"); 
      panelR4_2.add(InterviewCandField, "wrap");
      InterviewCandField.setEnabled(true);
      InterviewCandField.setEditable(true);
      
      panelR4_2.add(new JLabel("Recruiter: "), "align label");
      panelR4_2.add(InterviewRecField, "wrap");  
      InterviewRecField.setEnabled(true);
      InterviewRecField.setEditable(false);
      
      panelR4_2.add(new JLabel("Job id: "), "align label");
      panelR4_2.add(InterviewJobIdField, "wrap");
      InterviewJobIdField.setEnabled(true);
      InterviewJobIdField.setEditable(false);  
	   
    /*  panelR4_2.add(new JLabel("Interview id: "), "align label");
      panelR4_2.add(InterviewIdField, "wrap");
      InterviewIdField.setEnabled(true);
      InterviewIdField.setEditable(false); */
	  
	  panelR4_2.add(new JLabel("Interview Date : "), "align label");
      panelR4_2.add(InterviewDateField, "wrap");
      InterviewDateField.setEnabled(true);
      InterviewDateField.setEditable(true);
	  
      panelR4_2.add(new JLabel("Duration: "), "align label");
      panelR4_2.add(InterviewDurField, "wrap");
      InterviewDurField.setEnabled(true);
      InterviewDurField.setEditable(true);
	  
	  panelR4_2.add(new JLabel("Comments: "), "align label");
      panelR4_2.add(InterviewComField, "wrap");
      InterviewComField.setEnabled(true);
      InterviewComField.setEditable(true);
	  
	  panelR4_2.add(new JLabel("Personality: "), "align label");
      panelR4_2.add(InterviewPerField, "wrap");
      InterviewPerField.setEnabled(true);
      InterviewPerField.setEditable(true);
	  
	  panelR4_2.add(new JLabel("Education: "), "align label");
      panelR4_2.add(InterviewEduField, "wrap");
      InterviewEduField.setEnabled(true);
      InterviewEduField.setEditable(true);
	  
  	  panelR4_2.add(new JLabel("Experience: "), "align label");
      panelR4_2.add(InterviewExpField, "wrap");
      InterviewExpField.setEnabled(true);
      InterviewExpField.setEditable(true);
	   
       panelR4_2.add(initialButtons4());
    
       return panelR4_2;
  }
  
  
  
  
  //************************************************************************************prepei na ftiaksw kai to R5
  private JPanel initialButtons1() {
      JPanel editPanelButton1 = new JPanel();
      editPanelButton1.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      editPanelButton1.add(editButton1);
      editPanelButton1.add(submitButton1);
      editPanelButton1.add(cancelButton1);

      return editPanelButton1;
   }  
   
     private JPanel initialButtons2() {
      JPanel editPanelButton2 = new JPanel();
      editPanelButton2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      editPanelButton2.add(editButton2);
      editPanelButton2.add(submitButton2);
      editPanelButton2.add(cancelButton2);

      return editPanelButton2;
   }  
   
     private JPanel initialButtons3() {
      JPanel editPanelButton3 = new JPanel();
      editPanelButton3.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      //editPanelButton3.add(editButton3);
      editPanelButton3.add(submitButton3);
      editPanelButton3.add(cancelButton3);

      return editPanelButton3;
   }  
   
     private JPanel initialButtons4() {
      JPanel editPanelButton4 = new JPanel();
      editPanelButton4.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));     
      //editPanelButton4.add(editButton4);
     // editPanelButton4.add(submitButton4);
      editPanelButton4.add(submitButton4_1);
      editPanelButton4.add(cancelButton10);
    //  editPanelButton4.add(editButton4_1);
          //editPanelButton4.add(editButtonSP);
      return editPanelButton4;
   }  
   
     private JPanel initialButtons5() {
      JPanel editPanelButton5 = new JPanel();
      editPanelButton5.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      editPanelButton5.add(editButton5);
      editPanelButton5.add(submitButton5);
      editPanelButton5.add(cancelButton5);
      editPanelButton5.add(applyButton5);
      editPanelButton5.add(cancelButton555);
      return editPanelButton5;
   }  
   
   
    
  private void initialComponents(){// **********************************PANELS CHECK AUTO EINAI TO ARXIKO PANEL alagh onoma panel r3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  
   ArrayList<String> jobIdList = new ArrayList<String>();
      
      JFrame frame = new JFrame("Recruiter");
      setMaximumSize( new Dimension( 70, 60 ) );
      JPanel panelA = new JPanel();
      panelA.setBackground(new java.awt.Color(78, 108, 157));
      panelA.setPreferredSize(new Dimension(500,300));
      
      JPanel panel1 = new JPanel();
      panel1.setBackground(new java.awt.Color(78, 108, 157));
     // panel1.setPreferredSize(new Dimension(500,300));
     JLabel label10=new JLabel("<html>Welcome " + NewJFrame.s + "!  </br> Please select one of the options to proceed.</html>",SwingConstants.CENTER);
     
      Font f=new Font("Calibri",Font.BOLD,20);
      label10.setFont(f);
       panelA.add(label10);
	   
	             JButton button1 = new JButton("Company Profile");

                 JButton button2 = new JButton("My Profile");
				 
				 JButton button3 = new JButton("New Job Position");
				 
				 JButton button4 = new JButton("My Created Job Positions");
				 
				 JButton button5 = new JButton("Company Job Positions");
	   
      JPanel panel2 = new JPanel();
      panel2.setBackground(new java.awt.Color(78, 108, 157));
      panel2.setPreferredSize(new Dimension(500,400));
      panel2.setLayout(new BorderLayout(5,5));
      
      JPanel panel3 = new JPanel();
      panel3.setBackground(new java.awt.Color(78, 108, 157));
      panel3.setPreferredSize(new Dimension(500,400));
      panel3.setLayout(new BorderLayout(5,5));
      
      JPanel panel4 = new JPanel();
      panel4.setBackground(new java.awt.Color(78, 108, 157));
      panel4.setPreferredSize(new Dimension(500,400));
      panel4.setLayout(new BorderLayout(5,5));
      
      JPanel panel5 = new JPanel();
      panel5.setBackground(new java.awt.Color(78, 108, 157));
      panel5.setPreferredSize(new Dimension(500,400));
      panel5.setLayout(new BorderLayout(5,5));
      DefaultTableModel modelJ5 =new DefaultTableModel();
	  JPanel panel800 = new JPanel();
	  panel800.setBackground(new java.awt.Color(78, 108, 157));
      panel800.setPreferredSize(new Dimension(500,400));
      panel800.setLayout(new BorderLayout(5,5));
	  panel5.add(panel800,BorderLayout.CENTER);
          JPanel panel2000 = new JPanel();
          panel2000.add(editButton5);
          panel5.add(panel2000,BorderLayout.SOUTH);
          panel5.add(panel800,BorderLayout.CENTER);
        
      panel800.setBorder(new TitledBorder(new EtchedBorder(),"Company's Jobs"));
      modelJ5.addColumn("ID");     
      modelJ5.addColumn("Start date");
      modelJ5.addColumn("Salary");
      modelJ5.addColumn("Position");  
      modelJ5.addColumn("Location");
      modelJ5.addColumn("Recruiter");
      modelJ5.addColumn("Announce Date"); 
      modelJ5.addColumn("Submission Date");
	  JTable tableJ5 = new JTable(modelJ5); 
       DefaultTableModel modelJ5_edit =new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
        if (column == 1 || column==7 )  {return false;}
		else
		{return true;}}
      };
        JPanel panel7 = new JPanel();
      panel7.setBackground(new java.awt.Color(78, 108, 157));
      panel7.setPreferredSize(new Dimension(500,400));
      panel7.setLayout(new BorderLayout(5,5));
	  JPanel panelR900 = new JPanel();
	  panelR900.setBackground(new java.awt.Color(78, 108, 157));
      panelR900.setPreferredSize(new Dimension(500,400));
      panelR900.setLayout(new BorderLayout(5,5));
       panel7.add(panelR900,BorderLayout.CENTER);
        JPanel panel3000 = new JPanel();
          panel3000.add(applyButton5);
          panel3000.add(cancelButton5);
          panel7.add(panel3000,BorderLayout.SOUTH);
      panelR900.setBorder(new TitledBorder(new EtchedBorder(),"My Jobs"));
      modelJ5_edit.addColumn("Select"); 
      modelJ5_edit.addColumn("ID");     
      modelJ5_edit.addColumn("Start date");
      modelJ5_edit.addColumn("Salary");
      modelJ5_edit.addColumn("Position");  
      modelJ5_edit.addColumn("Location");
      modelJ5_edit.addColumn("Recruiter");
      modelJ5_edit.addColumn("Announce Date"); 
      modelJ5_edit.addColumn("Submission Date");
	  JTable tableJ5_edit = new JTable(modelJ5_edit);
          JPanel panel8 = new JPanel();
      panel8.setBackground(new java.awt.Color(78, 108, 157));
      panel8.setPreferredSize(new Dimension(500,400));
      panel8.setLayout(new BorderLayout(5,5));
       JPanel panelR1000 = new JPanel();
	  panelR1000.setBackground(new java.awt.Color(78, 108, 157));
      panelR1000.setPreferredSize(new Dimension(500,400));
      panelR1000.setLayout(new BorderLayout(5,5));
       panel8.add(panelR1000,BorderLayout.CENTER);
        JPanel panel4000 = new JPanel();
          panel4000.add(submitButton5);
          panel4000.add(cancelButton555);
          panel8.add(panel4000,BorderLayout.SOUTH);
       JPanel panel6 = new JPanel();
      panel6.setBackground(new java.awt.Color(78, 108, 157));
      panel6.setPreferredSize(new Dimension(500,400));
      panel6.setLayout(new BorderLayout(5,5));
      
      JPanel panel10 = new JPanel();
      panel10.setBackground(new java.awt.Color(78, 108, 157));
      panel10.setPreferredSize(new Dimension(500,400));
      panel10.setLayout(new BorderLayout(5,5));
      
	  JPanel panel15=new JPanel();
      panel2.add(panel15,BorderLayout.NORTH);
      panel15.add(new JLabel("Choose an option to continue")) ;  
                      
	  JPanel panel2_1=new JPanel((new MigLayout()));// TA ARXIKA KOUMPIA
      //panel2_1.setLayout(new MigLayout());
      panel2_1.setBackground(new java.awt.Color(103,177,234));
      panel2.add(panel2_1,BorderLayout.NORTH);//h NORTH
	  panel2_1.add(button1,"gap unrelated");
	  panel2_1.add(button2,"gap unrelated");
	  panel2_1.add(button3,"gap unrelated");
	  panel2_1.add(button4,"gap unrelated");
	  panel2_1.add(button5,"gap unrelated");
	  
	  
        //CREATEDDDDDD
    //  JPanel panelR4 = new JPanel();
      
      //****************************************************************************************************************************************************************** TABLE GIA CURRENT JOB POSITIONS*******************
      DefaultTableModel modelJ =new DefaultTableModel(){
		@Override
	public boolean isCellEditable(int row, int column) {
        if (column == 3 || column==8 )  return false;
		return true;
        } } ; 
      //panelR4.setLayout(new BorderLayout(5,5));
      //panelR4.add(this.initialFieldCreatedPosition(),BorderLayout.SOUTH);
      TableColumnModel colmodel;
      //DefaultTableModel modelJ =new DefaultTableModel();   
      scrollPane.setPreferredSize(new Dimension(380, 100));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      JPanel panelR4_1 = new JPanel();
      panelR4_1.setBackground(new java.awt.Color(78, 108, 157));
      panelR4_1.setPreferredSize(new Dimension(500,400));
      panelR4_1.setLayout(new BorderLayout(5,5));
      JPanel panel300 = new JPanel();
      //panelR4_1.add(panel300,BorderLayout.SOUTH);
      panel4.add(panel300,BorderLayout.SOUTH);
      
    //  panel300.add(cancelButton10);
     //  panel300.add(submitButton4_1);
     
      panel300.add(editButton4);
	  panel300.add(editButton4_1);           
          panel300.add(editButtonSP);
          JPanel panel350 = new JPanel();
      panel350.add(submitButton4);
       panel350.add(cancelButton4);
      panelR4_1.add(panel350,BorderLayout.SOUTH);
         // panel300.add(new JLabel("else"));
      // panelR4_1.add(initialButtons4(),BorderLayout.SOUTH);
     //  panel4.setBorder(new TitledBorder
      //(new EtchedBorder(),"My Jobs"));
        modelJ.addColumn("Check all");
      modelJ.addColumn("Sum");
      modelJ.addColumn("Status");
      modelJ.addColumn("ID");     
      modelJ.addColumn("Start date");
      modelJ.addColumn("Salary");
      modelJ.addColumn("Position");  
      modelJ.addColumn("Location");
      modelJ.addColumn("Recruiter");
      modelJ.addColumn("Announce Date"); 
      modelJ.addColumn("Submission Date");
      JTable tableJ = new JTable(modelJ);  
    
       
    //  panel4.add(initialButtons4(),BorderLayout.NORTH);
      
      JPanel panel100 =new JPanel();
       panel100.setLayout(new BorderLayout());
      panel100.setBackground(new java.awt.Color(103,177,234));
      panel4.add(panel100,BorderLayout.CENTER);
	  
   
     // JScrollPane scrollpane1 = new JScrollPane(tableJ);
     // add(new JScrollPane(tableJ)); 
      
      TableColumnModel colmodel_edit;//****************************************************************************************************************************************************************** TABLE GIA CURRENT JOB POSITIONS*******************
      DefaultTableModel modelJ_edit =new DefaultTableModel(){
		@Override
		public boolean isCellEditable(int row, int column) {
        if (column == 0 || column==6 )  {return false;}
		else
		{return true;}}
      };
      panelR4_1.setBorder(new TitledBorder
      (new EtchedBorder(),"My Jobs"));
      modelJ_edit.addColumn("ID");     
      modelJ_edit.addColumn("Start date");
      modelJ_edit.addColumn("Salary");
      modelJ_edit.addColumn("Position");  
      modelJ_edit.addColumn("Location");
      modelJ_edit.addColumn("Recruiter");
      modelJ_edit.addColumn("Announce Date"); 
      modelJ_edit.addColumn("Submission Date");
	   JTable tableJ_edit = new JTable(modelJ_edit);
           JPanel panel200 =new JPanel();
       panel200.setLayout(new BorderLayout());
      panel200.setBackground(new java.awt.Color(103,177,234));
      panelR4_1.add(panel200,BorderLayout.CENTER);
	  
      JPanel panelSP = new JPanel();
        panelSP.setBackground(new java.awt.Color(78, 108, 157));
      panelSP.setPreferredSize(new Dimension(500,400));
      panelSP.setLayout(new BorderLayout(5,5));
      TableColumnModel colmodel_SP;//****************************************************************************************************************************************************************** TABLE GIA CURRENT JOB POSITIONS*******************
      DefaultTableModel modelSP =new DefaultTableModel(){
		@Override
	public boolean isCellEditable(int row, int column) {
        if (column == 3 || column==8 )  return false;
		return true;
        } } ;
    
            JPanel panelSP_1 =new JPanel();
       panelSP_1.setLayout(new BorderLayout());
      panelSP_1.setBackground(new java.awt.Color(103,177,234));
      panelSP.add(panelSP_1,BorderLayout.CENTER);
      scrollPane.setPreferredSize(new Dimension(380, 100));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       panelSP.setBorder(new TitledBorder
      (new EtchedBorder(),"Show Results"));
	  modelSP.addColumn("Candidate");
	  modelSP.addColumn("Total Interviews");
	  modelSP.addColumn("Personality");
	  modelSP.addColumn("Education");
	  modelSP.addColumn("Experience");
	  modelSP.addColumn("Total Grade");
	  modelSP.addColumn("Rejected");
	  modelSP.addColumn("Rejection Reason");

	   
     // panelSP.add(initialButtons4());
      
	  
      JTable tableSP = new JTable(modelSP);
      JScrollPane scrollpaneSP = new JScrollPane(tableSP);
      scrollpaneSP.add(new JScrollPane(tableSP));
	  
      //JScrollPane scrollpanel2= new JScrollPane(tableJ_edit);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
      
					final JPanel cardsR = new JPanel(new CardLayout());
                                        cardsR.add(panelA, PANELA);
                                   cardsR.add(panel1, PANEL1);
                                  cardsR.add(panel2, PANEL2);
				 cardsR.add(panel3, PANEL3);
				 cardsR.add(panel4, PANEL4);
				 cardsR.add(panel5, PANEL5);
                                  cardsR.add(panelR4_1, PANELR4_1);
                                  cardsR.add(panel6, PANEL6);
                                   cardsR.add(panel10, PANEL10);
                                  cardsR.add(panelSP, PANELSP);
                                  cardsR.add(panel7, PANEL7);
                                  cardsR.add(panel8, PANEL8);
                   CardLayout cl = (CardLayout) (cardsR.getLayout());//get cards
                  // cl.show(panel3,PANEL3);
    
				 
				 
					button1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {//koumpia pou emfanizontai pantou***********************************1o button********************
					editButton1.setVisible(true);
					cancelButton1.setVisible(false);
					submitButton1.setVisible(false);
                
					count1++;
					if(count1>0 ){
					panel1.removeAll();//********************O panelR4 einai tou my current job positions CREATEDDDD
					textArea.setText(null);
					}                        
                       
					try{
                     
                     String query = "SELECT etaireia.* FROM recruiter INNER join etaireia ON recruiter.firm=etaireia.AFM WHERE recruiter.username=?";
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
                     prepstate.setString(1, NewJFrame.s);//to s einai metablhth mesa sto newjframe
                     ress=prepstate.executeQuery(); //orizoume to ress result set dld pou epistrefei

                     while(ress.next()){ // h while leitoyrgei san cursor ress metablhth
                     String a = ress.getString("AFM");//ress einai to result  set pou 8eleis na sou emfanisei. to a 8a apo8hkeusei to prwto ths sthlhs tou  username
                     String b = ress.getString("DOY");
                     String c = ress.getString("name");
                     long d = ress.getLong("tel");
					 String e = ress.getString("street");
					 int f = ress.getInt("num");
					 String g = ress.getString("city");
					 String h = ress.getString("country"); //************************************************************************************************************************************************
                     //modelJ.addRow(new Object[]{a,b,c,d});
                     afmField.setText(a);
					 douField.setText(b);
					 nameField.setText(c);
                     //textArea.append(d );//MEGALWNEI TO MHKOS TOU TEXT OSO 8ELOUME
                     telephoneField.setText(String.valueOf(d));// edw 8a emfanisei sto aspro keno to string pou delw
                     streetField.setText(e);
					 numberField.setText(String.valueOf(f));
					 cityField.setText(g);
					 countryField.setText(h);
                     //textArea.setCaretPosition(textArea.getDocument().getLength());        //BOH8AEI STO MHKOS TOU TEXT            
                                          
                     }

                    panel1.add(initialFieldEtaireias(),BorderLayout.NORTH);

                    button1.setVisible(false);
                    button2.setVisible(true); //KOUMPIA GIA TA ALLA MENU************************************
					button3.setVisible(true);
					button4.setVisible(true);
					button5.setVisible(true);
					
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cardsR.getLayout());//get cards
                c1.show(cardsR,PANEL1);
                
            }
        });
		
      editButton1.addActionListener(new ActionListener() { //*********************************EDIT BUTTON etaireias
      @Override
      public void actionPerformed(ActionEvent ae){
        editButton1.setVisible(false);
        submitButton1.setVisible(true);
        cancelButton1.setVisible(true);
		afmField.setEditable(false);
		 douField.setEditable(false);
		 nameField.setEditable(false);
         telephoneField.setEditable(true);
         streetField.setEditable(true);
		 numberField.setEditable(true);
		 cityField.setEditable(true);
		countryField.setEditable(true);
        button1.setVisible(false);
        button2.setVisible(true); 
		button3.setVisible(true);
		button4.setVisible(true);
		button5.setVisible(true);
      }  
    });
	
	
    submitButton1.addActionListener(new ActionListener() {///////////////////////////////SUBMIT BUTTON etaireias
      @Override
      public void actionPerformed(ActionEvent ae){
                int a1 = Integer.parseInt(afmField.getText());
		int afm = a1;
		String dou = douField.getText();
		String name = nameField.getText();
                Long a2 = Long.parseLong(telephoneField.getText());
                Long telep =a2;
                String str = streetField.getText();
                int a3 = Integer.parseInt(numberField.getText());
		int number = a3;
		String city = cityField.getText();
		String country = countryField.getText();
        try{
         String query = "UPDATE etaireia SET tel=?,street=?,num=?,city=?,country=? WHERE AFM=? ";
         prepstate=connect.prepareStatement(query);       
         prepstate.setLong(1,telep);
         prepstate.setString(2, str);
         prepstate.setInt(3,number);
         prepstate.setString(4, city);
		 prepstate.setString(5,country);
		 prepstate.setInt(6,afm);
         ress1=prepstate.executeUpdate();
         
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout cl = (CardLayout) (cardsR.getLayout());//get cards
                cl.show(cardsR,PANELA);//******************************************************************************ti kanei?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                
      }  
    });  
	
	
     cancelButton1.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout cl = (CardLayout) (cardsR.getLayout());//get cards
                cl.show(cardsR,PANEL1);
      }  
    }); 
	
					 //***************************************************************************************************************************************
					 //******************************************************************************************************2o button!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					 
					 button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {//koumpia pou emfanizontai pantou
					editButton2.setVisible(true);
					cancelButton2.setVisible(false);
					submitButton2.setVisible(false);
                
					count2++;
					if(count2>0 ){
					panel2.removeAll();//********************O panelR4 einai tou my current job positions CREATEDDDD
					textArea.setText(null);
					}                        
                       
					try{
                     
                     String query = "SELECT * FROM recruiter WHERE recruiter.username=?";
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
                     prepstate.setString(1, NewJFrame.s);//to s einai metablhth mesa sto newjframe
                     ress=prepstate.executeQuery(); //orizoume to ress result set dld pou epistrefei

                     while(ress.next()){ // h while leitoyrgei san cursor ress metablhth
                     String usr = ress.getString("Username");//ress einai to result  set pou 8eleis na sou emfanisei. to a 8a apo8hkeusei to prwto ths sthlhs tou  username
                     String yea = ress.getString("exp_years");
                     String fir = ress.getString("firm");
                     usernameField.setText(usr);
					 exp_yearsField.setText(yea);
					 firmField.setText(fir);                                                  
                     }

                    panel2.add(initialFieldProfile(),BorderLayout.NORTH);

                    button1.setVisible(true);
                    button2.setVisible(false); //KOUMPIA GIA TA ALLA MENU************************************
					button3.setVisible(true);
					button4.setVisible(true);
					button5.setVisible(true);
					
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c2 = (CardLayout) (cardsR.getLayout());//get cards
                c2.show(cardsR,PANEL2);
                
            }
        });
		
      editButton2.addActionListener(new ActionListener() { //*********************************EDIT BUTTON PROFILE
      @Override
      public void actionPerformed(ActionEvent ae){
        editButton2.setVisible(false);
        submitButton2.setVisible(true);
        cancelButton2.setVisible(true);
		
		 usernameField.setEditable(false);
		 exp_yearsField.setEditable(true);
         firmField.setEditable(true);
        button1.setVisible(true);
        button2.setVisible(false); 
		button3.setVisible(true);
		button4.setVisible(true);
		button5.setVisible(true);
      }  
    });
	
	
    submitButton2.addActionListener(new ActionListener() {///////////////////////////////SUBMIT BUTTON etaireias
      @Override
      public void actionPerformed(ActionEvent ae){
		String u1 = usernameField.getText();
		String y1 = exp_yearsField.getText();
        String f1 =firmField.getText();
		
        try{
         String query = "UPDATE recruiter SET exp_years=?,firm=? WHERE username=? ";
         prepstate=connect.prepareStatement(query);       
         prepstate.setString(1,y1);
         prepstate.setString(2, f1);
         prepstate.setString(3,u1);
         ress1=prepstate.executeUpdate();
         
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout c2 = (CardLayout) (cardsR.getLayout());//get cards
                c2.show(cardsR,PANEL2);
                
      }  
    });  
	
	
     cancelButton2.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON  PROFILE
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout c2 = (CardLayout) (cardsR.getLayout());//get cards
                c2.show(cardsR,PANEL2);
      }  
    }); 
	//********************************************************************************************************************************************** 3o BUTTON*******************************
	
						 button3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {//koumpia pou emfanizontai pantou
					//editButton3.setVisible(true);
					cancelButton3.setVisible(true);
					//submitButton3.setVisible(false);
                                       
					count3++;
					if(count3>0 ){
					panel3.removeAll();
					//textArea.setText(null);
					}     
		                        recField.setText(NewJFrame.s);
					try{
                     panel3.add(initialFieldCreatePosition(),BorderLayout.NORTH);
					 }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
					}   
					 					 

                    button1.setVisible(true);
                    button2.setVisible(true); //KOUMPIA GIA TA ALLA MENU************************************
					button3.setVisible(false);
					button4.setVisible(true);
					button5.setVisible(true);
					
                CardLayout c3 = (CardLayout) (cardsR.getLayout());//get cards
                c3.show(cardsR,PANEL3);
                
            }
        });    
	
	    submitButton3.addActionListener(new ActionListener() {///////////////////////////////SUBMIT BUTTON INSERT NEW JOB
      @Override
      public void actionPerformed(ActionEvent ae){
		  
					String id1 = idField.getText();
					String startD1 =start_dateField.getText();
					String money1 = moneyField.getText();
					String pos1 = posField.getText();
					String loc1 =locField.getText();
					String rec4 = recField.getText();
					String aD1 = annDateField.getText();
					String sD1 =subDateField.getText();                                        
					String aT =antTitleField.getText();
					String aD =antDescField.getText();	
					String aF =antFatherField.getText();
		                         cancelButton3.setVisible(true);
                                          submitButton3.setVisible(true);
        try{
           String query = "INSERT INTO job VALUES (DEFAULT,?,?,?,?,?,?,?)";
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
								//prepstate.setString(1,id1);
								prepstate.setString(1, startD1);
								prepstate.setString(2,money1);
						                prepstate.setString(3,pos1);
								prepstate.setString(4, loc1);
								prepstate.setString(5,rec4);
								prepstate.setString(6,aD1);
								prepstate.setString(7, sD1);
	 
                     ress1=prepstate.executeUpdate(); //orizoume to ress result set dld pou epistrefei
                     
					 String query25 = "INSERT INTO antikeim VALUES (?,?,?)";
                     prepstate=connect.prepareStatement(query25);// kanei connection kai tsekarei to query
                     prepstate=connect.prepareStatement(query25);// kanei connection kai tsekarei to query
								prepstate.setString(8, aT);
								prepstate.setString(9,aD);
						        prepstate.setString(10,aF);

	 
                     ress1=prepstate.executeUpdate();
         
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout c3 = (CardLayout) (cardsR.getLayout());//get cards
                c3.show(cardsR,PANEL3);
                
      }  
    });
	cancelButton3.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON  JOB INSERT
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout c3 = (CardLayout) (cardsR.getLayout());//get cards
                c3.show(cardsR,PANEL3);
      }  
    });
	
	button4.addActionListener(new ActionListener() { //*********************************************************************************4o BUTTON Createddddd*************************************************************************
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
				
					editButton4.setVisible(true);
					cancelButton4.setVisible(false);
					submitButton4.setVisible(false);
					//submitButton4_1.setVisible(false);
					editButton4_1.setVisible(true);
					//cancelButton10.setVisible(false);
					if(count4>0 ){
                                         modelJ.setRowCount(0);   
					panel100.removeAll();
					//textArea.setText(null);
                                        
					}  
	                                count4++;
                                        try{                                       
					
                                          String query4 = "SELECT * FROM job WHERE recruiter =?";
                                          prepstate=connect.prepareStatement(query4);
                                         prepstate.setString(1, NewJFrame.s);
                                         ress=prepstate.executeQuery();                                          
					 
                     while(ress.next()){
						int id2 = ress.getInt("id");
						Date sD2 = ress.getDate("start_date"); // ALLAGH APO STRING SE ALLO SOSOSOSOSOSOSOSOSOSOSOSOSOSOSOSOSOSOSOS SOS
						Float money2 = ress.getFloat("salary");  //TO IDIO KAI EDW
						String pos2 = ress.getString("position");
						String loc2 = ress.getString("edra");
						String rec2 = ress.getString("recruiter");                     
						Timestamp timestamp = ress.getTimestamp("announce_date");
						if (timestamp != null){
						date = new java.util.Date(timestamp.getTime());
                                                }
						Date subDate = ress.getDate("submission_date");			
						String status ;
						//DateFormat currDate = new SimpleDateFormat("yyyy-MM-dd");
						//Date date = new Date();
						//currDate.format(date); auto einai h hmeromhnia tou shmera
                                                long millis=System.currentTimeMillis();  
                                                java.sql.Date cur_date=new java.sql.Date(millis);
						int result = subDate.compareTo( cur_date );
					 if (result==0){status="Closed";}
					 else if (result>0){status="Open";}
					 else {status="Closed ";}

					 String query7 = "SELECT COUNT(*) AS plithos FROM applies WHERE job_id=?";//************COUNT
                                         prepstate1=connect.prepareStatement(query7);// kanei connection kai tsekarei to query
                     prepstate1.setInt(1, id2);//to s einai metablhth mesa sto newjframe
                     ress2=prepstate1.executeQuery(); //orizoume to ress result set dld pou epistrefei
                     //int plithos=0;
                     while(ress2.next()){
					  plithos = ress2.getInt("plithos");}
					 
                     modelJ.addRow(new Object[]{new Boolean(false),plithos,status,id2,sD2,money2,pos2,loc2,rec2,timestamp,subDate});
					// panel4.add(modelJ);
                     }		     
                     TableColumn tabc = tableJ.getColumnModel().getColumn(0);//******************************************************ti kanei edw
                     tabc.setCellEditor(tableJ.getDefaultEditor(Boolean.class));
                     tabc.setCellRenderer(tableJ.getDefaultRenderer(Boolean.class));
                     
                     panel100.add((new JScrollPane(tableJ)));                    
                      class MyItemListener implements ItemListener
                      {
                      public void itemStateChanged(ItemEvent e) {
                      Object source = e.getSource();
                      if (source instanceof AbstractButton == false) return;
                      boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                      for(int x = 0, y = tableJ.getRowCount(); x < y; x++)
                      {
                       tableJ.setValueAt(new Boolean(checked),x,0);
                      }
                      }
                      }
                   tabc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
                    button1.setVisible(true);
                    button2.setVisible(false); 
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c4 = (CardLayout) (cardsR.getLayout());//get cards
                c4.show(cardsR,PANEL4);
                
            //}
			        button1.setVisible(true);
                    button2.setVisible(true); //KOUMPIA GIA TA ALLA MENU************************************
					button3.setVisible(true);
					button4.setVisible(false);
					button5.setVisible(true);
   }
        });
			
		
editButton4.addActionListener(new ActionListener() { //*********************************EDIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){ //*********************************************me bash ta poia boxes einai checked 8a kanei edit mono auta
	  
        editButton4.setVisible(true);
        submitButton4.setVisible(true);
	//submitButton4_1.setVisible(false);
        cancelButton4.setVisible(true);
	editButton4_1.setVisible(false);	  
     
		int anychecked =0;
		for(int i=0;i<tableJ.getModel().getRowCount();i++) //κωδικας για να εκτελετειται κατι οταν επιλεγει συγκεκριμενα checkboxes και παταει edit
                  {
                    if ((Boolean) tableJ.getModel().getValueAt(i,0)){ //αν το εχει επιλεξει check box					         
						  Object obj3=tableJ.getValueAt(i,3);
						  Object obj4=tableJ.getValueAt(i,4);
						  Object obj5=tableJ.getValueAt(i,5);
						  Object obj6=tableJ.getValueAt(i,6);
						  Object obj7=tableJ.getValueAt(i,7);
						  Object obj8=tableJ.getValueAt(i,8);
                                                  Object obj9=tableJ.getValueAt(i,9);
						  Object obj10=tableJ.getValueAt(i,10);
						 anychecked =anychecked +1;
						 Object[] row = {obj3, obj4, obj5, obj6, obj7, obj8,obj9,obj10}; //αναθεση τιμων σε σειρα
					modelJ_edit.addRow(row);}
					                   
				  }
					if	(anychecked == 0){
                                            JOptionPane.showMessageDialog(frame,//AN DEN EXEI EPILEKSEI KANENA BOX BGAZEI MHNYMA
						"Choose any position's to edit",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					    }
                                        else{
                                         panel200.add(new JScrollPane(tableJ_edit));
                                          CardLayout c4 = (CardLayout) (cardsR.getLayout());//get cards
                                         c4.show(cardsR,PANELR4_1);
                                        }
		
                button1.setVisible(true);
                button2.setVisible(true); 
		button3.setVisible(true);
		button4.setVisible(false);
		button5.setVisible(true);
      }  
    });
	
	
    submitButton4.addActionListener(new ActionListener() {////////////////////////////////////////////////////////////////////////////////////SUBMIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){
		  for(int i=0;i<tableJ_edit.getModel().getRowCount();i++){
						
						Object id3=tableJ_edit.getValueAt(i,0);
						Object startD3=tableJ_edit.getValueAt(i,1);
						Object money3=tableJ_edit.getValueAt(i,2);
						Object pos3=tableJ_edit.getValueAt(i,3);
						Object loc3=tableJ_edit.getValueAt(i,4);
						Object rec3=tableJ_edit.getValueAt(i,5);
						Object aD3=tableJ_edit.getValueAt(i,6);
						Object sD3=tableJ_edit.getValueAt(i,7);
			  
			  
		
        try{
         String query = "UPDATE job SET id=?,start_date=?,salary=?,position=?,edra=?,recruiter=?,announce_date=?,submission_date=? WHERE job.id=? ";
         prepstate=connect.prepareStatement(query);       
		 
         prepstate.setString(1,String.valueOf(id3));
         prepstate.setString(2, String.valueOf(startD3));
         prepstate.setString(3,String.valueOf(money3));
		 prepstate.setString(4,String.valueOf(pos3));
		 prepstate.setString(5,String.valueOf(loc3));
		 prepstate.setString(6,String.valueOf(rec3));
		 prepstate.setString(7,String.valueOf(aD3));
		 prepstate.setString(8,String.valueOf(sD3));
		 prepstate.setString(9,String.valueOf(id3));
         ress=prepstate.executeQuery();
         
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
		  }}
         CardLayout c4 = (CardLayout) (cardsR.getLayout());//get cards
                c4.show(cardsR,PANEL4);
                
      }  
    });  
	
	
     cancelButton4.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON  CURRJOB
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout c4 = (CardLayout) (cardsR.getLayout());//get cards
                c4.show(cardsR,PANEL4);
      }  
    }); 
//**************************************************************************************************************************************************************************************************************	
			     editButton4_1.addActionListener(new ActionListener() { //*********************************EVALUATION INTERVIEW INSERT BUTTON JOB****************************************************************************
      @Override
      public void actionPerformed(ActionEvent ae){
        editButton4.setVisible(false);
        submitButton4.setVisible(false);
		//submitButton4_1.setVisible(false);
        cancelButton4.setVisible(false);
		editButton4_1.setVisible(true);
		
	 //Object id4=null;
     String idConverted=null;    
	int count_check=0;	
        //int  count4_1=0;
for(int i=0;i<tableJ.getModel().getRowCount();i++) //κωδικας για να εκτελετειται κατι οταν επιλεγει συγκεκριμενα checkboxes και παταει apply
                  {
                           // Object  obj=null;
                    if ((Boolean) tableJ.getModel().getValueAt(i,0)) //αν το εχει επιλεξει 
					   // obj=;//STATUS EINAI STHN 2 STHLH
                    {    if(String.valueOf(tableJ.getValueAt(i,2)).equals("Open")){ 					//αν επιλεξει θέση που είναι ανοιχτη θα του πεταει joption pane με μηνυμα λαθους βλεπε εδω: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
						
						JOptionPane.showMessageDialog(frame,
						"Choose a closed job position",
						"Error",
						JOptionPane.ERROR_MESSAGE);
                                                break;
					    }
						else{ //αν η θέση ειναι κλειστη ολα οκ,αντικατεστησε το query μου με αυτο που ζηταει
							count_check++;
							 id4=tableJ.getValueAt(i,3);
							 idConverted = String.valueOf(id4);
							jobIdList.add(idConverted);// pros8etei ston dynamic pinaka ta id 
				  }//else
				  }//1h if
				  
				  				  
				  }//for
				 if(count_check>0){ JComboBox boxJobId= new JComboBox();
				  for(int j=0; j<jobIdList.size(); j++){
				  boxJobId.addItem(jobIdList.get(j));
                                  
                                  }
				  
					 EventQueue.invokeLater(new Runnable(){
					 @Override
					 public void run(){
						JPanel popPanel= new JPanel(new GridLayout(0,1));
						popPanel.add(new JLabel("Choose a Job ID:"));
						popPanel.add(boxJobId);
					  //  int choice = Integer.parseInt((String) boxJobId.getSelectedItem());
						
						int resultButton= JOptionPane.showConfirmDialog(null,popPanel,"popWindow",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
						if(resultButton== JOptionPane.OK_OPTION){
					
					 editButton1.setVisible(true);
					 cancelButton1.setVisible(false);
					 //submitButton4_1.setVisible(false);
                
					count4_1++;
					if(count4_1>0 ){
					panel6.removeAll();//********************O panelR4 einai tou my current job positions CREATEDDDD
					//textArea.setText(null);
					}                        
                       
					try{
                     
                     String query = "SELECT * FROM interview  WHERE recr_username=? AND job_id=?";
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
                     prepstate.setString(1, NewJFrame.s);//to s einai metablhth mesa sto newjframe
                	 prepstate.setString(2, String.valueOf(id4));
                     ress=prepstate.executeQuery(); //orizoume to ress result set dld pou epistrefei

                     while(ress.next()){ // h while leitoyrgei san cursor ress metablhth
                     String inter1 = ress.getString("cand_username");//ress einai to result  set pou 8eleis na sou emfanisei. to a 8a apo8hkeusei to prwto ths sthlhs tou  username
                     String inter2 = ress.getString("recr_username");
                     String inter3 = ress.getString("job_id");                     
                     int inter4 = ress.getInt("inter_id");
					 String inter5 = ress.getString("inter_date");
					 Time inter6 = ress.getTime("duration");
					 String inter7 = ress.getString("comments");
					 String inter8 = ress.getString("personality");
					 String inter9 = ress.getString("education");
					 String inter10 = ress.getString("experience");
                     
                     InterviewCandField.setText(inter1);
					 
                    //InterviewIdField.setText(inter4);// edw 8a emfanisei sto aspro keno to string pou delw
                     InterviewDateField.setText(inter5);
					 InterviewDurField.setText(String.valueOf(inter6));
					 InterviewComField.append(inter7);//MEGALWNEI TO MHKOS TOU TEXT OSO 8ELOUME
					 InterviewComField.setText(inter7);
					 InterviewPerField.setText(inter8);
					 InterviewEduField.setText(inter9);
					 InterviewExpField.setText(inter10);
                     InterviewComField.setCaretPosition(InterviewComField.getDocument().getLength());        //BOH8AEI STO MHKOS TOU TEXT            
                                          
                     }
                                         InterviewRecField.setText(NewJFrame.s);
					 InterviewJobIdField.setText(String.valueOf(id4));
                    panel6.add(initialFieldInterviews(),BorderLayout.NORTH);

                    button1.setVisible(true);
                    button2.setVisible(true); //KOUMPIA GIA TA ALLA MENU************************************
					button3.setVisible(true);
					button4.setVisible(false);
					button5.setVisible(true);
					
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c4_2 = (CardLayout) (cardsR.getLayout());//get cards
                c4_2.show(cardsR,PANEL6);
                
            }
						}//IF OK BUTTON POPUP------------------------------------------------------------------------------------------------------------------------------------------------
						
                                         }); 	}//telos if check_Count
						
					    if(count_check==0){
						JOptionPane.showMessageDialog(frame,
						"No Job Id's Availables",
						"Error",
						JOptionPane.ERROR_MESSAGE);}
					button1.setVisible(true);
                                       button2.setVisible(true); 
		button3.setVisible(true);
		button4.setVisible(false);
		button5.setVisible(true);
					}
				});			
		submitButton4_1.addActionListener(new ActionListener() {///////////////////////////////SUBMIT BUTTON etaireias
      @Override
      public void actionPerformed(ActionEvent ae){
		 editButton4.setVisible(false);
        submitButton4.setVisible(false);
		submitButton4_1.setVisible(false);
        cancelButton4.setVisible(true);
		editButton4_1.setVisible(false); 
		  
		String cand_user = InterviewCandField.getText();
		String recr_user = InterviewRecField.getText();
		String jId = InterviewJobIdField.getText();
       // String iId =InterviewIdField.getText();
        String idate = InterviewDateField.getText();
		String idur = InterviewDurField.getText();
		String icom = InterviewComField.getText();
		String iper = InterviewPerField.getText();
		String iedu = InterviewEduField.getText();
		String iexp = InterviewExpField.getText();
		int check=0;
        try{
            String query = "SELECT IF(EXISTS(SELECT * FROM interview WHERE cand_username=? AND recr_username=? AND job_id=? ),1,0)";
                     prepstate=connect.prepareStatement(query);// kanei connection kai tsekarei to query
								prepstate.setString(1, cand_user);
								prepstate.setString(2,recr_user);
						        prepstate.setString(3,jId);
                     ress=prepstate.executeQuery();
					 while(ress.next()){
						  check = ress.getInt(1);}
          if (check==1){                               
         String query6 = "UPDATE interview SET cand_username=?,recr_username=?,job_id=?,inter_id=inter_id,inter_date=?,duration=?,comments=?,personality=?,education=?,experience=? WHERE job_id=? AND cand_username=?";
         prepstate=connect.prepareStatement(query6);       
         prepstate.setString(1,cand_user);
         prepstate.setString(2, recr_user);
         prepstate.setString(3,jId);
         prepstate.setString(4, idate);
	 prepstate.setString(5,idur);
	 prepstate.setString(6,icom);
	 prepstate.setString(7,iper);
	 prepstate.setString(8,iedu);
	 prepstate.setString(9,iexp);
         prepstate.setString(10,jId);
         prepstate.setString(11,cand_user);
         ress1=prepstate.executeUpdate();
          }
          else {
         String query6 = "Insert INTO interview VALUES(?,?,?,DEFAULT,?,?,?,?,?,?)";
         prepstate=connect.prepareStatement(query6);       
         prepstate.setString(1,cand_user);
         prepstate.setString(2, recr_user);
         prepstate.setString(3,jId);
         prepstate.setString(4, idate);
		 prepstate.setString(5,idur);
		 prepstate.setString(6,icom);
		 prepstate.setString(7,iper);
		 prepstate.setString(8,iedu);
		 prepstate.setString(9,iexp);
         ress1=prepstate.executeUpdate();
			}//telos else
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout c4_2 = (CardLayout) (cardsR.getLayout());//get cards
                c4_2.show(cardsR,PANELA);//******************************************************************************ti kanei?!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                
      }  
    });					

editButtonSP.addActionListener(new ActionListener() { //*********************************EDIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){ //*********************************************me bash ta poia boxes einai checked 8a kanei edit mono auta
	  
        editButton4.setVisible(false);
        submitButton4.setVisible(false);
		submitButton4_1.setVisible(false);
		editButtonSP.setVisible(false);
        cancelButton4.setVisible(true);
		editButton4_1.setVisible(false);      
	   
	//  panelR4_1.add(initialButtons4());
    
	  
         	int find_row=0;
		int anycheckedSP =0;
		int j1=0;
		int j2=1;
		for(int i=0;i<tableJ.getModel().getRowCount();i++) //κωδικας για να εκτελετειται κατι οταν επιλεγει συγκεκριμενα checkboxes και παταει edit
                  {
                    if ((Boolean) tableJ.getModel().getValueAt(i,0))//αν το εχει επιλεξει check box
					{												
					  anycheckedSP =anycheckedSP +1;}
					                   
				  }
					if	(anycheckedSP > 1){
                                            JOptionPane.showMessageDialog(null,//AN EXEI EPILEKSEI ENA BOX BGAZEI MHNYMA
						"Choose only ONE job,\n"
						+"in order to see the Interview results",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					    }
                         else if(anycheckedSP == 0){//AN DEN EXEI EPILEKSEI KANENA BOX BGAZEI MHNYMA
                        JOptionPane.showMessageDialog(null,
						"No job selected\n"
						+"Please choose only ONE job",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					    }
						
						else{ 
						try{
						for(int i=0;i<tableJ.getModel().getRowCount();i++)
						{ if ((Boolean) tableJ.getModel().getValueAt(i,0))
						{find_row=i; }}
						
						Object jobSP =tableJ.getValueAt(find_row,3);
						int jSP =Integer.parseInt(String.valueOf(jobSP));
						String querySP="{call showResults(?)}";
						CallableStatement pst2=connect.prepareCall(querySP);
						pst2.setInt(1,jSP); //set in parameter
						ress = pst2.executeQuery(); 
                                                
                                                
						String querySP2 = "SELECT * FROM results ORDER BY Total_grade DESC";
						prepstate=connect.prepareStatement(querySP2);
						 ress2=prepstate.executeQuery();
						 
						 while(ress2.next()){
						String spCa = ress2.getString("Candidate_name");
						int spIn = ress2.getInt("Interviews_total");
						int spPe = ress2.getInt("Personality_value");
						int spEx = ress2.getInt("Education_value");
						int spEd = ress2.getInt("Experience_value");                     
						float spTo = ress2.getFloat("Total_grade");
									
					 
                                                modelSP.addRow(new Object[]{spCa,spIn,spPe,spEx,spEd,spTo,"NO","-"}); 					 
					 //panelSP.add(modelSP);// edw einai kala???????????????????????????????????? xreiazete mhpws allou??
                     }
                                               //   panelSP_1.add(new JScrollPane(tableSP));
					 int rowRej=tableSP.getRowCount();
                                         //int rowRej=1;
					 String[][] rejArray=new String[rowRej][2];
                                          int count=0;
                                           
					 //for(int i=0; i<rowRej; i++){
					//try{	
						// ResultSet ress2 = pst1.executeQuery();
                                               // int z=0; 
						 String querySP3 = "SELECT * FROM rejected ";
						 prepstate1=connect.prepareStatement(querySP3);
                                                 //prepstate1.setString(1,String.valueOf(tableSP.getModel().getValueAt(0)));
                                                //prepstate1.setString(1,);
						 ress3=prepstate1.executeQuery();
						 while(ress3.next()){
                                                 
						 String rej1 = ress3.getString("cand");
						 String rej2 = ress3.getString("keimeno");						
						 rejArray[count][j1]=rej1;
						 rejArray[count][j2]=rej2;
                                                  count++;
						 }//telos while					 
						 
					// }//try
						// catch(Exception ex){
                // JOptionPane.showMessageDialog(null, ex.getMessage());
						// }//telos iside catch
						
						//}//telos for
                                              if(count>0){
						 for(int i=0; i<rowRej; i++){//for pou 8a allazei ton JTableSP
						 for(int j=0; j<tableSP.getModel().getRowCount();j++)
						 {
                                                     if(rejArray[i][0]!= null){
                                                     if (rejArray[i][0].equals((String.valueOf(tableSP.getModel().getValueAt(j,0))))){//ama bre8ei to candidate pou 8eloyme
							 modelSP.setValueAt("Yes",j,6);
							 modelSP.setValueAt(rejArray[i][1],j,7);
						 }//telos eswterikhs for
                                                     }
					 }//telos for pou psaxnei mesa ston tableSP ta candidate name
					 
						 }//telos for allaghs periexomenou table
                                                }
						// panelSP_1.add(new JScrollPane(tableSP));
						 
						 
						 if(tableSP.getRowCount()==0){//AN ADEIOS O PINAKAS  meta ta insert se auto tote bgale auto
                                            JOptionPane.showMessageDialog(frame,//AN EXEI EPILEKSEI ENA BOX BGAZEI MHNYMA
						"Evaluation has not yet completed,\n"
						+"please try again",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					    }
                                                 else{
                                                 panelSP_1.add(new JScrollPane(tableSP));
                                                 }
						 
						 }//telos try
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }
						 
						 }//telos else
				CardLayout cSP = (CardLayout) (cardsR.getLayout());//get cards
                cSP.show(cardsR,PANELSP);
		
        button1.setVisible(true);
        button2.setVisible(true); 
		button3.setVisible(true);
		button4.setVisible(false);
		button5.setVisible(true);
      }  
    });
button5.addActionListener(new ActionListener() { //*********************************EDIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){ 
	  
		cancelButton5.setVisible(false);
		editButton5.setVisible(true);
		submitButton5.setVisible(false);
		applyButton5.setVisible(false);
	    cancelButton555.setVisible(false);
	  
	    try{
			String query12 = "SELECT * FROM job WHERE job.recruiter IN(SELECT username FROM recruiter WHERE firm IN (SELECT firm FROM recruiter WHERE username=?))";
			 prepstate=connect.prepareStatement(query12);
			 prepstate.setString(1, NewJFrame.s);
             ress=prepstate.executeQuery(); 
			  while(ress.next()){
				  
						int id8 = ress.getInt("id");
						Date sD8 = ress.getDate("start_date"); 
						Float money8 = ress.getFloat("salary");  
						String pos8 = ress.getString("position");
						String loc8 = ress.getString("edra");
						String rec8 = ress.getString("recruiter");                     
						Timestamp timestamp8 = ress.getTimestamp("announce_date");
						if (timestamp8 != null){
						date = new java.util.Date(timestamp8.getTime());}
						Date subDate8 = ress.getDate("submission_date");			

						
				  modelJ5.addRow(new Object[]{id8,sD8,money8,pos8,loc8,rec8,timestamp8,subDate8}); 
				  
				  
			  }
			  panel800.add(new JScrollPane(tableJ5));
			  
			  
			 
			      
				  //panel900.add(new JScrollPane(tableJ5_edit));//den xreiazetai edw
			 
		}
	      catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
				
				 
                CardLayout c500 = (CardLayout) (cardsR.getLayout());//get cards
                c500.show(cardsR,PANEL5);
				
				
				button1.setVisible(true);
                button2.setVisible(true); 
			 	button3.setVisible(true);
				button4.setVisible(true);
				button5.setVisible(false);

		 }  
		  
    });
editButton5.addActionListener(new ActionListener() { //*********************************EDIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){ 
	  for(int i=0;i<tableJ5.getModel().getRowCount();i++)//****************dhmiourgia periexomenou neou pinaka
			 {
				 if(String.valueOf(tableJ5.getValueAt(i,5)).equals(NewJFrame.s))
				 {
					 Object[] row5 = {new Boolean(false),tableJ5.getValueAt(i,0), tableJ5.getValueAt(i,1), tableJ5.getValueAt(i,2), tableJ5.getValueAt(i,3), tableJ5.getValueAt(i,4), tableJ5.getValueAt(i,5),tableJ5.getValueAt(i,6),tableJ5.getValueAt(i,7),tableJ5.getValueAt(i,5)}; //αναθεση τιμων σε σειρα
					modelJ5_edit.addRow(row5);}//telos if
				 }//telos for 
			      
		cancelButton5.setVisible(true);
		editButton5.setVisible(false);
		submitButton5.setVisible(true);
		applyButton5.setVisible(true);
		cancelButton555.setVisible(false);
		TableColumn tabc = tableJ5_edit.getColumnModel().getColumn(0);//******************************************************ti kanei edw
                     tabc.setCellEditor(tableJ5_edit.getDefaultEditor(Boolean.class));
                     tabc.setCellRenderer(tableJ5_edit.getDefaultRenderer(Boolean.class));
                      panelR900.add(new JScrollPane(tableJ5_edit));
                                   
                      class MyItemListener implements ItemListener
                      {
                      public void itemStateChanged(ItemEvent e) {
                      Object source = e.getSource();
                      if (source instanceof AbstractButton == false) return;
                      boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                      for(int x = 0, y = tableJ5_edit.getRowCount(); x < y; x++)
                      {
                       tableJ5_edit.setValueAt(new Boolean(checked),x,0);
                      }
                      }
                      }
		
			 
                       CardLayout c900 = (CardLayout) (cardsR.getLayout());//get cards***************emfanish pinaka me my jobs 
                       c900.show(cardsR,PANEL7);
			 	  
		
	      }  
    });	

	applyButton5.addActionListener(new ActionListener() { //*********************************EDIT BUTTON JOB
      @Override
      public void actionPerformed(ActionEvent ae){ 
	  int anychecked5 =0;
	    cancelButton555.setVisible(true);
		cancelButton5.setVisible(true);
		editButton5.setVisible(false);
		submitButton5.setVisible(true);
		applyButton5.setVisible(false);
		  modelJ5.setRowCount(0);
		  
		  for(int i=0;i<tableJ5_edit.getModel().getRowCount();i++) //κωδικας για να εκτελετειται κατι οταν επιλεγει συγκεκριμενα checkboxes και παταει edit
                  {
                    if ((Boolean) tableJ5_edit.getModel().getValueAt(i,0)){ //αν το εχει επιλεξει check box				
						 anychecked5 =anychecked5 +1;}
					                   
				  }
					 if	(anychecked5 == 0){
                                            JOptionPane.showMessageDialog(frame,//AN DEN EXEI EPILEKSEI KANENA BOX BGAZEI MHNYMA
						"Choose any job/s to edit",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					    }
                                        else{
											int numrows =tableJ5_edit.getModel().getRowCount();
											for(int i=0;i<numrows;i++)
											{if ((Boolean) tableJ5_edit.getModel().getValueAt(i,0))
												{ //modelJ5_edit.removeRow(i);
                                                                                                Object[] row6 = {tableJ5_edit.getValueAt(i,1), tableJ5_edit.getValueAt(i,2), tableJ5_edit.getValueAt(i,3), tableJ5_edit.getValueAt(i,4), tableJ5_edit.getValueAt(i,5),tableJ5_edit.getValueAt(i,6),tableJ5_edit.getValueAt(i,7),tableJ5_edit.getValueAt(i,8)}; //αναθεση τιμων σε σειρα
					                                                             modelJ5.addRow(row6);
                                                                                                }}
											
											//tableJ5_edit.removeColumn( tableJ5_edit.getColumnModel().getColumn(0) );
											
											
                                         panelR1000.add(new JScrollPane(tableJ5));
                                          CardLayout c56 = (CardLayout) (cardsR.getLayout());//get cards
                                         c56.show(cardsR,PANEL8);
                                        }
		  	  
				 
	      }  
    });	
		cancelButton555.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout c56 = (CardLayout) (cardsR.getLayout());//get cards
                c56.show(cardsR,PANELA);
      }  
    }); 
     
	submitButton5.addActionListener(new ActionListener() { 
      @Override
      public void actionPerformed(ActionEvent ae){ 
	  
	    cancelButton555.setVisible(false);
		cancelButton5.setVisible(false);
		editButton5.setVisible(false);
		submitButton5.setVisible(false);
		applyButton5.setVisible(false);
	  Object id85=null;
						Object startD85=null;
						Object money85=null;
						Object pos85=null;
						Object loc85=null;
						Object rec85=null;
						Object aD85=null;
						Object sD85=null;
	    for(int i=0;i<tableJ5.getModel().getRowCount();i++){
						
						    id85=tableJ5.getValueAt(i,0);
						    startD85=tableJ5.getValueAt(i,1);
						    money85=tableJ5.getValueAt(i,2);
						    pos85=tableJ5.getValueAt(i,3);
						    loc85=tableJ5.getValueAt(i,4);
						    rec85=tableJ5.getValueAt(i,5);
						    aD85=tableJ5.getValueAt(i,6);
						    sD85=tableJ5.getValueAt(i,7);
		
        try{
         String query = "UPDATE job SET id=?,start_date=?,salary=?,position=?,edra=?,recruiter=?,announce_date=?,submission_date=? WHERE job.id=? ";
         prepstate=connect.prepareStatement(query);       
		 
         prepstate.setString(1,String.valueOf(id85));
         prepstate.setString(2, String.valueOf(startD85));
         prepstate.setString(3,String.valueOf(money85));
		 prepstate.setString(4,String.valueOf(pos85));
		 prepstate.setString(5,String.valueOf(loc85));
		 prepstate.setString(6,String.valueOf(rec85));
		 prepstate.setString(7,String.valueOf(aD85));
		 prepstate.setString(8,String.valueOf(sD85));
		 prepstate.setString(9,String.valueOf(id85));
         ress1=prepstate.executeUpdate();
         
        }
	      catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
				CardLayout c1 = (CardLayout) (cardsR.getLayout());//get cards
                c1.show(cardsR,PANELA);
	      } 
	  }		  
    });
    cancelButton5.addActionListener(new ActionListener() { //*************************************CANCEL BUTTON
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout c57 = (CardLayout) (cardsR.getLayout());//get cards
                c57.show(cardsR,PANELA);
      }  
    }); 
	
		 
		 
        JPanel buttonPanelR = new JPanel();
       buttonPanelR.add(button1);
        buttonPanelR.add(button2);
		buttonPanelR.add(button3);
		buttonPanelR.add(button4);
		buttonPanelR.add(button5);
               


        frame.add(cardsR);
        frame.add(buttonPanelR, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
        
    }
  
		 
   }
	
//************************************************************************************************************************************TO DO********************************************************	
	//JScrollPane sp = new JScrollPane(tableJ);
                  		
    class CheckBoxHeader1 extends JCheckBox
    implements TableCellRenderer, MouseListener {
    protected CheckBoxHeader1 rendererComponent;
    protected int column;
    protected boolean mousePressed = false;
    public CheckBoxHeader1(ItemListener itemListener) {
    rendererComponent = this;
    rendererComponent.addItemListener(itemListener);
    }
   public Component getTableCellRendererComponent(
      JTable tableJ, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (tableJ != null) {
      JTableHeader header = tableJ.getTableHeader();
      if (header != null) {
        rendererComponent.setForeground(header.getForeground());
        rendererComponent.setBackground(header.getBackground());
        rendererComponent.setFont(header.getFont());
        header.addMouseListener(rendererComponent);
      }
    }
    setColumn(column);
    rendererComponent.setText("Check All");
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    return rendererComponent;
  }
  protected void setColumn(int column) {
    this.column = column;
  }
  public int getColumn() {
    return column;
  }
  protected void handleClickEvent(MouseEvent e) {
    if (mousePressed) {
      mousePressed=false;
      JTableHeader header = (JTableHeader)(e.getSource());
      JTable tableView = header.getTable();
      TableColumnModel columnModel = tableView.getColumnModel();
      int viewColumn = columnModel.getColumnIndexAtX(e.getX());
      int column = tableView.convertColumnIndexToModel(viewColumn);
  
      if (viewColumn == this.column && e.getClickCount() == 1 && column != -1) {
        doClick();
      }
    }
  }
  public void mouseClicked(MouseEvent e) {
    handleClickEvent(e);
    ((JTableHeader)e.getSource()).repaint();
  }
  public void mousePressed(MouseEvent e) {
    mousePressed = true;
  }
  public void mouseReleased(MouseEvent e) {
  }
  public void mouseEntered(MouseEvent e) {
  }
  public void mouseExited(MouseEvent e) {
  }
}
/*
 * @author Ρωμανός
 */

