import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Gerador {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			InterfaceCaixa impl = (InterfaceCaixa) registry.lookup("caixa");

			Scanner scanner = new Scanner(System.in);

			while (true) {				
				System.out.println("Retire o seu bilhete");
				
				Bilhete bilhete = new Bilhete();
				
				System.out.print("Seu nome: ");
				bilhete.setCliente(scanner.nextLine());

				System.out.print("Prioridade: ");
				bilhete.setPrioridade(scanner.nextLine());

				bilhete = impl.gerarBilhete(bilhete);
				
				System.out.println("\n--------------------");
				System.out.println("Senha: " + bilhete.getSenha());
				System.out.println("--------------------\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
