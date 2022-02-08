import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Container;
import java.io.*;

 public  class Req extends JFrame implements ActionListener

{
    JLabel lblorder_no,lblitemname,lblordered_date,lblshipment_status,lblc_name,lblqntity,lblrate,lblamount;
    JTextField txtcname;
    JTextField txtorder_no;
    JTextField txtyear;
    JTextField txtitemname;
    JTextField txtqntity;
    JTextField txtamount;
    JTextField txtrate;
    JTextField txtship;
    JComboBox cmbmonth,cmbconcession;
    //JComboBox cmbgnder,cmbconcession3;
    JComboBox cmbdate,cmbconcession1;
    JButton btnadd,btncancel,btnsearch,btnreset;
   private Statement str;
    private Connection con;
    private PreparedStatement ps;

 
     public Req()
{
     super ("Order Details Form");
    getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);

      

     lblorder_no = new JLabel("Order_id:");
     lblorder_no.setBounds(20,55,100,30);
     add(lblorder_no);
    txtorder_no=new JTextField();
      txtorder_no.setBounds(130,55,160,25);
      add(txtorder_no);
     
      lblc_name= new JLabel("Cust_name:");
     lblc_name.setBounds(20,90,100,30);
     add(lblc_name);
     txtcname=new JTextField();
     txtcname.setBounds(130,90,160,25);
     add(txtcname);

     lblordered_date = new JLabel("Ordered_Date:");
     lblordered_date.setBounds(20,140,100,30);
     add(lblordered_date);
     //lblordered_date.setFont(new Font("Arial Black",Font.PLAIN,12));
     //lblordered_date.setForeground(Color.WHITE);
    cmbconcession=new JComboBox();
    cmbconcession.addItem("Jan");
    cmbconcession.addItem("Feb");
    cmbconcession.addItem("Mar");
    cmbconcession.addItem("Apr");
    cmbconcession.addItem("May");
    cmbconcession.addItem("June");
   cmbconcession.addItem("July");
   cmbconcession.addItem("Aug");
   cmbconcession.addItem("Sep");
   cmbconcession.addItem("Oct");
   cmbconcession.addItem("Nov");
   cmbconcession.addItem("Dec");
  cmbconcession.setSelectedIndex(0);
  cmbconcession.setBounds(130,140,50,25);
  add(cmbconcession);

 cmbconcession1=new JComboBox();
cmbconcession1.addItem("1");
cmbconcession1.addItem("2");
cmbconcession1.addItem("3");
cmbconcession1.addItem("4");
cmbconcession1.addItem("5");
cmbconcession1.addItem("6");
cmbconcession1.addItem("7");
cmbconcession1.addItem("8");
cmbconcession1.addItem("9");
cmbconcession1.addItem("10");
cmbconcession1.addItem("11");
cmbconcession1.addItem("12");
cmbconcession1.addItem("13");
cmbconcession1.addItem("14");
cmbconcession1.addItem("15");
cmbconcession1.addItem("16");
cmbconcession1.addItem("17");
cmbconcession1.addItem("18");
cmbconcession1.addItem("19");
cmbconcession1.addItem("20");
cmbconcession1.addItem("21");
cmbconcession1.addItem("22");
cmbconcession1.addItem("23");
cmbconcession1.addItem("24");

cmbconcession1.addItem("25");
cmbconcession1.addItem("26");
cmbconcession1.addItem("27");
cmbconcession1.addItem("28");
cmbconcession1.addItem("29");
cmbconcession1.addItem("30");
cmbconcession1.addItem("31");

cmbconcession1.setSelectedIndex(0);
cmbconcession1.setBounds(190,140,50,25);
add(cmbconcession1);

 txtyear=new JTextField();
 txtyear.setBounds(250,140,40,25);
 add(txtyear);

  lblshipment_status = new JLabel("Address:");
  lblshipment_status.setBounds(20,180,100,35);
  add(lblshipment_status);
  txtship=new JTextField();
  txtship.setBounds(130,180,160,30);
  add(txtship);

  lblitemname = new JLabel("Item_Name:");
  lblitemname.setBounds(20,220,150,25);
  add(lblitemname);
  txtitemname=new JTextField();
  txtitemname.setBounds(130,220,160,25);
  add(txtitemname);
  

    lblqntity = new JLabel("Quantity:");
    lblqntity.setBounds(20,250,100,25);
    add(lblqntity);
 
    txtqntity=new JTextField();
    txtqntity.setBounds(130,250,160,25);
    add(txtqntity);

    lblrate = new JLabel("Rate:");
    lblrate.setBounds(20,280,100,25);
    add(lblrate);
  
    txtrate=new JTextField();
    txtrate.setBounds(130,280,50,25);
    add(txtrate);

     lblamount = new JLabel("Amount:");
     lblamount.setBounds(190,280,50,25);
     add(lblamount);
    
     txtamount=new JTextField();
     txtamount.setBounds(240,280,50,25);
     add(txtamount);

 
              btnadd=new JButton("ADD");
              btnadd.setBounds(60,330,80,30);
              add(btnadd);
              btncancel=new JButton("CANCEL ORDER");
              btncancel.setBounds(160,330,150,30);
              add(btncancel);
             
              btnreset=new JButton("RESET");
              btnreset.setBounds(330,330,90,30);
              add(btnreset);

    btnadd.addActionListener(this);
   
    btncancel.addActionListener(this);
   btnreset.addActionListener(this);
      }//constructor closed

public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String sql1="select * from Inventory where Item_name='"+txtitemname.getText()+"'";
ResultSet rs1=st.executeQuery(sql1);
if( rs1.next())
{
String f = rs1.getString("selling_price");

txtrate.setText(f);
}


                

 try {
int  val =Integer.parseInt(txtqntity.getText());
int val1=Integer.parseInt(txtrate.getText());
int pf=(val1*val);
String s=String.valueOf(pf);
txtamount.setText(s);


String str = "INSERT INTO Requested (req_id,cust_name,req_date1,req_date2,req_date3,address,item_name,quantity,rate,amount)"+
                             "values(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1, txtorder_no.getText());
                    ps.setString(2, txtcname.getText());
                    ps.setString(3,cmbconcession.getSelectedItem().toString());
                    ps.setString(4,cmbconcession1.getSelectedItem().toString());
                    ps.setString(5, txtyear.getText());
                    ps.setString(6, txtship.getText());
                    ps.setString(7, txtitemname.getText());
                    ps.setString(8, txtqntity.getText());
                    ps.setString(9, txtrate.getText());
                    ps.setString(10, txtamount.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Order details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed
    
        if (e.getActionCommand().equalsIgnoreCase("RESET")) {
          
                    txtorder_no.setText("");
                    txtcname.setText("");
                    cmbconcession.setSelectedItem("");
                    cmbconcession1.setSelectedItem("");
                     txtyear.setText("");
                     txtship.setText("");
                     txtitemname.setText("");
                    txtqntity.setText("");
                    txtrate.setText("");
                     txtamount.setText("");
 
                  }
 if (e.getActionCommand().equalsIgnoreCase("CANCEL ORDER")) {
  try {
 if (e.getSource() == btncancel)
 {
               c frm = new c();
                frm.setVisible(true);
                frm.setSize(300,250);
                
            }
}
catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed

           
        }//if closed
}



                           public static void main(String args[]) 
                             {
                                    Req l=new Req();
	                    l.setSize(500,425);
                                      l.setVisible(true);
                                      l.setLocation(0,0);
                                      l.setResizable(true);
                                }
}//class closed
