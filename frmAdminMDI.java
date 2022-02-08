import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
//import javax.swing JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JMenuItem;

public class  frmAdminMDI  extends JFrame  implements ActionListener
{

    JLabel lblimg,lblimg1;
    private JMenuBar menubar;
    private JMenu mnuhome;
    private JMenu mnuinvntry;
    private JMenu mnucustg;
    private JMenu mnuemp;
    private JMenu mnufeedback;
    private JMenu mnulogin;
    private JMenu mnureport;

    private JMenuItem mnustorage;
    private JMenuItem mnuinvntry1;
    private JMenuItem mnuitem;
    private JMenuItem mnuorder;
    private JMenuItem mnuship;
    private JMenuItem mnuemp1;
    private JMenuItem mnumanager;
    private JMenuItem mnulogin1;
    private JMenuItem mnuview;
    private JMenuItem mnuradmin;
     private JMenuItem mnurshipment;
    private JMenuItem mnurinvnt;
    private JMenuItem mnurfeedback;
    private JMenuItem mnuremp;
    private JMenuItem mnurorder;
    private JMenuItem mnuadmin;
    
    public static JDesktopPane desktop;

    public frmAdminMDI()
 {
         super("Inventory Management System");
         setLayout(null);
         getContentPane().setBackground(new Color(0,51,102));
         lblimg=new JLabel(new ImageIcon("2.JPG"));
         lblimg.setBounds(0,0,1400,750);
         add(lblimg);
        
      
      
        desktop = new JDesktopPane();
       
        menubar = new JMenuBar();
        mnuhome = new JMenu("Home");
        mnulogin = new JMenu("Authentication");
        mnuinvntry = new JMenu("Inventory");
        mnucustg=new JMenu("Order");
        mnuemp = new JMenu("Employment");
        mnufeedback=new JMenu("Feedback");
        mnureport=new JMenu("Report");

        mnuinvntry1 = new JMenuItem("Inventory details");
        mnustorage = new JMenuItem("Storage deatils");
        mnuitem = new JMenuItem("Item details");
        mnuorder = new JMenuItem("Order details");
        mnuship= new JMenuItem("Shipment details");
        mnuemp1 = new JMenuItem("Emp details");
        mnulogin1=new JMenuItem("Login");
        mnumanager= new JMenuItem("Manager deatails");
        mnuview=new JMenuItem("share view");
        mnuadmin=new JMenuItem("Admin");
        mnuradmin=new JMenuItem("Admin_report");
        mnurinvnt=new JMenuItem("Inventory_report");
       mnurorder=new JMenuItem("Order_report");
       mnurshipment=new JMenuItem("Shipment_report");
       mnuremp=new JMenuItem("Employee_report");
       mnurfeedback=new JMenuItem("Feedback_report");
        
       mnureport.add(mnuradmin);
       mnureport.add(mnuremp);
       mnureport.add(mnurinvnt);
       mnureport.add(mnurorder);
       mnureport.add(mnurshipment);
       mnureport.add(mnurfeedback);
       mnuemp.add(mnuadmin);
       mnufeedback.add(mnuview);
       mnuinvntry.add(mnuinvntry1);
       mnuinvntry.add(mnuitem);
       mnuinvntry.add(mnustorage);
       mnuemp.addSeparator();
       mnuemp.add(mnuemp1);
       mnuemp.add(mnumanager);
       mnucustg.add(mnuorder);
       mnulogin.add(mnulogin1);
       mnucustg.add(mnuship);
    
    
        menubar.add(mnuhome);
        menubar.add(mnulogin);
        menubar.add(mnuinvntry);
        menubar.add(mnucustg);
        menubar.add(mnuemp);
        menubar.add(mnufeedback);
        menubar.add(mnureport);
       
       
         mnuorder.addActionListener(this);
        mnulogin1.addActionListener(this);
        mnuitem.addActionListener(this);
        mnustorage.addActionListener(this);
        mnuship.addActionListener(this);
        mnuemp1.addActionListener(this);
        mnumanager.addActionListener(this);
        mnuinvntry1.addActionListener(this);
        mnuview.addActionListener(this);
        mnuadmin.addActionListener(this);
       mnuradmin.addActionListener(this);
        mnurinvnt.addActionListener(this);
       mnurorder.addActionListener(this);
       mnurshipment.addActionListener(this);
       mnuremp.addActionListener(this);
       mnurfeedback.addActionListener(this);
        
        this.setJMenuBar(menubar);
        this.add(desktop);
        }//constructor closed
   
        public void actionPerformed(ActionEvent e) 
          {
        try
            {
            if (e.getSource() == mnuorder) {
            Req frm = new Req();
                frm.setVisible(true);
                frm.setSize(700,600);
            }
            if (e.getSource() == mnulogin1) {
               Login frm = new Login();
                frm.setVisible(true);
                frm.setSize(400,400);
            }
            if (e.getSource() == mnuitem) {
                Item frm = new Item();
                frm.setVisible(true);
               frm.setSize(700,600);
            }
            if (e.getSource() == mnustorage) {
                Storage frm = new Storage();
                frm.setVisible(true);
                frm.setSize(700,600);
            }
           if (e.getSource() == mnuemp1) {
                Employee frm = new Employee();
                frm.setVisible(true);
               frm.setSize(700,600);
            }
            if (e.getSource() == mnumanager) {
                Manager frm = new Manager();
                  frm.setVisible(true);
                  frm.setSize(700,600);
           
            }
            if (e.getSource() == mnuadmin) {
                Admin frm = new Admin();
                  frm.setVisible(true);
                  frm.setSize(700,600);
            }
            if (e.getSource() == mnuship) {
               Shipment frm = new Shipment();
                frm.setVisible(true);
                frm.setSize(700,600);            
             }
            if (e.getSource() == mnuview) {
                feedback frm = new feedback();
                frm.setVisible(true);
                frm.setSize(700,600);  
            }
         
       if (e.getSource() == mnuinvntry1) {
                Inventory frm = new Inventory();
                frm.setVisible(true);
                frm.setSize(700,600);
            }
 if (e.getSource() == mnuradmin) {
               Report1 frm = new Report1();
                frm.setVisible(true);
                frm.setSize(800,600);
            }

if (e.getSource() == mnurinvnt) {
               Report3 frm = new Report3();
                frm.setVisible(true);
                frm.setSize(800,600);
            }
if (e.getSource() == mnurorder) {
               Report4 frm = new Report4();
                frm.setVisible(true);
                frm.setSize(800,600);
            }
if (e.getSource() == mnurshipment) {
               Report5 frm = new Report5();
                frm.setVisible(true);
                frm.setSize(800,600);
            }
if (e.getSource() == mnuremp) {
               Report2 frm = new Report2();
                frm.setVisible(true);
                frm.setSize(800,600);
            }
if (e.getSource() == mnurfeedback) {
               Report6 frm = new Report6();
                frm.setVisible(true);
                frm.setSize(800,600);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed
    }//actionPerformed() closed

   public static void main(String args[]) 
                             {
                                    frmAdminMDI l=new frmAdminMDI();
	                    l.setSize(1360,800);
                                      l.setVisible(true);
                                      l.setLocation(0,0);
                                      l.setResizable(true);
                                }
} //class closed
