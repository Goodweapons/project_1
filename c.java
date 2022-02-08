import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
    public class c extends JFrame implements ActionListener
{
    JLabel lblorder_id;
    

   JTextField txtorder_id;
   
  JButton btnok;
private Statement str;
   private Connection con;
    private PreparedStatement ps;
     public c()
{
     super ("cancelation Form");
getContentPane().setBackground(new Color(98,135,165));
      setLayout(null);  

     lblorder_id = new JLabel("Order_id:");
     lblorder_id.setBounds(20,50,100,25);
     add(lblorder_id);
 //lblorder_id.setFont(new Font("Arial Black",Font.BOLD,12));
  // lblorder_id.setForeground(Color.BLACK);

     txtorder_id=new JTextField();
      txtorder_id.setBounds(120,50,100,25);
         add(txtorder_id);   

 btnok=new JButton("OK");
              btnok.setBounds(100,100,60,30);
              add(btnok);

btnok.addActionListener(this);
   
   }//constructor closed
public void actionPerformed(ActionEvent e) {
       
        if (e.getActionCommand().equalsIgnoreCase("OK")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
              
                 Statement st = con.createStatement();
 st.executeUpdate("delete from Requested where req_id='"+txtorder_id.getText()+"'");

                    JOptionPane.showMessageDialog(null, " details successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            
        }//if closed
    
       


    }


                         public static void main(String args[]) 
                            {
                                   c l=new c();
	                    l.setSize(250,200);
                                      l.setVisible(true);
                                      l.setLocation(50,50);
                                      l.setResizable(false);
                                }
}//class closed