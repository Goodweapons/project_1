import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

    public class Is extends JFrame
{
    JLabel lblsearchbyis;
    
   JTextField txtsbis;
   JButton btnok;


     public Is()
{
     super ("search Details Form");
     getContentPane().setBackground(new Color(98,135,165));
      setLayout(null);    

    lblsearchbyis= new JLabel("Search by Item_name:");
     lblsearchbyis.setBounds(10,60,150,25);
     add(lblsearchbyis);
           txtsbis=new JTextField();
                txtsbis.setBounds(160,60,150,25);
                add( txtsbis);

  btnok=new JButton("OK");
              btnok.setBounds(150,150,60,30);
              add(btnok);

   }//constructor closed

                         public static void main(String args[]) 
                            {
                                   Is l=new Is();
	                    l.setSize(300,250);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(false);
                                }
}//class closed