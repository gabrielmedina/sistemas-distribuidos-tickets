import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Caixa {
	private String caixa;
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa impl = (InterfaceCaixa) registry.lookup("hey");

			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Chamar o próximo bilhete");
			
			while (scanner.nextLine() != null) {
				Bilhete bilhete = impl.proximoBilhete();
				
				if(bilhete != null){
					System.out.println("--------------------");
					System.out.println("Cliente: " + bilhete.getCliente());
					System.out.println("Prioridade: " + bilhete.getPrioridade());
					System.out.println("--------------------");
				} else {
					System.out.println("--------------------");
					System.out.println("Sem bilhetes");
					System.out.println("--------------------");
				}
				
				System.out.println("\nChamar o próximo bilhete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
