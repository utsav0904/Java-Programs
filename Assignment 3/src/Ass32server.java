import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Ass32server {
	public static void main(String[] args){
		try {
			DatagramSocket ods=new DatagramSocket(9998);
			System.out.println("\n Datagram socket created...");
			byte[] buffer=new byte[2048];
			
				DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
				ods.receive(odpReceiving);
				String filename=new String(odpReceiving.getData(), 0, odpReceiving.getLength());
				System.out.println("File Name: "+filename);
		
				try	{
					File file=new File(filename);
					FileInputStream ofis=new FileInputStream(file);
					int length=ofis.read(buffer);	
				}catch(FileNotFoundException e){
					buffer="Requested file not Found".getBytes();
				}
				
				InetAddress ip=odpReceiving.getAddress();
				int port=odpReceiving.getPort();
				System.out.println("Reading buffer of length :"+buffer.length+" data:"+new String(buffer));
				DatagramPacket odpSending=new DatagramPacket(buffer,buffer.length,ip,port);
				ods.send(odpSending);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
