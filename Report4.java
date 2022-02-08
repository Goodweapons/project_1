import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class Report4 extends JFrame implements Printable, ActionListener{
     JPanel headerPanel,titlePanel,dataPanel,btnPanel,masterPanel;
     String headerStr,titleStr;
     JTable table;
     DefaultTableModel dtm;
     Vector dataVector,temp,colVec;
     JScrollPane scrollPane;
     JLabel headerLabel,titleLabel;
     private JButton btnprint, btncancel;
     
     private Connection con;
     private Statement st;
      
     // Founction FOR PRINTING 
     
       public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now print the window and its visible contents */
        masterPanel.printAll(g);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
     public Report4(/*Connection con*/){
          headerPanel=new JPanel();
          headerPanel.setLayout(new BorderLayout());
          titlePanel=new JPanel();
          titlePanel.setLayout(new BorderLayout());
          dataPanel=new JPanel();
          dataPanel.setLayout(new BorderLayout());
          //you can take dynamic values here..
          headerStr="ORDER DETAILS";
          this.setSize(750,500);
          titleStr="LIST OF 0RDER DETAILS WITH CUSTOMER DETAILS";
          
          //Creating button for print
          btnprint= new JButton("Print");
          btnprint.addActionListener(this);
          btncancel = new JButton("Cancel");
          btncancel.addActionListener(this);
          btnPanel = new JPanel();
          btnPanel.add(btnprint);
          btnPanel.add(btncancel);
          
          //getContentPane().add(btnPanel,BorderLayout.SOUTH);
 
          colVec=new Vector();
          dataVector=new Vector();
          headerLabel=new JLabel(headerStr);
 
          headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
          titleLabel=new JLabel(titleStr);
          titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
          headerPanel.add(headerLabel,BorderLayout.NORTH);
          headerPanel.add(titleLabel,BorderLayout.CENTER);
          
          table=new JTable();
          try
          {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection con=DriverManager.getConnection("jdbc:odbc:Inventory");
               st=con.createStatement();
               ResultSet rs=st.executeQuery("select  *  from Requested");
               ResultSetMetaData md= rs.getMetaData();
               int columns =md.getColumnCount();
               String booktblheading[ ]={"ORDER ID","CUSTOMER NAME","MONTH","DATE","YEAR ","ADDRESS","ITEM_NAME","TOTAL QUANTITY","RATE","TOTAL AMOUNT"};
               for(int i=1; i<= booktblheading.length;i++)
               {
                    colVec.addElement(booktblheading[i-1]);
               }
               while(rs.next())
               {
                    Vector row = new Vector(columns);
                    for(int i=1;i<=columns;i++)
                    {
                         row.addElement(rs.getObject(i));
                         
                         
                    }
                    dataVector.addElement(row);
 
               }
               ((DefaultTableModel)table.getModel()).setDataVector(dataVector,colVec);
               rs.close();
               st.close();
          }
          catch(Exception e)
          {
               System.out.println(e);
          }
 
          
          /**dtm=new DefaultTableModel();

          dtm.setDataVector(dataVector,colVec);*/
          
          table.setShowHorizontalLines(false);
          table.setEnabled(false);
          table.getTableHeader().setBackground(Color.WHITE);
          scrollPane=new JScrollPane(table);
          scrollPane.setAutoscrolls(false);
          masterPanel = new JPanel();
          dataPanel.add(scrollPane,BorderLayout.CENTER);
          dataPanel.setPreferredSize(scrollPane.getPreferredSize());
          dataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          getContentPane().setPreferredSize(new Dimension(750,500));
          getContentPane().setLayout(new BorderLayout());
          headerPanel.setBackground(Color.WHITE);
          dataPanel.setBackground(Color.WHITE);
          masterPanel.setLayout(new BorderLayout());
          masterPanel.add(headerPanel,BorderLayout.NORTH);
          masterPanel.add(dataPanel,BorderLayout.CENTER);
          getContentPane().add(masterPanel,BorderLayout.CENTER);
          //getContentPane().setBackground(Color.WHITE);
          getContentPane().add(btnPanel,BorderLayout.SOUTH);
          
          pack();
          setVisible(true);
     
     }
public void actionPerformed(ActionEvent ae)
{
     Object obj = ae.getSource();
     if(obj==btnprint)
     {
          PrinterJob job = PrinterJob.getPrinterJob();
              job.setPrintable(this);
              boolean ok = job.printDialog();
              if (ok) 
          {
                  try {
                       job.print();
                      } 
               catch (PrinterException ex) 
               {
                        /* The job did not successfully complete */
                  }
             }
 
     }
     else if(obj== btncancel)
     {
          setVisible (false);
          dispose();
 
     }
}
public static void main(String args[])
{
new Report4();
}
     
}
 