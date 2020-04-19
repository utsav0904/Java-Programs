import java.net.*;
import java.io.*;
public class Proxy
{

ServerSocket ss;
Socket s,s1;
InputStream is;
OutputStream os;
DataInputStream dis;
DataOutputStream dos;
int port2;

public Proxy(int port1,int p2) throws IOException
{
ss=new ServerSocket(port1);
port2=p2;
s=ss.accept();
s1=new Socket("127.0.0.1",port2);
doChat();
os.close();
is.close();
dis.close();
s.close();
ss.close();
}

public void doChat() throws IOException
{
String str;
do
{
is=s1.getInputStream();
dis=new DataInputStream(is);
str=dis.readUTF();
System.out.println("Msg received from server: "+str);
os=s.getOutputStream();
dos=new DataOutputStream(os);
dos.writeUTF(str+" from proxy");
is=s.getInputStream();
dis=new DataInputStream(is);
str=dis.readUTF();
System.out.println("Msg received from client: "+str);
os=s1.getOutputStream();
dos=new DataOutputStream(os);
dos.writeUTF(str);


}while(!str.equals("bye"));
}

public static void main(String[] args)throws IOException
{
  Proxy cs=new Proxy(4000,3000);
}}
