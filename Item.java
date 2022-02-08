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



    public class Item extends JFrame implements ActionListener
  {
 JLabel lblitem_name,lblbarcode,lblitemdescrip,lblserial_no;
    
   JTextField txtitem_name;
   JTextField txtbarcode;
   JTextField txtitem_descrip;
  JTextField txtserial_no;
 
  JButton btnadd,btncancel,btnsearch;
JComboBox cmbdate,cmbconcession;
private Connection con;
private PreparedStatement ps;
   public Item()
{
     super ("Item Details Form");
setLayout(null);     
getContentPane().setBackground(new Color(98,135,165));

lblitem_name= new JLabel("Item_name:");
     lblitem_name.setBounds(30,40,100,30);
     add(lblitem_name);
cmbconcession=new JComboBox();

cmbconcession.addItem(" pc_glass window");
cmbconcession.addItem("pc_glass protector");
cmbconcession.addItem("pc_rotri glass");
cmbconcession.addItem("pc_lidd");
cmbconcession.addItem("he_body");
cmbconcession.addItem("he_tetryl booster");
cmbconcession.addItem("he_fuse");
cmbconcession.addItem("SMC_sefty slot");
cmbconcession.addItem("SMC_sling arm");
cmbconcession.addItem("SMC_handling");
cmbconcession.addItem("LMG_fore sight");
cmbconcession.addItem("LMG_piston");
cmbconcession.addItem("LMG_but plate");
cmbconcession.addItem("SLR_silling carrier");
cmbconcession.addItem("SLR_inject sight");
cmbconcession.addItem("SLR_body cover");

cmbconcession.setSelectedIndex(0);
cmbconcession.setBounds(150,50,150,25);
add(cmbconcession);
    
     lblserial_no = new JLabel("Serial_No:");
     lblserial_no.setBounds(30,80,100,30);
     add(lblserial_no);
     txtserial_no=new JTextField();
     txtserial_no.setBounds(150,80,150,25);
     add(txtserial_no);

    lblitemdescrip = new JLabel("Item_description:");
    lblitemdescrip.setBounds(30,110,100,30);
    add(lblitemdescrip);
    txtitem_descrip=new JTextField();
    txtitem_descrip.setBounds(150,110,150,25);
    add(txtitem_descrip);
   
  lblbarcode = new JLabel("Bar_code:");
  lblbarcode.setBounds(30,140,100,30);
  add(lblbarcode);
  txtbarcode=new JTextField();
  txtbarcode.setBounds(150,140,150,25);
  add(txtbarcode);

btnadd=new JButton("ADD");
              btnadd.setBounds(150,200,150,30);
              add(btnadd);
 btncancel=new JButton("CANCEL");
              btncancel.setBounds(150,240,150,30);
              add(btncancel);



 btnadd.addActionListener(this);
 btncancel.addActionListener(this);

}//constructor closed
        public void actionPerformed(ActionEvent e) {
        
if (e.getActionCommand().equalsIgnoreCase("ADD")) {
           try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                
                    String str = "INSERT INTO item_details (item_name,serial_no,item_descrip,bar_code)"+
                             "values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(str);
                 ps.setString(1,cmbconcession.getSelectedItem().toString());
                    ps.setString(2,  txtserial_no.getText());
                    ps.setString(3, txtitem_descrip.getText());
                   
                   ps.setString(4, txtbarcode.getText());
                 
                     ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Item details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
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
                                     Item l=new Item();
	                    l.setSize(800,800);
                                      l.setVisible(true);
                                      l.setLocation(100,100);
                                      l.setResizable(true);
                                }
}//class closed


