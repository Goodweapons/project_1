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
 public class Storage extends JFrame implements ActionListener
{
JLabel lblinvntry_id,lblitem_name,lbltb,lblts,lblci;
    JTextField txtinvntry_id;
    JTextField txtitem_name;
    JTextField txttb;
    JTextField txtts;
    JTextField txtci;

    private Connection con;
    private PreparedStatement ps;
    private Statement str;
   
  JButton btnadd,btnclear,btnstatus;
   public Storage()
{
     super ("Storage Details Form");
getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);

     lblinvntry_id = new JLabel("Inventory Id:");
    lblinvntry_id.setBounds(10,40,100,25);
 //lblinvntry_id.setFont(new Font("ARIAL BLACK", Font.PLAIN,12));
  //lblinvntry_id.setForeground(Color.WHITE);

     add(lblinvntry_id);
txtinvntry_id=new JTextField();
      txtinvntry_id.setBounds(140,40,150,25);
         add(txtinvntry_id);
 lblitem_name = new JLabel("Item_Name:");
    lblitem_name.setBounds(10,70,100,25);
//lblitem_name.setFont(new Font("ARIAL BLACK", Font.PLAIN,12));
 // lblitem_name.setForeground(Color.WHITE);
     add(lblitem_name);
           txtitem_name=new JTextField();
                txtitem_name.setBounds(140,70,150,25);
                add(txtitem_name);
  
       lbltb = new JLabel("Total Bought:");
     lbltb.setBounds(10,130,100,40);
 //lbltb.setFont(new Font("ARIAL BLACK", Font.PLAIN,12));
   //lbltb.setForeground(Color.WHITE);
     add(lbltb);
           txttb=new JTextField();
                txttb.setBounds(140,130,150,25);
                add(txttb);
 lblts = new JLabel("Total Sold:");
     lblts.setBounds(10,160,100,25);
 //lblts.setFont(new Font("ARIAL BLACK", Font.PLAIN,12));
   //lblts.setForeground(Color.WHITE);
     add(lblts);
           txtts=new JTextField();
                txtts.setBounds(140,160,150,25);
                add(txtts);

 lblci = new JLabel("Current Inventory:");
     lblci.setBounds(10,190,150,25);
 //lblci.setFont(new Font("ARIAL BLACK", Font.PLAIN,12));
  // lblci.setForeground(Color.WHITE);
     add(lblci);
           txtci=new JTextField();
                txtci.setBounds(140,190,150,25);
                add(txtci);


btnadd=new JButton("ADD");
              btnadd.setBounds(100,330,80,30);
              add(btnadd);


 btnclear=new JButton("CLEAR");
              btnclear.setBounds(200,330,80,30);
              add(btnclear);
 btnstatus=new JButton("STATUS");
              btnstatus.setBounds(300,330,90,30);
              add(btnstatus);
btnadd.addActionListener(this);
btnclear.addActionListener(this);
btnstatus.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
       

        if (e.getActionCommand().equalsIgnoreCase("STATUS")) {
            try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection  con = DriverManager.getConnection("jdbc:odbc:Inventory");
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

String sql1="select MAX(t_q) as maxt_q  from Inventory where Item_name='"+txtitem_name.getText()+"'";
			ResultSet rs1=st.executeQuery(sql1);
                                                    if(rs1.next())
                                                   {
        int w=rs1.getInt("maxt_q");
       String s9=String.valueOf(w);
       txttb.setText(s9);

  }
else
{ 
JOptionPane.showMessageDialog(null, "ID does not match", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                       }
       String sql3="select * from Inventory where Item_name='"+txtitem_name.getText()+"'";
        ResultSet rs3= st.executeQuery(sql3);
        if (rs3.next())
        {
       
        String f3=rs3.getString("invntry_id");
        txtinvntry_id.setText(f3);
    
}

String sql="select MAX(t_s) as maxt_s  from shipment where item_name='"+txtitem_name.getText()+"'";
			ResultSet rs=st.executeQuery(sql);
                                                    if(rs.next())
                                                   {
        int l=rs.getInt("maxt_s");
       String s11=String.valueOf(l);
       txtts.setText(s11);
}
else
{ 
JOptionPane.showMessageDialog(null, "Item does not match", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                       }


 } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
}
 if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection  con = DriverManager.getConnection("jdbc:odbc:Inventory");
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


     int  val =Integer.parseInt(txtts.getText());
     int val1=Integer.parseInt(txttb.getText());
     float pf=(val1-val);
     String s=String.valueOf(pf);
     txtci.setText(s);


                
                
                    String str = "INSERT INTO storage(invntry_id,item_name,total_bought,total_sold,current_invnt)"+
                             "values(?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,  txtinvntry_id.getText());
                 
                    ps.setString(2, txtitem_name.getText());
                    ps.setString(3,txttb.getText());
                    
                    
                    ps.setString(4, txtts.getText());
                  
                    
                    ps.setString(5, txtci.getText());
                 
                   
                 
                   
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Storage details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    //ClearForm();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
           
        }//if closed
     
       
       

 
  if (e.getActionCommand().equalsIgnoreCase("Clear")) {
            txtinvntry_id.setText("");
           txtitem_name.setText("");
           txttb.setText("");
           txtts.setText("");
          txtci.setText("");
             
  }
        
//catch (Exception ex) {
           // JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
      //  }//try catch closed*/


    }

 


     public static void main(String args[]) 
                             {
                                    Storage l=new Storage();
	                    l.setSize(600,550);
                                      l.setVisible(true);
                                      l.setLocation(100,100);
                                      l.setResizable(true);
                                }
}//class closed