import java.rmi.*;
import java.net.*;

public class BookServer
{	public static void main(String args[])
	{	GetBook ogb;
		try
		{	ogb=new GetBook();
			String url="rmi://"+args[0]+":"+args[1]+"/GetBook";
			Naming.rebind(url,ogb);
			System.out.println("server running..");
		}
		catch(RemoteException re)
		{	System.out.println("Remote Exception :"+re.toString());	}
		catch(MalformedURLException e)
		{	System.out.println("URL Exception :"+e.toString());	}
		catch(Exception e)
		{	e.printStackTrace();	}
	}
}