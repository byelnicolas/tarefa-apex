package mvc.model;

public class Aluno {

	private int codigo;
	private String nome;
	private int nota_um;
	private int nota_dois;
	private int nota_tres;

	public Aluno(int codigo, String nome, int nota_um, int nota_dois, int nota_tres) {
		this.codigo = codigo;
		this.nome = nome;
		this.nota_um = nota_um;
		this.nota_dois = nota_dois;
		this.nota_tres = nota_tres;
	}

	public Aluno() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota_um() {
		return nota_um;
	}

	public void setNota_um(int nota_um) {
		this.nota_um = nota_um;
	}

	public int getNota_dois() {
		return nota_dois;
	}

	public void setNota_dois(int nota_dois) {
		this.nota_dois = nota_dois;
	}

	public int getNota_tres() {
		return nota_tres;
	}

	public void setNota_tres(int nota_tres) {
		this.nota_tres = nota_tres;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
