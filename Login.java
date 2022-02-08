import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Login extends JFrame implements ActionListener
{

        JLabel lbllogin,lblusername,lblpass;
        JTextField txtusername;
        JPasswordField txtpass;
        JButton btnlogin,btncancel;
       JRadioButton  admin, user;
        public Login()
           {
                super("LOGIN FORM");
                setLayout(null);
               getContentPane().setBackground(new Color(98,135,165));
               lbllogin=new JLabel(new ImageIcon("key.JPG"));
               lbllogin.setBounds(100,0,400,100);
               add(lbllogin);
                lblusername=new JLabel("USER NAME:");
                lblusername.setBounds(20,120,150,30);
                add(lblusername);
               lblusername.setFont(new Font("Arial Black",Font.PLAIN,12));
                lblusername.setForeground(Color.BLUE);

                txtusername=new JTextField();
                txtusername.setBounds(140,120,150,30);
                add(txtusername);

               lblpass=new JLabel("PASSWORD:");
               lblpass.setBounds(20,160,150,30);
               add(lblpass);
               lblpass.setFont(new Font("Arial Black",Font.PLAIN,12));
               lblpass.setForeground(Color.BLUE);

               txtpass=new JPasswordField();
               txtpass.setBounds(140,160,150,30);
               add(txtpass);

              btnlogin=new JButton("LOGIN");
              btnlogin.setBounds(120,230,80,30);
              add(btnlogin);
               btnlogin.setForeground(Color.BLUE);

               btncancel=new JButton("CANCEL");
               btncancel.setBounds(220,230,80,30);
               add(btncancel);
              btncancel.setForeground(Color.BLUE);
              
             btnlogin.addActionListener(this);
               btncancel.addActionListener(this);

          }//constructor closed

		  public void actionPerformed(ActionEvent e)
		  {
			  if (e.getSource()==btnlogin)
			  {
				 // System.out.println("OK");
				  try
				  {
					 // System.out.println("OK");
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con=DriverManager.getConnection("jdbc:odbc:Inventory");
				try
				{
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from login where user_name='"+txtusername.getText()+"' and password="+txtpass.getText()+"");
                if(rs.next())
				{
					//if((txtusername.equals(rs.getString(0)) && txtpass.equals(rs.getString(1)))	)
					if (rs.getString(3).equals("admin"))
					{
						Inventory frm = new Inventory();
                                                                                                           frm.setVisible(true);
                                                                                                           frm.setVisible(true);
                                                                                                           frm.setSize(700,600);
                        }
						else 
						{                            
                            new Login().setVisible(true);
                        }
            
						
						}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid username or password","invalid",JOptionPane.ERROR_MESSAGE);
				}
                con.close();
				
				  }
                catch(Exception e1)
                  {
			JOptionPane.showMessageDialog(null,"invalid username or password","invalid",JOptionPane.ERROR_MESSAGE);		  
                txtusername.setText("");
				txtpass.setText("");
				  }
 }
catch(Exception x)
{
JOptionPane.showMessageDialog(null,"unable to connect","Connection Error",JOptionPane.ERROR_MESSAGE);
}	
			  }
		  }

                         public static void main(String args[]) 
                             {
                                    Login l=new Login();
	                   l.setSize(400,400);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(true);

                             }
}//class closed
