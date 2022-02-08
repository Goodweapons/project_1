import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;


    public class As extends JFrame //implements ActionListener 
{
    
JTextField txtsben;
   
  JButton btnok;

   

     public As()
{
     super ("search Details Form");
      setLayout(null);     



JRadioButton option1=new JRadioButton("Search by Admin_name");
JRadioButton option2=new JRadioButton("Search by Admin_id");

ButtonGroup group=new ButtonGroup();
group.add(option1);
group.add(option2);

setLayout(new FlowLayout());
add(option1);
add(option2);

pack();
        
//btnok.addActionListener(this);
 
txtsben=new JTextField("                                           ");
 txtsben.setBounds(200,300,370,150);
                add(txtsben);

btnok=new JButton("OK");
              btnok.setBounds(200,300,30,30);
              add(btnok);


   }//constructor closed
public void actionPerformed(ActionEvent e) {
        
 if (e.getActionCommand().equalsIgnoreCase("ADD")) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:Inventory");
                try {
Statement st =con.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
String sql1="select * from admin where admin_id=' "+txtitemname.getText()+" ' ";
ResultSet rs1=st.executeQuery(sql1);
if( rs1.next())
{
String f = rs1.getString("selling_price");

txtrate.setText (f);
}






 } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed



                         public static void main(String args[]) 
                            {
SwingUtilities.invokeLater(new Runnable()
{
                                   public void run()
{
new As().setVisible(true);

                                    As l=new As();

	                    l.setSize(500,450);
                                }
});
}//class closed
}