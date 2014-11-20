
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePainel extends Remote {
	public Bilhete proximoBilhete(Bilhete bilhete) throws RemoteException;
}
