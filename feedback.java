import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Statement;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class  feedback extends JFrame implements ActionListener

{
JLabel lblorder_no,lblfeedback;
    JTextField txtfeedback;
   JTextField txtorder_no;
   //JTextField txtp_name;
   
  JButton btnadd,btncancel;
private Statement str;
    private Connection con;
    private PreparedStatement ps;

   public feedback()
{
     super ("`Feedback  Form");
getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);

     lblorder_no = new JLabel("Order_no:");
     lblorder_no.setBounds(100,100,150,30);
 lblorder_no.setFont(new Font("ARIAL BLACK", Font.PLAIN,16));
   lblorder_no.setForeground(Color.BLUE);

     add(lblorder_no);
txtorder_no=new JTextField();
      txtorder_no.setBounds(250,100,150,30);
         add(txtorder_no);
 lblfeedback = new JLabel("Feedback:");
     lblfeedback.setBounds(100,170,150,30);
 lblfeedback.setFont(new Font("ARIAL BLACK", Font.PLAIN,18));
   lblfeedback.setForeground(Color.BLUE);
     add(lblfeedback);
           txtfeedback=new JTextField();
                txtfeedback.setBounds(250,170,150,50);
                add(txtfeedback);

   
 btnadd=new JButton("ADD");
              btnadd.setBounds(240,280,80,30);
              add(btnadd);
btnadd.setForeground(Color.BLUE);



 btncancel=new JButton("CANCEL");
              btncancel.setBounds(330,280,80,30);
              add(btncancel);
btncancel.setForeground(Color.BLUE);
btnadd.addActionListener(this);
btncancel.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
      
        if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                
                    String str = "INSERT INTO feedback (order_no,feedback)"+
                             "values(?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,txtorder_no.getText());
                    ps.setString(2, txtfeedback.getText());
                   
                   
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, " THANKS FOR VIEWS", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
         
        }//if closed
    
        if (e.getActionCommand().equalsIgnoreCase("Cancel")) {
            this.dispose();
        }//if closed


    
}








     public static void main(String args[]) 
                             {
                                 feedback l=new feedback();
	                    l.setSize(550,400);
                                      l.setVisible(true);
                                      l.setLocation(100,100);
                                      l.setResizable(true);
                                }
}//class closed