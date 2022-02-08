import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.sql.Statement;
import java.awt.Container;



    public class Employee extends JFrame implements ActionListener
  {
    JLabel lblemp_id,lblempname,lbladdress,lblphone_no,lblemployee,lblqlfcsn,lblgndr;
    
   JTextField txtemp_id;
   JTextField txtempname;
   JTextField txtaddress;
   JTextField txtphone_no;
   JTextField txtqlfcsn;
   JButton btnadd,btncancel;
  JRadioButton Male,Female,Other;
  JComboBox cmbmonth,cmbconcession;
  JComboBox cmbmonth1,cmbconcession1;
  private Connection con;
  private PreparedStatement ps;

     public Employee()
  {
     super ("Employee Details Form");
     getContentPane().setBackground(new Color(98,135,165));
     setLayout(null);
    // lblemployee=new JLabel(new ImageIcon("desert.JPG"));
   //lblemployee.setBounds(250,55,250,150);
             //   add(lblemployee);
            
    lblempname = new JLabel("Emp_name:");
     lblempname.setBounds(20,55,100,25);
     add(lblempname);
   
           txtempname=new JTextField();
                txtempname.setBounds(150,55,100,25);
                add(txtempname);

     lblemp_id = new JLabel("Emp_id:");
     lblemp_id.setBounds(20,90,100,25);
     add(lblemp_id);
    
        txtemp_id=new JTextField();
                txtemp_id.setBounds(150,90,100,25);
                add(txtemp_id);

     lbladdress = new JLabel("Address:");
     lbladdress.setBounds(20,120,100,25);
     add(lbladdress);
   
         txtaddress=new JTextField();
                txtaddress.setBounds(150,120,100,25);
                add(txtaddress);

         lblphone_no = new JLabel("Phone_no:");
     lblphone_no.setBounds(20,150,150,25);
     add(lblphone_no);

txtphone_no=new JTextField();
                txtphone_no.setBounds(150,150,100,25);
                add(txtphone_no);

lblqlfcsn = new JLabel("Qualification:");
     lblqlfcsn.setBounds(20,180,150,30);
     add(lblqlfcsn);

cmbconcession=new JComboBox();
cmbconcession.addItem("    ");

cmbconcession.addItem("Matriculation");
cmbconcession.addItem("Intermediate");
cmbconcession.addItem("Graduate");
cmbconcession.addItem("Post Graduate");
cmbconcession.addItem("Other");


cmbconcession.setSelectedIndex(0);
cmbconcession.setBounds(150,180,100,25);
add(cmbconcession);
lblgndr = new JLabel("Gender:");
     lblgndr.setBounds(20,210,150,30);
     add(lblgndr);



 
cmbconcession1=new JComboBox();
cmbconcession1.addItem("  Male  ");
cmbconcession1.addItem("  Female  ");
cmbconcession1.addItem("  Other  ");

cmbconcession1.setSelectedIndex(0);
cmbconcession1.setBounds(150,220,100,25);
add(cmbconcession1);

btnadd=new JButton("ADD");
              btnadd.setBounds(100,330,80,30);
              add(btnadd);
 btncancel=new JButton("CANCEL");
              btncancel.setBounds(200,330,80,30);
              add(btncancel);
 

btnadd.addActionListener(this);
btncancel.addActionListener(this);



   }//constructor closed
public void actionPerformed(ActionEvent e) {
      

        if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
              
                    String str = "INSERT INTO employee (emp_name,emp_id,address,phone_no,qualification,gender)"+
                             "values(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,  txtempname.getText());
                    ps.setString(2, txtemp_id.getText());
                   
                    ps.setString(3, txtaddress.getText());
                    ps.setString(4,txtphone_no.getText());
                   ps.setString(5,cmbconcession.getSelectedItem().toString());
                   ps.setString(6,cmbconcession1.getSelectedItem().toString());
                  
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Employee details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
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
                                    Employee l=new Employee();
	                    l.setSize(500,450);
                                      l.setVisible(true);
                                      l.setLocation(0,0);
                                      l.setResizable(false);
                                }
}//class closed