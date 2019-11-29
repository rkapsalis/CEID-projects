/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
//import java.awt.image.BufferedImage;
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
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
//import java.io.*;
//import javax.imageio.ImageIO;

 public class candidateGUI extends NewJFrame{
    private JTextField usernameField = new JTextField(10);
     private JTextField bioField = new JTextField(40);
     private JTextField sisField = new JTextField(20);
     private JTextField certField = new JTextField(20);
     private JTextArea textArea = new JTextArea(10, 15);
     //JScrollPane sp = new JScrollPane(textArea);
     JScrollPane scrollPane = new JScrollPane(textArea);       
     java.util.Date date;
     //textArea.setEditable(false);
     private JButton editButton = new JButton("Edit");
     private JButton submitButton = new JButton("Submit");
     private JButton cancelButton = new JButton("Cancel");
     private JButton applyButton = new JButton("Apply");
     private JButton appButton = new JButton("My applications");
     private JButton aplButton = new JButton("Submit");
     private JButton canButton = new JButton("Cancel");
     private JButton deleteButton = new JButton("Withdraw");
    NewJFrame m;
    private final static String PANEL3 = "panel 3";
    private final static String PANEL1 = "panel 1";
    private final static String PANEL2 = "panel 2";
    private final static String PANEL4 = "panel 4";
    private final static String PANEL5 = "panel 5";
    Connection conn=null;
    Statement stmt=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
      ResultSet rs3=null;
       ResultSet rs4=null;
      
      int count1=0 ;
     int count2=0;
     int count7=0;
    String msg;
  public  candidateGUI() {
   conn=project.ConnectDb(); 
   initComponents(); 
  }
  protected JPanel initFields() {
      JPanel panel1_1 = new JPanel();
      panel1_1.setLayout(new MigLayout());
      panel1_1.setBackground(new java.awt.Color(103,177,234));
      panel1_1.add(new JLabel("Username: "), "align label"); 
      panel1_1.add(usernameField, "wrap");
      usernameField.setEnabled(true);
      usernameField.setEditable(false);
      
      panel1_1.add(new JLabel("Bio: "), "align label");
       panel1_1.add(textArea, "wrap");
      textArea.setEnabled(true);
      textArea.setEditable(false);
      
      panel1_1.add(new JLabel("Sistatikes: "), "align label");
       panel1_1.add(sisField, "wrap");
      sisField.setEnabled(true);
      sisField.setEditable(false);
   
      panel1_1.add(new JLabel("Certificates: "), "align label");
       panel1_1.add(certField, "wrap");
       certField.setEnabled(true);
       certField.setEditable(false);
       panel1_1.add(initButtons());
    
       return panel1_1;
  }
  private JPanel initButtons() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(editButton);
      panel.add(submitButton);
      panel.add(cancelButton);
      //editButton.addActionListener(new ButtonHandler());
     
      return panel;
   }  
    
  private void initComponents(){
      
      JFrame frame = new JFrame("Candidate");
      setMaximumSize( new Dimension( 70, 60 ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground(new java.awt.Color(78, 108, 157));
      panel3.setPreferredSize(new Dimension(500,300));
      
      JPanel panel1 = new JPanel();
      panel1.setBackground(new java.awt.Color(78, 108, 157));
     // panel1.setPreferredSize(new Dimension(500,300));
     //JLabel label10=new JLabel("<html>Welcome " + NewJFrame.s + "!  </br> Please select one of the above options to proceed.</html>",SwingConstants.CENTER);
     JLabel label10=new JLabel("<html>Welcome " + NewJFrame.s + "!  </br> Please select one of the above options to proceed.</html>");
      Font f=new Font("Calibri",Font.BOLD,20);
      label10.setFont(f);
       panel3.add(label10);
      JPanel panel2 = new JPanel();
      panel2.setBackground(new java.awt.Color(78, 108, 157));
      panel2.setPreferredSize(new Dimension(500,300));
      panel2.setLayout(new BorderLayout(5,5));
      JPanel panel4 = new JPanel();
      panel4.setBackground(new java.awt.Color(78, 108, 157));
      panel4.setPreferredSize(new Dimension(500,300));
      panel4.setLayout(new BorderLayout(5,5));
      JPanel panel4_1=new JPanel();
      panel4.add(panel4_1,BorderLayout.SOUTH);
      panel4_1.add(deleteButton);
     // JPanel panel15=new JPanel();
      //panel2.add(panel15,BorderLayout.NORTH);
      JPanel panel5 =new JPanel();
      panel5.setBackground(new java.awt.Color(78, 108, 157));
      panel5.setPreferredSize(new Dimension(500,300));
     // panel5.setLayout(new BorderLayout(5,5));
      panel5.add(applyButton);
      panel5.add(appButton);
      JPanel panel16=new JPanel();
               
      JPanel panel2_1=new JPanel();
      panel2_1.setLayout(new BorderLayout());
      panel2_1.setBackground(new java.awt.Color(103,177,234));
      panel2.add(panel2_1,BorderLayout.CENTER);
       
       panel2_1.add(panel16,BorderLayout.SOUTH);
       JPanel panel2_2=new JPanel();
       panel2_2.add(new JLabel("Open Positions"));
       panel2.add(panel2_2,BorderLayout.NORTH);
      panel16.add(canButton);
      panel16.add(aplButton); 
       JPanel panel900 =new JPanel();
       panel900.setLayout(new BorderLayout());
      panel900.setBackground(new java.awt.Color(103,177,234));
      panel4.add(panel900,BorderLayout.CENTER);
      TableColumnModel colmodel;
      DefaultTableModel model =new DefaultTableModel();
      panel1.setLayout(new BorderLayout(5,5));
      panel1.add(this.initFields(),BorderLayout.SOUTH);
      scrollPane.setPreferredSize(new Dimension(380, 100));
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      panel1.setBorder(new TitledBorder
      (new EtchedBorder(),"My Profile"));
      model.addColumn("Select all");
      model.addColumn("ID");  
      model.addColumn("Start Date");
      model.addColumn("Salary");
      model.addColumn("Position"); 
      model.addColumn("Edra"); 
      model.addColumn("Recruiter");
      model.addColumn("Announce Date");
      model.addColumn("Submission Date");
      JTable table = new JTable(model);
      //JScrollPane scrollpane1 = new JScrollPane(table);
     // add(new JScrollPane(table)); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
      
    final JPanel cards = new JPanel(new CardLayout());
        cards.add(panel3, PANEL3);
        cards.add(panel1, PANEL1);
        cards.add(panel2, PANEL2);
        cards.add(panel4, PANEL4);
         cards.add(panel5, PANEL5);
        CardLayout cl = (CardLayout) (cards.getLayout());//get cards
               // cl.show(panel3,PANEL3);
    
    JButton button1 = new JButton("Profile");
   // panel3.add(button1,BorderLayout.CENTER);
    //panel2.add(button1);
    JButton button2 = new JButton("Applications");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                editButton.setVisible(true);
                cancelButton.setVisible(false);
                submitButton.setVisible(false);
                aplButton.setVisible(false);
                
                count1++;
                if(count1>0 ){
                 panel1.removeAll();
                 textArea.setText(null);
                }                        
                       
                 try{
                     
                    //NewJFrame m=new NewJFrame(); 
                     String query = "SELECT * FROM candidate WHERE username=?";
                     pst=conn.prepareStatement(query);
                     pst.setString(1, NewJFrame.s);
                     rs=pst.executeQuery();
                    // DefaultTableModel model = new DefaultTableModel(new String[]{"Username", "Bio", "Sistatikes", "Certificates"},0);
                    // panel1.add(model);
                     while(rs.next()){
                     String a = rs.getString("username");
                     String b = rs.getString("bio");
                     String c = rs.getString("sistatikes");
                     String d = rs.getString("certificates");
                     //model.addRow(new Object[]{a,b,c,d});
                     usernameField.setText(a);
                     //bioField.setText(b);
                     textArea.append(b );
                     sisField.setText(c);
                     certField.setText(d);
                     textArea.setCaretPosition(textArea.getDocument().getLength());                    
                                          
                     }
                    //JTable table = new JTable(); 
                    //table.setModel(model);
                   // panel1.add(table,BorderLayout.CENTER);
                    //JPanel panel1_2 = new JPanel();
                    //panel1_2.setBackground(new java.awt.Color(78, 108, 157));
                    //panel1_2.add(new JLabel("sth"));
                    panel1.add(initFields(),BorderLayout.NORTH);
                   // panel1.add(initButtons(),BorderLayout.CENTER);              
                    
                    //panel1.add(panel1_2,BorderLayout.SOUTH);
                    button1.setVisible(false);
                    button2.setVisible(true); 
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL1);
                
            }
        });
    
    //panel3.add(button2);
    //panel1.add(button2);
        button2.addActionListener(new ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                button1.setVisible(true);
                button2.setVisible(false);
                canButton.setVisible(true);
                aplButton.setVisible(true);
                applyButton.setVisible(true);
                appButton.setVisible(true);
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL5);
            }
        });
      editButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
        editButton.setVisible(false);
        submitButton.setVisible(true);
        cancelButton.setVisible(true);        
        textArea.setEditable(true);
        sisField.setEditable(true);
        certField.setEditable(true); 
        button1.setVisible(false);
        button2.setVisible(true); 
      }  
    });
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
        String b1=textArea.getText();
        String cer=certField.getText();
        String si=sisField.getText();
        try{
         String query = "UPDATE candidate SET bio=?,sistatikes=?,certificates=? WHERE username=?";
         pst=conn.prepareStatement(query);       
         pst.setString(1,b1);
         pst.setString(2, si);
         pst.setString(3,cer);
         pst.setString(4, NewJFrame.s);
         rs=pst.executeQuery();
         
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
                
      }  
    });  
     cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
      }  
    }); 
     applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {        
                    applyButton.setVisible(false);
                    canButton.setVisible(true);
                    aplButton.setVisible(true);
                    appButton.setVisible(false);
                    button2.setVisible(true);
                   
                if(count7>0 ){
                 panel2_1.removeAll();
                 model.setRowCount(0);
                 //textArea.setText(null);
                }
                 count7++;
                 try{
                     
                     String query = "SELECT * FROM job WHERE submission_date>CURDATE()";
                     pst=conn.prepareStatement(query);
                     //pst.setString(1, NewJFrame.s);
                     rs=pst.executeQuery();
                     //DefaultTableModel model = new DefaultTableModel(new String[]{"Username", "Bio", "Sistatikes", "Certificates"},0);
                     while(rs.next()){
                     int e = rs.getInt("id");
                     Date f = rs.getDate("start_date");
                     Float g = rs.getFloat("salary");
                     String h = rs.getString("position");
		     String i = rs.getString("edra");
                     String j = rs.getString("recruiter");                     
        	     Timestamp timestamp = rs.getTimestamp("announce_date");
                     if (timestamp != null){
                     date = new java.util.Date(timestamp.getTime());}
                     Date l = rs.getDate("submission_date");					 
                     model.addRow(new Object[]{new Boolean(false),e,f,g,h,i,j,timestamp,l});
                                          
                     }
		     //JScrollPane sp = new JScrollPane(table);
                     TableColumn tc = table.getColumnModel().getColumn(0);
                     tc.setCellEditor(table.getDefaultEditor(Boolean.class));
                     tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
                     
                     panel2_1.add((new JScrollPane(table)));                    
                      class MyItemListener implements ItemListener
                      {
                      public void itemStateChanged(ItemEvent e) {
                      Object source = e.getSource();
                      if (source instanceof AbstractButton == false) return;
                      boolean checked = e.getStateChange() == ItemEvent.SELECTED;
                      for(int x = 0, y = table.getRowCount(); x < y; x++)
                      {
                       table.setValueAt(new Boolean(checked),x,0);
                      }
                      }
                      }
                   tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
                    button1.setVisible(true);
                    //button2.setVisible(false); 
                }
                catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.getMessage());
 
                }   
                
                CardLayout c1 = (CardLayout) (cards.getLayout());//get cards
                c1.show(cards,PANEL2);
                
            }
        });
     int no_data;
 int total;
 DefaultTableModel model1 =new DefaultTableModel();
      model1.addColumn("Select all");
      model1.addColumn("Username");  
      model1.addColumn("Job id");
      model1.addColumn("Status");
      model1.addColumn("Salary");	  
      model1.addColumn("Position"); 
      model1.addColumn("Edra");       
      JTable table1 = new JTable(model1);
appButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae){
              appButton.setVisible(false);
              applyButton.setVisible(true);
              deleteButton.setVisible(true);
              button2.setVisible(true);
		     
                if(count2>0 ){
                // panel4.removeAll();
                  model1.setRowCount(0);
                 //textArea.setText(null);
                } 
                 count2++;
             try{	
                     Date m=null;
                     Float q=0f;
                     String r="";
                     String s="";
	             String query = "SELECT * FROM applies WHERE cand_usrname=?";
                     pst=conn.prepareStatement(query);
                     pst.setString(1, NewJFrame.s);
                     rs=pst.executeQuery();                     
                   while(rs.next()){
					// no_data=0;
                     String k = rs.getString("cand_usrname");
                     int l = rs.getInt("job_id");                                                     
        	                              
                     //date = new java.util.Date(timestamp.getTime());                    				 
                     
                     String query1 = "SELECT * FROM job WHERE id=?";
                     pst=conn.prepareStatement(query1);
                     pst.setInt(1, l);                    
                     rs1=pst.executeQuery(); 
	         	 while(rs1.next()){
					  q=rs1.getFloat("salary");
					  r=rs1.getString("position");
					  s=rs1.getString("edra");
				          m = rs1.getDate("submission_date");
                             }                       
                       long millis=System.currentTimeMillis();  
                       java.sql.Date cur_date=new java.sql.Date(millis);  
                       if(m.compareTo(cur_date)>0){
						   msg="open for submission";
						   //εδω θα βαλω ενα Joptionpane "thes na aposireis? " και θα βγαινει ενα combobox που θα εμφανιζει job id, αν πατησει confirm κανει delete.
					   }
					   else if(m.compareTo(cur_date)<0 ){
                                                 String query6 = "SELECT * FROM interview WHERE cand_username=? AND job_id=?";
                                                  pst=conn.prepareStatement(query6);
					         pst.setString(1, NewJFrame.s);
                                                 pst.setInt(2, l);
                                                                   
                                                 rs3=pst.executeQuery();
                                                 int no_data=0;
                                                // !rs3.isBeforeFirst()
					         if(rs3.next()){
							  no_data++; 							  
						   } 
                                                 if(no_data==0){
						  msg="under assessment";
                                                 }
					        else{					      
                                                   String query4="{call showResults(?)}";
						   CallableStatement pst1=conn.prepareCall(query4);
						   pst1.setInt(1,l);  //set in parameter
						   ResultSet rs = pst1.executeQuery();                                                
                                                
                                                 
						   String query2 = "SELECT * FROM results ORDER BY Total_grade DESC";
                                                   pst=conn.prepareStatement(query2);
                           //pst3.setString(1, l);                    
                                                   rs2=pst.executeQuery();
                                                   int no_data1=0;
                                                   int thesi=0;
					         if(rs2.next()){
							  no_data1++;
                                                     if(  rs2.getString("Candidate_name").equals(NewJFrame.s)){
                                                        
						      thesi=no_data;
						   }
						   } 
                                                  if(no_data1==0){
						  msg="under assessment";
                                                 }
                                                  else{
						   int count5=0;
                                                   
                                                   int total=0;
						 /*  while(rs2.next()){
						   count5++;
						   if(rs2.getString("Candidate_name") == NewJFrame.s){
                                                        
						      thesi=count5;
						   }
						   }  */
						   String query3 = "SELECT COUNT(*) AS synolo FROM results ";
                                                   pst=conn.prepareStatement(query3);                                            
                                                   rs3=pst.executeQuery();
                                                   while(rs3.next()){
						    total=rs3.getInt("synolo"); }
						   msg="Your ranking is:" + thesi + "out of" + total + "candidates";						   
						   
					   //}
					   
                                                 }	
                       }
                       		   
                     } 
                      model1.addRow(new Object[]{new Boolean(false),k,l,msg,q,r,s});
                   }
					 
		            //JScrollPane sp = new JScrollPane(table);
                     TableColumn tc1 = table1.getColumnModel().getColumn(0);
                     tc1.setCellEditor(table1.getDefaultEditor(Boolean.class));
                     tc1.setCellRenderer(table1.getDefaultRenderer(Boolean.class));
                     
                     panel900.add(new JScrollPane(table1));  }
					  catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL4);
        }  
        });
     aplButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae){
		 //try{
		   int countOpt=0;
		   int count=table.getRowCount();
		   ArrayList<Integer> cbList = new ArrayList<Integer>();
                  // table.getModel().addTableModelListener(new TableModelListener() {
             // @Override
             // public void tableChanged(TableModelEvent e) {
                  for(int i=0;i<table.getModel().getRowCount();i++)
                  {
                    if ((Boolean) table.getModel().getValueAt(i,0) )
                    {  
                         try{
                          String query = "INSERT INTO applies(cand_usrname,job_id) VALUES (?,?)";
                          pst=conn.prepareStatement(query);
                          pst.setString(1, NewJFrame.s);
		          Object obj2 = table.getValueAt(i,1);
		          pst.setString(2,obj2.toString());
                          pst.executeUpdate();
                         }
                         catch(Exception ex){
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                          } 
                        // System.out.println(">\t"+table.getSelectedRow());
                     // break;
                    }
                 }     
             // }
    //});	
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
        }  
        });
     deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae){
		   int countOpt=0;
		   int count=table.getRowCount(); 
                  
                  for(int i=0;i<table1.getModel().getRowCount();i++)
                  {
                    if ((Boolean) table1.getModel().getValueAt(i,0) )
                    {  
                         try{
                          String query = "DELETE FROM applies WHERE cand_usrname=? AND job_id=?";
                          pst=conn.prepareStatement(query);
                          pst.setString(1, NewJFrame.s);
		          Object obj2 = table1.getValueAt(i,2);
		          pst.setString(2,String.valueOf(obj2));
                          pst.executeUpdate();
                         }
                         catch(Exception ex){
                           JOptionPane.showMessageDialog(null, ex.getMessage());
                          } 
                        // System.out.println(">\t"+table.getSelectedRow());
                     // break;
                    }
                 }     
             // }
    //});	
         CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.show(cards,PANEL3);
        }  
        });
      JPanel buttonPanel = new JPanel();
       buttonPanel.add(button1);
        buttonPanel.add(button2);


        frame.add(cards);
        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
  }
 }
 
 
    class CheckBoxHeader extends JCheckBox
    implements TableCellRenderer, MouseListener {
    protected CheckBoxHeader rendererComponent;
    protected int column;
    protected boolean mousePressed = false;
    public CheckBoxHeader(ItemListener itemListener) {
    rendererComponent = this;
    rendererComponent.addItemListener(itemListener);
    }
   public Component getTableCellRendererComponent(
      JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (table != null) {
      JTableHeader header = table.getTableHeader();
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

