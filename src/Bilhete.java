import java.io.Serializable;

public class Bilhete implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cliente;
	private String senha;
	private String prioridade;
	private String atendente;

	public Bilhete(String cliente, String senha, String prioridade) {
		this.cliente = cliente;
		this.senha = senha;
		this.prioridade = prioridade;
	}

	public Bilhete() {

	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	@Override
	public String toString() {
		String text = "Senha: " + this.senha + "\n" + "Cliente: "
				+ this.cliente + "\n" + "Prioridade: " + this.prioridade + "\n";

		return text;
	}
}
