package beans;

public class Bebida extends Item{

	private String nome;
	private String tamanho;
	private String sabor;
	
	public Bebida(int id, double valor, String nome, String tamanho, String sabor){
		super(id);
		super.setValor(valor);
		this.nome = nome;
		this.tamanho = tamanho;
		this.sabor = sabor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
