
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCaixa extends Remote {
	public String getAtendente() throws RemoteException;
	
	public Bilhete gerarBilhete(Bilhete ticket) throws RemoteException;

	public Bilhete proximoBilhete(String atendente) throws RemoteException;
	
	public Boolean checarFila() throws RemoteException;
}
