package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ViewScoped
@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();
	
	private Integer autorId;

	
	public List<Autor> getAutoresDoLivro(){
		return livro.getAutores();
	}

	
	public Livro getLivro() {
		return livro;
	}

	public Integer getAutorId() {
		return autorId;
	}



	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}



	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor", new  FacesMessage("o livro deve ter autor"));
			return;
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		this.livro = new Livro();
	}
	
	public void gravarAutor() {
		
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
		this.livro.adicionaAutor(autor);
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public List<Livro> getTodoLivros(){
		return new DAO<Livro>(Livro.class).listaTodos();
	}
	public void comecaComDigitoUm(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
		String valor = value.toString();
		if(!valor.startsWith("1")) {
			throw new ValidatorException( new FacesMessage("Deveria começar com 1") );
		}
		
	}

	
}
