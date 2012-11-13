package br.com.triadworks.blog.model;

public class Filme {

	private int codigo;
	private String titulo;
	private int ano;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Filme) obj).getCodigo() == this.getCodigo();
	}
}
