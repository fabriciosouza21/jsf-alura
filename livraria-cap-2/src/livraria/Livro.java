package livraria;

public class Livro {
	public String titulo;
	public String isbn;
	public double preco;
	public String dataLacamento;

	public Livro() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDataLacamento() {
		return dataLacamento;
	}

	public void setDataLacamento(String dataLacamento) {
		this.dataLacamento = dataLacamento;
	}
	
	
}