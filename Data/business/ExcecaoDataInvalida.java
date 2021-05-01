package business;

public class ExcecaoDataInvalida extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int valor;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}

	public int getValor() {
		return valor;
	}

	ExcecaoDataInvalida(String nome, int val) {
		super("O atributo " + nome + " não pode receber " + val);
		this.setNome(nome);
		this.setValor(val);
	}

	

}
