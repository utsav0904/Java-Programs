import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
public class Echos {
	
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(3005);
			Socket soc =  ss.accept();
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			String msg;
			
			while(true){
				
				msg = dis.readUTF();
				System.out.print("Client : ");
				System.out.println(msg);
				dos.writeUTF(msg);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
