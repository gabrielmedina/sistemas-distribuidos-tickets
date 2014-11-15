import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	// Main
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("hey", new InterfaceCaixaImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
