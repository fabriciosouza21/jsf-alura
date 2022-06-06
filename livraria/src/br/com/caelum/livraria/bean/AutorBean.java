package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;

	
	public Autor getAutor() {
		return autor;
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		
		if(this.autor.getId() == null) {
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		this.autor = new Autor();
		return "livro?faces-redirect=true";
	}
	
	public List<Autor> getTodosAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void alterar(Autor autor) {
		this.autor = autor;
	}
	
	public void remover(Autor autor) {
		new DAO<Autor>(Autor.class).remove(autor);
	}
	public void carregarPeloId() {
		System.out.println(autorId);
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);

	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

}
