package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.AutorDao;
import br.com.fiap.model.Autor;

public class Teste {
	public static void main(String[] args) {
		AutorDao dao = new AutorDao();
		Autor autor = new Autor();
		List<Autor> listaAutor = new ArrayList<Autor>();
		
		
		autor = dao.pesquisar(114);
		
		System.out.println(autor.getNome()+" "+autor.getSobrenome()+"\n");
		
		//autor.setId(113);
		//autor.setNome("bbb");
		//autor.setSobrenome("Lima");
		//dao.alterar(autor);
		
		//listaAutor = dao.listar();
		
		/*for (Autor autor : listaAutor) {
			System.out.println(autor.getNome()+" "+autor.getSobrenome()+"\n");
		}*/
	}
}
