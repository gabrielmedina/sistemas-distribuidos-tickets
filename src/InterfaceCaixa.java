import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceCaixa extends Remote {
	public String getAtendente() throws RemoteException;
	
	public Bilhete gerarBilhete(Bilhete ticket) throws RemoteException;

	public Bilhete proximoBilhete(String atendente) throws RemoteException;
}
