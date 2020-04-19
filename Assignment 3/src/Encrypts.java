import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypts
{
	public static void main(String[] args) 
	{
		 try {
			 String key="Hellohiihowareyo";
		       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		       Cipher cipher = Cipher.getInstance("AES");
		       cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		       File file=new File("Info.txt");
		       FileInputStream ofis = new FileInputStream(file);
		       byte[] buffer = new byte[(int)file.length()];
		       ofis.read(buffer);

		       byte[] cipherText = cipher.update(buffer);
		       System.out.println("\n Encrypted :"+cipherText.toString());
		      
		       
		       ServerSocket oss=new ServerSocket(9990);
				System.out.println("\n Waiting for the client to connect");
				Socket os=oss.accept();
				OutputStream output=os.getOutputStream();
				output.write(cipherText);
				ofis.close();
				output.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
}
