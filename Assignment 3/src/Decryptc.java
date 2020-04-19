import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decryptc 
{

	public static void main(String[] args) 
	{
		try 
		{
			InetAddress ip = InetAddress.getByName("localhost");
			Socket os=new Socket(ip,9990);
			System.out.println("\n Connected to the server");
			
			byte[] buffer=new byte[65536];
			InputStream is=os.getInputStream();
			is.read(buffer);
			
			
			
			System.out.println("Cipher received :"+buffer.toString());
			String key="Hellohiihowareyo";
			 Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		       Cipher cipher = Cipher.getInstance("AES");
		       cipher.init(Cipher.DECRYPT_MODE, secretKey);

		       byte[] outputBytes = cipher.update(buffer);

		       File file=new File("Info.txt");
		       FileOutputStream outputStream = new FileOutputStream(file);
		       outputStream.write(outputBytes);
		       is.close();
		       outputStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

