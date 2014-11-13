import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class InterfaceImpl extends UnicastRemoteObject implements Interface {
	private static final long serialVersionUID = 1L;
	private ArrayList<Ticket> tickets;

	// Construtor
	public InterfaceImpl() throws RemoteException {
		tickets = new ArrayList<Ticket>();
		tickets.add(new Ticket("Padrao", "0", "baixa"));
	}

	// Métodos
	public Ticket gerarSenha(String cliente, String prioridade) throws RemoteException {
		Ticket ticket = tickets.get(tickets.size()- 1);
		
		int senha = Integer.parseInt(ticket.getSenha()) + 1;
		
		ticket.setCliente(cliente);
		ticket.setSenha(String.valueOf(senha));
		ticket.setPrioridade(prioridade);
		
		tickets.add(ticket);
		
		return ticket;
	}
	
	public Ticket getSenha(String caixa) throws RemoteException {
		Ticket ticket = tickets.get(0);
		ticket.setAtendente(caixa);
		
		return ticket;
	}
}
