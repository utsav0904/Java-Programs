import java.rmi.*;
import java.net.*;
import java.util.*;

public class BookClient
{	public static void main(String[] args)
	{	Scanner sc=new Scanner(System.in);
		String url="rmi://"+args[0]+":"+args[1]+"/GetBook";
		int id;
		try
		{	Object o=Naming.lookup(url);
			IGetBook igb=(IGetBook)o;
			System.out.print("Book Number : ");
			id=sc.nextInt();
			String bookdata=igb.getBook(id);
			if(bookdata!=null)
			{	System.out.println("\n\nYour Book details \n"+bookdata);
System.out.println("\n\n Book Id  Name");
System.out.println("\n\n 1        Java Programming" );		}
			else
			{	System.out.println("Book is not available");	}
		}
		catch(RemoteException re)
		{	System.out.println("Remote Exception :"+re.toString());	}
		catch(MalformedURLException e)
		{	System.out.println("URL Exception :"+e.toString());	}
		catch(Exception e)
		{	e.printStackTrace();	}
	}
}