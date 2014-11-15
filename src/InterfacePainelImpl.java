import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfacePainelImpl extends UnicastRemoteObject implements
		InterfacePainel {
	// Atributos
	private static final long serialVersionUID = 1L;
	
	// Construtores
	public InterfacePainelImpl() throws RemoteException {
		
	}

	// Métodos
	public Bilhete proximoBilhete(Bilhete bilhete) throws RemoteException {
		System.out.println("Próxima senha: " + bilhete.getSenha());
		
		return null;
	}
}
