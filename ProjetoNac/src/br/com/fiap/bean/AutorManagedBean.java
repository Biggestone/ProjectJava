package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.dao.AutorDao;
import br.com.fiap.model.Autor;

@ManagedBean
public class AutorManagedBean {
	
	private List<Autor> listaAutor;
	private Autor autor;
	private String nome;
	private String sobrenome;
	private int id;
	
	public Autor getAutor() {
		return autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void createAutor(){
		autor = new Autor();
		autor.setNome(nome);
		autor.setSobrenome(sobrenome);
		AutorDao dao = new AutorDao();
		dao.inserir(autor);
	}
	
	public void deleteAutor(){
		AutorDao dao = new AutorDao();
		dao.deletar(id);
		
	}
	
	public void alterAutor(){
		autor = new Autor();
		autor.setNome(nome);
		autor.setSobrenome(sobrenome);
		autor.setId(id);
		
		AutorDao dao = new AutorDao();
		dao.alterar(autor);
	}
	
	public List<Autor> listAutor(){
		listaAutor = new ArrayList<Autor>();
		AutorDao dao = new AutorDao();
		listaAutor = dao.listar();
		
	return listaAutor;}
	
}
