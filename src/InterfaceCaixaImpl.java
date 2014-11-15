import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InterfaceCaixaImpl extends UnicastRemoteObject implements
		InterfaceCaixa {
	private static final long serialVersionUID = 1L;
	private ArrayList<Bilhete> bilhetes;

	// Construtor
	public InterfaceCaixaImpl() throws RemoteException {
		bilhetes = new ArrayList<Bilhete>();
	}

	// Métodos
	public Bilhete gerarBilhete(Bilhete bilhete) throws RemoteException {
		int senha;
		
		if(bilhetes.size() == 0){
			senha = 1;
		} else {
			Bilhete b = bilhetes.get(bilhetes.size() - 1);
			senha = Integer.parseInt(b.getSenha()) + 1;
		}

		bilhete.setSenha(String.valueOf(senha));
		bilhetes.add(bilhete);

		return bilhete;
	}

	public Bilhete proximoBilhete() {
		if(this.bilhetes.size() != 0){
			for(int i = 0; i < this.bilhetes.size(); i++){
				Bilhete bilhete = this.bilhetes.get(i);
				
				if(bilhete.getPrioridade().equalsIgnoreCase("Alta")){
					this.bilhetes.remove(i);
					
					return bilhete;
				}
			}		
			
			Bilhete bilhete = this.bilhetes.get(0);	
			this.bilhetes.remove(0);
			
			return bilhete;
		}
		
		return null;
	}
}
