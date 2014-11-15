import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Painel {
	// Main
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(1098);
			registry.rebind("painel", new InterfacePainelImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
