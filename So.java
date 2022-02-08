import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

    public class So extends JFrame
{
    JLabel lblsearchbycname,lblsearchbyorder_no,lblsearchbyemp_id;
    

   JTextField txtsbcn;
   JTextField txtsbod;
   
  JButton btnok;


     public So()
{
     super ("search Details Form");
      setLayout(null);     


     lblsearchbyemp_id = new JLabel("Search by Cust_name:");
     lblsearchbyemp_id.setBounds(40,80,150,30);
     add(lblsearchbyemp_id);
        txtsbcn=new JTextField();
                txtsbcn.setBounds(170,80,100,25);
                add(txtsbcn);

 btnok=new JButton("OK");
              btnok.setBounds(100,150,60,30);
              add(btnok);


   
   }//constructor closed

                         public static void main(String args[]) 
                            {
                                   So l=new So();
	                    l.setSize(300,250);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(false);
                                }
}//class closed