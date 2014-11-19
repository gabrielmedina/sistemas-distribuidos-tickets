import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InterfaceCaixaImpl extends UnicastRemoteObject implements
		InterfaceCaixa {
	// Atributos
	private static final long serialVersionUID = 1L;
	private ArrayList<Bilhete> bilhetes;
	private InterfacePainel implPainel;
	private int atendenteID = 1;

	// Construtores
	public InterfaceCaixaImpl(InterfacePainel implPainel) throws RemoteException {
		this.bilhetes = new ArrayList<Bilhete>();
		this.implPainel = implPainel;
	}

	// Métodos
	public String getAtendente(){
		return "Caixa " + this.atendenteID++;
	}
	
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

	public Bilhete proximoBilhete(String caixa) throws RemoteException {
		if(this.bilhetes.size() != 0){
			for(int i = 0; i < this.bilhetes.size(); i++){
				Bilhete bilhete = this.bilhetes.get(i);
				
				if(bilhete.getPrioridade().equalsIgnoreCase("Alta")){
					this.bilhetes.remove(i);
					
					bilhete.setAtendente(caixa);
					
					try {
						implPainel.proximoBilhete(bilhete);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return bilhete;
				}
			}		
			
			Bilhete bilhete = this.bilhetes.get(0);	
			this.bilhetes.remove(0);
			bilhete.setAtendente(caixa);
			
			try {
				implPainel.proximoBilhete(bilhete);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return bilhete;
		}
		
		return null;
	}
}
