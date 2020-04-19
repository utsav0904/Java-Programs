import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class MyBook implements Serializable
{
  static final long serialVersionUID=0;
  String bid,bauthor,bqty;
  String bname;
  int bprice;

 public MyBook()
{
  bid="";
  bname="";
  bprice=0;
  bauthor="";
  bqty="";
}
public String toString()
{
  return(" "+bid+"  "+bname+"  "+bprice+" "+bauthor+" "+bqty);
}
}
class MyFrame extends JFrame implements ActionListener
{
	JFrame frame=new JFrame("Book Management");
 	

		
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	
	
   JLabel l1,l2,l3,name,l4,l6;
   JTextField tf1,tf2,tf3,tf5,tf6;
   TextArea tf4;
   JButton b1,b2,b3,b4,b5,b6,b7;
   Container con;
   FileInputStream fis;
   ObjectInputStream ois;
   FileOutputStream fos;
   ObjectOutputStream oos;
   int nr;

public MyFrame() throws Exception
{
	
 super("Book Library");
 setSize(1500,900);
 setLocation(100,100);
 setLayout(null);
 l1=new JLabel("Book-ID");
 l2=new JLabel("Book-Name");
 l3=new JLabel("Book-Price");
 l4=new JLabel("Book-Author"); 
 l6=new JLabel("Book-Quantity");
 frame.setLayout(null);

	
 
 panel2.setLayout(new GridLayout(1,1));

	
	
	
 
 name = new JLabel("Book Library");
	Font f = new Font("Tahoma",Font.BOLD,50);
	name.setFont(f);
	panel3.setBounds(0,0,1500,80);
	frame.add(panel3);
	panel3.setBackground(Color.WHITE);
	panel3.add(name);


 tf1=new JTextField();
 tf2=new JTextField();
 tf3=new JTextField();
 tf5=new JTextField();
 tf6=new JTextField();
 tf4=new TextArea("",10,10,1);
 b1=new JButton("Clear");
 b2=new JButton("Close");
 b3=new JButton("Insert");
 b4=new JButton("Delete");
 b5=new JButton("Display");
 b6=new JButton("Search");
 b7=new JButton("Update");
 l1.setBounds(500,160,100,20);
 l2.setBounds(500,200,100,20);
 l4.setBounds(500,240,100,20);
 l3.setBounds(500,280,100,20);
 l6.setBounds(500,320,100,20);
 tf1.setBounds(620,160,230,20);
 tf2.setBounds(620,200,230,20);
 tf5.setBounds(620,240,230,20);
 tf3.setBounds(620,280,230,20);
 tf6.setBounds(620,320,230,20);
 tf4.setBounds(620,360,250,150);
 b1.setBounds(600,550,100,30);
 b2.setBounds(750,550,100,30);
 b3.setBounds(400,100,100,30);
 b4.setBounds(550,100,100,30);
 b5.setBounds(700,100,100,30);
 b6.setBounds(850,100,100,30);
 b7.setBounds(1000,100,100,30);

 con=getContentPane();
 
 con.add(panel3);
 
 con.add(l4);
 con.add(tf5);

 con.add(l1);
 con.add(l2);
 con.add(l3);
 con.add(l6);
 con.add(tf1);
 con.add(tf2);
 con.add(tf3);
 con.add(tf6);
 con.add(tf4);
 con.add(b1);
 con.add(b2);
 con.add(b3);
 con.add(b4);
 con.add(b5);
 con.add(b6);
 con.add(b7);
 b1.addActionListener(this);
 b2.addActionListener(this);
 b3.addActionListener(this); 
 b4.addActionListener(this);
 b5.addActionListener(this);
 b6.addActionListener(this);
 b7.addActionListener(this);
 setVisible(true);
 fos=new FileOutputStream("Book.dat");
 oos=new ObjectOutputStream(fos);
 nr=0;
 addWindowListener(new WindowAdapter()
 {
  public void windowClosing(WindowEvent we)
  {
   System.exit(0);
  }
 });
}

public void actionPerformed(ActionEvent ae)
{
 String st = ae.getActionCommand();
 try
 {
  if(st=="Insert") insert();
  else if(st=="Delete") deleter();
  else if(st=="Display") display();
  else if(st=="Search") query();
  else if(st=="Update") update();
  else if(st=="Clear") clear();
  else System.exit(0);
 }
catch(Exception e)
{
 System.out.println(e.toString());
}
}




void insert()throws Exception
{
 if((tf1.getText()).equalsIgnoreCase("") ||(tf2.getText()).equalsIgnoreCase("")|| (tf3.getText()).equalsIgnoreCase("")|| (tf5.getText()).equalsIgnoreCase("")|| (tf6.getText()).equalsIgnoreCase(""))
{
  JOptionPane.showMessageDialog(this,"Insert All Values...","",JOptionPane.INFORMATION_MESSAGE);
  return;
}

fis=new FileInputStream("book.dat"); //read byte stream from file 
ois=new ObjectInputStream(fis);

MyBook mb =new MyBook();
int i=0;
while(i<nr)
{
   mb=(MyBook)ois.readObject();
 //  System.out.println("Good");
   if((mb.bid).equalsIgnoreCase(tf1.getText()))
   {
     JOptionPane.showMessageDialog(this,"This Book is already exist. Please Insert Different Book-ID..","",JOptionPane.INFORMATION_MESSAGE);
     return;
   }
    i++;
}

 ois.close();

 mb.bid=tf1.getText();

 mb.bname=tf2.getText();
 mb.bauthor=tf5.getText();
 mb.bqty=tf6.getText();
 try
 {
   mb.bprice=Integer.parseInt(tf3.getText());
 }
 catch(NumberFormatException ne)
 {
   JOptionPane.showMessageDialog(this,"please insert numeric price...","",JOptionPane.INFORMATION_MESSAGE);
   tf3.setText("");
   return;

 }
 oos.writeObject(mb);
 JOptionPane.showMessageDialog(this,"Data has been saved","",JOptionPane.INFORMATION_MESSAGE);
 tf1.setText("");
 tf2.setText("");
 tf3.setText("");
 tf5.setText("");
 tf6.setText("");
 nr++;
}



