import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Caixa {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);			
			Interface impl = (Interface) registry.lookup("hey");
			
			impl.gerarSenha("Gabriel Medina", "Baixa");
			System.out.println(impl.getSenha("João do Atendimento").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
