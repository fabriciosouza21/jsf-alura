package livraria;

import java.util.List;

import javax.faces.bean.ManagedBean;



@ManagedBean
public class BeanLivro {

	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}
	



	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public void gravar() {
		System.out.println("Gravar");
	}
	

}
