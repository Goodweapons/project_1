import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Container;
import java.io.*;

 public  class Inventory extends JFrame implements ActionListener
{
    JLabel lblitem_name,lblinventory_id,lblquantity,lblquantity1,lblserial_no,lblk,lblo_d,lbls_d,lblc_p,lblprofit,lblitem_name1,lbltotal_cost,lbls_p,lblitem_name2;
    
   JTextField txtinventory_id;

   JTextField txtserial_no;
   JTextField txtquantity;
   JTextField txtquantity1;
  JTextField txtc_p;
  JTextField txts_p;
  JTextField txtprofit;  
  JTextField txtyear;
  JTextField txtyear1;
 JTextField txttotal_cost;
JTextField txt1;
JTextField txt2;
JButton btnadd,btnclear,btnsearch,btn1;
JComboBox cmbmonth,cmbconcession;
  JComboBox cmbmonth1,cmbconcession1;
JComboBox cmbdate2,cmbconcession2;
JComboBox cmbdate3,cmbconcession3;


   private Statement str;
   private Connection con;
    private PreparedStatement ps;
   
    public Inventory()
{
     super ("Inventory Details Form");
     setLayout(null);
getContentPane().setBackground(new Color(98,135,165));

        lblitem_name1 = new JLabel("Inventory Type:");
     lblitem_name1.setBounds(30,40,100,30);
     add(lblitem_name1);
 lblitem_name2 = new JLabel("Inventory  Id:");
     lblitem_name2.setBounds(460,40,100,30);
     add(lblitem_name2);
txtyear1=new JTextField();
                txtyear1.setBounds(440,70,120,25);
                add(txtyear1);

cmbconcession3=new JComboBox();
cmbconcession3.addItem("1_Prismetic Compass");
cmbconcession3.addItem("2_H.E. Granade");
cmbconcession3.addItem("3_Sten Machine Carbine");
cmbconcession3.addItem("4_Light Gun Machine");
cmbconcession3.addItem("5_Self Loading Rifle");

cmbconcession3.setSelectedIndex(0);
cmbconcession3.setBounds(130,40,170,25);
add(cmbconcession3);
 
  
     lblitem_name = new JLabel("Item name:");
     lblitem_name.setBounds(30,70,100,30);
     add(lblitem_name);


cmbconcession2=new JComboBox();
cmbconcession2.addItem(" pc_glass window");
cmbconcession2.addItem("pc_glass protector");
cmbconcession2.addItem("pc_rotri glass");
cmbconcession2.addItem("pc_lidd");
cmbconcession2.addItem("he_body");
cmbconcession2.addItem("he_tetryl booster");
cmbconcession2.addItem("he_fuse");
cmbconcession2.addItem("SMC_sefty slot");
cmbconcession2.addItem("SMC_sling arm");
cmbconcession2.addItem("SMC_handling");
cmbconcession2.addItem("LMG_fore sight");
cmbconcession2.addItem("LMG_piston");
cmbconcession2.addItem("LMG_but plate");
cmbconcession2.addItem("SLR_silling carrier");
cmbconcession2.addItem("SLR_inject sight");
cmbconcession2.addItem("SLR_body cover");
cmbconcession2.setSelectedIndex(0);
cmbconcession2.setBounds(130,70,170,25);
add(cmbconcession2);
    
     lblquantity = new JLabel("Quantity:");
     lblquantity.setBounds(30,100,100,30);
     add(lblquantity);
txtquantity=new JTextField();
                txtquantity.setBounds(130,100,170,25);
                add(txtquantity);

lblquantity1 = new JLabel("Total Quantity:");
     lblquantity1.setBounds(460,140,100,30);
     add(lblquantity1);
txtquantity1=new JTextField();
                txtquantity1.setBounds(440,170,120,25);
                add(txtquantity1);

 lblo_d = new JLabel("Receiving Date:");
     lblo_d.setBounds(30,170,100,30);

     add(lblo_d);
cmbconcession1=new JComboBox();

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
txtyear.setBounds(250,170,50,25);
add(txtyear);

lblc_p=new JLabel("Cost Price");
lblc_p.setBounds(30,220,100,30);
add(lblc_p);
txtc_p=new JTextField();
txtc_p.setBounds(130,220,170,25);
add(txtc_p);
lbls_p=new JLabel("Selling Price");
lbls_p.setBounds(30,250,100,30);
add(lbls_p);
txts_p=new JTextField();
txts_p.setBounds(130,250,170,25);
add(txts_p);

lblprofit=new JLabel("Profit/Loss");
lblprofit.setBounds(30,280,100,30);
add(lblprofit);
txtprofit=new JTextField();
txtprofit.setBounds(130,280,170,25);
add(txtprofit);

lbltotal_cost=new JLabel("Total Cost");
lbltotal_cost.setBounds(460,250,100,30);
add(lbltotal_cost);
txttotal_cost=new JTextField();
txttotal_cost.setBounds(440,280,120,25);
add(txttotal_cost);

 btnadd=new JButton("ADD");
              btnadd.setBounds(130,400,170,30);
              add(btnadd);
 btnclear=new JButton("CLEAR");
              btnclear.setBounds(440,400,120,30);
              add(btnclear);
 


btnadd.addActionListener(this);
btnclear.addActionListener(this);


   }//constructor closed
  public void actionPerformed(ActionEvent e) {
           
       if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
int  val =Integer.parseInt(txtc_p.getText());
int val1=Integer.parseInt(txts_p.getText());
float pf=(val1-val);
String s=String.valueOf(pf);
txtprofit.setText(s);

int  val2 =Integer.parseInt(txtc_p.getText());
int val3=Integer.parseInt(txtquantity.getText());
float pf1=(val2*val3);
String s1=String.valueOf(pf1);
txttotal_cost.setText(s1);


                                           try
			{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection  con = DriverManager.getConnection("jdbc:odbc:Inventory");
   Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
   String sql1="select MAX(t_q) as maxt_q  from Inventory where invntry_id='"+ txtyear1.getText()+"'";
			ResultSet rs1=st.executeQuery(sql1);

			
			if(rs1.next())
                                             {
int w=rs1.getInt("maxt_q");
String s9=String.valueOf(w);
 txtquantity1.setText(s9);
              				
		    }
int  val4 =Integer.parseInt(txtquantity.getText());
int val5=Integer.parseInt(txtquantity1.getText());
float pf2=(val4+val5);
String s2=String.valueOf(pf2);
txtquantity1.setText(s2);
		
                
try
{
String str = "INSERT INTO Inventory(invntry_type,Item_name,quantity,order_date1,order_date2,order_date3,cost_price,selling_price,profit_loss,totalcost,t_q,invntry_id)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1,cmbconcession3.getSelectedItem().toString());
                    ps.setString(2,cmbconcession2.getSelectedItem().toString());
                    ps.setString(3, txtquantity.getText());
                    ps.setString(4, cmbconcession1.getSelectedItem().toString());
                    ps.setString(5, cmbconcession.getSelectedItem().toString());
                    ps.setString(6, txtyear.getText());               
                    ps.setString(7,txtc_p.getText());
                    ps.setString(8,  txts_p.getText());
                    ps.setString(9, txtprofit.getText());
                   
                    ps.setString(10,  txttotal_cost.getText());
                     
                    ps.setString(11,  txtquantity1.getText());
                    ps.setString(12,  txtyear1.getText());
                    ps.executeUpdate();
           
                    JOptionPane.showMessageDialog(null, "Inventory details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
}
			catch (Exception ex)
			{
                           }
        }//if closed
       if (e.getActionCommand().equalsIgnoreCase("Clear")) {
          
        cmbconcession3.setSelectedIndex(0);
        cmbconcession2.setSelectedIndex(0);
        txtquantity.setText("");
       cmbconcession1.setSelectedIndex(0);
       cmbconcession.setSelectedIndex(0);
        txtyear.setText("");
        txtyear1.setText("");
        txtc_p.setText("");
        txts_p.setText("");
        txtprofit.setText("");
        txttotal_cost.setText("");
        txtquantity1.setText("");
  
}
}

                         public static void main(String[] args) 
                             {
                                    Inventory l=new Inventory();
	                    l.setSize(600,550);
                                      l.setVisible(true);
                                      l.setLocation(100,100);
                                      l.setResizable(true);
                                }
}//class closed