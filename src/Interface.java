import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	public Ticket gerarSenha(String cliente, String prioridade) throws RemoteException;
	public Ticket getSenha(String caixa) throws RemoteException;
}
