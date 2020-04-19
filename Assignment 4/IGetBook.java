import java.rmi.*;
import java.rmi.Remote;

public interface IGetBook extends Remote
{	public String getBook(int id)throws RemoteException;	}