 void deleter()throws Exception
 {
  if(nr==0)
   {
    JOptionPane.showMessageDialog(this,"No Records Found...","",JOptionPane.INFORMATION_MESSAGE);
    return;
   }
 fis=new FileInputStream("book.dat");//read a byte stream from file
 ois=new ObjectInputStream(fis);//read the object
 FileOutputStream fos1=new FileOutputStream("bookn.dat");//write a stream of bytes to a file
 ObjectOutputStream oos1=new ObjectOutputStream(fos1);//write java object to outputstream
 String st1=tf1.getText();
 if(st1.equalsIgnoreCase(""))
 {
  JOptionPane.showMessageDialog(this,"Insert Book-id...","",JOptionPane.INFORMATION_MESSAGE);
  return;
}
MyBook mb=new MyBook();
int i=0,f1=0;
while(i<nr)
{
  mb=(MyBook)ois.readObject();
  if(mb.bid.equals(st1))
  {
    f1=1;
  }
 i++;
}
if(f1==0)
{
  JOptionPane.showMessageDialog(this,"Record Not Found...","",JOptionPane.INFORMATION_MESSAGE);
  return;
}
ois.close();
fis=new FileInputStream("book.dat");
ois=new ObjectInputStream(fis);
i=0;
while(i<nr)
{
  mb=(MyBook)ois.readObject();
  i++;
  if(mb.bid.equals(st1))
 {
   continue;
 }
else
{
  oos1.writeObject(mb);
  System.out.println(mb);
}
}
JOptionPane.showMessageDialog(this,"values successfully Deleted","",JOptionPane.INFORMATION_MESSAGE);
tf1.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
tf6.setText("");
nr--;
try
{
  ois.close();
  oos1.close();
  FileInputStream fis1=new FileInputStream("bookn.dat");
  ObjectInputStream ois1=new ObjectInputStream(fis1);
  fos=new FileOutputStream("book.dat");
  oos=new ObjectOutputStream(fos);
  i=0;
  while(i<nr)
  {
    MyBook mb1=(MyBook)ois1.readObject();
    oos.writeObject(mb1);
    i++;
  }
 ois1.close();
}
  catch(Exception e){}
}



