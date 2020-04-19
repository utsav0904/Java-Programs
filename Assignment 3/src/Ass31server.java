import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ass31server {
	public static void main(String[] args) {
		try {
			ServerSocket oss=new ServerSocket(1234);
			System.out.println("\n Server Waiting for Connection");
			Socket os=oss.accept();
			System.out.println("\n Connected !!");
			
			OutputStream output=os.getOutputStream();
			File file=new File("new.txt");
			FileInputStream ofis=new FileInputStream(file);
			byte[] b=new byte[1024];
			int length=0;
			if((length=ofis.read(b))>0){
				output.write(b); 
				}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

