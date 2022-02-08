import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class ME extends JFrame
{
JMenu menu1,menu2,menu3,submenu;
JMenuItem i1,i2,i3,i4,i5;
public ME()
{
JFrame f=new JFrame("Menu");
JMenuBar mb=new JMenuBar();
menu1=new JMenu("Home");
menu2=new JMenu("Login");
menu3=new JMenu("Inventory");
submenu =new JMenu("Inventory_details:");
i1=new JMenuItem("Storage_details");
i2= new JMenuItem("Item_details");
//i3=new JMenuItem("print preview");
menu3.add(i1);
menu3.add(i2);
//submenu.add(i3);
menu3.add(submenu);
menu1.add(submenu);
mb.add(menu3);
f.setJMenuBar(mb);
f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
}
public static void main(String args[])
{
new ME();
}
}