  void update()throws Exception
  {
    if(nr==0)
    {
     JOptionPane.showMessageDialog(this,"No Record Found..","",JOptionPane.INFORMATION_MESSAGE);
     return;
    }
    fis=new FileInputStream("book.dat");
    ois=new ObjectInputStream(fis);
    FileOutputStream fos1=new FileOutputStream("bookn.dat");
    ObjectOutputStream oos1=new ObjectOutputStream(fos1);
    String st1=tf1.getText();
    String st2=tf2.getText();
    String stt3=tf3.getText();
    String st5=tf5.getText();
    String st6=tf6.getText();
    if(st1.equalsIgnoreCase("")||st2.equalsIgnoreCase("")||stt3.equalsIgnoreCase("")||st5.equalsIgnoreCase("")||st6.equalsIgnoreCase(""))
    {
      JOptionPane.showMessageDialog(this,"Insert all Values...","",JOptionPane.INFORMATION_MESSAGE);
      return;
    }
  int st3=0;
   try
   {
     st3=Integer.parseInt(tf3.getText());
    }
  catch(NumberFormatException ne)
  {
    JOptionPane.showMessageDialog(this,"Insert Valid Price...","",JOptionPane.INFORMATION_MESSAGE);
    return;
  }
  MyBook mb=new MyBook();
  int i=0,f1=0;
  while(i<nr)
  {
    mb=(MyBook)ois.readObject();
    if(mb.bid.equals(st1))
    {
      f1=1;
    }
    i++;
  }
  if(f1==0)
  {
    JOptionPane.showMessageDialog(this,"Record Not Found...","",JOptionPane.INFORMATION_MESSAGE);
    return;
  }
  ois.close();
  fis=new FileInputStream("book.dat");
  ois=new ObjectInputStream(fis);
  i=0;
  while(i<nr)
  {
    mb=(MyBook)ois.readObject();
    i++;
    if(mb.bid.equals(st1))
    {
      mb.bname=st2;
      mb.bprice=st3;
      mb.bauthor=st5;
      mb.bqty=st6;
      oos1.writeObject(mb);
    }
  else
  {
    oos1.writeObject(mb);
    System.out.println(mb);
   }
}
JOptionPane.showMessageDialog(this,"Vlaues successfully Updated...","",JOptionPane.INFORMATION_MESSAGE);
 tf1.setText("");
 tf2.setText("");
 tf3.setText("");
 tf5.setText("");
 tf6.setText("");
 try
 {
   ois.close();
   oos1.close();
   FileInputStream fis1=new FileInputStream("bookn.dat");
   ObjectInputStream ois1=new ObjectInputStream(fis1);
   fos=new FileOutputStream("book.dat");
   oos=new ObjectOutputStream(fos);
   i=0;
   while(i<nr)
   {
     MyBook mb1=(MyBook)ois1.readObject();
     oos.writeObject(mb1);
     i++;
   }
    ois1.close();
  }
catch(Exception e)
{}
display();
}



 void display()throws Exception
 {
   tf4.setText("");
   if(nr==0)
   {
    JOptionPane.showMessageDialog(this,"No Record Found...","",JOptionPane.INFORMATION_MESSAGE);
    return;
   }
 fis=new FileInputStream("book.dat");
 ois=new ObjectInputStream(fis);
 int i=0;
 tf4.setText("ID  BookName  Price  Author  Quatity");
 tf4.append("\n------------------------\n");
 while(i<nr)
 {
  String st=(ois.readObject()).toString();
  tf4.append(st+"\n");
  i++;
 }
 
 
 

 
}
   void query()throws Exception
   {
    if(nr==0)
     {
      JOptionPane.showMessageDialog(this,"No Record Found...","",JOptionPane.INFORMATION_MESSAGE);
      return;
     }
  String st1=tf1.getText(),st2=tf2.getText();
  if(st1.equalsIgnoreCase("") && st2.equalsIgnoreCase(""))
  {
    JOptionPane.showMessageDialog(this,"Insert Book-Id or Book-Name...","",JOptionPane.INFORMATION_MESSAGE);
    return;
  }
 tf4.setText("");
 fis=new FileInputStream("book.dat");
 ois=new ObjectInputStream(fis);
 int i=nr,flag=0;
 tf4.setText("ID  BookName  Price  Author  Quatity");
 tf4.append("\n-------------------------------------\n");
 if(!st1.equalsIgnoreCase("") && st2.equalsIgnoreCase(""))
 {
   MyBook mb=new MyBook();
   while(i>0)
   {
     mb=(MyBook)ois.readObject();
     i--;
     if((mb.bid).equalsIgnoreCase(st1))
     {
       flag=1;
       tf4.append("\n"+mb.toString());
     }
 }
if(flag==0)
{
  JOptionPane.showMessageDialog(this,"No Reacords Found...","",JOptionPane.INFORMATION_MESSAGE);
}
}
  if(st1.equalsIgnoreCase("") && !st2.equalsIgnoreCase(""))
  {
    MyBook mb=new MyBook();
    while(i>0)
    {
      mb=(MyBook)ois.readObject();
      i--;
      if((mb.bname).equalsIgnoreCase(st2))
       {
         flag=1;
         tf4.append("\n" +mb.toString());}
}
if(flag==0)
{
  JOptionPane.showMessageDialog(this,"No Record Found...","",JOptionPane.INFORMATION_MESSAGE);
}
}
if(!st1.equalsIgnoreCase("") && !st2.equalsIgnoreCase(""))
{
  MyBook mb=new MyBook();
  while(i>0)
  {
   mb=(MyBook)ois.readObject();
   i--;
   if((mb.bid).equalsIgnoreCase(st1) && (mb.bname).equalsIgnoreCase(st2))
   {
     flag=1;
     tf4.append("\n" +mb.toString());
   }
  }
if(flag==0)
{
  JOptionPane.showMessageDialog(this,"No Record Found...","",JOptionPane.INFORMATION_MESSAGE);
}
}
}



void clear()
{
   tf1.setText("");
   tf2.setText("");
   tf3.setText("");
   tf4.setText("");
   tf5.setText("");
   tf6.setText("");
}
}

public class Ass1
{
  public static void main(String[] args) throws Exception
  {
    MyFrame mf1=new MyFrame();
  }
}






