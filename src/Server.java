import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	// Main
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("hey", new InterfaceImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
