import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
public class Echoc {
	
	public static void main(String[] args) {
		try {
			Socket soc = new Socket(InetAddress.getLocalHost().getHostAddress(),3005);		
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			String msg;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				
				msg = br.readLine();
				System.out.print("Client : ");
				System.out.println(msg);
				dos.writeUTF(msg);
				msg = dis.readUTF();
				System.out.print("Server : ");
				System.out.println(msg);
			}
		} catch (IOException e) {	
			e.printStackTrace();
		}		
}
}
