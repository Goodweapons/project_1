import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
//import java.maths.*;
//import javax.swing.JTextField;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Container;
import java.io.*;



    public class Invntrys extends JFrame
{
    JLabel lblsearchbyid;
    

   JTextField txtsbid;
  // JTextField txtsbed;
  // JRadioButton sbed,sben;
  JButton btnok;
private Connection con;

     public Invntrys()
{
     super ("search Details Form");
      setLayout(null);     






   public  class Inventory extends JFrame implements ActionListener
{
    JLabel lblitem_name,lblinventory_id,lblquantity,lblserial_no,lblk,lblo_d,lbls_d,lblc_p,lbls_p,lblprofit,lblitem_name1;
    
   JTextField txtinventory_id;

   JTextField txtserial_no;
   JTextField txtquantity;
  JTextField txtc_p;
  JTextField txts_p;
  JTextField txtprofit;  
  JTextField txtyear;
  JTextField txtyear1;
JTextField txt1;
JButton btnadd,btncancel,btnsearch,btn1;
JComboBox cmbmonth,cmbconcession;
  JComboBox cmbmonth1,cmbconcession1;
JComboBox cmbdate2,cmbconcession2;
JComboBox cmbdate3,cmbconcession3;
JComboBox cmbdate4,cmbconcession4;
   // private Statement str;
   private Connection con;
    private PreparedStatement ps;
   private int x;
  private int y;


     public Inventory()
{
     super ("Inventory Details Form");
     setLayout(null);
getContentPane().setBackground(new Color(98,135,165));

        lblitem_name1 = new JLabel("Inventory_id:");
     lblitem_name1.setBounds(30,40,80,30);
     add(lblitem_name1);
txt1=new JTextField();
                txt1.setBounds(130,40,80,25);
                add(txt1);
    
     lblitem_name = new JLabel("Item_name:");
     lblitem_name.setBounds(30,70,80,30);
     add(lblitem_name);


cmbconcession2=new JComboBox();
//cmbconcession2.additem(" ");
cmbconcession2.addItem("abc");
cmbconcession2.addItem("def");
cmbconcession2.addItem("geh");
cmbconcession2.addItem("ijk");
cmbconcession2.addItem("medicine");
cmbconcession2.addItem("books");
cmbconcession2.addItem("");
cmbconcession2.addItem("");
cmbconcession2.addItem("");
cmbconcession2.addItem("");
cmbconcession2.addItem("");
cmbconcession2.addItem("");
cmbconcession2.setSelectedIndex(0);
cmbconcession2.setBounds(130,70,80,25);
add(cmbconcession2);
    
     lblquantity = new JLabel("Quantity:");
     lblquantity.setBounds(30,100,80,30);
     add(lblquantity);
txtquantity=new JTextField();
                txtquantity.setBounds(130,100,80,25);
                add(txtquantity);
/*lblserial_no=new JLabel(" Serial_no");
lblserial_no.setBounds(30,140,80,30);
add(lblserial_no);
txtserial_no=new JTextField();
txtserial_no.setBounds(130,140,80,25);
add(txtserial_no);*/
 lblo_d = new JLabel("Order_Date:");
     lblo_d.setBounds(30,170,80,30);
//lblo_d.setFont(new Font("serif",Font.BOLD,12));
//lblo_d.setForeground(Color.BLACK);
     add(lblo_d);
cmbconcession1=new JComboBox();
cmbconcession1.addItem("    ");

cmbconcession1.addItem("1");
cmbconcession1.addItem("2");
cmbconcession1.addItem("3");
cmbconcession1.addItem("4");
cmbconcession1.addItem("5");
cmbconcession1.addItem(" 6 ");

cmbconcession1.addItem("7");
cmbconcession1.addItem("8");
cmbconcession1.addItem("9");
cmbconcession1.addItem("10");
cmbconcession1.addItem("11");
cmbconcession1.addItem(" 12 ");

cmbconcession1.addItem("13");
cmbconcession1.addItem("14");
cmbconcession1.addItem("15");
cmbconcession1.addItem("16");
cmbconcession1.addItem("17");
cmbconcession1.addItem("18 ");

cmbconcession1.addItem("19");
cmbconcession1.addItem("20");
cmbconcession1.addItem("21");
cmbconcession1.addItem("22");
cmbconcession1.addItem("23");
cmbconcession1.addItem(" 24 ");

cmbconcession1.addItem("25");
cmbconcession1.addItem("26");
cmbconcession1.addItem("27");
cmbconcession1.addItem("28");
cmbconcession1.addItem("29");
cmbconcession1.addItem("30");

cmbconcession1.setSelectedIndex(0);
cmbconcession1.setBounds(130,170,50,25);
add(cmbconcession1);

cmbconcession=new JComboBox();
//cmbconcession.additem(" ");
cmbconcession.addItem("Jan");
cmbconcession.addItem("Feb");
cmbconcession.addItem("Mar");
cmbconcession.addItem("Apr");
cmbconcession.addItem("May");
cmbconcession.addItem("June");
cmbconcession.addItem("July");
cmbconcession.addItem("Aug");
cmbconcession.addItem("Sep");
cmbconcession.addItem("Oct");
cmbconcession.addItem("Nov");
cmbconcession.addItem("Dec");
cmbconcession.setSelectedIndex(0);
cmbconcession.setBounds(190,170,50,25);
add(cmbconcession);
txtyear=new JTextField();
txtyear.setBounds(250,170,50,20);
add(txtyear);

lbls_d = new JLabel("Shipment_date:");
     lbls_d.setBounds(30,190,100,30);
     add(lbls_d);


txtyear1=new JTextField();
txtyear1.setBounds(250,195,50,20);
add(txtyear1);

lblc_p=new JLabel("Cost Price");
lblc_p.setBounds(30,220,80,30);
add(lblc_p);
txtc_p=new JTextField();
txtc_p.setBounds(130,220,80,25);
add(txtc_p);
lbls_p=new JLabel("Selling Price");
lbls_p.setBounds(30,250,80,30);
add(lbls_p);
txts_p=new JTextField();
txts_p.setBounds(130,250,80,25);
add(txts_p);

lblprofit=new JLabel("Profit/Loss");
lblprofit.setBounds(30,280,80,30);
add(lblprofit);
txtprofit=new JTextField();
txtprofit.setBounds(130,280,80,25);
add(txtprofit);

 


    

 btnok=new JButton("OK");
              btnok.setBounds(150,150,60,30);
              add(btnok);

btnok.addActionListener(this);


   
   }//constructor closed
public void actionPerformed(ActionEvent e) {
if (e.getActionCommand().equalsIgnoreCase("OK")) {
            try {

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con  = DriverManager.getConnection("jdbc:odbc:Inventory");
                
Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String sql="select * from Inventory where invntry_id=' "+txtsbid.getText()+" ' ";
ResultSet rs=st.executeQuery(sql);
if(rs.next());
String f=rs1.getString("Item_name");
txt
 } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error on retrieving admission number" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }//inner try closed
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error on database connection, Closing window", "Error", JOptionPane.ERROR_MESSAGE);
    }//try catch closed*/
 }

                         public static void main(String args[]) 
                            {
                                   Invntrys l=new Invntrys();
	                    l.setSize(350,300);
                                      l.setVisible(true);
                                      l.setLocation(150,150);
                                      l.setResizable(false);
                                }
}//class closed