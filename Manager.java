import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Statement;
import java.awt.Container;

    public class Manager extends JFrame implements ActionListener
{
    JLabel lblusername,lblemail_id,lblmanager_id,lbladdress,lblmanager1,lblgndr;
    JTextField txtusername;
   JTextField txtemail_id;
   JTextField txtmanager_id;
   JTextField txtaddress;
  JButton btnadd,btncancel,btnsearch;
 JComboBox  cmbgender,cmbconcession;
JComboBox cmbmonth,cmbconcession1;

 private Connection con;
 private PreparedStatement ps;
private String gender;


     public Manager()
{
     super ("Manager Details Form");

getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);
// lblmanager1=new JLabel(new ImageIcon("employee-engagement.jpg"));
     //    lblmanager1.setBounds(300,0,100,150);
         //       add(lblmanager1);

     lblusername = new JLabel("Man_Name:");
     lblusername.setBounds(20,50,100,25);
     add(lblusername);
 

     txtusername=new JTextField();
      txtusername.setBounds(120,50,150,25);
         add(txtusername);

    lblemail_id = new JLabel("Email_id:");
     lblemail_id.setBounds(20,90,100,25);
     add(lblemail_id);



           txtemail_id=new JTextField();
                txtemail_id.setBounds(120,90,150,25);
                add(txtemail_id);

     lblmanager_id = new JLabel("Manager_id:");
     lblmanager_id.setBounds(20,130,100,25);
     add(lblmanager_id);


        txtmanager_id=new JTextField();
                txtmanager_id.setBounds(120,130,150,25);
                add(txtmanager_id);

     lbladdress = new JLabel("Address:");
     lbladdress.setBounds(20,170,100,25);
     add(lbladdress);


txtaddress=new JTextField();
                txtaddress.setBounds(120,170,150,25);
                add(txtaddress);
 btnadd=new JButton("ADD");
              btnadd.setBounds(80,280,80,30);
              add(btnadd);
 btncancel=new JButton("CANCEL");
              btncancel.setBounds(180,280,80,30);
              add(btncancel);
 btnsearch=new JButton("SEARCH");
              btnsearch.setBounds(280,280,90,30);
              add(btnsearch);

 lblgndr = new JLabel("Gender:");
     lblgndr.setBounds(20,200,100,25);
     add(lblgndr);


cmbconcession1=new JComboBox();
cmbconcession1.addItem("  Male  ");
cmbconcession1.addItem("  Female  ");
cmbconcession1.addItem("  Other  ");

cmbconcession1.setSelectedIndex(0);
cmbconcession1.setBounds(120,200,150,25);
add(cmbconcession1);
btnadd.addActionListener(this);
btncancel.addActionListener(this);
btnsearch.addActionListener(this);

   }//constructor closed
public void actionPerformed(ActionEvent e) {
        try {
 if (e.getSource() == btnsearch)
 {
               Ms frm = new Ms();
                frm.setVisible(true);
                frm.setSize(400,400);
                
            }
}
catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed


        if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                try {




                    String str = "INSERT INTO manager (man_name,email_id,man_id,address,gender)"+
                             "values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,  txtusername.getText());
                    ps.setString(2, txtemail_id.getText());
                    ps.setString(3,txtmanager_id.getText());
                    ps.setString(4, txtaddress.getText());
                   ps.setString(5,cmbconcession1.getSelectedItem().toString());
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Manager details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                 } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed
    
        if (e.getActionCommand().equalsIgnoreCase("Cancel")) {
            this.dispose();
        }//if closed

    
}


                         public static void main(String args[]) 
                             {
                                    Manager l=new Manager();
	                    l.setSize(450,400);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(true);
                                }
}//class closed