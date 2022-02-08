import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Statement;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class  Admin extends JFrame implements ActionListener


{
    JLabel lbladname,lbladmin_id,lblemail_id,lbladdress,lblcolor;


   JTextField txtadname;
   JTextField txtadmin_id;
   JTextField txtaddress;
   JTextField txtemail_id;
 
  JButton btnadd,btncancel,btnsearch;

private Connection con;
private PreparedStatement ps;

   public Admin()
{
     super ("Admin Details Form");
setLayout(null);
getContentPane().setBackground(new Color(98,135,165));

    lbladname= new JLabel("Admin_name:");
     lbladname.setBounds(20,50,100,30);
     add(lbladname);
           txtadname=new JTextField();
                txtadname.setBounds(110,50,150,30);
                add(txtadname);

     lbladmin_id = new JLabel("Admin_id:");
     lbladmin_id.setBounds(20,90,100,30);
     add(lbladmin_id);
        txtadmin_id=new JTextField();
                txtadmin_id.setBounds(110,90,150,30);
                add(txtadmin_id);

     lbladdress = new JLabel("Address:");
     lbladdress.setBounds(20,130,100,30);
     add(lbladdress);
         txtaddress=new JTextField();
                txtaddress.setBounds(110,130,150,30);
                add(txtaddress);

    lblemail_id = new JLabel("Email_id:");
     lblemail_id.setBounds(20,170,100,30);
     add(lblemail_id);
         txtemail_id=new JTextField();
                txtemail_id.setBounds(110,170,150,30);
                add(txtemail_id);
btnadd=new JButton("ADD");
              btnadd.setBounds(100,230,80,30);
              add(btnadd);
 btncancel=new JButton("CANCEL");
              btncancel.setBounds(200,230,80,30);
              add(btncancel);

btnadd.addActionListener(this);
btncancel.addActionListener(this);


   
   }//constructor closed

public void actionPerformed(ActionEvent e) {
  

        if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                
                    String str = "INSERT INTO admin (admin_name,admin_id,address,email_id)"+
                             "values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,txtadname.getText());
                    ps.setString(2, txtadmin_id.getText());
                   
                    ps.setString(3, txtaddress.getText());
                    ps.setString(4,txtemail_id.getText());
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Admin details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
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
                                    Admin l=new Admin();
	                    l.setSize(500,425);
                                      l.setVisible(true);
                                      l.setLocation(200,200);
                                      l.setResizable(false);
                                }

}//class closed