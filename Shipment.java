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

 public  class Shipment extends JFrame implements ActionListener
{
JLabel lblorder_id,lblc_name,lbls_address,lbli_name,lblquantity,lblship_date,lblt_s;
    JTextField txtorder_id;
    JTextField txtc_name;
    JTextField txts_address;
    JTextField txti_name;
    JTextField txtquantity;
    JTextField txtship_date;
    JTextField txtt_s;
    JButton btnadd,btnclear,btnshow;
    
    private Statement str;
    private Connection con;
    private PreparedStatement ps;

  
 public Shipment()
      {
     super ("Shipment Details Form");
    getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);

     lblorder_id = new JLabel("Order_id:");
     lblorder_id.setBounds(30,40,100,30);
      add(lblorder_id);

      txtorder_id=new JTextField();
      txtorder_id.setBounds(130,40,150,25);
      add(txtorder_id);

       lblc_name = new JLabel("Cust_name:");
       lblc_name.setBounds(30,80,100,30);
       add(lblc_name);

       txtc_name=new JTextField();
       txtc_name.setBounds(130,80,150,25);
       add(txtc_name);

      lbls_address = new JLabel("Ship_address:");
      lbls_address.setBounds(30,120,100,30);
      add(lbls_address);

      txts_address=new JTextField();
      txts_address.setBounds(130,120,150,25);
      add(txts_address);
           
      lbli_name = new JLabel("Item_name:");
      lbli_name.setBounds(30,160,100,30);
      add(lbli_name);
           
       txti_name=new JTextField();
       txti_name.setBounds(130,160,150,25);
       add(txti_name);

      lblquantity = new JLabel("Quantity:");
      lblquantity.setBounds(30,200,100,30);
      add(lblquantity);
             
      txtquantity=new JTextField();
      txtquantity.setBounds(130,200,150,25);
      add(txtquantity);

     lblship_date = new JLabel("Ship_date:");
     lblship_date.setBounds(30,240,100,30);
      add(lblship_date);

     txtship_date=new JTextField();
     txtship_date.setBounds(130,240,150,25);
     add(txtship_date);
            
     lblt_s = new JLabel("Total_sold:");
     lblt_s.setBounds(30,280,100,30);
     add(lblt_s);

     txtt_s=new JTextField();
     txtt_s.setBounds(130,280,150,25);
     add(txtt_s);

               btnadd=new JButton("ADD");
               btnadd.setBounds(60,350,80,30);
               add(btnadd);
 
              btnclear=new JButton("CLEAR");
              btnclear.setBounds(160,350,80,30);
              add(btnclear);
 btnshow=new JButton("SHOW");
              btnshow.setBounds(260,350,80,30);
              add(btnshow);
                
btnadd.addActionListener(this);
btnclear.addActionListener(this);
btnshow.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
 {
      if (e.getActionCommand().equalsIgnoreCase("SHOW")) 
          {
            try
               {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                   
                       String sql1="select * from Requested where req_id='"+ txtorder_id.getText()+"'";
			ResultSet rs1=st.executeQuery(sql1);

			
			if(rs1.next())
                                                       {
                                                         String f4= rs1.getString("cust_name");
                                                           txtc_name.setText(f4);					
	                                        String f5= rs1.getString("address");
                                                           txts_address.setText(f5);	
                                                          String f6= rs1.getString("item_name");
                                                             txti_name.setText(f6);	
                                                            String f7= rs1.getString("quantity");
                                                             txtquantity.setText(f7);	    

                                                        }
                                                    else
                                                       {
                                                      JOptionPane.showMessageDialog(null, "Order_id does not match", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                       }
                  
                      String sql2="select MAX(t_s) as maxt_s  from shipment where item_name='"+txti_name.getText()+"'";
			ResultSet rs2=st.executeQuery(sql2);

			
			if(rs2.next())
                                             {
int w=rs2.getInt("maxt_s");
String s9=String.valueOf(w);
txtt_s.setText(s9);	
			
				
}
   else
{
 JOptionPane.showMessageDialog(null, "It's new item", "Success", JOptionPane.INFORMATION_MESSAGE);
}

               } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
		  }
      if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
int  val =Integer.parseInt( txtquantity.getText());
int val1=Integer.parseInt(txtt_s.getText());

	
int pf=(val1+val);
String s=String.valueOf(pf);
txtt_s.setText(s);




                
String str = "INSERT INTO shipment (order_id,cust_name,ship_address,item_name,quantity,ship_date,t_s)"+
                             "values(?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1, txtorder_id.getText());
                    ps.setString(2,  txtc_name.getText());
                    ps.setString(3, txts_address.getText());
                    ps.setString(4, txti_name.getText());
                   ps.setString(5, txtquantity.getText());
                   ps.setString(6, txtship_date.getText());
                   ps.setString(7, txtt_s.getText());
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Shipment details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
           
        }//if closed
    
        if (e.getActionCommand().equalsIgnoreCase("CLEAR")) {
             txtorder_id.setText("");
                     txtc_name.setText("");
                   txts_address.setText("");
                   txti_name.setText("");
                   txtquantity.setText("");
                   txtship_date.setText("");
                   txtt_s.setText("");
        }//if closed
}

             public static void main(String[] args) 
                             {
                                     Shipment l=new Shipment();
	                   l.setSize(450,400);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(true);
                                    
                                }
  }//class closed
