import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {	
	// Main
	public static void main(String[] args) {
		try {
			Registry registryCaixa = LocateRegistry.createRegistry(1099);
			
			Registry registryPainel = LocateRegistry.getRegistry("127.0.0.1", 1098);
			InterfacePainel impl = (InterfacePainel) registryPainel.lookup("painel");
			
			registryCaixa.rebind("caixa", new InterfaceCaixaImpl(impl));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
